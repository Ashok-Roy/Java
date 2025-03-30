package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import datacollector.CheckSubscription;
import datacollector.DataCollector;

/**
 * Servlet implementation class BuyTicket
 */
public class BuyTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuyTicket() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// hit hitesh sir login?msisdn=279888495960&type=onnet
		// hit sdp login?msisdn=279888495960&type=offnet
		PrintWriter out = response.getWriter();
		String sdpurl = DataCollector.getSdpUrl();
//		String sdpurl = "http://sdp.smartcalltech.co.za/Traffic/868e5eb5-57bb-45f6-9a58-1676ebd6844f";
		String ani = checkAni(request.getParameter("msisdn"));
		if (ani == null) {
			response.sendRedirect(sdpurl);
			return;
		} else {
			String smsurl = DataCollector.getSMSurl();
//			String smsurl="http://sdp.smartcalltech.co.za/sms/868e5eb5-57bb-45f6-9a58-1676ebd6844f/27" + ani;
			String flag = "";
			String output = "";
			String URL = smsurl + "/27" + ani;
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost postRequest = new HttpPost(URL);
			System.out.println(postRequest);
			HttpResponse resp = httpClient.execute(postRequest);
			BufferedReader br = new BufferedReader(new InputStreamReader((resp.getEntity().getContent())));
			System.out.println("Output from Server ....");
			while ((output = br.readLine()) != null) {
				System.out.println("output::" + output);
				flag = output;
			}
			if (flag.equalsIgnoreCase("true")) {
				response.sendRedirect("wait?result=" + flag + "&msisdn=" + ani + "&ref=00");
				return;
			} else if (flag.equalsIgnoreCase("false")) {
				response.sendRedirect("wait?result=" + flag + "&msisdn=" + ani + "&ref=00");
				return;
			}

		}

	}

	public String checkAni(String ani) {
		String countyCode = "27";
		if (ani.startsWith("0"))
			ani = ani.substring(1);
		if (ani.startsWith("+"))
			ani = ani.substring(1);
		int len = countyCode.length();
		if (ani.substring(0, len).equals(countyCode))
			ani = ani.substring(len);
		if (ani.contains(" "))
			ani = ani.replace(" ", "");
		return ani;
	}

}

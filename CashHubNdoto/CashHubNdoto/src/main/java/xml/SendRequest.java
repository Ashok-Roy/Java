package xml;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.json.XML;
import java.util.*;
public class SendRequest {


	public static void main(String[] args) throws IOException {

		String request = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
				+ "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n"
				+ "  <soap:Body>\r\n"
				+ "    <GetToken xmlns=\"http://tempuri.org/\">\r\n"
				+ "      <username>27820000110</username>\r\n"
				+ "      <pin>4321</pin>\r\n"
				+ "    </GetToken>\r\n"
				+ "  </soap:Body>\r\n"
				+ "</soap:Envelope>";

		URL url = new URL("http://ws.marblegold.co.za/SmartloadGateway.asmx");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		// Set timeout as per needs
		connection.setConnectTimeout(20000);
		connection.setReadTimeout(20000);

		// Set DoOutput to true if you want to use URLConnection for output.
		// Default is false
		connection.setDoOutput(true);

		connection.setUseCaches(true);
		connection.setRequestMethod("POST");

		// Set Headers
		connection.setRequestProperty("Soap-Action", "http://tempuri.org/GetToken");
		connection.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
		connection.setRequestProperty("Host", "ws.marblegold.co.za");

		// Write XML
		OutputStream outputStream = connection.getOutputStream();
		byte[] b = request.getBytes("UTF-8");
		outputStream.write(b);
		outputStream.flush();
		outputStream.close();

		// Read XML
		InputStream inputStream = connection.getInputStream();
		byte[] res = new byte[2048];
		int i = 0;
		StringBuilder response = new StringBuilder();
		while ((i = inputStream.read(res)) != -1) {
			response.append(new String(res, 0, i));
		}
		inputStream.close();

//		System.out.println("Response= " + response.toString());
		
		JSONObject js=XML.toJSONObject(response.toString());
		System.out.println(js.getJSONObject("soap:Envelope").getJSONObject("soap:Body").getJSONObject("GetTokenResponse").getJSONObject("GetTokenResult").get("token"));
	
		

	
}

}

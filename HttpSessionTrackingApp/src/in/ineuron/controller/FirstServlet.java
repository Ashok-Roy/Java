package in.ineuron.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/test1")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Collect request parameter data
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		// Create a session object and store the data in session object 
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		session.setAttribute("age", age);
		
		// Create a RequestDispatcher to send the request, response object to SecondServlet
		RequestDispatcher rd = request.getRequestDispatcher("/form2.html");
		rd.forward(request, response);
	}

}

package in.ineuron.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ValidationApp")
public class ValidationApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String dbName = "Nitin";
		String dbPass = "12345";
		if(dbName.equals(name)&& dbPass.equals(password))
		{
			request.setAttribute("name", name);
			RequestDispatcher rd = request.getRequestDispatcher("./inbox.jsp");
			rd.forward(request, response);
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("./error.jsp");
			rd.forward(request, response);
		}
	}

}

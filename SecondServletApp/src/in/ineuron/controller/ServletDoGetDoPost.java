package in.ineuron.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServletDoGetDoPost")
public class ServletDoGetDoPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static{
		System.out.println("Servlet Loading happend...");
	}
    public ServletDoGetDoPost() {
       System.out.println("Servlet Instantiation happend..");
    }
    // method="POST" if method is POST, doPost(HSR req, HSR res) will call
    // if user define doPost() method is not there HttpServlet(AC) doPost() method will call because of inheritance.
    // But if HttpServlet(AC) method will call then user will not get desire output.
    // So, HttpServlet(AC) class object should not be created and body should not be execute of HttpServlet.
    // That's why HttpServlet(AC) make as Abstract class although there is no abstract method.
    // if HttpServlet doPost method called we will get as result "HTTP Status 405 – Method Not Allowed"
    // it means user define doPost method is not there.
    // Same happen to doGet() method
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Request Type is Get");
	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Request Type is Post");
	}
}

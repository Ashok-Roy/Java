package in.visiontrek.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ArrayList<String> list = new ArrayList<>();
		 list.add("A");
		 list.add("B");
		 list.add("C");
		 list.add("D");
		 list.add("E");
		 
		 Gson gson = new Gson();
	     String jsonData = gson.toJson(list);

//	     // set response type to JSON 
//	     response.setContentType("application/json");
//	     response.setCharacterEncoding("UTF-8");
//
//	     // return data as JSON
//	     response.getWriter().write(jsonData);
	     
	     
	     response.setContentType("application/json");
	     response.setCharacterEncoding("UTF-8");
	     response.getWriter().write(new Gson().toJson(jsonData));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

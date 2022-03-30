package com.servlet.examples;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.servlet.pojo.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MVCControllerServlet
 */
@WebServlet("/mvc/controllerServlet")
public class MVCControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MVCControllerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

		List<Student> list = new ArrayList<>();
		list.add(new Student("Swati", 123, "s@s.com"));
		list.add(new Student("Garg", 124, "g@g.com"));
		list.add(new Student("Neha", 125, "n@n.com"));
		
		request.setAttribute("students_list", list);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/mvcView.jsp");
		
		requestDispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

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

@WebServlet("/mvc/controllerServlet")
public class MVCControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

		List<Student> list = new ArrayList<>();
		list.add(new Student("Swati", "Raghav", 123, "s@s.com"));
		list.add(new Student("Garg", "Chauhan", 124, "g@g.com"));
		list.add(new Student("Neha", "Kashyap", 125, "n@n.com"));

		request.setAttribute("students_list", list);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/mvcView.jsp");

		requestDispatcher.forward(request, response);

	}

}

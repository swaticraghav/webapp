package com.jdbc.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.servlet.pojo.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/mvc/homepage")
public class SelectQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try {
			Connection connection = DriverManager.getConnection(Constants.JDBC_URL, Constants.USERNAME,
					Constants.PASSWORD);
			out.println("Connected to the PostgreSQL Server <br><hr>");

			List<Student> list = StudentUtil.selectMethod2(out, connection);
			request.setAttribute("students_list", list);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/mvcView.jsp");
			requestDispatcher.forward(request, response);

			connection.close();
		} catch (SQLException e) {
			out.println("Connection Error");
			out.println(e.getMessage());
		}

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}

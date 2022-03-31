package com.jdbc.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/mvc/deleteServlet")
public class DeleteQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		try {
			Connection connection = DriverManager.getConnection(Constants.JDBC_URL, Constants.USERNAME,
					Constants.PASSWORD);

			Statement createStatement = connection.createStatement();
			createStatement.executeUpdate(
					"DELETE FROM student WHERE student_id = " + Integer.valueOf(request.getParameter("studentId")));
			

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/successPage.html");
			requestDispatcher.forward(request, response);

			connection.close();
		} catch (SQLException e) {
			out.println("Connection Error");
			out.println(e.getMessage());
		}

		response.getWriter().append("Served at Ass: " + request.getParameter("studentId"));
	}

}

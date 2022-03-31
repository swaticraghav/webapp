package com.jdbc.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/mvc/insertServlet")
public class InsertQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try {
			Connection connection = DriverManager.getConnection(Constants.JDBC_URL, Constants.USERNAME,
					Constants.PASSWORD);
			out.println("Connected to the PostgreSQL Server");

			PreparedStatement prepareStatement = connection
					.prepareStatement("INSERT INTO student (first_name, last_name, email) VALUES (?, ?, ?);");

			prepareStatement.setString(1, request.getParameter("first-name"));
			prepareStatement.setString(2, request.getParameter("last-name"));
			prepareStatement.setString(3, request.getParameter("email"));

			prepareStatement.executeUpdate();
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/successPage.html");
			requestDispatcher.forward(request, response);

			connection.close();
		} catch (SQLException e) {
			out.println("Connection Error" + e.getMessage());
		}
		out.println("Record/Records created successfully");

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}

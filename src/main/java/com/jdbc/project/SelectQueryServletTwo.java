package com.jdbc.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.servlet.pojo.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/mvc/selectServletTwo")
public class SelectQueryServletTwo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String studentId = request.getParameter("studentId");

		try {
			Connection connection = DriverManager.getConnection(Constants.JDBC_URL, Constants.USERNAME,
					Constants.PASSWORD);
			out.println("Connected to the PostgreSQL Server <br><hr>");

			Statement selectStatement = connection.createStatement();
			ResultSet result = selectStatement.executeQuery("Select * from student where student_id = " + studentId);

			List<Student> list = new ArrayList<>();

			while (result.next()) {
				Student student = new Student(result.getString("first_name"), result.getString("last_name"),
						result.getInt("student_id"), result.getString("email"));
				list.add(student);
				request.setAttribute("student_info", student);
			}

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/updateForm.jsp");
			requestDispatcher.forward(request, response);

			selectStatement.close();
			connection.close();
		} catch (SQLException e) {
			out.println("Connection Error");
			out.println(e.getMessage());
		}

	}

}

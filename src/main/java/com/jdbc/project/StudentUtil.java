package com.jdbc.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.servlet.pojo.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StudentUtil {

	static int studentID;
	static String firstName, lastName, email;
	
	public static void updateMethod(HttpServletRequest request, HttpServletResponse response, Connection connection)
			throws SQLException, ServletException, IOException {
		String sql = "UPDATE student SET first_name = ?, last_name = ?, email = ? WHERE student_id = ?";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, request.getParameter("first-name"));
		preparedStatement.setString(2, request.getParameter("last-name"));
		preparedStatement.setString(3, request.getParameter("email"));
		preparedStatement.setInt(4, Integer.valueOf(request.getParameter("student-id")));

		preparedStatement.executeUpdate();
		

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/successPage.html");
		requestDispatcher.forward(request, response);

		preparedStatement.close();
	}

	public static void createMethod(PrintWriter out, Connection connection) throws SQLException {

		Statement statement = connection.createStatement();
		statement.executeUpdate("INSERT INTO learning (topic) VALUES ('Fundamentals');");
		statement.executeUpdate("INSERT INTO learning (topic) VALUES ('Moderate');");
		statement.executeUpdate("INSERT INTO learning (topic) VALUES ('Advanced');");

		statement.close();

	}

	public static void selectMethod(PrintWriter out, Connection connection) throws SQLException {
		Statement selectStatement = connection.createStatement();
		ResultSet result = selectStatement.executeQuery("Select * from student limit 5;");

		while (result.next()) {
			studentID = result.getInt("student_id");
			firstName = result.getString("first_name");
			lastName = result.getString("last_name");
			email = result.getString("email");

			out.println(firstName + lastName + email + studentID);
		}
		selectStatement.close();
	}

	public static List<Student> selectMethod2(PrintWriter out, Connection connection) throws SQLException {
		Statement selectStatement = connection.createStatement();
		ResultSet result = selectStatement.executeQuery("Select * from student ORDER BY student_id;");

		List<Student> list = new ArrayList<>();

		while (result.next()) {
			Student student = new Student(result.getString("first_name"), result.getString("last_name"), result.getInt("student_id"),
					result.getString("email"));
			list.add(student);
		}
		selectStatement.close();
		return list;
	}

	public static void createMethod(Connection connection) throws SQLException {
		Statement createStatement = connection.createStatement();
		createStatement.executeUpdate(
				"CREATE TABLE student ( student_id serial PRIMARY KEY, first_name VARCHAR(100), last_name VARCHAR(100), email VARCHAR(300));");
		createStatement.close();
	}

}

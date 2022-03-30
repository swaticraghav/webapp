<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<h2>Student Table Demo</h2>
	<table border="1">
		<tr>
			<td>Student ID</td>
			<td>Student Name</td>
			<td>Student Email ID</td>
		</tr>
		<c:forEach var="student" items="${students_list}">
			<tr>
				<td>${student.name}</td>
				<td>${student.id}</td>
				<td>${student.email}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
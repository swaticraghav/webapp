<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Student Data</title>
	<link type="text/css" rel="stylesheet" href="/webapp/css/style.css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>University Student Data</h2>
		</div>
	</div>
	
	<div id="container">
			
			<input type="button" value="Add Student"
					onclick="window.location.href='/webapp/insertForm.html'; return false;"
					class="add-student-button"					
			/>
			<hr>
	
			<table>
				<tr>
					<th>Student - ID</th>
					<th>Student - First Name</th>
					<th>Student - Last Name</th>
					<th>Student - Email</th>
					<th>Action</th>
				</tr>
				<c:forEach var="student" items="${students_list}">
					<c:url var="updateLinkForStudent" value="selectServletTwo">
						<c:param name="studentId" value="${student.studentID}"></c:param>
					</c:url>
					<c:url var="deleteLinkForStudent" value="deleteServlet">
						<c:param name="studentId" value="${student.studentID}"></c:param>
					</c:url>
				
					<tr>
						<td>${student.studentID}</td>
						<td>${student.firstName}</td>
						<td>${student.lastName}</td>
						<td>${student.email}</td>
						<td>
							<a href="${updateLinkForStudent}">Update</a>
							/
							<a href="${deleteLinkForStudent}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
	</div>
	
	
</body>
</html>
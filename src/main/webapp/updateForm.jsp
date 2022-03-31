<html>
	<head>
		<title>
			Update Student Details
		</title>
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

			<form action="/webapp/mvc/updateServlet" method="GET">
			
				<input type="hidden" name="student-id" value="${student_info.studentID}">
				
				<table>
					<tbody>
						<tr>
							<td>First Name - </td>
							<td><input type="text" name="first-name" value="${student_info.firstName}"></td>
						</tr>
						
						<tr>
							<td>Last Name - </td>
							<td><input type="text" name="last-name" value="${student_info.lastName}"></td>
						</tr>
						
						<tr>
							<td>Email - </td>
							<td><input type="text" name="email" value="${student_info.email}"></td>
						</tr>
						
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Update Student Data" class="button-25"></td>
						</tr>
					</tbody>
				</table>
				
			</form>
			
			<div style="clear:both;"></div>
			<p>
				<a href="/webapp/mvc/homepage">Back to list</a>
			</p>
			
			
			
		</div>
	</body>
</html>
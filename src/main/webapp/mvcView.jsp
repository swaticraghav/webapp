<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<c:forEach var="student" items="${students_list}">
		Name - ${student.name} <br />
		ID - ${student.id} <br>
		Email - ${student.email} <br />
		<hr>
	</c:forEach>
</body>
</html>
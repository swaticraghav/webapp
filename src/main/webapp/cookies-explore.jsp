<html>
	<head>
		<title>Explore More!</title>
	</head>
	
	<body>
		<%
			Cookie[] list = request.getCookies();
			String bookName = "";
			String movieName = "";
		
			if(list != null){
				for(Cookie c : list){
					if("cookie.book".equals(c.getName())){
						bookName = c.getValue();
					}
					if("cookie.movie".equals(c.getName())){
						movieName = c.getValue();
					}
				}
			}
		%>
		
		<h1>Author of <%= bookName %> is XYZ.</h1>
		<h1>Director of <%= movieName %> is ABC.</h1>
		<hr>
		<h3>Different selection? <a href="cookies-form.html">Click Here!</a></h3>
				
	</body>
</html>
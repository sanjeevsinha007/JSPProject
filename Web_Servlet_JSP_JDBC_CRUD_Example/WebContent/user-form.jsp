<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		</br>
		<h2>Add New User</h2>
		</br>
		<form action="newuser" method="Get">
			<div class="form-group">
				<label for="name">User Name</label> <input type="text"
					class="form-control" name="name">
			</div>
			<div class="form-group">
				<label for="email">User Email</label> <input type="email"
					class="form-control" name="email">
			</div>
			<div class="form-group">
				<label for="country">User Country</label> <input type="text"
					class="form-control" name="country">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>
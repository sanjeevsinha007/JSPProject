<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			
		<!-- <h2>Welcome <c:out value="${email}"></c:out></h2> -->
		<c:if test="${user!=null}">
		<h2>Update Existing user</h2>
			<form action="edituser" method="Post">
		</c:if>
		
		<c:if test="${user==null}">
		<h2>Add New user</h2>
			<form action="newuser" method="Post">
		</c:if>
			<div class="form-group">
				<label for="name">User Name</label> <input type="text"
					class="form-control" name="name" value="<c:out value="${user.name}"></c:out>">
			</div>
			<div class="form-group">
				<label for="email">User Email</label> <input type="email"
					class="form-control" name="email" value="<c:out value="${user.email}"></c:out>">
			</div>
			<div class="form-group">
				<label for="country">User Country</label> <input type="text"
					class="form-control" name="country" value="<c:out value="${user.country}"></c:out>">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>

</body>
</html>
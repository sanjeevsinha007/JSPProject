<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management Application</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>

<body>

	<jsp:include page="header.jsp"></jsp:include>
<div class="container">
	</br>
	</br>
	<a href="<%=request.getContextPath()%>/userform" class="btn btn-success">Create New User</a></br></br>
	<h2>Users List</h2>
	<table class="table table-sm table-dark">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Country</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${listUser}">
				<tr>
					<td><c:out value="${user.id}"></c:out></td>
					<td><c:out value="${user.name}"></c:out></td>
					<td><c:out value="${user.email}"></c:out></td>
					<td><c:out value="${user.country}"></c:out></td>
					<td>
						<a href="editform?id=<c:out value="${user.id}"/>" class="btn btn-secondary">Edit</a>
						<a href="deleteuser?id=<c:out value="${user.id}"/>" class="btn btn-danger">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>
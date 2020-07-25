<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style type="text/css">
.right {
  background-color: pink;
  color: black;
  font-weight: bold;
  padding: 4px;
  font-family: Verdana, Arial, Helvetica, sans-serif;;
}
</style>
<div align="right">
	<label type="text" class="right"> Welcome <c:out value="${email}"></c:out>
	</label> 
	</br> 
	<a href="LogoutServlet" class="btn btn-primary btn-lg active"
		tabindex="-1" role="button" aria-disabled="true">Logout</a>
</div>
<nav>
	<ul class="nav nav-tabs" id="myTab" role="tablist">
		<li class="nav-item" role="presentation"><a
			class="nav-link active" id="home-tab" data-toggle="tab" href="#home"
			role="tab" aria-controls="home" aria-selected="true">Home</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="profile-tab" data-toggle="tab" href="#profile" role="tab"
			aria-controls="about" aria-selected="false">About</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="messages-tab" data-toggle="tab" href="#messages" role="tab"
			aria-controls="manageuser" aria-selected="false">Manage User</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="settings-tab" data-toggle="tab" href="#settings" role="tab"
			aria-controls="managerole" aria-selected="false">Manage Role</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="customer-tab" data-toggle="tab" href="#settings" role="tab"
			aria-controls="manage customer" aria-selected="false">Manage
				Customer</a></li>


	</ul>


</nav>

<div class="tab-content">
	<div class="tab-pane active" id="home" role="tabpanel"
		aria-labelledby="home-tab">...</div>
	<div class="tab-pane" id="profile" role="tabpanel"
		aria-labelledby="profile-tab">...</div>
	<div class="tab-pane" id="messages" role="tabpanel"
		aria-labelledby="messages-tab">...</div>
	<div class="tab-pane" id="settings" role="tabpanel"
		aria-labelledby="settings-tab">...</div>
	<div class="tab-pane" id="settings" role="tabpanel"
		aria-labelledby="customer-tab">...</div>
</div>



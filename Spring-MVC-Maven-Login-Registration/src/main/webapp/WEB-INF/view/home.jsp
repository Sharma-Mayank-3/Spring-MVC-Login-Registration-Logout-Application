<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Login Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<%@ page isELIgnored="false"%>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href="https://www.xadmin.net" class="navbar-brand"> You are
					successful login </a>
			</div>
			<div class="container text-right">

				<a href="<%=request.getContextPath()%>/logout"
					class="btn btn-success"> Logout </a>
			</div>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">


				<fieldset class="form-group">
					<label>User Name</label> <input type="text" value="${user.name}"
						class="form-control" name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>User Email : </label> <input type="text"
						value="${user.email}" class="form-control" name="email">
				</fieldset>

				<fieldset class="form-group">
					<label>User Country : </label> <input type="text"
						value="${user.country}" class="form-control" name="country">
				</fieldset>
			</div>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register-Page</title>
<%@include file="components/cssAndJs.jsp"%>
</head>
<body>
	<%@include file="components/navbar.jsp"%>
	<div class="container-fluid">
		<div class="row mt-3">
			<div class="col-md-4 offset-md-4">
				<div class="card ">

					<div class="card-header text-white text-center coustom-bg ">
						<span class="fa fa-user-plus fa-2x"></span> <br>
						<h3>Register here</h3>
					</div>
					<div>
						<%@include file="components/message.jsp"%>
					</div>

					<div class="card-body">
						<form action="registerServlet" method="post">
							<div class="form-group">
								<label for="name">User Name</label> <input type="text"
									class="form-control" id="name" aria-describedby="emailHelp"
									placeholder="Enter name" name="user_name">

							</div>
							<div class="form-group">
								<label for="email">User Email</label> <input type="email"
									class="form-control" id="email" aria-describedby="emailHelp"
									placeholder="Enter email" name="user_email">

							</div>
							<div class="form-group">
								<label for="password">User Password</label> <input
									type="password" class="form-control" id="password"
									aria-describedby="emailHelp" placeholder="Enter password"
									name="user_password">
							</div>
							<div class="form-group">
								<label for="phone">User Phone</label> <input type="number"
									class="form-control" id="phone" aria-describedby="emailHelp"
									placeholder="Enter phone number" name="user_phone">

							</div>
							<div class="form-group">
								<label for="phone">User Address</label>
								<textarea style="height: 80px" class="form-control"
									name="user_address" placeholder="enter address"></textarea>
							</div>
							<div class="container text-center">
								<button class="btn btn-outline-success">Register</button>
								<button class="btn btn-outline-warning">Reset</button>

							</div>
						</form>

					</div>
				</div>
			</div>
		</div>

	</div>


</body>
</html>
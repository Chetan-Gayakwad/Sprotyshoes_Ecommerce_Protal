<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
<%@include file="components/cssAndJs.jsp"%>

</head>
<body>

	<%@include file="components/navbar.jsp"%>

	<div class="container">
		<div class="row mt-5">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-header coustom-bg text-white text-center">
						<span class="fa fa-user-circle fa-3x fa-spin"></span>
						<p>Login Here</p>
					</div>
					<div class="card-body">
						<%@include file="components/dangermsg.jsp"%>
						<form action="loginServlet" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									name="email" required type="email" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									placeholder="Enter email"> <small id="emailHelp"
									class="form-text text-muted">We'll never share your
									email with anyone else.</small>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									name="password" required type="password" class="form-control"
									id="exampleInputPassword1" placeholder="Password">
							</div>

							<div class="container text-center">
								<button type="submit" class="btn btn-primary">Login</button>
							</div>
						</form>
					</div>

				</div>
			</div>

		</div>
	</div>

</body>
</html>
<%@page import="java.util.Map"%>
<%@page import="com.simplilearn.sportyshoes.helper.Helper"%>
<%@page import="com.smplilearn.sportyshoes.entities.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.simplilearn.sportyshoes.helper.FactoryProvider"%>
<%@page import="com.smplilearn.sportyshoes.Dao.CategoryDao"%>
<%@page import="com.smplilearn.sportyshoes.entities.User"%>
<%
User user = (User) session.getAttribute("current-user");
if (user == null) {

	session.setAttribute("message", "you are not login !! login first");
	response.sendRedirect("login.jsp");
	return;

} else {
	if (user.getUserType().equals("normal")) {

		session.setAttribute("message", "you are not admin !! Do not access this page");
		response.sendRedirect("login.jsp");

		return;
	}
}
%>

<%
CategoryDao dao = new CategoryDao(FactoryProvider.getFactory());
List<Category> list = dao.getCategory();


/* Map<String,Long> m= Helper.getCount(FactoryProvider.getFactory()); */



%>





<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Panel</title>
<%@include file="components/cssAndJs.jsp"%>


</head>
<body>
	<%@include file="components/navbar.jsp"%>
	<div class="container admin">
		<div class="fluid-container mt-3">
			<%@include file="components/message.jsp"%>


		</div>


		<div class="row mt-5">
			<div class="col-md-4">
				<div class="card">
					<div class="card-body text-center">
						<div class="container">
							<img alt="" src="img/team.png" class="img-fluid rounded-circle"
								style="max-width: 125px">
						</div>
						<%-- <h3><%= m.get("userQuant") %></h3> --%>
						<h1 class="text-uppercase text-muted">User</h1>

					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card">
					<div class="card-body text-center">
						<div class="container">
							<img alt="" src="img/options.png"
								class="img-fluid rounded-circle" style="max-width: 125px">
						</div>
						<br>
						<h3><%= list.size() %></h3>
						<h1 class="text-uppercase text-muted">Categories</h1>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card">
					<div class="card-body text-center">
						<div class="container">
							<img alt="" src="img/ecommerce.png"
								class="img-fluid rounded-circle" style="max-width: 125px">
						</div>
						
						<h1 class="text-uppercase text-muted">Product</h1>
					</div>
				</div>
			</div>

		</div>
		<div class="row mt-3">
			<div class="col-md-6">
				<div class="card" data-toggle="modal"
					data-target="#add-category-model">
					<div class="card-body text-center">
						<div class="container">
							<img alt="" src="img/category.png"
								class="img-fluid rounded-circle" style="max-width: 125px">
						</div>
						<h1 class="text-uppercase text-muted">Add Categories</h1>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="card" data-toggle="modal"
					data-target="#add-product-modal">
					<div class="card-body text-center">
						<div class="container">
							<img alt="" src="img/add-to-cart.png"
								class="img-fluid rounded-circle" style="max-width: 125px">
						</div>
						<h1 class="text-uppercase text-muted">Add Product</h1>
					</div>
				</div>
			</div>


		</div>

	</div>

	<!-- Button trigger modal -->


	<!-- Modal category -->
	<div class="modal fade" id="add-category-model" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered model-lg "
			role="document">
			<div class="modal-content">
				<div class="modal-header coustom-bg text-white">
					<h5 class="modal-title" id="exampleModalLongTitle">Fill
						Category Details</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="ProductOprationServlet" method="post">

						<input type="hidden" name="operation" value="addcategory">
						<div class="form-group">
							<label for="title">Description Title</label> <input name="title"
								required type="text" class="form-control" id="title"
								placeholder="Enter Title">
						</div>
						<div class="form-group">
							<textarea class="form-control" style="height: 200px"
								placeholder="Enter Category Discription" name="desc" required>
							</textarea>
						</div>
						<div class="container text-center">
							<button type="submit" class="btn btn-outline-success">Add
								Category</button>
							<button type="button" class="btn btn-outline-secondary"
								data-dismiss="modal">Close</button>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>
	<!-- 	end category modal -->

	<!-- 	add product modal -->

	<!-- Button trigger modal -->


	<!-- Modal -->
	<div class="modal fade" id="add-product-modal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered model-lg"
			role="document">
			<div class="modal-content">
				<div class="modal-header coustom-bg">
					<h5 class="modal-title" id="exampleModalLabel">Add product</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>

				</div>

				<div class="modal-body">

					<form action="ProductOprationServlet" method="post"
						enctype="multipart/form-data">
						<input type="hidden" name="operation" value="addproduct">
						<div class="form-group">
							<label for="title"> </label> <input name="title" required
								type="text" class="form-control" id="title"
								placeholder="Enter Product Title">
						</div>

						<div class="form-group">
							<textarea class="form-control" style="height: 100px"
								placeholder="Enter product Discription" name="desc" required>
							</textarea>
						</div>

						<div class="form-group">
							<label for="price"> </label> <input name="price" required
								type="number" class="form-control" id="price"
								placeholder="Enter product price">
						</div>

						<div class="form-group">
							<label for="discount"></label> <input name="discount" required
								type="number" class="form-control" id="discount"
								placeholder="product Discount ">
						</div>

						<div class="form-group">
							<label for="quantity"></label> <input name="quantity" required
								type="number" class="form-control" id="quantity"
								placeholder="product quantity">
						</div>



						<div class="form-group">
							<select name="catId" class="form-cotrol">

								<%
								for (Category c : list) {
								%>
								<option value="<%=c.getCategoryId()%>"><%=c.getCategoryTitle()%></option>
								<%
								}
								%>
							</select>
						</div>
						<div class="form-group">
							<label for="img">Select image</label> <input name="img" multiple
								type="file" id="img" class="form-control">
						</div>

						<div class="container text-center">
							<button type="submit" class="btn btn-outline-success">Add
								Product</button>
							<button type="button" class="btn btn-outline-secondary"
								data-dismiss="modal">Close</button>
						</div>
					</form>

				</div>
			</div>
		</div>
	</div>


	<!-- end product modal -->

</body>
</html>
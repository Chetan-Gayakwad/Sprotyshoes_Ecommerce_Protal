<!doctype html>
<%@page import="com.simplilearn.sportyshoes.helper.Helper"%>
<%@page import="com.smplilearn.sportyshoes.entities.Category"%>
<%@page import="com.smplilearn.sportyshoes.Dao.CategoryDao"%>
<%@page import="com.smplilearn.sportyshoes.entities.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.smplilearn.sportyshoes.Dao.ProductDao"%>
<%@page import="com.simplilearn.sportyshoes.helper.FactoryProvider"%>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<%@include file="components/cssAndJs.jsp"%>

<title>SportyShoes-Home</title>
</head>
<body>
	<%@include file="components/navbar.jsp"%>


	<div class="container-fluid">


		<div class="row mt-3 mx-2">

			<%
		String cat = request.getParameter("category");
			//out.println(cat);

			ProductDao dao = new ProductDao(FactoryProvider.getFactory());

			List<Product> list =null;
			
		
			
			 if (cat == null ||cat.trim().equals("all")){
				list =dao.getAllProduct();
			}else{
				
				int cid = Integer.parseInt(cat.trim());
				list=dao.getAllProductById(cid);
			}
			

			CategoryDao cDao = new CategoryDao(FactoryProvider.getFactory());
			List<Category> clist = cDao.getCategory();
			%>
			<div class="col-md-2">

				<div class="list-group mt-4">
					<a href="index.jsp?category=all"
						class="list-group-item list-group-item-action active"> All
						Products </a>


					<%
					for (Category category : clist) {
					%>

					<a href="index.jsp?category=<%=category.getCategoryId()%>"
						class="list-group-item list-group-item-action"> <%=category.getCategoryTitle()%>
					</a>

					<%
					}
					%>
				</div>

			</div>

			<div class="col-md-10">

				<div class="row mt-4 ">

					<div class="col-md-12">

						<div class="card-columns  ">
							<%
							for (Product p : list) {
							%>
							<div class="card card-effect">
								<div class="container text-center card-img">

									<img alt="" src="img/products/<%=p.getpPhoto()%>"
										style="max-height: 200px; max-width: 100%; width: auto;"
										class="card-img-top m-2">

								</div>

								<div class="card-body">
									<h5 class="card-title"><%=p.getpName()%></h5>
									<p class="card-text"><%=Helper.get10words(p.getpDesc())%></p>

								</div>
								<div class="card-footer">
									<button class="btn coustom-bg text-white" onclick="add_to_cart(<%= p.getpId()%>, <%= p.getpName()%>, <%= p.getDiscountPrice()%>)">Add to Cart</button>
									<button class="btn btn-outline-primary">
										&#8377;<%=p.getDiscountPrice()%>/- <span class="text-success discount label "><%= p.getpDiscount() %> % off  &#8377; <%= p.getpPrice() %></span></button>

								</div>

							</div>

							<%
							}
							%>
						</div>

					</div>

				</div>

			</div>

		</div>
	</div>
<%@include file="components/common_modal.jsp" %>
</body>
</html>
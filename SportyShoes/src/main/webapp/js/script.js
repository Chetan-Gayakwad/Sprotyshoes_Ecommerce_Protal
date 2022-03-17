function add_to_cart(pid, pname, price) {
	let cart = localStorage.getItem("cart");
	if (cart == null) {

		let products = [];
		let product = { productId: pid, productName: pname, productQuantity: 1, price }

		products.push(product);
		localStorage.setItem("cart", JSON.stringify(product));
		console.log("Product is added for first time");

	} else {

		let pcart = JSON.parse(cart);
		let oldProduct = pcart.find((item) => item.productId == pid)

		if (oldProduct) {
			oldProduct.productQuantity = oldProduct.prroductQuantity + 1

			pcart.map((item) => {

				if (item.productId == oldProduct.productId) {

					item.productQuantity = oldProduct.productQuantity;

				}

			})
			localStorage.setItem("cart", JSON.stringify(pcart))
			console.log("Product quantity is increses");


		} else {

			let product = { productId: pid, productName: pname, productQuantity: 1, price }
			pcart.push(product);
			localStorage.setItem("cart", JSON.stringify(pcart))
			console.log("Product is added ");

		}
	}


	updateCart();
}



/*update cart*/

function updateCart() {

	let cartString = localStorage.getItem();
	let cart = JSON.parse(cartString);
	if (cart == null || cart.length == 0) {
		console.log("cart is empty");

		$(".cart-body").html("<h3> Cart is empty</h3>");
		$(".checkout-btn").addClass("disabled");
	} else {


		console.log(cart);
		
		let table=`
		<table class = 'table'>
		
		<thead class = 'thead-light'>
		<tr>
			<th>Item Name</th>
			<th> Price </th>
			<th> Quantiy </th>
			<th> Total Price</th>
			<th> Action </th>
		
		
		</tr>
		
		</thead>
		
		`;
		
		
		table=table+`</table>`
		$(".cart-body").html(table);
		
	
}
}


$(document).ready(function() {
	
updateCart()
})
















<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		 <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

		<title>Electronic Device Shop</title>

 		<!-- Google font -->
 		<link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

 		<!-- Bootstrap -->
 		<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>

 		<!-- Slick -->
 		<link type="text/css" rel="stylesheet" href="css/slick.css"/>
 		<link type="text/css" rel="stylesheet" href="css/slick-theme.css"/>

 		<!-- nouislider -->
 		<link type="text/css" rel="stylesheet" href="css/nouislider.min.css"/>

 		<!-- Font Awesome Icon -->
 		<link rel="stylesheet" href="css/font-awesome.min.css">

 		<!-- Custom stlylesheet -->
 		<link type="text/css" rel="stylesheet" href="css/style.css"/>

		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->

    </head>
	<body>
		<!-- HEADER -->
		<header>
			 <!--TOP HEADER -->
			<div id="top-header">
				<div class="container">
					<ul class="header-links pull-left">
						<li><a href="#"><i class="fa fa-phone"></i> +021-95-51-84</a></li>
						<li><a href="#"><i class="fa fa-envelope-o"></i> shopelectronicdevice@email.com</a></li>
						<li><a href="#"><i class="fa fa-map-marker"></i> 1 Vo Van Ngan, Thu Duc, TP Ho Chi Minh</a></li>
					</ul>
					<ul class="header-links pull-right">
						<%--						<li><a href="#"><i class="fa fa-dollar"></i> USD</a></li>--%>
						<li><a href="#"><i class="fa fa-user-o"></i> My Account</a></li>
					</ul>
				</div>
			</div>
			<!-- /TOP HEADER -->

			<!-- MAIN HEADER -->
			<div id="header">
				<!-- container -->
				<div class="container">
					<!-- row -->
					<div class="row">
						<!-- LOGO -->
						<div class="col-md-3">
							<div class="header-logo">
								<a href="index.jsp" class="logo">
									<img src="./img/logo1.png" alt="">
								</a>
							</div>
						</div>
						<!-- /LOGO -->

						<!-- ACCOUNT -->
						<div style="margin-left: 550px" class="col-md-3 clearfix">
							<div class="header-ctn">
								<!--Notification-->
								<div class="dropdown">
									<a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
										<i class="fa fa-bell"></i>
										<span>Notification</span>
										<div class="qty">1</div>
									</a>
									<ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
										<li><a class="dropdown-item" href="#">Welcome to our shop</a></li>
                                                                        
									</ul>
								</div>
                                                                
								<!-- Cart -->
								<div class="dropdown">
									<a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
										<i class="fa fa-shopping-cart"></i>
										<span>Your Cart</span>
										<div class="qty">3</div>
									</a>
								</div>
								<!-- /Cart -->
							</div>
						</div>
						<!-- /ACCOUNT -->
					</div>
					<!-- row -->
				</div>
				<!-- container -->
			</div>
			<!-- /MAIN HEADER -->
		</header>
		<!-- /HEADER -->
		<form method="post" action="cart">
			<%--@elvariable id="listcart" type="java.util.List" --%>
			<c:set var="listcart" scope="page" value="${listcart}" />
			<c:if test="${empty listcart}">
				<div class="nocartyet">
					<p style="font-size: 15px; line-height: 1.5; margin-left: 505px;">Chưa có sản phẩm nào</p>
					<a href="${pageContext.request.contextPath}/store"
					   style="font-family: Roboto, Helvetica, Arial, sans-serif;line-height: 1.5;text-size-adjust: 100%;text-align: center;box-sizing: border-box;text-decoration: none;width: 190px;border-radius: 4px;color: rgb(74, 74, 74);font-size: 14px;background-color: rgb(253, 216, 53);display: block;margin-left: 480px;">Tiếp
						tục mua sắm</a>
				</div>
			</c:if>
			<c:if test="${not empty listcart}">
				<div class="row">
					<table style="width: 100%;" class="cart">
						<thead>
						<tr>
							<th>Số Lượng</th>
							<th>Mã sản phẩm</th>
							<th>Mã người dùng</th>
							<th>Tên sản phẩm</th>
							<th>Giá</th>
							<th>Ưu đãi</th>
							<th></th>
						</tr>
						</thead>
							<%--@elvariable id="listcart" type="java.util.List" --%>
						<c:forEach items="${listcart}" var="element">
							<tbody>
							<tr>
								<td>
									<form action="cart" method="post">
										<input type="hidden" name="action" value="update">
										<input type="number" value="${element[0]}" name="amount">
										<input type="hidden" value="${element[7]}" name="id">
										<input type="hidden" value="${element[8]}" name="productCode">
										<input type="submit" value="update"
											   style="width: 60px; font-size:15px; margin-left:10px">
									</form>
								</td>
								<td>${element[1]}</td>
								<td>${element[2]}</td>
								<td>${element[3]}</td>
								<td> ${element[4]} VND</td>
								<td>${element[5]}</td>
								<td>
									<a href="cart?action=remove&amp;id=${element[7]}&amp;productCode=${element[8]}"
									   target="myiframe">Xóa
									</a>
								</td>
							</tr>
							</tbody>
						</c:forEach>
					</table>
					<div class="row">
						<div class="col1-md-6 cart__foot">
							<a href="${pageContext.request.contextPath}/cart">
								<button type="button" class="btn btn-kx1">Cập nhật giỏ hàng</button>
							</a>
						</div>
						<div class="col1-md-6 cart__foot2">
							<a href="${pageContext.request.contextPath}/index">
								<button type="button" class="btn btn-kx1">Tiếp tục mua sắm</button>
							</a>
						</div>
						<div class="col1-md-3 cart__foot" style="margin-left: 440px;">
							<button type="button" class="btn btn-kx1">
								<a class="btn-kx2 non-underline-link"
								   href="${pageContext.request.contextPath}/">Mua
									hàng</a>
							</button>
						</div>
					</div>
				</div>
			</c:if>
		</form>

		<!-- FOOTER -->
		<footer id="footer">
			<!-- top footer -->
			<div class="section">
				<!-- container -->
				<div class="container">
					<!-- row -->
					<div class="row">
						<div class="col-md-3 col-xs-6">
							<div class="footer">
								<h3 class="footer-title">About Us</h3>
<%--								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut.</p>--%>
<%--								<ul class="footer-links">--%>
<%--									<li><a href="#"><i class="fa fa-map-marker"></i>1734 Stonecoal Road</a></li>--%>
<%--									<li><a href="#"><i class="fa fa-phone"></i>+021-95-51-84</a></li>--%>
<%--									<li><a href="#"><i class="fa fa-envelope-o"></i>email@email.com</a></li>--%>
<%--								</ul>--%>
								<ul class="footer-links">
									<li><a href="https://www.facebook.com/profile.php?id=100006023145474">Nguyen Trong Hieu</a> </li>
									<li><a href="https://www.facebook.com/nhok.moon.52012">Le Tran Minh Nhut</a> </li>
								</ul>
							</div>
						</div>-->

<!--						<div class="col-md-3 col-xs-6">
							<div class="footer">
								<h3 class="footer-title">Categories</h3>
								<ul class="footer-links">
									<li><a href="#">Hot deals</a></li>
									<li><a href="#">Laptops</a></li>
									<li><a href="#">Smartphones</a></li>
									<li><a href="#">Cameras</a></li>
									<li><a href="#">Accessories</a></li>
								</ul>
							</div>
						</div>-->

						<div class="clearfix visible-xs"></div>

						<div class="col-md-3 col-xs-6">
							<div class="footer">
								<h3 class="footer-title">Information</h3>
<!--								<ul class="footer-links">
									<li><a href="#">About Us</a></li>
									<li><a href="#">Contact Us</a></li>
									<li><a href="#">Privacy Policy</a></li>
									<li><a href="#">Orders and Returns</a></li>
									<li><a href="#">Terms & Conditions</a></li>
								</ul>-->
							</div>
						</div>

						<div class="col-md-3 col-xs-6">
							<div class="footer">
								<h3 class="footer-title">Service</h3>
								<ul class="footer-links">
									<li><a href="#">My Account</a></li>
									<li><a href="#">View Cart</a></li>
									<!--<li><a href="#">Wishlist</a></li>-->
									<!--<li><a href="#">Track My Order</a></li>-->
									<li><a href="#">Help</a></li>
								</ul>
							</div>
						</div>
					</div>
					<!-- /row -->
				</div>
				<!-- /container -->
			</div>
			<!-- /top footer -->

<!--			 bottom footer 
			<div id="bottom-footer" class="section">
				<div class="container">
					 row 
					<div class="row">
						<div class="col-md-12 text-center">
							<ul class="footer-payments">
								<li><a href="#"><i class="fa fa-cc-visa"></i></a></li>
								<li><a href="#"><i class="fa fa-credit-card"></i></a></li>
								<li><a href="#"><i class="fa fa-cc-paypal"></i></a></li>
								<li><a href="#"><i class="fa fa-cc-mastercard"></i></a></li>
								<li><a href="#"><i class="fa fa-cc-discover"></i></a></li>
								<li><a href="#"><i class="fa fa-cc-amex"></i></a></li>
							</ul>
							<span class="copyright">
								 Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. 
								Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
							 Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. 
							</span>
						</div>
					</div>
						 /row 
				</div>
				 /container 
			</div>
			 /bottom footer -->
		</footer>
		<!-- /FOOTER -->

		<!-- jQuery Plugins -->
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/slick.min.js"></script>
		<script src="js/nouislider.min.js"></script>
		<script src="js/jquery.zoom.min.js"></script>
		<script src="js/main.js"></script>

	</body>
</html>

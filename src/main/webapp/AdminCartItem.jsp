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
    <%--    <link type="text/css" rel="stylesheet" href="css/table.css"/>--%>

    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                <li><a href="https://www.google.com/maps/place/Tr%C6%B0%E1%BB%9Dng+%C4%90%E1%BA%A1i+h%E1%BB%8Dc+S%C6%B0+ph%E1%BA%A1m+K%E1%BB%B9+thu%E1%BA%ADt+Th%C3%A0nh+ph%E1%BB%91+H%E1%BB%93+Ch%C3%AD+Minh/@10.8507267,106.7697336,17z/data=!3m1!4b1!4m5!3m4!1s0x31752763f23816ab:0x282f711441b6916f!8m2!3d10.8507214!4d106.7719223?hl=vi-VN"><i class="fa fa-map-marker"></i> 1 Vo Van Ngan, Thu Duc, TP Ho Chi Minh</a></li>
            </ul>
            <ul class="header-links pull-right">

                <li><a href="Login.jsp"><i class="fa fa-user-o"></i> Admin</a></li>
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

                        <!-- Logout -->
                        <div class="button">
                            <a href="index.jsp" >
                                <i class="fa fa-sign-out" aria-hidden="true"></i>
                            </a>

                        </div>
                        <!-- /Logout -->
                        <!-- Menu Toogle -->
                        <div class="menu-toggle">
                            <a href="#">
                                <i class="fa fa-bars"></i>
                                <span>Menu</span>
                            </a>
                        </div>
                        <!-- /Menu Toogle -->
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

<section id="list"class="list">
    <div class="container">
        <h2>List Cart</h2>
        <table class="table table-bordered table-striped table-responsive-stack"  >
            <thead class="thead-dark">
            <tr>
                <th><h3 style="text-align: center">Item ID</h3></th>
                <th><h3 style="text-align: center">Cart ID</h3></th>
                <th><h3 style="text-align: center">Product ID</h3></th>
                <th><h3 style="text-align: center">Amount</h3></th>



            </tr>
            </thead>
            <tbody>

            <c:forEach var="cartitem" items="${listCartItem}">
                <tr>
                    <td style="text-align: center">${cartitem.getId()}</td>
                    <td style="text-align: center">${cartitem.getCartId()}</td>
                    <td style="text-align: center">${cartitem.getProductId()}</td>
                    <td style="text-align: center">${cartitem.getAmount()}</td>
                </tr>
            </c:forEach>
            <a class="btn-info" href="Adminitem?action=confirm&id=${listCartItem.getCartId()}">Confirm</a>


            </tbody>
        </table>


    </div>
    <!-- /.container -->
</section>







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

                        <ul class="footer-links">
                            <li><a href="https://www.facebook.com/profile.php?id=100006023145474">Nguyen Trong Hieu</a> </li>
                            <li><a href="https://www.facebook.com/nhok.moon.52012">Le Tran Minh Nhut</a> </li>
                        </ul>
                    </div>
                </div>
                <div class="clearfix visible-xs"></div>
                <div class="col-md-3 col-xs-6">
                    <div class="footer">
                        <h3 class="footer-title">Service</h3>
                        <ul class="footer-links">
                            <li><a href="#">My Account</a></li>
                            <li><a href="#">View Cart</a></li>

                            <li><a href="#">Help</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- /row -->
        </div>
        <!-- /container -->
    </div>

</footer>
<!-- /FOOTER -->

<!-- jQuery Plugins -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/slick.min.js"></script>
<script src="js/nouislider.min.js"></script>
<script src="js/jquery.zoom.min.js"></script>
<script src="js/main.js"></script>
<%--<script src="js/table.js"></script>--%>
</body>
</html>

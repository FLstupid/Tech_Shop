<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link type="text/css" rel="stylesheet" href="css/Login.css">
    <script src="https://kit.fontawesome.com/0958be80bb.js" crossorigin="anonymous"></script>

</head>
<body>
<div class="bg-img">
<h2>Welcome to Electronic Device Shop</h2>
<div class="container" id="container">
    <div class="form-container sign-up-container">
        <form action="login">
            <input type="hidden" name="action" value="add">
            <h1>Create Account</h1>
            <div class="social-container">
                <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
            </div>
            <span>or use your email for registration</span>
            <input type="text" placeholder="Name" />
            <input type="email" placeholder="Email" />
            <input type="password" placeholder="Password" />
            <input type="password" placeholder="Confirm Password" />
            <button>Sign Up</button>
        </form>
    </div>
    <div class="form-container sign-in-container">
        <form action="login">
            <input type="hidden" name="action" value="signin">
            <h1>Sign in</h1>
            <div class="social-container">
                <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
            </div>
            <span>or use your account</span>
            <input type="email" placeholder="Email" />
            <input type="password" placeholder="Password" />
            <a href="#">Forgot your password?</a>
            <button>Sign In</button>
        </form>
    </div>
    <div class="overlay-container">
        <div class="overlay">
            <div class="overlay-panel overlay-left">
                <a href="index.jsp" class="logo">
                    <img src="./img/logo1.png" alt="">
                </a>
                <h1>Welcome Back!</h1>
                <p>To keep connected with us please login with your personal info</p>
                <button class="ghost" id="signIn">Sign In</button>
            </div>
            <div class="overlay-panel overlay-right">
                <a href="${pageContext.request.contextPath}/index" class="logo">
                    <img src="./img/logo1.png" alt="">
                </a>
                <h1>Hello, Friend!</h1>
                <p>Enter your personal details and start journey with us</p>
                <button class="ghost" id="signUp">Sign Up</button>
            </div>
        </div>
    </div>
</div>
</div>
<!-- jQuery Plugins -->
<script src="js/Login.js"></script>
<script src="js/countdown.js"></script>
</body>
</html>

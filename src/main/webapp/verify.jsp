<%--@elvariable id="message" type="java.lang.String"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Verify Page</title>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" href="css/all.min.css"/>
    <link rel="stylesheet" href="Registration/style.css"/>
    <!-- Logo -->
    <link rel="shortcut icon"
          type="image/x-icon"
          href="">
</head>
<body>
<div style="width: 100%" class="form-container sign-in-container">
    <form action="Emailverify" method="post">
        <input type="hidden" name="action" value="confirm">
        <h1>Nhập Mã Xác Thực</h1>
        <span>Kiểm tra Email của bạn và nhập mã xác thực vào ô bên dưới</span>
        <input style="width: 500px;" type="text" name="authcode1"/>
        <button type="submit" class="btn2 btn-submit">Xác Nhận</button>
        <c:if test="${not empty message}">
            <script>
                window.addEventListener("load", function () {
                    alert("${message}");
                })
            </script>
        </c:if>
    </form>
</div>
</body>
</html>
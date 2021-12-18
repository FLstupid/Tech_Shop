<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Verify Page</title>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" href="css/all.min.css"/>
    <link rel="stylesheet" href="Registration/style.css"/>
    <!-- Logo -->
</head>
<body>
<div style="width: 100%" class="form-container sign-in-container">
    <form action="EmailverifyResetPass" method="post">
        <h1>Nhập Mã Xác Thực</h1>
        <span>Kiểm tra Email của bạn và nhập mã xác thực vào ô bên dưới</span>
        <input style="width: 500px;" type="text" name="authcode"/>
        <button type="submit" id="btn2" value="verify" class="btn2 btn-submit">Xác Nhận</button>
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
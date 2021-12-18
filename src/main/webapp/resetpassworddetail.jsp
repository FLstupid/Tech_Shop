<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Verify Page</title>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" href="css/all.min.css"/>
    <link rel="stylesheet" href="Registration/style.css"/>
</head>
<body>
<div style="width: 100%" class="form-container sign-in-container">
    <form action="resetpassworddetail.jsp" method="post">
        <h1>Nhập Mật Khẩu Mới</h1>
        <input style="width: 500px;" type="password" name="newpass"/>
        <input style="width: 500px;" type="password" name="confirmnewpasss"/>
        <button type="submit" id="btn2" value="verify" class="btn2 btn-submit">Xác Nhận</button>
        <%--@elvariable id="message4" type="java.lang.String"--%>
        <c:if test="${not empty message4}">
            <script>
                window.addEventListener("load", function () {
                    alert("${message4}");
                })
            </script>
        </c:if>
    </form>
</div>
</head>
</body>
</html>
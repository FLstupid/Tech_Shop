<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
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
    <form action="reset_password" method="post">
        <input type="hidden" name="action" value="resetpass">
        <h2>Khôi phục mật khẩu</h2>
        <p>
            Xin hãy nhập email tài khoản của bạn chúng tôi sẽ gửi 1 mã xác thực đến:
        </p>
        <input style="width: 500px" type="text" name="email" id="email" />
        <button type="submit" class="btn2 btn-submit">Xác Nhận</button>
        <%--@elvariable id="message5" type="java.lang.String"--%>
        <c:if test="${not empty message5}">
            <script>
                window.addEventListener("load", function () {
                    alert("${message5}");
                })
            </script>
        </c:if>
    </form>
</div>
</body>
</html>
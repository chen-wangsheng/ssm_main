<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>权限</title>
    <script src="js/jquery.min.js"></script>
    <script>
         $(function () {
            $("#403_pic").click(function () {
                location.href = "${pageContext.request.contextPath}/index.jsp";
            });
        });
    </script>
</head>
<body>
    <img src="${pageContext.request.contextPath}/images/error_403.png" id="403_pic"/>
</body>
</html>

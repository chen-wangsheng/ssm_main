<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>页面不存在</title>
    <script src="js/jquery.min.js"></script>
    <script>
        $(function () {
            $("#404_pic").click(function () {
                location.href = "${pageContext.request.contextPath}/index.jsp";
            });
        });

    </script>
</head>
<body>
<img src="${pageContext.request.contextPath}/images/error_404.jpg" id="404_pic"/>
</body>
</html>

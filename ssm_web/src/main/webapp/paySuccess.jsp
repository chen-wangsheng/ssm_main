<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>支付成功</title>
</head>
<body>
	恭喜你付款成功！<br>
	<a href="index.jsp">继续购买</a> &nbsp;
	<a href="${pageContext.request.contextPath}/order/findOrdersAll.do?id=${sessionScope.member.id}">查看订单</a>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>商品分类查询</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
</head>
<script>
        function buy(productId, memberId) {
            if (memberId != '') {
                $.ajax({
                    url: "${pageContext.request.contextPath}/member/buyProduct.do",
                    data: {"productId": productId, "memberId": memberId},
                    type: "get",
                    dataType: "json",
                    success: function (result) {
                        if (result) {
                            alert("添加购物车成功！");
                        } else {
                            alert("添加购物车失败！")
                        }
                    }
                });
            } else {
                alert("您还未登录，请登录后再购买！");
            }
        }
</script>

<body>
<!-- 页面头部 -->
<jsp:include page="header.jsp"></jsp:include>
<!--main开始-->

<div class="main">
    <div class="main-inner body-width">
        <!--模块-->
        <div class="main-cont main-recommend">
            <div class="main-cont__title">
                <h3>${categoryName}</h3>
            </div>
            <ul class="main-cont__list clearfix">
                <c:forEach items="${products}" var="product" varStatus="obj">
                    <c:if test="${obj.count<=5}">
                        <li class="item">
                            <a href="#" class="pic">
                                <img src="/img1/${product.productPic}" width="224px" height="224px" alt="#">
                            </a>
                            <div class="info">
                                <a href="#" class="title">${product.productName}&nbsp;|&nbsp;${product.productPrice}元</a>
                                <span title="${product.productDesc}">
                                    <c:if test="${product.productDesc.length() <=10 }">
                                        ${product.productDesc}
                                    </c:if>
                                    <c:if test="${product.productDesc.length() > 10 }">
                                        ${ fn:substring(product.productDesc ,0,10)}...
                                    </c:if>
                                </span>
                                <div onclick="buy('${product.id}','${sessionScope.member.id}');">
                                    <a class="icon-text__pink purchase">立即购买</a>
                                </div>
                            </div>
                        </li>
                    </c:if>
                </c:forEach>
            </ul>
        </div>
        <!--模块1-->

        <div class="main-cont main-recommend">
            <div class="main-cont__title1"></div>
            <ul class="main-cont__list clearfix">
                <c:forEach items="${products}" var="product" varStatus="obj">
                    <c:if test="${obj.count>5}">
                        <li class="item">
                            <a href="#" class="pic">
                                <img src="/img1/${product.productPic}" width="224px" height="224px" alt="#">
                            </a>
                            <div class="info">
                                <a href="#" class="title">${product.productName}&nbsp;|&nbsp;${product.productPrice}元</a>
                                <span title="${product.productDesc}">
                                    <c:if test="${product.productDesc.length() <=10 }">
                                        ${product.productDesc}
                                    </c:if>
                                    <c:if test="${product.productDesc.length() > 10 }">
                                        ${ fn:substring(product.productDesc ,0,10)}...
                                    </c:if>
                                </span>
                                 <div onclick="buy('${product.id}','${sessionScope.member.id}');">
                                    <a class="icon-text__pink purchase">立即购买</a>
                                </div>
                            </div>
                        </li>
                    </c:if>
                </c:forEach>
            </ul>
        </div>

        <%--<!--模块2-->
        <div class="main-cont main-recommend">
            <div class="main-cont__title1"></div>
            <ul class="main-cont__list clearfix">
                <li class="item">
                    <a href="#" class="pic"><img src="images/cont/main_img6.jpg" alt="#"></a>
                    <div class="info">
                        <a href="#" class="title">夹克</a>
                        <span>18739人在逛</span>
                        <a href="#" class="icon-text__pink purchase">良品购</a>
                    </div>
                </li>
                <li class="item">
                    <a href="#" class="pic"><img src="images/cont/main_img7.jpg" alt="#"></a>
                    <div class="info">
                        <a href="#" class="title">夹克</a>
                        <span>18739人在逛</span>
                        <a href="#" class="icon-text__pink purchase">良品购</a>
                    </div>
                </li>
                <li class="item">
                    <a href="#" class="pic"><img src="images/cont/main_img8.jpg" alt="#"></a>
                    <div class="info">
                        <a href="#" class="title">夹克</a>
                        <span>18739人在逛</span>
                        <a href="#" class="icon-text__pink purchase">良品购</a>
                    </div>
                </li>
                <li class="item">
                    <a href="#" class="pic"><img src="images/cont/main_img9.jpg" alt="#"></a>
                    <div class="info">
                        <a href="#" class="title">夹克</a>
                        <span>18739人在逛</span>
                        <a href="#" class="icon-text__pink purchase">良品购</a>
                    </div>
                </li>
                <li class="item">
                    <a href="#" class="pic"><img src="images/cont/main_img10.jpg" alt="#"></a>
                    <div class="info">
                        <a href="#" class="title">夹克</a>
                        <span>18739人在逛</span>
                        <a href="#" class="icon-text__pink purchase">良品购</a>
                    </div>
                </li>
            </ul>
        </div>--%>


    </div>
</div>
<!--/main结束-->
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

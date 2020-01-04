<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<header class="header">
    <div class="header-inner body-width">
        <a href="#" class="logo"></a>
        <div class="category">
            <!--<a href="#" class="category-link">分类</a>
            <i class="icon-arrow"></i>
            <div class="category-result"></div>-->
            <!-- 边框 -->
            <!--<span class="btn-border"></span>-->
            <span class="result-border"></span>
            <span class="neck-border"></span>
        </div>
        <div class="search">
            <input type="text" class="search-text" placeholder="Seach here...">
            <button class="search-btn" id="search_bth"><i class="icon-search"></i></button>
        </div>
        <nav class="header-nav">
            <ul>
                <li>
                    <span class="line"></span>
                    <a href="${pageContext.request.contextPath}/index.jsp">首页</a>
                    <!--<i class="icon-text__pink icon-new">new</i>-->
                </li>
                <li>
                    <span class="line"></span>
                    <a id="regist" href="${pageContext.request.contextPath}/register.jsp"
                       class="">注册</a>
                </li>
                <li>
                    <span class="line"></span>
                    ${sessionScope.member.name}
                    <c:if test="${member.name == null}">
                        <a id="login" href="${pageContext.request.contextPath}/login.jsp">登录</a>
                    </c:if>
                    <c:if test="${member.name != null}">
                        <a id="login" href="${pageContext.request.contextPath}/member/logout.do">退出</a>
                    </c:if>
                </li>
                <li>
                    <span class="line"></span>
                    <a href="${pageContext.request.contextPath}/order/findAll.do?id=${sessionScope.member.id}"
                       class="app">购物车</a>
                </li>
                <li>
                    <span class="line"></span>
                    <a href="${pageContext.request.contextPath}/order/findOrdersAll.do?id=${sessionScope.member.id}"
                       class="app">我的订单</a>
                </li>
            </ul>
        </nav>
    </div>
    <div class="header-shadow"></div>
</header>
<script>
    $(".search-btn").click(function () {
        var $text = $(".search-text").val();
        location.href = "${pageContext.request.contextPath}/index/search.do?name=" + $text;
    });

    $(document).ready(function () {
        $(".header-nav a").each(function () {
            $this = $(this);
            if ($this[0].href == String(window.location)) {
                //class="icon-text__pink register"

                $this.addClass("icon-text__pink register");
            }
        });
    });
</script>

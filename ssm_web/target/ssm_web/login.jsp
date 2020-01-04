<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="utf-8">
    <meta name="keywords" content=""/>
    <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet" type="text/css"
          media="all">
    <link href="${pageContext.request.contextPath}/css/style1.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="http://fonts.googleapis.com/css?family=Raleway:400,500,600,700,800,900" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script>

    </script>
</head>
<body>
<%session.invalidate();%>
<div class="signupform">
    <h1>用户登录</h1>
    <div class="container">

        <div class="agile_info">
            <div class="w3l_form">
                <div class="left_grid_info">
                    <h3>欢迎登录!</h3>
                    <h4>服务条款的确认和接纳</h4>
                    <p>
                        本站的各项电子服务的所有权和运作权归本站。本站提供的服务将完全按照其发布的服务条款和操作规则严格执行。用户同意所有服务条款并完成注册程序，才能成为本站的正式用户。用户确认：本协议条款是处理双方权利义务的约定，除非违反国家强制性法律，否则始终有效。在下订单的同时，您也同时承认了您拥有购买这些产品的权利能力和行为能力，并且将您对您在订单中提供的所有信息的真实性负责。
                    </p>

                </div>
            </div>
            <div class="w3_info">
                <h2>登录</h2>
                <p>请填写信息！</p>
                <form action="${pageContext.request.contextPath}/index/login.do" method="post">
                    <div class="input-group">
                        <span><i class="fa fa-user" aria-hidden="true"></i></span>
                        <input type="text" placeholder="用户名" name="name">
                    </div>

                    <div class="input-group">
                        <span><i class="fa fa-lock" aria-hidden="true"></i></span>
                        <input type="Password" placeholder="密码" name="password">
                    </div>
                    <input type="checkbox" value="remember-me"/> <h4>记住密码 </h4>
                    <a href="${pageContext.request.contextPath}/register.jsp" style="float: right"><h4
                            style="color: gray">去注册 </h4></a>
                    <button class="btn btn-danger btn-block" type="submit">登录</button>
                </form>
            </div>
            <div class="clear"></div>
        </div>

    </div>
    <div class="footer">
    </div>
</div>
</body>
</html>
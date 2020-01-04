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
        $(function () {
            $("#btn").click(function () {
                var pwd1 = $("#password1").val();
                var pwd2 = $("#password2").val();
                if($("#username").val()==''){
                    alert("用户名不能为空！")
                    return;
                }
                if(pwd1==''||pwd2==''){
                    alert("密码不能为空！")
                    return;
                }
                if (pwd1 == pwd2) {
                    $.ajax({
                        url: "${pageContext.request.contextPath}/member/register.do",
                        type: "post",
                        data:{"name":$("#username").val(),"password":$("#password1").val(),"email":$("#email").val(),"phoneNum":$("#phoneNum").val()},
                        dataType: "json",
                        success: function (result) {
                            if(result){
                                $("#regForm").empty();
                                window.location.href="${pageContext.request.contextPath}/login.jsp";
                            }else {
                                alert("注册失败！");
                                window.location.href="${pageContext.request.contextPath}/register.jsp";
                            }
                        }
                    });
                    return;
                } else {
                    alert("两次输入密码不一样！")
                    return;
                }
            });

            function registPost() {

            }
        })


    </script>
</head>
<body>
<%session.invalidate();%>
<div class="signupform">
    <h1>用户注册</h1>
    <div class="container">

        <div class="agile_info">
            <div class="w3l_form">
                <div class="left_grid_info">
                    <h3>欢迎注册!</h3>
                    <h4>帐号、密码和安全性</h4>
                    <p>
                        一旦成功注册成为会员，您将有一个密码和用户名。用户将对用户名和密码的安全负全部责任。另外，每个用户都要对以其用户名进行的所有活动和事件负全责。您可以随时改变您的密码。用户若发现任何非法使用用户帐号或存在安全漏洞的情况，请立即通告本站。
                    </p>

                </div>
            </div>
            <div class="w3_info">
                <h2>注册</h2>
                <p><span id="message">请填写信息！</span></p>
                <form method="post" id="regForm">
                    <div class="input-group">
                        <span><i class="fa fa-user" aria-hidden="true"></i></span>
                        <input id="username" type="text" placeholder="用户名" name="name">
                    </div>
                    <div class="input-group">
                        <span><i class="fa fa-phone" aria-hidden="true"></i></span>
                        <input id="phoneNum" type="text" placeholder="手机号" name="phoneNum">
                    </div>
                    <div class="input-group">
                        <span><i class="fa fa-envelope" aria-hidden="true"></i></span>
                        <input id="email" type="email" placeholder="电子邮箱" name="email">
                    </div>
                    <div class="input-group">
                        <span><i class="fa fa-lock" aria-hidden="true"></i></span>
                        <input id="password1" type="Password" placeholder="密码" name="password">
                    </div>
                    <div class="input-group">
                        <span><i class="fa fa-lock" aria-hidden="true"></i></span>
                        <input id="password2" type="Password" placeholder="确认密码" name="password1">
                    </div>
                </form>
                <button class="btn btn-danger btn-block"  id="btn">注册</button>

            </div>
            <div class="clear"></div>
        </div>

    </div>
    <div class="footer">

    </div>
</div>
</body>
</html>
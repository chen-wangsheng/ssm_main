<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>首页</title>
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/script.js"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
    <%-- <script>
         //设置页面刷新一次
         $(document).ready(function () {
             if (location.href.indexOf("#reloaded") == -1) {
                 location.href = location.href + "#reloaded";
                 location.reload();
             }
         });
     </script>--%>
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

        $(function () {
            //公告显示
            $(".choose a").click(function () {
                //显示模态框
                // 关键代码，如没将modal设置为 block，则$modala_dialog.height() 为零
                $("#noticeModal").css('display', 'block');
                var modalHeight = $(window).height() / 6 - $("#noticeModal").height() / 2;
                $("#noticeModal").find('.modal-dialog').css({
                    'margin-top': modalHeight
                });
                // $("#noticeModal").modal('show');
                //获取自定义属性noticeId
                var noticeId = $(this).attr("noticeId");//注意此处是this
                $.ajax({
                    url: "${pageContext.request.contextPath}/notice/findById.do",
                    data: {"noticeId": noticeId},
                    type: "get",
                    dataType: "json",
                    success: function (result) {
                        // console.log(result);
                        //将数据添加到模态框
                        $("#recipient-name").val(result.noticeTitle);
                        $("#message-text").val(result.noticeContent);
                        $("#notice-time").val(result.createTime);
                        $("#noticeModal").modal('show');
                    }
                });
            });
            $(".modal-footer").click(function () {
                $("#recipient-name").val("");
                $("#message-text").val("");
                $("#notice-time").val("")
                $("#noticeModal").modal('hide');
            });

        });


    </script>
</head>
<body>
<!-- 页面头部 -->
<jsp:include page="header.jsp"></jsp:include>

<!--main开始-->
<div class="main">
    <div class="main-inner body-width">
        <div class="banner clearfix">
            <div class="slider" id="slider">
                <ul class="slider-wrapper">
                    <li class="item" data-title="盛大开业！全场折扣，快！快！快！">
                        <a href="#" class="pic"><img
                                src="${pageContext.request.contextPath}/images/cont/slider_img1.jpg" alt="#"></a>
                    </li>
                    <li class="item" data-title="年终促销 折扣+包邮">
                        <a href="#" class="pic"><img
                                src="${pageContext.request.contextPath}/images/cont/slider_img2.jpg" alt="#"></a>
                    </li>
                    <li class="item" data-title="小家电温暖过冬" data-author="精选臻品">
                        <a href="#" class="pic"><img
                                src="${pageContext.request.contextPath}/images/cont/slider_img3.jpg" alt="#"></a>
                    </li>
                    <li class="item" data-title="时尚冬日，一件外套保护你">
                        <a href="#" class="pic"><img
                                src="${pageContext.request.contextPath}/images/cont/slider_img4.jpg" alt="#"></a>
                    </li>
                    <li class="item" data-title="Keep Moving 永不止步......">
                        <a href="#" class="pic"><img
                                src="${pageContext.request.contextPath}/images/cont/slider_img5.jpg" alt="#"></a>
                    </li>
                </ul>
                <a href="javascript:;" class="slider-prev"></a>
                <a href="javascript:;" class="slider-next"></a>
                <div class="slider-title">
                    <h2></h2>
                    <span></span>
                </div>
                <div class="slider-btns">
                    <span class="item"></span>
                    <span class="item"></span>
                    <span class="item"></span>
                    <span class="item"></span>
                    <span class="item"></span>
                </div>
            </div>
            <div class="banner-info">
                <div class="news body-border">
                    <ul>
                        <li class="title">最近公告</li>
                        <c:forEach items="${notices}" var="notice">
                            <li class="choose">
                                <a href="javascript:void(0)"
                                   noticeId="${notice.id}">『${notice.noticeTitle}』${notice.createTimeStr}</a>
                                    <%-- <span class="icon-text__pink">精选</span>--%>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
                <div class="app body-border">
                    <a href="#"></a>
                </div>
            </div>
        </div>
        <!--模块-->
        <div class="main-cont main-recommend">
            <div class="main-cont__title">
                <h3>电子产品</h3>
                <a href="${pageContext.request.contextPath}/product/findAllByCategoryId.do?categoryId=1001"
                   class="more">更多商品</a>
            </div>
            <ul class="main-cont__list clearfix">
                <c:forEach items="${list1}" var="electronics">
                    <li class="item">
                        <a href="#" class="pic">
                            <img src="/img1/${electronics.productPic}" width="224px" height="224px" alt="#">
                        </a>
                        <div class="info">
                            <a href="#" class="title">${electronics.productName}&nbsp;|&nbsp;${electronics.productPrice}元</a>
                            <span title="${electronics.productDesc}">
                                <c:if test="${electronics.productDesc.length() <=10 }">
                                    ${electronics.productDesc}
                                </c:if>
                                <c:if test="${electronics.productDesc.length() > 10 }">
                                    ${ fn:substring(electronics.productDesc ,0,10)}...
                                </c:if>
                            </span>
                            <div onclick="buy('${electronics.id}','${sessionScope.member.id}');">
                                <a class="icon-text__pink purchase">立即购买</a>
                            </div>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <!--模块1-->
        <div class="main-cont main-recommend">
            <div class="main-cont__title">
                <h3>时尚服装</h3>
                <a href="${pageContext.request.contextPath}/product/findAllByCategoryId.do?categoryId=1002"
                   class="more">更多商品 ></a>
            </div>
            <ul class="main-cont__list clearfix">
                <c:forEach items="${list2}" var="electronics">
                    <li class="item">
                        <a href="#" class="pic">
                            <img src="/img1/${electronics.productPic}" width="224px" height="224px" alt="#">
                        </a>
                        <div class="info">
                            <a href="#" class="title">${electronics.productName}&nbsp;|&nbsp;${electronics.productPrice}元</a>
                            <span title="${electronics.productDesc}">
                                <c:if test="${electronics.productDesc.length() <=10 }">
                                    ${electronics.productDesc}
                                </c:if>
                                <c:if test="${electronics.productDesc.length() > 10 }">
                                    ${ fn:substring(electronics.productDesc ,0,10)}...
                                </c:if>
                            </span>
                            <div onclick="buy('${electronics.id}','${sessionScope.member.id}');">
                                <a class="icon-text__pink purchase">立即购买</a>
                            </div>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>

        <!--模块2-->
        <div class="main-cont main-recommend">
            <div class="main-cont__title">
                <h3>畅销书籍</h3>
                <a href="${pageContext.request.contextPath}/product/findAllByCategoryId.do?categoryId=1003"
                   class="more">更多商品 ></a>
            </div>
            <ul class="main-cont__list clearfix">
                <c:forEach items="${list3}" var="electronics">
                    <li class="item">
                        <a href="#" class="pic">
                            <img src="/img1/${electronics.productPic}" width="224px" height="224px" alt="#">
                        </a>
                        <div class="info">
                            <a href="#" class="title">${electronics.productName}&nbsp;|&nbsp;${electronics.productPrice}元</a>
                            <span title="${electronics.productDesc}">
                                <c:if test="${electronics.productDesc.length() <=10 }">
                                    ${electronics.productDesc}
                                </c:if>
                                <c:if test="${electronics.productDesc.length() > 10 }">
                                    ${ fn:substring(electronics.productDesc ,0,10)}...
                                </c:if>
                            </span>
                            <div onclick="buy('${electronics.id}','${sessionScope.member.id}');">
                                <a class="icon-text__pink purchase">立即购买</a>
                            </div>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <!--模块3-->
        <div class="main-cont main-recommend">
            <div class="main-cont__title">
                <h3>家用电器</h3>
                <a href="${pageContext.request.contextPath}/product/findAllByCategoryId.do?categoryId=1004"
                   class="more">更多商品 ></a>
            </div>
            <ul class="main-cont__list clearfix">
                <c:forEach items="${list4}" var="electronics">
                    <li class="item">
                        <a href="#" class="pic">
                            <img src="/img1/${electronics.productPic}" width="224px" height="224px" alt="#">
                        </a>
                        <div class="info">
                            <a href="#" class="title">${electronics.productName}&nbsp;|&nbsp;${electronics.productPrice}元</a>
                            <span title="${electronics.productDesc}">
                                <c:if test="${electronics.productDesc.length() <=10 }">
                                    ${electronics.productDesc}
                                </c:if>
                                <c:if test="${electronics.productDesc.length() > 10 }">
                                    ${ fn:substring(electronics.productDesc ,0,10)}...
                                </c:if>
                            </span>
                            <div onclick="buy('${electronics.id}','${sessionScope.member.id}');">
                                <a class="icon-text__pink purchase">立即购买</a>
                            </div>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>

    </div>
</div>
<!--/main结束-->

<!--模态框-->
<div class="modal fade" id="noticeModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="exampleModalLabel">公告详情</h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="recipient-name" class="control-label">标题</label>
                        <input type="text" class="form-control" id="recipient-name">
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="control-label">内容</label>
                        <textarea class="form-control" id="message-text" rows="10" style="min-width: 90%"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="notice-time" class="control-label">发布时间</label>
                        <input type="text" class="form-control" id="notice-time">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default">关闭</button>
            </div>
        </div>
    </div>
</div>
<!--//模态框-->

<!-- 页面底部 -->
<jsp:include page="footer.jsp"></jsp:include>


</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index_cart.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript">

        function addOrDeleteNumber(num, pid) {
            var memberId = '${sessionScope.member.id}';
            if (num <= 0) {
                alert("购买数量最少为1");
                return false;
            }
            if (num >= 11) {
                alert("购买数量最多为10个");
                return false;
            }
            $.ajax({
                url:"${pageContext.request.contextPath}/order/addOrDeleteNumber.do",
                data:{"num":num,"productId":pid,"memberId":memberId},
                type:"get",
                dataType:"json",
                success:function (result) {
                    if(result){
                        location.reload();//操作成功刷新页面
                    }else {
                        alert("操作失败！")
                    }
                }
            });
        }

        //购物车去支付页面后台
        function pay(sum_price) {
             $obj = $(".payAllPid");
             var arr = new Array();
             $obj.each(function (i, dom) {
                 arr[i] = $(dom).attr("pid");
             });
             var pids = arr.join("&");
             var memberId = '${sessionScope.member.id}';
             if(memberId != ''||memberId != null){
                 window.location.href = "${pageContext.request.contextPath}/order/toPay.do?"+pids+"&sum_price="+ sum_price+"&memberId="+memberId;
             }else {
                 alert("请登录后再支付！");
             }
        }
        //删除商品
        function delProduct(orderId) {
             $.ajax({
                url:"${pageContext.request.contextPath}/order/deleteById.do",
                data:{"orderId":orderId},
                type:"get",
                dataType:"json",
                success:function (result) {
                    if(result){
                        location.reload();//操作成功刷新页面
                    }else {
                        alert("操作失败！")
                    }
                }
            });
        }

    </script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<div class="trolley_background">
    <div class="trolley_background_in">
        <div class="tro_tab_h">
            <div class="col tro_tab_img">
            </div>
            <p class="col tro_tab_name">商品名称</p>
            <div class="col tro_tab_img">
            </div>
            <div class="col tro_tab_price">单价</div>
            <div class="col tro_tab_num">数量</div>
            <div class="col tro_tab_total">小计</div>
            <div class="col tro_tab_action">操作</div>
        </div>
        <!-- 设置变量 -->
        <c:set var="total_price" value="0"></c:set>
        <c:forEach items="${carts}" var="c">
            <div class="tro_tab_h1">
                <div class="col tro_tab_img">
                </div>
                <div class="col tro_tab_name">
                    <input type="hidden" pid="productId=${c.product.id}" class="payAllPid"/>
                    <li class="tro_tab_name_li1" style="font-size: 16px;">${c.product.productName}</li>
                </div>
                <div class="col tro_tab_img">
                    <img src="/img1/${c.product.productPic}" alt="">
                </div>
                <div class="col tro_tab_price">
                    <span id="price">${c.product.productPrice}</span><span>元</span>
                </div>
                <div class="col tro_tab_num">
                    <a class="tro_tab_num_p1" id="subtract" href="javascript:void(0)"
                       onclick="addOrDeleteNumber('${c.productCount-1}','${c.product.id}')">-</a>
                    <input type="text" value="${c.productCount}" id="num">
                    <a class="tro_tab_num_p2" id="plus" href="javascript:void(0)"
                       onclick="addOrDeleteNumber('${c.productCount+1}','${c.product.id}')">+</a>
                </div>

                <div class="col tro_tab_total ">
                    <span class="tro_tab_total_value" id="prices">${c.productCount*c.product.productPrice}</span>元
                </div>
                <c:set var="total_price" value="${c.productCount*c.product.productPrice+total_price}"></c:set>
                <div class="col tro_tab_action" style="cursor: pointer;width: 40px;height: 40px;"
                     onclick="delProduct('${c.id}')">
                    删除
                </div>
            </div>
        </c:forEach>

    </div>

    <div class="tro_close_bot ">
        <!--<p class="tro_bot_ppp">+</p>-->
        <p class="tro_close_p "><a href="${pageContext.request.contextPath}/index/index.do">继续购物 </a> |
            共<span>${carts.size()}</span>种商品</p>

        <p class="tro_close_p_c">合计:<span id="close">${total_price}</span>元</p>

        <p class="tro_close_p_r" style="cursor: pointer;" onclick="pay('${total_price}')">去结算</p>
    </div>

</div>


<jsp:include page="footer.jsp"></jsp:include>


</body>
</html>
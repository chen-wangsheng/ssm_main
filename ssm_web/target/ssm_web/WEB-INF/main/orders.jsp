<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>订单处理</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="description" content=""/>
    <meta name="format-detection" content="telephone=no"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/tasp.css"/>
    <link href="${pageContext.request.contextPath}/css/orderconfirm.css" rel="stylesheet"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>

    <style>
        #page {
            width: auto;
        }

        #comm-header-inner,
        #content {
            width: 950px;
            margin: auto;
        }

        #logo {
            padding-top: 26px;
            padding-bottom: 12px;
        }

        #header .wrap-box {
            margin-top: -67px;
        }

        #logo .logo {
            position: relative;
            overflow: hidden;
            display: inline-block;
            width: 140px;
            height: 35px;
            font-size: 35px;
            line-height: 35px;
            color: #f40;
        }

        #logo .logo .i {
            position: absolute;
            width: 140px;
            height: 35px;
            top: 0;
            left: 0;
            background: url(http://a.tbcdn.cn/tbsp/img/header/logo.png);
        }
    </style>

</head>
<body data-spm="1">

<!-- 页面头部 -->
<jsp:include page="header.jsp"></jsp:include>

<div id="page">

    <div id="content" class="grid-c">

        <form id="J_Form" name="J_Form" action="#" method="post">

            <div>
                <div class="main-cont__title">
                    <h3>订单详情</h3>
                </div>
                <table cellspacing="0" cellpadding="0" class="order-table" id="J_OrderTable">
                    <thead>
                    <tr>
                        <th class="s-title">订单号
                            <hr/>
                        </th>
                        <th class="s-title">宝贝
                            <hr/>
                        </th>
                        <th class="s-price">状态
                            <hr/>
                        </th>
                        <th class="s-price">单价(元)
                            <hr/>
                        </th>
                        <th class="s-amount">数量
                            <hr/>
                        </th>
                        <th class="s-agio">时间
                            <hr/>
                        </th>
                        <%-- <th class="s-total">支付
                             <hr/>
                         </th>--%>
                        <th class="s-total">小计(元)
                            <hr/>
                        </th>
                    </tr>
                    </thead>

                    <tbody data-spm="3" class="J_Shop" data-tbcbid="0" data-outorderid="47285539868" data-isb2c="false"
                           data-postMode="2" data-sellerid="1704508670">
                    <tr class="shop blue-line">
                        <td colspan="2" class="promo">
                            <div>
                            </div>
                        </td>
                    </tr>
                    <!--订单详情显示-->

                    <c:set var="sum_price" value="0"></c:set>
                    <c:forEach items="${orders}" var="orders">
                        <tr class="item">
                            <td class="s-title">${orders.orderNum}</td>
                            <td class="s-title">
                                <a href="#" target="_blank" title="${orders.orderDesc}"
                                   class="J_MakePoint">
                                    <img src="/img1/${orders.product.productPic}" class="itempic">
                                    <span class="title J_MakePoint">${orders.orderDesc}</span>
                                </a>
                                <div class="props">
                                    <span>${orders.product.productName}</span><br/>
                                    <span title="${orders.product.productDesc}">
                                    <c:if test="${orders.product.productDesc.length() <=10 }">
                                        ${orders.product.productDesc}
                                    </c:if>
                                    <c:if test="${orders.product.productDesc.length() > 10 }">
                                        ${ fn:substring(orders.product.productDesc ,0,10)}...
                                    </c:if>
                                </span>
                                </div>
                            </td>
                            <td class="s-amount">
                                <c:if test="${orders.orderStatus==0}">
                                    未支付
                                </c:if>
                                <c:if test="${orders.orderStatus==1}">
                                    已支付
                                </c:if>
                            </td>
                            <td class="s-price">
										<span class='price '>
										 <em class="style-normal-small-black J_ItemPrice">${orders.product.productPrice}</em>
										</span>
                            </td>
                            <td class="s-amount">${orders.productCount}</td>
                            <td class="s-agio">
                                <div class="J_Promotion promotion">${orders.orderTimeStr}</div>
                            </td>
                                <%-- 支付方式
                                 <td class="s-agio">
                                     <div class="J_Promotion promotion"><span>${orders.payTypeStr}</span></div>
                                 </td>--%>
                            <td class="s-total">
										<span class='price '>
										 <em class="style-normal-bold-red J_ItemTotal ">${orders.productCount*orders.product.productPrice}</em>
										</span>
                            </td>
                            <c:set var="sum_price"
                                   value="${orders.productCount*orders.product.productPrice+sum_price}"></c:set>
                        </tr>
                    </c:forEach>
                    <%-- <!--数据2-->
                     <tr class="item">
                         <td class="s-title">
                             <a href="#" target="_blank" title="Huawei/华为 G520新款双卡双待安卓系统智能手机4.5寸四核手手机"
                                class="J_MakePoint">
                                 <img src="http://img03.taobaocdn.com/bao/uploaded/i3/18670026332876589/T1A4icFbNeXXXXXXXX_!!0-item_pic.jpg_60x60.jpg"
                                      class="itempic"><span class="title J_MakePoint"
                                                            data-point-url="http://log.mmstat.com/buy.1.5">Huawei/华为 G520新款双卡双待安卓系统智能手机4.5寸四核手手机</span>
                             </a>
                             <div class="props">
                                 <span>机身颜色: 黑 </span>
                                 <span>手机套餐: 套餐二 </span>
                                 <span>机身内存: 4G </span>
                                 <span>版本: 中国大陆 </span>
                             </div>
                         </td>
                         <td class="s-price">
                                         <span class='price '>
                                          <em class="style-normal-small-black J_ItemPrice">630.00</em>
                                         </span>
                         </td>
                         <td class="s-amount">1</td>
                         <td class="s-agio">
                             <div class="J_Promotion promotion">无优惠</div>
                         </td>
                         <td class="s-total">
                                         <span class='price '>
                                          <em class="style-normal-bold-red J_ItemTotal ">630.00</em>
                                         </span>
                         </td>
                     </tr>--%>
                    <!--/订单详情显示-->
                    <%--
                                        <tr class="shop-total blue-line">
                                            <td colspan="7">店铺合计(不含运费)：
                                                <span class='price g_price '>
                     <span>&yen;</span><em class="style-middle-bold-red J_ShopTotal">${sum_price}</em>
                                                            </span>
                                                <input type="hidden" name="1704508670:2|creditcard" value="false"/>
                                                <input type="hidden" id="J_IsLadderGroup" name="isLadderGroup" value="false"/>

                                            </td>
                                        </tr>--%>
                    </tbody>
                    <tfoot>
                    <tr>
                        <td colspan="12">
                            <div class="order-go">
                                <div class="kd-popup pop-back">
                                    <a href="${pageContext.request.contextPath}/index/index.do" style="float: right"
                                       class="back J_MakePoint" target="_top">去首页</a>
                                </div>
                            </div>
                        </td>
                    </tr>
                    </tfoot>
                </table>
            </div>
        </form>
    </div>

    <div id="footer"></div>
</div>
<div style="text-align:center;">
</div>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <%
        String base = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + base;
    %>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>结算页面</title>
    <link rel="stylesheet" href="../css/common.css"/>
    <link rel="stylesheet" href="../css/icons.css"/>
    <link rel="stylesheet" href="../css/table.css"/>
    <link rel="stylesheet" href="../css/orderSure.css"/>
    <script type="text/javascript">

        function showAdres(sp) {
            var pa = document.getElementById("newAdres");
            console.log(pa.style['display']);
            if (pa.style['display'] == "none") {
                pa.style['display'] = 'block';
                sp.innerHTML = "取消新增地址";
            } else {
                pa.style['display'] = 'none';
                sp.innerHTML = "新增收货地址";
            }
        }
    </script>
</head>
<body>
<!--顶部-->
<div class="top">
    <div class="top_center">
        <ul class="top_bars">
            <li>
                ${customer.name}，欢迎您！
                <a href="<%=basePath%>/loginOutServlet">退出</a>|
            </li>
            <li><a href="<%=basePath%>/user/listOrdersServlet">我的订单<span class="jt_down"></span></a>|</li>
            <li><a href="#">关注杰普<span class="jt_down"></span></a>|</li>
            <li><a href="#">网站导航<span class="jt_down"></span></a></li>
        </ul>
    </div>
</div>
<!--头部-->
<div class="header3">
    <a href="#"><img src="../images/logo.png" class="oneImg"></a>


    <div class="h3_right">
        <img src="../images/play_03.png" alt="">
    </div>

</div>
<p class="orderButtom">填写并核对订单信息</p>
<!--中间复杂部分-->
<div class="content">
    <div class="contentCenter">

        <form action="<%=basePath%>/user/submitOrderServlet" name="orderForm" method="post">

            <div class="centerTop">
                <b style="font-size:20px;">收货人信息</b>

                <b style="float: right;cursor: pointer;" onclick="showAdres(this);"
                   ondblclick="hideAdres(this);">新增收货地址</b>
                <ul class="adres">
                    <c:if test="${empty addresses}">
                        暂无收货地址，请添加！
                    </c:if>

                    <c:forEach items="${addresses}" var="add">
                        <li>
                            <input type="radio" name="shipAddId" value="${add.id}" style="width:50px">
                            ${add.receivename}&nbsp;&nbsp;&nbsp;${add.phone}&nbsp;&nbsp;&nbsp;${add.address}
                        </li>
                    </c:forEach>

                </ul>

                <p id="newAdres" style="font-size:15px;display: none;">
                    收件人姓名：<input type="text" name="receiveName"><br/><br/>
                    收件人地址：<input type="text" name="address"><br/><br/>
                    收件人电话：<input type="text" name="phone">
                </p>
            </div>


            <p class="singleP"><b>送货清单</b><span><a href="shopCart.html">返回修改购物车</a></span></p>
            <div class="bigDiv">
                <div class="twoDiv">
                    <b>商家：briup自营</b>
                    <c:forEach items="${shopCart.cart}" var="item">
                        <ul class="oneUL">
                            <li>
                                <img src="../images/viewBook.png" class="pic">
                                <p>计算机&nbsp;&nbsp;${item.value.book.name}&nbsp;&nbsp;</p>
                                <p><font>¥${item.value.book.price}</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${item.value.num}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;有货
                                </p>
                                <p><img src="../images/sureLogo_14.png" alt=""><span>七天无理由退换货</span></p>

                            </li>
                            <li>
                                <pre>【赠品】  高级定制干花书签  随机 ×1</pre>
                            </li>
                        </ul>
                    </c:forEach>
                </div>
            </div>

            <div class="money">
                <span><font>${shopCart.number}</font>件商品，总商品金额：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;¥${shopCart.total}</span>
                <span><img src="../images/sureLogo_18.png" alt="">运费：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;¥10.00</span>

                <span>应付总额：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;¥${shopCart.total}</span>
            </div>
            <div class="submit">
                <span>应付金额：<font>¥${shopCart.total+10}</font><a href="<%=basePath%>/user/submitOrderServlet"><input type="image" src="../images/21_03.png"></a></span>
            </div>
        </form>
    </div>

</div>

<!--脚部-->
<jsp:include page="../footer.jsp"/>
</body>
</html>

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
    <title>购物车页面</title>
    <link rel="stylesheet" href="../css/fullCar.css" />
    <link rel="stylesheet" href="../css/common.css"/>
    <link rel="stylesheet" href="../css/style.css" />
    <link rel="stylesheet" href="../css/icons.css" />
    <link rel="stylesheet" href="../css/table.css" />
    <link rel="stylesheet" type="text/css" href="../css/shopCar.css">
</head>
<body>
<!--顶部-->
<div class="top">
    <div class="top_center">
        <ul class="top_bars">
            <li>
                <c:if test="${!empty customer}">
                    ${customer.name}，欢迎您！
                    <a href="<%=basePath%>/loginOutServlet">退出</a>|
                </c:if>
                <c:if test="${empty customer}">
                    <a href="<%=basePath%>/login.jsp"><span style="font-size: 15px;color: blueviolet">登录</span></a>
                </c:if>
            </li>
            <li><a href="orderlist.jsp">我的订单<span class="jt_down"></span></a>|</li>
            <li><a href="#">关注杰普<span class="jt_down"></span></a>|</li>
            <li><a href="#">网站导航<span class="jt_down"></span></a></li>
        </ul>
    </div>
</div>

<!--头部-->
<div class="header3">
    <a href="<%=basePath%>/index.jsp"><img src="../images/logo.png" class="oneImg"></a>


    <div class="h3_right">
        <img src="../images/play_03.png" alt="">
    </div>

</div>

<!--中间部分div-->
<div class="empty">
    <div class="peisong"><pre>全部商品  ${shopCart.size} </pre></div>
    <div class="mainCenter">
        <div class="allCheck">
            <input type="checkbox"><p>全选</p>
            <p class="leftM">商品</p>
            <p class="rightM">单价(元)</p>
            <p class="leftM">数量</p>
            <p class="leftM">小计(元)</p>
            <p class="leftM">操作</p>
        </div>
        <div class="mainPro">
            <div class="aa">
                <input type="checkbox"><span id="but">自营</span>
            </div>
            <c:if test="${empty shopCart.cart}">
                <div style="font-size: 30px;color: #005EA7" align="center">
                    购物车为空！
                </div>
            </c:if>
            <c:forEach items="${shopCart.cart}" var="item" varStatus="index">
                    <table>
                        <tbody>
                        <tr>
                            <td class="index">${index.count}</td>
                            <td>
                                <img src="../images/1.png" >
                                <span>
                                    ${item.value.book.name}
                                    <br>
                                </span>
                            </td>
                            <td>
                                <span>${item.value.book.price}</span>
                            </td>
                            <td class="index2">
                                <input type="text" name="num" value="${item.value.num}"><br>
                                <span>有货</span>
                            </td>
                            <td>
                                <span>${item.value.cost}</span>
                            </td>
                            <td>
                                <button onclick="javascript:window.location='<%=basePath%>/user/deleteOrderLineInShopCartByIdServlet?id=${item.key}';">删除</button>
                            </td>
                        </tr>
                        </tbody>
                    </table>
            </c:forEach>

            <!-- <div class="min_content">
               <div class="bb">
                <input type="text" >
                <img src="images/1.png" >
                 <span>
                    Effective JAVA
                    <br>
                </span>
                <div class="mm">
                    <span>¥66.00</span>
                </div>
                <img src="images/have_03.png" style="margin-top:40px">
                <div class="ri">¥66.00元</div>
                <div class="righ">
                     <div class="rig">删除</div>
                </div>
            </div>

-->
            <!-- <div class="bb">
                   <input type="checkbox" >
                   <img src="images/1.png" >
                    <span>
                       Effective JAVA
                       <br>
                   </span>
                   <div class="mm">
                       <span>¥66.00</span>
                   </div>
                   <img src="images/have_03.png" style="margin-top:40px">
                   <div class="ri">¥66.00元</div>
                   <div class="righ">
                        <div class="rig">删除</div>
                   </div>
               </div> -->
        </div>
        <div class="allButtom">
            <!-- <p class="caozuo">去结算</p> -->
            <!-- <input value="去提交" class="caozuo" type="submit"> -->
            <a href="<%=basePath%>/user/confirm.jsp" class="caozuo">去提交</a>
            <span>已选择<font>${shopCart.number}</font>件商品&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;总价(不含运费)：<font>¥${shopCart.total}元</font></span>
        </div>

    </div>

</div>
</div>


<jsp:include page="../footer.jsp"/>
</body>
</html>

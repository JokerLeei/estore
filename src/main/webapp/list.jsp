<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%
        String base = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + base;
    %>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>briup电子商务-首页</title>
    <link rel="stylesheet" href="css/common.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <link rel="stylesheet" href="css/icons.css"/>
    <link rel="stylesheet" href="css/table.css"/>
</head>
<body>
<%--头部--%>
<jsp:include page="header.jsp"/>


<!--头部导航-->
<div class="nav_top">
    <div class="nav_top_center">
        <div>
            全部图书分类
        </div>
        <ul>
            <c:forEach items="${rootCategories}" var="rootCategory">
                <li>
                    <a href="<%=basePath%>/listBooksByRootCategoryServlet?categoryId=${rootCategory.id}">
                            ${rootCategory.name}
                    </a>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>

<!--内容-->
<div class="container4">
    <!--热卖-->
    <div class="c4_b1">
        <ul class="c4_b1_boxes">
            <li>
                <img src="images/hot_1.png">
                <div class="c4_b1_box_txt">
                    <p>Java疯狂讲义 </p>
                    <h1>活动价：<b>￥69</b></h1>
                    <h2><a href="viewBook.html">立即抢购</a></h2>
                </div>
            </li>
            <li>
                <img src="images/hot_1.png">
                <div class="c4_b1_box_txt">
                    <p>Java疯狂讲义 </p>
                    <h1>活动价：<b>￥69</b></h1>
                    <h2><a href="viewBook.html">立即抢购</a></h2>
                </div>
            </li>
            <li>
                <img src="images/hot_1.png">
                <div class="c4_b1_box_txt">
                    <p>Java疯狂讲义 </p>
                    <h1>活动价：<b>￥69</b></h1>
                    <h2><a href="viewBook.html">立即抢购</a></h2>
                </div>
            </li>
            <li>
                <img src="images/hot_1.png">
                <div class="c4_b1_box_txt">
                    <p>Java疯狂讲义 </p>
                    <h1>活动价：<b>￥69</b></h1>
                    <h2><a href="viewBook.html">立即抢购</a></h2>
                </div>
            </li>
        </ul>
    </div>
    <div class="c4_b2">
        <h1 class="c4_b2_x">
            <a href="<%=basePath%>/listBooksByRootCategoryServlet?categoryId=${rootCategory.id}">${rootCategory.name}</a>
            <c:if test="${!empty secoundCategory}">
                &nbsp;&nbsp;>
                <span><a
                        href="<%=basePath%>/listBooksBySecoundCategoryServlet?categoryId=${secoundCategory.id}">${secoundCategory.name}</a></span>
            </c:if>
        </h1>

        <ul class="c4_b2_y">
            <li>
                <span class="search_key">价格：</span>
                <span class="search_val">0-99</span>
                <span class="search_del"></span>
            </li>
            <li>
                <span class="search_key">出版社：</span>
                <span class="search_val">清华出版社</span>
                <span class="search_del"></span>
            </li>
        </ul>
    </div>
    <div class="c4_b3">
        <h1></h1>
        <div>
            <ul class="c4_b3_search">
                <li class="c4_b3_name">价格：</li>
                <li class="c4_b3_vals">
                    <a href="#">0-599</a>
                    <a href="#">600-999</a>
                    <a href="#">1000-1599</a>
                    <a href="#">1600-1999</a>
                    <a href="#">2000-2999</a>
                    <a href="#">3000-3999</a>
                    <a href="#">4000-4999</a>
                    <a href="#">5000-5999</a>
                    <a href="#">6000-6490</a>
                </li>
            </ul>
            <ul class="c4_b3_search">
                <li class="c4_b3_name">出版社：</li>
                <li class="c4_b3_vals">
                    <a href="#">清华出版社</a>
                    <a href="#">清华出版社</a>
                    <a href="#">清华出版社</a>
                    <a href="#">清华出版社</a>
                    <a href="#">清华出版社</a>
                    <a href="#">清华出版社</a>
                </li>
            </ul>
        </div>
    </div>
    <div class="c4_b4">
        <div class="c4_b4_x">
            <ul class="c4_b4_nav">
                <li class="current"><a href="#">默认</a></li>
                <li><a href="#">销量</a></li>
                <li><a href="#">价格</a></li>
                <li><a href="#">新品</a></li>
            </ul>
            <div class="c4_b4_search">
                <input type="text"/><span>确认</span>
            </div>
            <div class="c4_b4_pages">

            </div>
            <div class="clear"></div>
        </div>
        <div class="c4_b4_y">
            <ul>
                <li><input type="checkbox"> 仅显示有货</li>
            </ul>
        </div>
    </div>
    <!--商品列表-->
    <div class="c4_b5">
        <div class="c4_b5_content">
            <ul class="c4_b5_c_boxes">
                <c:if test="${empty bookList}">
                    <div align="center" style="font-size: 30px;color: #006cd7">搜索结果为空!</div>
                </c:if>
                <c:forEach items="${bookList}" var="book">
                    <li class="c4_b5_c_box">
                        <!--图片-->
                        <div class="c4_b5_c_box_pic">
                            <div class="c4b5_pic_view">
                                <a href="<%=basePath%>/findBookByIdServlet?id=${book.id}"><img src="images/list_p1.png"></a>
                            </div>
                        </div>
                        <!--价钱-->
                        <div class="c4_b5_c_box_txt">
                            <h1>￥ ${book.price}</h1>
                            <h2><a href="<%=basePath%>/findBookByIdServlet?id=${book.id}">${book.name}</a></h2>
                        </div>
                        <!--购买等操作-->
                        <div class="c4b5_el">
                            <div class="c4b5_el_x">
                                <span class="wjx01"></span>
                            </div>
                        </div>
                        <ul class="c4b5_option">
                            <li class="shopcar_box"><span class="shopcar01"></span><a
                                    href="user/shopCart.html">加入购物车</a></li>
                        </ul>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>

<!--脚部-->
<jsp:include page="footer.jsp"/>

</body>
</html>

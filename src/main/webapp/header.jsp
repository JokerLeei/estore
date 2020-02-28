<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" type="text/css" href="css/turn.css">
    <script type="text/javascript">
        function submitForm() {
            document.getElementById("search").submit();
        }
    </script>
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
            <li><a href="<%=basePath%>/user/listOrdersServlet">我的订单<span class="jt_down"></span></a>|</li>
            <li><a href="#">关注杰普<span class="jt_down"></span></a>|</li>
            <li><a href="#">网站导航<span class="jt_down"></span></a></li>
        </ul>
    </div>
</div>
<!--头部-->
<div class="header3">
    <a href="<%=basePath%>/index.jsp"><img src="images/logo.png"></a>
    <div class="h3_center">
        <div class="search_box">
            <form action="<%=basePath%>/searchServlet" method="post" id="search">
            <input type="text" name="index"/>
            <span onclick="submitForm()">搜索</span>
            </form>
        </div>
        <p>
            <c:forEach items="${rootCategories}" var="rootCategory">
                <a href="<%=basePath%>/listBooksByRootCategoryServlet?categoryId=${rootCategory.id}">
                        ${rootCategory.name}
                </a>
                |
            </c:forEach>
        </p>
    </div>
    <div class="h3_right">
        <div class="myyy">
            个人信息
            <span class="sj_down"></span>
        </div>
        <div class="tsc">
            <a href="<%=basePath%>/user/shopCart.jsp">去购物车结算</a>
            <span class="sj_right"></span>
        </div>
    </div>
</div>
</body>
</html>

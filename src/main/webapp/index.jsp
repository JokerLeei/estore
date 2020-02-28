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
    <link rel="stylesheet" type="text/css" href="css/turn.css">

</head>
<body>
<%--头部--%>
<jsp:include page="header.jsp"/>
<%--<%@ include file="header.jsp"%>--%>
<%--登陆成功，或者加载页面时。把登录错误信息删了--%>
<%--<c:remove var="login_msg" scope="session"/>--%>

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

<div class="container3">
    <div class="c3_b1">
        <div class="c3_b1_left">
            <dl>
                <c:forEach items="${rootCategories}" var="rootCategory">
                    <dd>
                        <a href="<%=basePath%>/listBooksByRootCategoryServlet?categoryId=${rootCategory.id}">
                            <h1>${rootCategory.name}</h1>
                        </a>
                        <p>
                            <c:forEach items="${rootCategory.childCategories}" var="child">
                                <a href="<%=basePath%>/listBooksBySecoundCategoryServlet?categoryId=${child.id}">
                                        ${child.name}
                                </a>
                            </c:forEach>
                        </p>
                    </dd>
                </c:forEach>
            </dl>
        </div>
        <div class="c3_b1_center">
            <!-- <div>
                <a href="#"><img src="images/ad1.png"></a>
            </div> -->
            <!-- 图片伦伯 -->
            <div class="carousel" id="carousel">
                <div class="btns">
                    <a href="javascript:;" class="leftBtn" id="leftBtn"></a>
                    <a href="javascript:;" class="rightBtn" id="rightBtn"></a>
                </div>
                <div class="m_unit" id="m_unit">
                    <ul>
                        <li><a href="#"><img src="images/ad1.png" alt=""/></a></li>
                        <li><a href="#"><img src="images/ad1.png" alt=""/></a></li>
                        <li><a href="#"><img src="images/ad1.png" alt=""/></a></li>
                        <li><a href="#"><img src="images/ad1.png" alt=""/></a></li>
                        <li><a href="#"><img src="images/ad1.png" alt=""/></a></li>
                    </ul>
                </div>
                <div class="circles" id="circles">
                    <ol>
                        <li class="cur"></li>
                        <li></li>
                        <li></li>
                        <li></li>
                        <li></li>
                    </ol>
                </div>
            </div>
            <div class="c3_b1_c_bottom">
                <ul>
                    <li>
                        <a href="viewBook.html"><img src="images/p01.png"/></a>
                        <a href="viewBook.html">Java从入门到精通</a>
                    </li>
                    <li>
                        <a href="viewBook.html"><img src="images/p01.png"/></a>
                        <a href="viewBook.html">Java从入门到精通</a>
                    </li>
                    <li>
                        <a href="viewBook.html"><img src="images/p01.png"/></a>
                        <a href="viewBook.html">Java从入门到精通</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="c3_b1_right">
            <h1>杰普快报<a href="#">更多</a></h1>
            <ul>
                <li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
                <li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
                <li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
                <li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
                <li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
                <li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
                <li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
                <li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
                <li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
                <li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
                <li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
                <li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
                <li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
                <li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
                <li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
            </ul>
        </div>
        <div style="clear:both"></div>
    </div>
    <div class="c3_b2">
        <ul>
            <c:forEach items="${bookList}" var="book">
                <li>
                    <div class="c3_b2_txt">
                        <a href="<%=basePath%>/findBookByIdServlet?id=${book.id}"><h1>${book.name}</h1></a>
                        <p>作者：${book.author}</p>
                        <h2>${book.publisher}</h2>
                        <h2>${book.pubdate}</h2>
                        <h2>${book.description}</h2>
                        <p><a href="<%=basePath%>/findBookByIdServlet?id=${book.id}">更多精彩，点击进入</a></p>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
    <div class="c20"></div>

    <%--脚部--%>
    <jsp:include page="footer.jsp"/>
</div>
<script type="text/javascript" src="js/animate-2.0.1.js"></script>
<script type="text/javascript" src="js/turn.js"></script>
</body>
</html>

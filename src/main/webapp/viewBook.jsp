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
    <script type="text/javascript">
        function reduceCount() {
            var numObj = document.getElementsByName("num")[0];
            if (parseInt(numObj.value) > 1) {
                numObj.value = parseInt(numObj.value) - 1;
            }
        }

        function addCount() {
            var numObj = document.getElementsByName("num")[0];
            numObj.value = parseInt(numObj.value) + 1;
        }

        function addCart() {
            document.getElementById("addCar").submit();
        }
    </script>
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

<div class="container5">
    <div class="cn5_top">
        <div class="cn5_top_x center01">
            <a class="font20" href="#">书籍</a> >
            <a href="#">计算机类</a>
        </div>
        <div class="cn5_top_y center01">
            <div class="cn5topy_1">
                <div class="cn5topy_imgview">
                    <img src="images/viewBook.png"/>
                    <!-- <ul class="cn5topy_imglist">
                        <li><a href="#"><img src="images/viewBook.png"></a></li>
                        <li class="current"><a href="#"><img src="images/viewBook.png"></a></li>
                        <li><a href="#"><img src="images/viewBook.png"></a></li>
                        <li><a href="#"><img src="images/viewBook.png"></a></li>
                        <li><a href="#"><img src="images/viewBook.png"></a></li>
                    </ul> -->
                </div>
            </div>
            <div class="cn5topy_2">
                <h1 class="pro_title font15">${book.name}</h1>
                <div class="pro_price">
                    <div class="pro_price_x">
                        <p> briup价：<b>￥${book.price}</b> <a href="#">(降价通知)</a></p>
                    </div>

                </div>
                <!-- <div>
                    <ul>
                        <li><span>作者：</span>托马斯</li>
                        <li></li>
                        <li></li>
                    </ul>
                </div> -->
                <div class="pro_selects">
                    <div class="pro_select">
                        <div class="pro_key pro_key_vertical fl">作者：</div>
                        <ul class="pro_select_vals">
                            <li>${book.author}</li>

                        </ul>
                    </div>
                    <div class="pro_select">
                        <div class="pro_key pro_key_vertical fl">出版社：</div>
                        <ul class="pro_select_vals">
                            <li>${book.publisher}</li>

                        </ul>
                    </div>
                    <div class="pro_select">
                        <div class="pro_key pro_key_vertical fl">书籍介绍：</div>
                        <ul class="pro_select_vals">
                            <li> 出版时间：${pubdate}</li>
                            <li>包装：平装</li>
                            <li>正文语种：中文</li>
                        </ul>
                    </div>
                </div>
                <form action="<%=basePath%>/user/addShopCartServlet" id="addCar">
                    <div class="pro_buy">
                        <div class="pro_buy_nums">
                            <input type="text" value="1" name="num"/>
                            <dl>
                                <dd onclick="addCount()">+</dd>
                                <dd onclick="reduceCount()">-</dd>
                            </dl>
                        </div>
                        <!--  <div class="pro_addshop" onclick="submitForm()">加入购物车</div> -->
                        <div class="pro_addshop" onclick="addCart()">加入购物车</div>
                    </div>
                </form>
                <div class="pro_ship">
                    <div>
                        <div class="pro_key fl">服&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;务：</div>
                        <ul class="pro_service f1">
                            <li class="service_fq">分期付款</li>
                            <li class="service_myf">免运费</li>
                            <li class="service_zt">自提</li>
                            <li class="service_th">7天无理由退换货</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="c5_b2">

        <div class="c5_b2_right">
            <!--选项卡-->
            <ul class="c5_b2_tabs">
                <li>商品介绍</li>
                <li class="current">规格参数</li>
                <li>包装清单</li>
                <li>商品评价</li>
            </ul>
            <!--内容-->
            <div class="c5_b2_right_1 box">
                <div class="introduce_item">
                    <ul>
                        <li>商品名称：Effective Java (中文版) 第2版</li>
                        <li>商品编号：1002024</li>
                        <li class="fr"><a class="color_link1" href="#">更多参数>></a></li>
                    </ul>
                </div>
            </div>
            <div class="intro_pics">
                <img class="intro_pic" src="images/viewBook.png">
            </div>
        </div>


        <div class="c5_b2_right">
            <div class="c5_b2_right_2">
                <h1>正品行货</h1>
                <p>briup网上商城向您保证所售商品均为正品，briup自营商品开具机打发票或电子发票。</p>

                <h1>全国联保</h1>
                <p>凭质保证书及briup网上商城发票，可享受全国联保服务，与您亲临商场选购的商品享受相同的质量保证。briup网上商城还为您提供具有竞争力的商品价格和运费政策，请您放心购买！</p>

                <h1>正品行货</h1>
                <p>briup网上商城向您保证所售商品均为正品，briup自营商品开具机打发票或电子发票。</p>

                <h1>全国联保</h1>
                <p>凭质保证书及briup网上商城发票，可享受全国联保服务，与您亲临商场选购的商品享受相同的质量保证。briup网上商城还为您提供具有竞争力的商品价格和运费政策，请您放心购买！</p>

            </div>
        </div>

        <!--左侧栏-->
        <div class="c5_b2_left_container">
            <div class="c5_b2_left box">
                <h1>服务时间 早9：00~凌晨1：00</h1>
                <p>
                    <a href="#">
                        <img class="callmebyqq" src="images/icon_qq_03.png"/>
                    </a>
                </p>
            </div>

            <div class="c5_b2_left box">
                <h1>其他种类</h1>
                <dl>
                    <dd>文学类</dd>
                    <dd>漫画类</dd>
                    <dd>通书类</dd>
                </dl>
                <dl>
                    <dd>文学类</dd>
                    <dd>漫画类</dd>
                    <dd>通书类</dd>
                </dl>
            </div>
        </div>
    </div>
</div>

<div class="c20"></div>

<!--脚部-->
<jsp:include page="footer.jsp"/>

</body>
</html>


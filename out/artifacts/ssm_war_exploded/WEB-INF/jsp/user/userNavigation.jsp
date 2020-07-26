<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>导航栏</title>
    <link rel="stylesheet" href="${requestScope.ContextPath}/css/Navigation.css">


</head>
<body>
<%--style="background-color: #2f353f"--%>

<div class="item-left clearfix">
    <%--<p class="title">车型选择</p>--%>
    <a class="item active" href="/user/myInformation" target="iframe2">我的信息</a>
        <a class="item active" data-index="0" ref="carTypeClick" href="/title/mockTest" target="iframe2">模拟考试</a>
        <%--<a class="item  icon2" data-index="1" ref="carTypeClick" href="#">货车</a>--%>
    <%--<a class="item  icon3" data-index="2" ref="carTypeClick" href="#">客车</a>--%>
    <%--<a class="item  icon4" data-index="3" ref="carTypeClick" href="#">摩托车</a>--%>
    <%--<a class="item  icon5" data-index="4" ref="carTypeClick" href="#">资格证</a>--%>
</div>



</body>
</html>

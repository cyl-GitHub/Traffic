<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>导航栏</title>
    <link rel="stylesheet" href="${requestScope.ContextPath}/css/Navigation.css">
</head>
<body>

<div class="item-left clearfix">
    <a class="item active" data-index="0" href="/title/title" target="iframe2">题目管理</a>
    <a class="item active" href="/title/addTitle" target="iframe2">添加题目</a>
    <%--<a class="item  icon2" data-index="1" ref="carTypeClick" href="#">货车</a>--%>
</div>

</body>
</html>

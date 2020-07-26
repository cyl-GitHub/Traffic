<%--
  Created by IntelliJ IDEA.
  User: cyl27
  Date: 2019/12/26
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="${requestScope.ContextPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${requestScope.ContextPath}/js/bootstrap.min.js"></script>
</head>
<body>
<div>
    <h1>身份验证</h1>


    <table class="table table-bordered">
        <thead>
        <tr>
            <th style="width: 40px">姓名</th>
            <th style="width: 240px">身份证号</th>
            <th style="width: 40px">科目</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${user.name}</td>
            <td>${user.id}</td>
            <td>科目四</td>
        </tr>

        <input type="button" value="开始考试" onclick="window.location.href = '/title/titles'">
        </tbody>

    </table>

</div>

</body>
</html>

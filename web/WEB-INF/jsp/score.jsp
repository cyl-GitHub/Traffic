<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cyl27
  Date: 2019/12/27
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>最终成绩为${score}分
    <c:if test="${score>=90}">
        ,成绩合格
    </c:if>
    <c:if test="${score<90}">
        ,成绩不合格
    </c:if>
</h1>
</body>
</html>

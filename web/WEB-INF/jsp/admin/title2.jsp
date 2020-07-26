<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文章管理</title>
    <link rel="stylesheet" href="${requestScope.ContextPath}/css/article.css">
    <link href="${requestScope.ContextPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${requestScope.ContextPath}/jquery-2.1.1/jquery.min.js"></script>
    <script src="${requestScope.ContextPath}/js/bootstrap.min.js"></script>
    <script src="${requestScope.ContextPath}/js/admin/title.js"></script>

</head>
<body>


<div style="float: left">
    <input type="hidden" id="pageNumber3" name="pageNumber3" value="1">
    <form action="/title/selectTitle2" method="post">
        <div style="float: left">
            &nbsp;
            车型查询
            <br>
            &nbsp;
            <select id="cla3" name="cla3" >
                <option  value="全部" >------------全部------------</option>
                <option value="小车">小车</option>
                <option value="货车">货车</option>
            </select>
        </div>

        <div style="float: left">
            &nbsp;
            科目查询
            <br>
            &nbsp;
            <select id="cla1" name="cla1" onclick="selectClass2()">
                <option value="全部">------------全部------------</option>
            </select>
        </div>

        <div style="float: left">
            &nbsp;
            章节查询
            <br>
            &nbsp;

            <select id="cla2" name="cla2">
                <option value="全部">------------全部------------</option>
            </select>
        </div>

        <%--<input type="button" value="查询" onclick="selectTitle()">--%>

        <input type="submit" value="查询" style="margin-top: 18px">
    </form>

</div>


<div id="cla4"></div>

<table class="table table-bordered">
    <thead>
    <tr>
        <th style="width: 33px">编号</th>
        <th style="width: 240px">内容</th>
        <th style="width: 50px">A</th>
        <th style="width: 50px">B</th>
        <th style="width: 50px">C</th>
        <th style="width: 50px">D</th>
        <th style="width: 35px">答案</th>
        <th>图片</th>
        <th>分数</th>
        <th>分类1</th>
        <th>分类2</th>
        <th>解析</th>
        <th style="width: 35px">操作</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${titles}" var="title">
        <tr>
            <td>${title.id}</td>
            <td>${title.content}</td>
            <td>${title.key1}</td>
            <td>${title.key2}</td>
            <td>${title.key3}</td>
            <td>${title.key4}</td>
            <td>${title.key}</td>


            <c:if test="${title.picture != ''&&title.picture != null}">
                <td><img src="${title.picture}" alt="图片" style="width: 100px;height: 80px"></td>
            </c:if>
            <c:if test="${title.picture == ''||title.picture == null}">
                <td>${title.picture}</td>
            </c:if>

            <td>${title.score}</td>
            <td>${title.class1}</td>
            <td>${title.class2}</td>
            <td>${title.analysis}</td>

            <td>
                <c:choose>
                    <c:when test="${title.admin eq adminLogin}">
                        <a href="/title/updateTitle?id=${title.id}">修改</a>
                        <a href="/title/deleteTitle?id=${title.id}&pageNumber=${pageNumber}">删除</a>
                    </c:when>
                    <c:otherwise>
                        不能操作
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>


    </c:forEach>

    </tbody>

</table>

<div style="float: right;font-size: 18px;">

    <c:choose>
        <c:when test="${cla3 eq null}">
            <tr>
                <td colspan="10">
                    当前${pageNumber}/${totalPage }页&nbsp;&nbsp;

                    <c:if test="${pageNumber ne 1}">
                        <a href="/title/title?pageNumber=1">首页</a>
                        <a href="/title/title?pageNumber=${pageNumber-1}">上一页 </a>
                    </c:if>

                    <c:if test="${pageNumber ne totalPage}">
                        <a href="/title/title?pageNumber=${pageNumber+1}">下一页 </a>
                        <a href="/title/title?pageNumber=${totalPage}">末页</a>
                    </c:if>

                </td>
            </tr>
        </c:when>

        <c:when test="${cla3 ne null}">
            <tr>
                <td colspan="10">
                    当前${pageNumber3}/${totalPage}页&nbsp;&nbsp;

                    <c:if test="${pageNumber3 ne 1}">
                        <a href="/title/selectTitle2?pageNumber3=1&cla3=${cla3}&cla1=${cla1}&cla2=${cla2}">首页</a>
                        <a href="/title/selectTitle2?pageNumber3=${pageNumber3-1}&cla3=${cla3}&cla1=${cla1}&cla2=${cla2}">上一页 </a>
                    </c:if>

                    <c:if test="${pageNumber3 ne totalPage}">
                        <a href="/title/selectTitle2?pageNumber3=${pageNumber3+1}&cla3=${cla3}&cla1=${cla1}&cla2=${cla2}">下一页 </a>
                        <a href="/title/selectTitle2?pageNumber3=${totalPage}&cla3=${cla3}&cla1=${cla1}&cla2=${cla2}">末页</a>
                    </c:if>

                </td>
            </tr>
        </c:when>


        <%--<c:when test="${cla ne null&&cla3 eq null}">--%>
            <%--<tr>--%>
                <%--<td colspan="10">--%>
                    <%--当前${pageNumber}/${totalPage}页&nbsp;&nbsp;--%>

                    <%--<c:if test="${pageNumber ne 1}">--%>
                        <%--<a href="/title/selectTitle?pageNumber=1&cla=${cla}">首页</a>--%>
                        <%--<a href="/title/selectTitle?pageNumber=${pageNumber-1}&cla=${cla}">上一页 </a>--%>
                    <%--</c:if>--%>

                    <%--<c:if test="${pageNumber ne totalPage}">--%>
                        <%--<a href="/title/selectTitle?pageNumber=${pageNumber+1}&cla=${cla}">下一页 </a>--%>
                        <%--<a href="/title/selectTitle?pageNumber=${totalPage}&cla=${cla}">末页</a>--%>
                    <%--</c:if>--%>
                <%--</td>--%>
            <%--</tr>--%>
        <%--</c:when>--%>
    </c:choose>

</div>

<div class="footer">2019©交通法规考试系统</div>
</body>
</html>

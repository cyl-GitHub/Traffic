<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="${requestScope.ContextPath}/js/admin/updateTitle.js"></script>
</head>
<body>

<form id="uploadPicture" enctype="multipart/form-data">

    <input type="hidden" value="${updateTitle.id}" id="id">

    <label for="content">内&nbsp;&nbsp;容:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" name="content"
                                                                                     id="content" value="${updateTitle.content}" style="width: 500px">
    <br><br>

    <label for="key1">选&nbsp;项 A:&nbsp;&nbsp;&nbsp;</label><input type="text" name="key1" id="key1" value="${updateTitle.key1}"
                                                                  style="width: 500px">
    <br><br>
    <label for="key2">选&nbsp;项 B:&nbsp;&nbsp;&nbsp;</label><input type="text" name="key2" id="key2" value="${updateTitle.key2}"
                                                                  style="width: 500px">
    <br><br>
    <label for="key3">选&nbsp;项 C:&nbsp;&nbsp;&nbsp;</label><input type="text" name="key3" id="key3" value="${updateTitle.key3}"
                                                                  style="width: 500px">
    <br><br>
    <label for="key4">选&nbsp;项 D:&nbsp;&nbsp;&nbsp;</label><input type="text" name="key4" id="key4" value="${updateTitle.key4}"
                                                                  style="width: 500px">
    <br><br>

    是否多选:
    <c:if test="${updateTitle.multiple eq 0}">
        <label for="multiple1">是:</label><input type="radio" id="multiple1" name="multiple" value="1" > &nbsp;&nbsp;
        <label for="multiple0">否:</label><input type="radio" id="multiple0" name="multiple" value="0" checked>
    </c:if>
    <c:if test="${updateTitle.multiple eq 1}">
        <label for="multiple1">是:</label><input type="radio" id="multiple1" name="multiple" value="1" checked> &nbsp;&nbsp;
        <label for="multiple0">否:</label><input type="radio" id="multiple0" name="multiple" value="0" >
    </c:if>


    <br><br>
    正确选项:
    <label for="key1">A:</label><input type="checkbox" name="key" id="key1" value="A">
    <label for="key2">B:</label><input type="checkbox" name="key" id="key2" value="B">
    <label for="key3">C:</label><input type="checkbox" name="key" id="key3" value="C">
    <label for="key4">D:</label><input type="checkbox" name="key" id="key4" value="D">

    <br><br>

    <div id="div2" style="width: 100%;color: red;font-size:18px;">

    </div>



    <label for="file">图片:</label><input type="file" name="file" id="file">

    <br><br>
    分&nbsp;&nbsp;值:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

    <c:if test="${updateTitle.score eq 1}">
        <label for="score1">1分:</label><input type="radio" name="score" id="score1" value="1" checked> &nbsp;&nbsp;
        <label for="score2">2分:</label><input type="radio" name="score" id="score2" value="2">
    </c:if>
    <c:if test="${updateTitle.score eq 2}">
        <label for="score1">1分:</label><input type="radio" name="score" id="score1" value="1" > &nbsp;&nbsp;
        <label for="score2">2分:</label><input type="radio" name="score" id="score2" value="2" checked>
    </c:if>

    <br><br>

    <div>
        分类：
        <div >
            &nbsp;
            车型选择
            <br>
            &nbsp;
            <select id="cla3" name="cla3" >
                <option  value="未选择" >------------未选择------------</option>
            </select>
        </div>

        <div >
            &nbsp;
            科目选择
            <br>
            &nbsp;
            <select id="cla1" name="cla1" onclick="selectClass2()">
                <option value="未选择">------------未选择------------</option>
            </select>
        </div>

        <div >
            &nbsp;
            章节选择
            <br>
            &nbsp;

            <select id="cla2" name="cla2">
                <option value="未选择">------------未选择------------</option>
            </select>
        </div>
    </div>

    <br><br>
    <label for="analysis">解&nbsp;&nbsp;析:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" name="analysis"  placeholder="${updateTitle.analysis}"
                                                                                      id="analysis"
                                                                                      style="width: 485px">
    <br><br>
    <div id="div1" style="width: 100%;color: red;font-size:18px;"></div>
    <br>

    <input type="button" id="updateButton" onclick="updateTitle()" value="更新">
    <input type="reset" value="重置">
    <br>
    <input type="button" value="取消" onclick="window.history.back(-1); ">
</form>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: cyl
  Date: 2019/12/20
  Time: 9:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${requestScope.ContextPath}/jquery-2.1.1/jquery.min.js"></script>
    <script src="${requestScope.ContextPath}/js/admin/addTitle.js"></script>

</head>
<body>
<form id="uploadPicture" enctype="multipart/form-data">

    <label for="content">内&nbsp;&nbsp;容:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" name="content" autofocus="autofocus"
                                                                                     id="content" style="width: 500px">
    <br><br>

    <label for="key1">选&nbsp;项 A:&nbsp;&nbsp;&nbsp;</label><input type="text" name="key1" id="key1"
                                                                  style="width: 500px">
    <br><br>
    <label for="key2">选&nbsp;项 B:&nbsp;&nbsp;&nbsp;</label><input type="text" name="key2" id="key2"
                                                                  style="width: 500px">
    <br><br>
    <label for="key3">选&nbsp;项 C:&nbsp;&nbsp;&nbsp;</label><input type="text" name="key3" id="key3"
                                                                  style="width: 500px">
    <br><br>
    <label for="key4">选&nbsp;项 D:&nbsp;&nbsp;&nbsp;</label><input type="text" name="key4" id="key4"
                                                                  style="width: 500px">
    <br><br>

    是否多选:

    <label for="multiple1">是:</label><input type="radio" id="multiple1" name="multiple" value="1" > &nbsp;&nbsp;
    <label for="multiple0">否:</label><input type="radio" id="multiple0" name="multiple" value="0" checked>

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

    <label for="score1">1分:</label><input type="radio" name="score" id="score1" value="1" checked> &nbsp;&nbsp;
    <label for="score2">2分:</label><input type="radio" name="score" id="score2" value="2">

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




    <%--分&nbsp;类 1:&nbsp;&nbsp;&nbsp;--%>

    <%--&lt;%&ndash;<input type="text" id="class1" name="class1">&ndash;%&gt;--%>
    <%--<label for="class1">科目一:</label><input type="radio" id="class1" name="class1" value="科目一" checked> &nbsp;&nbsp;--%>
    <%--<label for="class1_">科目四:</label><input type="radio" id="class1_" name="class1" value="科目四">--%>


    <%--<br><br>--%>
    <%--<label for="class2">分&nbsp;类 2:&nbsp;&nbsp;&nbsp;</label>--%>




    <%--<select id="class2" name="class2">--%>
        <%--<option value="道路交通安全法律、法规和规章">1. 道路交通安全法律、法规和规章</option>--%>
        <%--<option value="交通信号及其含义">2.交通信号及其含义</option>--%>
        <%--<option value="安全行车、文明驾驶知识">3.安全行车、文明驾驶知识</option>--%>
        <%--<option value="高速公路、山区道路、桥梁、隧道、夜间、恶劣气象和复杂条件下驾驶知识">4.高速公路、山区道路、桥梁、隧道、夜间、恶劣气象和复杂条件下驾驶知识</option>--%>
        <%--<option value="出现爆胎、转向失控、制动失灵等紧急情况时临危处置知识">5.出现爆胎、转向失控、制动失灵等紧急情况时临危处置知识</option>--%>
        <%--<option value="机动车总体构造和主要安全装置常识，日常检查和维护基本知识">6.机动车总体构造和主要安全装置常识，日常检查和维护基本知识</option>--%>
        <%--<option value="发生交通事故后的自救、急救等基本知识，以及常见危险化学品等知识">7.发生交通事故后的自救、急救等基本知识，以及常见危险化学品等知识</option>--%>
    <%--</select>--%>

    <%--<br><br>--%>
    <%--分&nbsp;类 3:&nbsp;&nbsp;&nbsp;--%>
    <%--<label for="class3">小车:</label><input type="radio" id="class3" name="class3" value="小车" checked> &nbsp;&nbsp;--%>
    <%--<label for="class3_">货车:</label><input type="radio" id="class3_" name="class3" value="货车">--%>

    <br><br>
    <label for="analysis">解&nbsp;&nbsp;析:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" name="analysis"
                                                                                      id="analysis"
                                                                                      style="width: 485px">
    <br><br>
    <div id="div1" style="width: 100%;color: red;font-size:18px;"></div>
    <br>

    <input type="button" id="insertButton" onclick="addTitle()" value="提交">
    <input type="reset" value="重置">
</form>
</body>
</html>

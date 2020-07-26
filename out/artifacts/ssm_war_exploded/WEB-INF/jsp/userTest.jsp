<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cyl27
  Date: 2019/12/25
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <link rel="stylesheet" href="${requestScope.ContextPath}/css/userTotalPage.css">
    <script src="${requestScope.ContextPath}/js/userTest.js"></script>

    <script>
        $(document).ready(
            gotoExam(1)
        );
    </script>
</head>
<body>

<div id="up" class="up">
    <h1 id="content">${title.content}</h1>

    <%--题号--%>
    <input type="text" id="qid" value="" hidden>

    <div style="float: left">

        <input type="radio" value="A" id="A" name="rad"><label for="A" id="kA"></label>

        <br>
        <input type="radio" value="B" id="B" name="rad"><label for="B" id="kB"></label>
        <div id="dC" style="">
            <%--<c:if test="${title.key3!=''}">--%>
            <input type="radio" value="C" id="C" name="rad"><label for="C" id="kC"></label>
            <%--</c:if>--%>
        </div>
        <%--<c:if test="${title.key4!=''}">--%>
        <div id="dD" style="">
            <input type="radio" value="D" id="D" name="rad"><label for="D" id="kD"></label>
            <%--</c:if>--%>
        </div>
        <br>
        <div style="float: bottom">

            <tr>
                <td><input type="button" value="上一题" onclick="change('up')" id="last"></td>
                <td><input type="button" value="下一题" onclick="change('down')" id="next"></td>
                <td><input type="button" value="交卷" onclick="close1('close')"></td>
            </tr>

        </div>

    </div>
    <div style="float: right">
        <img src="" alt="图片" id="pic">
    </div>
</div>


<div id="down" class="down">
    <input type="button" id="EOV1" onclick="gotoExam(1);" class="EOVWait" value="1">
    <input type="button" id="EOV2" onclick="gotoExam(2);" class="EOVWait" value="2">
    <input type="button" id="EOV3" onclick="gotoExam(3);" class="EOVWait" value="3">
    <input type="button" id="EOV4" onclick="gotoExam(4);" class="EOVWait" value="4">
    <input type="button" id="EOV5" onclick="gotoExam(5);" class="EOVWait" value="5">
    <input type="button" id="EOV6" onclick="gotoExam(6);" class="EOVWait" value="6">
    <input type="button" id="EOV7" onclick="gotoExam(7);" class="EOVWait" value="7">
    <input type="button" id="EOV8" onclick="gotoExam(8);" class="EOVWait" value="8">
    <input type="button" id="EOV9" onclick="gotoExam(9);" class="EOVWait" value="9">
    <input type="button" id="EOV10" onclick="gotoExam(10);" class="EOVWait" value="10">
    <input type="button" id="EOV11" onclick="gotoExam(11);" class="EOVWait" value="11">
    <input type="button" id="EOV12" onclick="gotoExam(12);" class="EOVWait" value="12">
    <input type="button" id="EOV13" onclick="gotoExam(13);" class="EOVWait" value="13">
    <input type="button" id="EOV14" onclick="gotoExam(14);" class="EOVWait" value="14">
    <input type="button" id="EOV15" onclick="gotoExam(15);" class="EOVWait" value="15">
    <input type="button" id="EOV16" onclick="gotoExam(16);" class="EOVWait" value="16">
    <input type="button" id="EOV17" onclick="gotoExam(17);" class="EOVWait" value="17">
    <input type="button" id="EOV18" onclick="gotoExam(18);" class="EOVWait" value="18">
    <input type="button" id="EOV19" onclick="gotoExam(19);" class="EOVWait" value="19">
    <input type="button" id="EOV20" onclick="gotoExam(20);" class="EOVWait" value="20">
    <input type="button" id="EOV21" onclick="gotoExam(21);" class="EOVWait" value="21">
    <input type="button" id="EOV22" onclick="gotoExam(22);" class="EOVWait" value="22">
    <input type="button" id="EOV23" onclick="gotoExam(23);" class="EOVWait" value="23">
    <input type="button" id="EOV24" onclick="gotoExam(24);" class="EOVWait" value="24">
    <input type="button" id="EOV25" onclick="gotoExam(25);" class="EOVWait" value="25">
    <br>
    <input type="button" id="EOV26" onclick="gotoExam(26);" class="EOVWait" value="26">
    <input type="button" id="EOV27" onclick="gotoExam(27);" class="EOVWait" value="27">
    <input type="button" id="EOV28" onclick="gotoExam(28);" class="EOVWait" value="28">
    <input type="button" id="EOV29" onclick="gotoExam(29);" class="EOVWait" value="29">
    <input type="button" id="EOV30" onclick="gotoExam(30);" class="EOVWait" value="30">
    <input type="button" id="EOV31" onclick="gotoExam(31);" class="EOVWait" value="31">
    <input type="button" id="EOV32" onclick="gotoExam(32);" class="EOVWait" value="32">
    <input type="button" id="EOV33" onclick="gotoExam(33);" class="EOVWait" value="33">
    <input type="button" id="EOV34" onclick="gotoExam(34);" class="EOVWait" value="34">
    <input type="button" id="EOV35" onclick="gotoExam(35);" class="EOVWait" value="35">
    <input type="button" id="EOV36" onclick="gotoExam(36);" class="EOVWait" value="36">
    <input type="button" id="EOV37" onclick="gotoExam(37);" class="EOVWait" value="37">
    <input type="button" id="EOV38" onclick="gotoExam(38);" class="EOVWait" value="38">
    <input type="button" id="EOV39" onclick="gotoExam(39);" class="EOVWait" value="39">
    <input type="button" id="EOV40" onclick="gotoExam(40);" class="EOVWait" value="40">
    <input type="button" id="EOV41" onclick="gotoExam(41);" class="EOVWait" value="41">
    <input type="button" id="EOV42" onclick="gotoExam(42);" class="EOVWait" value="42">
    <input type="button" id="EOV43" onclick="gotoExam(43);" class="EOVWait" value="43">
    <input type="button" id="EOV44" onclick="gotoExam(44);" class="EOVWait" value="44">
    <input type="button" id="EOV45" onclick="gotoExam(45);" class="EOVWait" value="45">
    <input type="button" id="EOV46" onclick="gotoExam(46);" class="EOVWait" value="46">
    <input type="button" id="EOV47" onclick="gotoExam(47);" class="EOVWait" value="47">
    <input type="button" id="EOV48" onclick="gotoExam(48);" class="EOVWait" value="48">
    <input type="button" id="EOV49" onclick="gotoExam(49);" class="EOVWait" value="49">
    <input type="button" id="EOV50" onclick="gotoExam(50);" class="EOVWait" value="50">

</div>

</body>
</html>

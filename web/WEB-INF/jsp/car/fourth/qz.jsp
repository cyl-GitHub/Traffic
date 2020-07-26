<%--
  Created by IntelliJ IDEA.
  User: cyl27
  Date: 2020/2/18
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>小车科目四全真模拟</title>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <link rel="stylesheet" href="${requestScope.ContextPath}/css/car/fourth/qz.css">
    <link rel="stylesheet" href="${requestScope.ContextPath}/css/car/fourth/sx.css">
    <script src="${requestScope.ContextPath}/js/car/fourth/qz.js"></script>

    <script>
        window.onload = function () {
            gotoExam();
        };
        $(document).ready(
            function () {
                var m = 45;  //分
                var s = 0;  //秒
                var countdown = $("#dsj");
                getCountdown();

                setInterval(function () {
                    getCountdown()
                }, 1000);

                function getCountdown() {
                    if (s >= 0 && s <= 9) {
                        countdown.html(m + ":0" + s);
                    } else {
                        countdown.html(m + ":" + s);
                    }

                    if (m == 0 && s == 0) {
                        testOver();
                    } else if (m >= 0) {
                        if (s > 0) {
                            s--;
                        } else if (s == 0) {
                            m--;
                            s = 59;
                        }
                    }
                }
            }
        );
    </script>
</head>
<body>

<div class="container mnks-exam" ref="body" data-sp="0">
    <div class="layout-article" ref="comMain" data-sp="0.6">
        <div class="container news-page">
            <div class="exam">
                <div class="row clearfix">
                    <%--考生信息--%>
                    <div class="col col1">

                        <fieldset class="kaochang">
                            <legend>理论考试</legend>
                            <span>第01考台</span>
                        </fieldset>

                        <fieldset class="kaosheng">
                            <legend>考生信息</legend>
                            <div class="author-img"></div>
                            <div class="kaosheng-item kemu red1">科目四</div>
                            <div class="kaosheng-item name">考生姓名：
                                <span id="stuid">${userLogin.getName()}</span>
                            </div>
                            <div class="kaosheng-item">考试题数：50</div>
                            <div class="kaosheng-item">考试时间：45分钟</div>
                            <div class="kaosheng-item">满分100分，90分及格</div>
                        </fieldset>

                        <fieldset class="daojishi">
                            <legend>剩余时间</legend>
                            <span class="djs" id="dsj"></span>
                        </fieldset>
                    </div>
                    <%--题目信息--%>
                    <div class="col col2">
                        <fieldset class="kaoti">
                            <legend>考试题目</legend>
                            <div data-sp="0.26" class="com-mnks-question-detail">
                                <div class="detail-content" id="ComQuestionInfo_qundefined">

                                    <%--题号--%>
                                    <input type="text" id="qid" value="1" hidden>

                                    <div class="timu">
                                        <%--题目--%>
                                        <p id="content">
                                        </p>
                                    </div>
                                    <%--选项--%>
                                    <div class="answer-w clearfix">
                                        <div data-questionid="911600" data-q-index="23" data-ismul="false"
                                             class="options-w left">
                                            <p id="kA"></p>
                                            <p id="kB"></p>
                                            <p id="kC"></p>
                                            <p id="kD"></p>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="clearfix">
                                <div class="select-w right" id="btn">
                                    <label style="float: left;margin-top:12px ">请选择:</label>
                                    <button class="select-lable" id="btnA" onclick="btnOn('A')" data-key="A">A</button>
                                    <button class="select-lable" id="btnB" onclick="btnOn('B')" data-key="B">B</button>
                                    <button class="select-lable" id="btnC" onclick="btnOn('C')" data-key="C">C</button>
                                    <button class="select-lable" id="btnD" onclick="btnOn('D')" data-key="D">D</button>
                                    <button class="btn-answer-ok" id="btnOk" onclick="check1()">确定</button>
                                </div>

                                <div class="user-answer" style="display: none" id="btn1">
                                    <span class="red1" id="res1">回答错误!&nbsp;&nbsp;</span>

                                    <span id="res2">您的答案：</span>

                                    <span class="blue2" id="res3"></span>&nbsp;&nbsp;
                                    <span>正确答案:</span>
                                    <span class="blue2" id="res4"></span>
                                    <a class="blue2 why" id="why">为什么</a>
                                </div>
                            </div>

                            <div style="display: none">
                                <input type="checkbox" value="A" id="A" name="rad">

                                <br>
                                <input type="checkbox" value="B" id="B" name="rad">

                                <div id="dC" style="">
                                    <input type="checkbox" value="C" id="C" name="rad">
                                </div>

                                <div id="dD" style="">
                                    <input type="checkbox" value="D" id="D" name="rad">
                                </div>
                            </div>
                        </fieldset>

                        <div class="kaoti-bar clearfix">
                            <fieldset class="tishi">
                                <legend>试题提示信息</legend>
                                <span id="multiple">单选题，请选择你认为正确的答案！</span>
                            </fieldset>
                            <div class="btn-bar">
                                <button class="pre" onclick="change('up')">上一题</button>
                                <button class="next" onclick="change('down')">下一题</button>
                                <button class="submit" onclick="delcfm()">交卷</button>
                            </div>
                        </div>
                    </div>
                    <%--答题卡--%>
                    <div class="col col3">
                        <h3 class="part-title">答题卡
                        </h3>
                        <div class="col col3">
                            <div class="datika">
                                <div class="dtcard" id="tCard">
                                    <div id="dtka" class="down">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <%--图片信息--%>
                <fieldset class="tishi-img">
                    <legend>图片信息</legend>
                    <div class="media-w">
                        <img src="#" alt="" id="pic"></div>
                </fieldset>
            </div>
        </div>
    </div>
</div>
</body>
</html>

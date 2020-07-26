<%--
  Created by IntelliJ IDEA.
  User: cyl27
  Date: 2020/2/12
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>科目四难点练习</title>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <link rel="stylesheet" href="${requestScope.ContextPath}/css/car/fourth/main.css">
    <link rel="stylesheet" href="${requestScope.ContextPath}/css/car/fourth/sx.css">
    <script src="${requestScope.ContextPath}/js/car/fourth/nd.js"></script>

    <script>
        window.onload = function () {
            gotoExam();
        }
        $(document).ready(
            gotoExam1(1)
        );
    </script>

</head>
<body>

<div class="container mnks-exercise" ref="body" data-sp="0">
    <div class="layout-article" ref="comMain" data-sp="0.6">
        <div class="container news-page">
            <div class="frame-l-r">
                <div class="left">


                    <%--答题页--%>
                    <div class="com-mnks-question-detail" data-sp="0.27">
                        <div class="detail-content" id="ComQuestionDetail_qundefined">
                            <%--题号--%>
                            <input type="text" id="qid" value="1" hidden>

                            <div class="timu">

                                <%--题目--%>
                                <p class="timu-text"
                                >
                                    <i class="nan">难</i>
                                    <span id="content">
                                    </span>

                                </p>

                                <button class="btn-shoucang" onclick="shoucang()" id="shoucang">收藏</button>
                            </div>

                            <div class="answer-w clearfix">
                                <%--选项--%>
                                <div data-questionid="909800" data-q-index="0" data-ismul="false" id="choose"
                                     class="options-w left">

                                    <input type="radio" value="A" id="A" name="rad"><label for="A" id="kA"></label>

                                    <br>
                                    <input type="radio" value="B" id="B" name="rad"><label for="B" id="kB"></label>

                                    <div id="dC" style="">
                                        <input type="radio" value="C" id="C" name="rad"><label for="C" id="kC"></label>
                                    </div>

                                    <div id="dD" style="">
                                        <input type="radio" value="D" id="D" name="rad"><label for="D" id="kD"></label>
                                    </div>
                                    <br><br><br>

                                    <button class="btn-answer-ok" onclick="check()">确定</button>
                                    <div id="result"></div>
                                </div>

                                <%--图片--%>
                                <div class="media-w right">
                                    <img src="" alt="图片" id="pic">
                                    <video src="" autoplay=""
                                           loop="" alt="">您的浏览器不支持 video 标签。
                                    </video>
                                </div>
                            </div>
                        </div>
                        <%--题目说明--%>
                        <div class="option-type-msg">
                            <span id="multiple"></span>
                        </div>
                        <div class="cwl-bar">错误率&nbsp;
                            <span class="red1" id="wrongRate"></span>,&nbsp; 做错人数&nbsp;
                            <span class="red1" id="wrongCnt"></span>
                        </div>
                    </div>

                    <%--操作项--%>
                    <div class=" com-mnks-datika" data-sp="0.26">
                        <div class="tool-bar">
                            <div class="btn-bar clearfix">
                                <button class="left gl" onclick="change('up')" id="last">上一题</button>
                                <button class="left gl" onclick="change('down')" id="next">下一题</button>
                                <button class="right pt" onclick="testCard()" id="cardbut">显示答题卡</button>
                                <button class="right pt" onclick="xiangjie()" id="xjbut">显示详解</button>
                            </div>
                            <div class="msg-bar clearfix">

                                <span class="left">
                                    <span class="gray">答对：</span>
                                    <span class="count-right" id="rightCount">&nbsp;题</span>
                                </span>
                                <span class="left">
                                    <span class="gray">答错：</span>
                                    <span class="count-wrong" id="wrongCount"></span>
                                </span>
                                <span class="left">
                                    <span class="gray">正确率：</span>
                                    <span id="accuracyRate"></span>
                                </span>
                            </div>
                        </div>

                    </div>

                    <%--详解--%>
                    <div class="" id="xiangjie" hidden>
                        <div data-sp="0.28">
                            <div class="com-shiti-xiangjie com-part">
                                <h3 class="part-title">试题详解
                                </h3>
                                <div class="xiangjie" id="xj">

                                </div>
                            </div>
                        </div>
                    </div>


                    <%--答题卡--%>
                    <div class="" id="testCard" hidden>
                        <div data-sp="0.28">
                            <div class="com-shiti-xiangjie com-part">
                                <h3 class="part-title">答题卡
                                </h3>
                                <div class="dtcard" id="tCard">

                                    <div id="dtka" class="down">

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <br>


                </div>
            </div>
        </div>
    </div>

</div>


</body>
</html>

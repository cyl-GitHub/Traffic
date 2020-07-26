<%--
  Created by IntelliJ IDEA.
  User: cyl27
  Date: 2020/2/17
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>科目四章节练习</title>
    <script src="${requestScope.ContextPath}/jquery-2.1.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${requestScope.ContextPath}/css/car/fourth/zj.css">
</head>
<body>

<div class="container mnks-tiku-menu-chapter" ref="body" data-sp="0">
    <div class="layout-article" ref="comMain" data-sp="0.6">
        <div class="container news-page">

            <div class="lx-main jkbd-width wid-auto"><h1 class="lx-title">小车科目四 章节练习</h1>
                <p class="lx-summary">按照法规章节逐步分类</p>
                <div class="lx-categroy ">
                    <div class="categroy-hd ">
                        <h3>
                            <a href="/title/carFourthZjSx?class2=道路交通安全法律、法规和规章" target="iframe2" class="hoverBdBlue" >第 1 章 道路交通安全法律、法规和规章</a>
                        </h3>
                        <span>（${count1}）</span>
                    </div>
                    <div class="categroy-bd">
                        <ul class="dot-ul cl">
                            <li>
                                <a target="iframe2" href="/title/carFourthZjSx?class2=道路交通安全法律、法规和规章">
                                    <span class="dian">•</span>顺序答题
                                </a>
                            </li>
                            <li>
                                <a target="iframe2" href="/title/carFourthZjSj?class2=道路交通安全法律、法规和规章">
                                    <span class="dian">•</span>随机答题
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="lx-categroy ">
                    <div class="categroy-hd ">
                        <h3>
                            <a href="/title/carFourthZjSx?class2=交通信号及其含义" target="iframe2" class="hoverBdBlue">第 2 章 交通信号及其含义</a>
                        </h3>
                        <span>（${count2}）</span>
                    </div>

                    <div class="categroy-bd">
                        <ul class="dot-ul cl">
                            <li>
                                <a target="iframe2" href="/title/carFourthZjSx?class2=交通信号及其含义">
                                    <span class="dian">•</span>顺序答题
                                </a>
                            </li>
                            <li>
                                <a target="iframe2" href="/title/carFourthZjSj?class2=交通信号及其含义">
                                    <span class="dian">•</span>随机答题
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="lx-categroy ">
                    <div class="categroy-hd "><h3>
                        <a href="/title/carFourthZjSx?class2=安全行车、文明驾驶知识" target="iframe2"
                           class="hoverBdBlue">第 3 章 安全行车、文明驾驶知识
                        </a>
                    </h3>
                        <span>（${count3}）</span>
                    </div>
                    <div class="categroy-bd">
                        <ul class="dot-ul cl">
                            <li>
                                <a target="iframe2" href="/title/carFourthZjSx?class2=安全行车、文明驾驶知识">
                                    <span class="dian">•</span>顺序答题
                                </a>
                            </li>
                            <li>
                                <a target="iframe2" href="/title/carFourthZjSj?class2=安全行车、文明驾驶知识">
                                    <span class="dian">•</span>随机答题
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="lx-categroy ">
                    <div class="categroy-hd "><h3>
                        <a href="/title/carFourthZjSx?class2=高速公路、山区道路、桥梁、隧道、夜间、恶劣气象和复杂条件下驾驶知识" target="iframe2" class="hoverBdBlue">第 4 章 高速公路、山区道路、桥梁、隧道、夜间、恶劣气象和复杂条件下驾驶知识</a></h3>
                        <span>（${count4}）</span>
                    </div>
                    <div class="categroy-bd">
                        <ul class="dot-ul cl">
                            <li>
                                <a target="iframe2" href="/title/carFourthZjSx?class2=高速公路、山区道路、桥梁、隧道、夜间、恶劣气象和复杂条件下驾驶知识">
                                    <span class="dian">•</span>顺序答题
                                </a>
                            </li>
                            <li>
                                <a target="iframe2" href="/title/carFourthZjSj?class2=高速公路、山区道路、桥梁、隧道、夜间、恶劣气象和复杂条件下驾驶知识">
                                    <span class="dian">•</span>随机答题
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="lx-categroy ">
                    <div class="categroy-hd ">
                        <h3>
                            <a href="/title/carFourthZjSx?class2=出现爆胎、转向失控、制动失灵等紧急情况时临危处置知识" target="iframe2" class="hoverBdBlue">第 5 章 出现爆胎、转向失控、制动失灵等紧急情况时临危处置知识</a>
                        </h3>
                        <span>（${count5}）</span>
                    </div>
                    <div class="categroy-bd">
                        <ul class="dot-ul cl">
                            <li><a target="iframe2" href="/title/carFourthZjSx?class2=出现爆胎、转向失控、制动失灵等紧急情况时临危处置知识"><span class="dian">•</span>顺序答题</a></li>
                            <li><a target="iframe2" href="/title/carFourthZjSj?class2=出现爆胎、转向失控、制动失灵等紧急情况时临危处置知识"><span class="dian">•</span>随机答题</a></li>
                        </ul>
                    </div>
                </div>
                <div class="lx-categroy ">
                    <div class="categroy-hd ">
                        <h3>
                            <a href="/title/carFourthZjSx?class2=机动车总体构造和主要安全装置常识，日常检查和维护基本知识" target="iframe2" class="hoverBdBlue">第 6 章 机动车总体构造和主要安全装置常识，日常检查和维护基本知识</a>
                        </h3>
                        <span>（${count6}）</span>
                    </div>
                    <div class="categroy-bd">
                        <ul class="dot-ul cl">
                            <li><a target="iframe2" href="/title/carFourthZjSx?class2=机动车总体构造和主要安全装置常识，日常检查和维护基本知识"><span class="dian">•</span>顺序答题</a></li>
                            <li><a target="iframe2" href="/title/carFourthZjSj?class2=机动车总体构造和主要安全装置常识，日常检查和维护基本知识"><span class="dian">•</span>随机答题</a></li>
                        </ul>
                    </div>
                </div>
                <div class="lx-categroy ">
                    <div class="categroy-hd "><h3><a href="/title/carFourthZjSx?class2=发生交通事故后的自救、急救等基本知识，以及常见危险化学品等知识" target="iframe2"
                                                     class="hoverBdBlue">第 7 章 发生交通事故后的自救、急救等基本知识，以及常见危险化学品等知识</a>
                    </h3>
                        <span>（${count7}）</span></div>
                    <div class="categroy-bd">
                        <ul class="dot-ul cl">
                            <li><a target="iframe2" href="/title/carFourthZjSx?class2=发生交通事故后的自救、急救等基本知识，以及常见危险化学品等知识"><span class="dian">•</span>顺序答题</a></li>
                            <li><a target="iframe2" href="/title/carFourthZjSj?class2=发生交通事故后的自救、急救等基本知识，以及常见危险化学品等知识"><span class="dian">•</span>随机答题</a></li>
                        </ul>
                    </div>
                </div>


                <%--<div class="lx-categroy ">--%>
                <%--<div class="categroy-hd "><h3><a href="/mnks/exercise/1-car-kemu4-chifeng-133.html" target="_blank"--%>
                <%--class="hoverBdBlue">第 7 章 发生交通事故后的自救、急救等基本知识，以及常见危险化学品等知识</a></h3>--%>
                <%--<span>（43题）</span></div>--%>
                <%--<div class="categroy-bd">--%>
                <%--<ul class="dot-ul cl">--%>
                <%--<li><a target="_blank" href="/mnks/exercise/1-car-kemu4-chifeng-133.html"><span--%>
                <%--class="dian">•</span>顺序答题</a></li>--%>
                <%--<li><a target="_blank" href="/mnks/exercise/1-car-kemu4-chifeng-133.html?r=1"><span--%>
                <%--class="dian">•</span>随机答题</a></li>--%>
                <%--</ul>--%>
                <%--</div>--%>
                <%--</div>--%>


            </div>
        </div>
    </div>
</div>


</body>
</html>

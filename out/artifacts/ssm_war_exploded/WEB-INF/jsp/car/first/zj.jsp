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
    <title>科目一章节练习</title>
    <script src="${requestScope.ContextPath}/jquery-2.1.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${requestScope.ContextPath}/css/car/fourth/zj.css">
</head>
<body>

<div class="container mnks-tiku-menu-chapter" ref="body" data-sp="0">
    <div class="layout-article" ref="comMain" data-sp="0.6">
        <div class="container news-page">

            <div class="lx-main jkbd-width wid-auto"><h1 class="lx-title">小车科目一 章节练习</h1>
                <p class="lx-summary">按照法规章节逐步分类</p>
                <div class="lx-categroy ">
                    <div class="categroy-hd ">
                        <h3>
                            <a href="/title/carFirstZjSx?class2=道路交通安全法律、法规和规章" target="iframe2" class="hoverBdBlue">第
                                1 章 道路交通安全法律、法规和规章</a>
                        </h3>
                        <span>（${count1}）</span>
                    </div>
                    <div class="categroy-bd">
                        <ul class="dot-ul cl">
                            <li>
                                <a target="iframe2" href="/title/carFirstZjSx?class2=道路交通安全法律、法规和规章">
                                    <span class="dian">•</span>顺序答题
                                </a>
                            </li>
                            <li>
                                <a target="iframe2" href="/title/carFirstZjSj?class2=道路交通安全法律、法规和规章">
                                    <span class="dian">•</span>随机答题
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="lx-categroy ">
                    <div class="categroy-hd ">
                        <h3>
                            <a href="/title/carFirstZjSx?class2=交通信号及其含义" target="iframe2" class="hoverBdBlue">第 2 章
                                交通信号及其含义</a>
                        </h3>
                        <span>（${count2}）</span>
                    </div>
                    <div class="categroy-bd">
                        <ul class="dot-ul cl">
                            <li>
                                <a target="iframe2" href="/title/carFirstZjSx?class2=交通信号及其含义">
                                    <span class="dian">•</span>顺序答题
                                </a>
                            </li>
                            <li>
                                <a target="iframe2" href="/title/carFirstZjSj?class2=交通信号及其含义">
                                    <span class="dian">•</span>随机答题
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="lx-categroy ">
                    <div class="categroy-hd "><h3>
                        <a href="/title/carFirstZjSx?class2=安全行车、文明驾驶知识" target="iframe2"
                           class="hoverBdBlue">第 3 章 安全行车、文明驾驶知识
                        </a>
                    </h3>
                        <span>（${count3}）</span>
                    </div>
                    <div class="categroy-bd">
                        <ul class="dot-ul cl">
                            <li>
                                <a target="iframe2" href="/title/carFirstZjSx?class2=安全行车、文明驾驶知识">
                                    <span class="dian">•</span>顺序答题
                                </a>
                            </li>
                            <li>
                                <a target="iframe2" href="/title/carFirstZjSj?class2=安全行车、文明驾驶知识">
                                    <span class="dian">•</span>随机答题
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="lx-categroy ">
                    <div class="categroy-hd "><h3>
                        <a href="/title/carFirstZjSx?class2=机动车驾驶操作相关基础知识" target="iframe2" class="hoverBdBlue">第 4 章
                            机动车驾驶操作相关基础知识</a></h3>
                        <span>（${count4}）</span>
                    </div>
                    <div class="categroy-bd">
                        <ul class="dot-ul cl">
                            <li>
                                <a target="iframe2" href="/title/carFirstZjSx?class2=机动车驾驶操作相关基础知识">
                                    <span class="dian">•</span>顺序答题
                                </a>
                            </li>
                            <li>
                                <a target="iframe2" href="/title/carFirstZjSj?class2=机动车驾驶操作相关基础知识">
                                    <span class="dian">•</span>随机答题
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>


</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: cyl27
  Date: 2020/2/11
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${requestScope.ContextPath}/css/car/main.css">
</head>
<body>
<div class="com-tiku-menu clearfix" data-sp="0.26">
    <div class="item-left">
        <%--<p class="title">车型选择</p>--%>
        <a class="item active icon1" data-index="0" ref="carTypeClick" href="#">小车</a>
        <a class="item  icon2" data-index="1" ref="carTypeClick" href="#">货车</a>
        <%--<a class="item  icon3" data-index="2" ref="carTypeClick" href="#">客车</a>--%>
        <%--<a class="item  icon4" data-index="3" ref="carTypeClick" href="#">摩托车</a>--%>
        <%--<a class="item  icon5" data-index="4" ref="carTypeClick" href="#">资格证</a>--%>
    </div>
    <div class="item-right">
        <div class="tab-w">
            <ul class="tab-nav clearfix">
                <li class="active" data-index="0" ref="ksTypeClick">
                    <a target="iframe2" href="#">小车科目一交规</a>
                </li>
                <li class="" data-index="1" ref="ksTypeClick">
                    <a target="iframe2" href="/title/mockTest1">小车科目四安全文明驾驶</a>
                </li>
            </ul>
            <div class="tab-content clearfix active">
                <a class="item" target="_blank" href="#">
                    <p class="p1"><i class="icon icon0"></i>顺序练习</p>
                    <p class="p2">按顺序练习做题</p>
                </a>
                <a class="item" target="_blank" href="#"><p class="p1">
                    <i class="icon icon3"></i>随机练习</p>
                    <p class="p2">所有法规一个不漏</p>
                </a>

                <a class="item" target="_blank" href="#"><p class="p1">
                    <i class="icon icon2"></i>专项练习</p>
                    <p class="p2">分门别类重点突破</p>
                </a>
                <a class="item" target="_blank" href="#">
                    <p class="p1"><i
                            class="icon icon1"></i>章节练习</p>
                    <p class="p2">按照法规章节逐步分类</p>
                </a>
                <a class="item" target="_blank" href="#">
                    <p class="p1"><i class="icon icon8"></i>难点攻克</p>
                    <p class="p2">准确把握考试难点</p></a>
                <a class="item" target="_blank" href="#">
                    <p class="p1">
                        <i class="icon icon9"></i>全真模拟</p>
                    <p class="p2">真实还原交管局考题难度</p></a>
            </div>
            <div class="tab-content clearfix ">
                <a class="item" target="_blank" href="#">
                    <p class="p1">
                        <i class="icon icon0"></i>顺序练习</p>
                    <p class="p2">按顺序练习做题</p></a>
                <a class="item" target="_blank" href="#"><p class="p1">
                    <i class="icon icon3"></i>随机练习</p>
                    <p class="p2">所有法规一个不漏</p>
                </a>
                <a class="item" target="_blank" href="#">
                    <p class="p1"><i class="icon icon2"></i>专项练习</p>
                    <p class="p2">分门别类重点突破</p></a>
                <a class="item" target="_blank" href="#">
                    <p class="p1">
                        <i class="icon icon1"></i>章节练习</p>
                    <p class="p2">按照法规章节逐步分类</p>
                </a><a class="item" target="_blank" href="#"><p class="p1">
                <i class="icon icon8"></i>难点攻克</p>
                <p class="p2">准确把握考试难点</p></a>
                <a class="item" target="_blank" href="#">
                    <p class="p1">
                        <i class="icon icon9"></i>全真模拟
                    </p>
                    <p class="p2">真实还原交管局考题难度</p>
                </a>
            </div>
        </div>
    </div>
</div>
</body>
</html>

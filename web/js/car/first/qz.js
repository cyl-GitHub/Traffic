function toDecimal(x) {
    var f = parseFloat(x);
    if (isNaN(f)) {
        return 0;
    }
    f = Math.round(x * 100) / 100;
    return f * 100;
}

function gotoExam() {

    $.ajax({
        url: "/title/getCarTitlesCount",
        dataType: "json",
        type: "POST",
        contentType: 'application/x-www-form-urlencoded',
        //向后端传输的数据
        data: {
            id: 1
        },
        //处理后端返回的数据
        success: function (data) {
            $("#dtka").html("");
            for (var i = 1; i <= data.carTitlesCount; i++) {
                $("#dtka").append(
                    "<input type=\"button\" id=\"EOV" + i + "\" name=\"dt\"  onclick=\"gotoExam1(" + i + ");\" class=\"EOVWait\" value = \"" + i + "\" >"
                )
                if (i % 5 == 0) {
                    $("#dtka").append("<br>");
                }
            }
            $("#EOV1").addClass("blue");
            gotoExam1(1);
        },
        //处理失败返回的数据
        error: function (data) {

        }
    })

}

function gotoExam1(id) {
    var qid = $("#qid").val();
    $("#EOV" + qid).removeClass("blue");
    $.ajax({
        url: "/title/getCarTitle",
        dataType: "json",
        type: "POST",
        contentType: 'application/x-www-form-urlencoded',
        //向后端传输的数据
        data: {
            id1: id,
        },
        //处理后端返回的数据
        success: function (data) {

            $("#qid").attr('value', data.qid);


            $('input[type=radio][name="rad"]:checked').attr("checked", false);
            $('input[type=checkbox][name="rad"]:checked').attr("checked", false);

            //上一题
            if (data.qid == 1) {
                $("#last").attr("style", "display:none;");
            } else {
                $("#last").attr("style", "display:block;");
            }
            //下一题
            if (data.qid == data.carTitlesCount) {
                $("#next").attr("style", "display:none;");
            } else {
                $("#next").attr("style", "display:block;");
            }


            $("#kA").html("A." + " " + data.carTitle.key1);
            $("#kB").html("B." + " " + data.carTitle.key2);

            $("#btnA").removeClass("active");
            $("#btnB").removeClass("active");
            $("#btnC").removeClass("active");
            $("#btnD").removeClass("active");
            if (data.carTitle.key3 != null && data.carTitle.key3 != '') {

                $("#btnC").attr("style", "display:block;");
                $("#kC").html("C." + " " + data.carTitle.key3);
            } else {
                $("#btnC").attr("style", "display:none;");
                $("#kC").html("");
            }
            if (data.carTitle.key4 != null && data.carTitle.key4 != '') {
                $("#btnD").attr("style", "display:block;");
                $("#kD").html("D." + " " + data.carTitle.key4);
            } else {
                $("#btnD").attr("style", "display:none;");
                $("#kD").html("");
            }

            if (data.carTitle.multiple == 1) {

                $("#btnA").attr("onclick", "btnOn(" + "'" + "A" + "'" + ")");
                $("#btnB").attr("onclick", "btnOn(" + "'" + "B" + "'" + ")");
                $("#btnC").attr("onclick", "btnOn(" + "'" + "C" + "'" + ")");
                $("#btnD").attr("onclick", "btnOn(" + "'" + "D" + "'" + ")");

                $("#content").html(data.qid + "." + data.carTitle.content);
                $("#btnOk").attr("style", "display:block;");

                $("#A").attr('type', 'checkbox');
                $("#B").attr('type', 'checkbox');
                $("#C").attr('type', 'checkbox');
                $("#D").attr('type', 'checkbox');

                $("#multiple").html("多选题，请选择你认为正确的答案！");
            } else if (data.carTitle.multiple == 0) {
                $("#btnA").attr("onclick", "checkA()");
                $("#btnB").attr("onclick", "checkB()");
                $("#btnC").attr("onclick", "checkC()");
                $("#btnD").attr("onclick", "checkD()");

                $("#content").html(data.qid + "." + data.carTitle.content);
                $("#btnOk").attr("style", "display:none;");
                $("#A").attr('type', 'radio');
                $("#B").attr('type', 'radio');
                $("#C").attr('type', 'radio');
                $("#D").attr('type', 'radio');

                $("#multiple").html("单选题，请选择你认为正确的答案！");
            }


            if (stringIsNotEmpty(data.carTitle.keyNow)) {
                var keyNow = data.carTitle.keyNow;

                $("#btn").attr("style", "display:none;");
                $("#btn1").attr("style", "display:block;");


                if (data.carTitle.keyNow == data.carTitle.key) {
                    $("#res1").html("回答正确!");
                    $("#res1").removeClass("red1");
                    $("#res1").addClass("blue1");
                    $("#res2").html("");
                    $("#res3").html("");
                } else {
                    $("#res1").html("回答错误");
                    $("#res1").removeClass("blue1");
                    $("#res1").addClass("red1");
                    $("#res2").html("您的答案：");
                    $("#res3").html(data.carTitle.keyNow);
                }
                $("#res4").html(data.carTitle.key);

                var str = keyNow.split("");

                if (str.length == 1) {
                    $("#" + keyNow).click();
                } else {
                    for (var i = 0; i < str.length; i++) {
                        $("#" + str[i]).click();
                    }
                }


            } else {
                $("#btn1").attr("style", "display:none;");
                $("#btn").attr("style", "display:block;");
            }


            if (data.carTitle.picture != null && data.carTitle.picture != '') {
                $("#pic").attr("style", "display:block;");
                $("#pic").attr("src", data.carTitle.picture);
            } else {
                $("#pic").attr("style", "display:none;");
            }


            $("#xj").html(data.carTitle.analysis);
            $("#why").attr("onclick", "alert(" + "'" + data.carTitle.analysis + "'" + ")");

            $("#result").html("");

            $("#EOV" + data.qid).addClass("blue");
        },
        //处理失败返回的数据
        error: function (data) {

        }
    })
}

function change(ud) {
    var qid = $("#qid").val();
    if (ud == "up" && qid == 1) {
        alert("这已经是第一道题了!");
    } else if (ud == "down" && qid == 50) {
        alert("这已经是最后一道题了!若答完请交卷!");
    } else {

        $("#EOV" + qid).removeClass("blue");
        $.ajax({
            url: "/title/changeCarTitle",
            dataType: "json",
            type: "POST",
            contentType: 'application/x-www-form-urlencoded',
            //向后端传输的数据
            data: {
                id: $("#qid").val(),
                ud: ud
            },
            //处理后端返回的数据
            success: function (data) {
                // var i = "EOV" + $("#qid").val();
                // document.getElementById(i).style.background = "#2aabd2";
                $("#qid").attr('value', data.qid);


                $('input[type=radio][name="rad"]:checked').attr("checked", false);
                $('input[type=checkbox][name="rad"]:checked').attr("checked", false);


                $("#btnA").removeClass("active");
                $("#btnB").removeClass("active");
                $("#btnC").removeClass("active");
                $("#btnD").removeClass("active");

                if (data.qid == 1) {
                    $("#last").attr("style", "display:none;");
                } else {
                    $("#last").attr("style", "display:block;");
                }
                if (data.qid == data.carTitlesCount) {
                    $("#next").attr("style", "display:none;");
                } else {
                    $("#next").attr("style", "display:block;");
                }


                $("#kA").html("A." + " " + data.carTitle.key1);
                $("#kB").html("B." + " " + data.carTitle.key2);
                if (data.carTitle.key3 != null && data.carTitle.key3 != '') {

                    $("#btnC").attr("style", "display:block;");
                    $("#kC").html("C." + " " + data.carTitle.key3);
                } else {
                    $("#btnC").attr("style", "display:none;");
                    $("#kC").html("");
                }
                if (data.carTitle.key4 != null && data.carTitle.key4 != '') {
                    $("#btnD").attr("style", "display:block;");
                    $("#kD").html("D." + " " + data.carTitle.key4);
                } else {
                    $("#btnD").attr("style", "display:none;");
                    $("#kD").html("");
                }


                if (data.carTitle.multiple == 1) {

                    $("#btnA").attr("onclick", "btnOn(" + "'" + "A" + "'" + ")");
                    $("#btnB").attr("onclick", "btnOn(" + "'" + "B" + "'" + ")");
                    $("#btnC").attr("onclick", "btnOn(" + "'" + "C" + "'" + ")");
                    $("#btnD").attr("onclick", "btnOn(" + "'" + "D" + "'" + ")");

                    $("#content").html(data.qid + "." + data.carTitle.content);
                    $("#btnOk").attr("style", "display:block;");

                    $("#A").attr('type', 'checkbox');
                    $("#B").attr('type', 'checkbox');
                    $("#C").attr('type', 'checkbox');
                    $("#D").attr('type', 'checkbox');

                    $("#multiple").html("多选题，请选择你认为正确的答案！");
                } else if (data.carTitle.multiple == 0) {
                    $("#btnA").attr("onclick", "checkA()");
                    $("#btnB").attr("onclick", "checkB()");
                    $("#btnC").attr("onclick", "checkC()");
                    $("#btnD").attr("onclick", "checkD()");

                    $("#content").html(data.qid + "." + data.carTitle.content);
                    $("#btnOk").attr("style", "display:none;");
                    $("#A").attr('type', 'radio');
                    $("#B").attr('type', 'radio');
                    $("#C").attr('type', 'radio');
                    $("#D").attr('type', 'radio');

                    $("#multiple").html("单选题，请选择你认为正确的答案！");
                }


                if (stringIsNotEmpty(data.carTitle.keyNow)) {
                    var keyNow = data.carTitle.keyNow;

                    $("#btn").attr("style", "display:none;");
                    $("#btn1").attr("style", "display:block;");


                    if (data.carTitle.keyNow == data.carTitle.key) {
                        $("#res1").html("回答正确!");
                        $("#res1").removeClass("red1");
                        $("#res1").addClass("blue1");
                        $("#res2").html("");
                        $("#res3").html("");
                    } else {
                        $("#res1").html("回答错误");
                        $("#res1").removeClass("blue1");
                        $("#res1").addClass("red1");
                        $("#res2").html("您的答案：");
                        $("#res3").html(data.carTitle.keyNow);
                    }
                    $("#res4").html(data.carTitle.key);

                    var str = keyNow.split("");

                    if (str.length == 1) {
                        $("#" + keyNow).click();
                    } else {
                        for (var i = 0; i < str.length; i++) {
                            $("#" + str[i]).click();
                        }
                    }


                } else {
                    $("#btn1").attr("style", "display:none;");
                    $("#btn").attr("style", "display:block;");
                }

                if (data.carTitle.picture != null && data.carTitle.picture != '') {
                    $("#pic").attr("style", "display:block;");
                    $("#pic").attr("src", data.carTitle.picture);
                } else {
                    $("#pic").attr("style", "display:none;");
                }
                $("#why").attr("onclick", "alert(" + "'" + data.carTitle.analysis + "'" + ")");

                $("#result").html("");
                $("#EOV" + data.qid).addClass("blue");
            },
            //处理失败返回的数据
            error: function (data) {

            }
        })

    }


}

function checkA() {
    $("#A").click();
    check1();
}

function checkB() {
    $("#B").click();
    check1();
}

function checkC() {
    $("#C").click();
    check1();
}

function checkD() {
    $("#D").click();
    check1();
}

function xiangjie() {

    if ($("#xiangjie").css("display") == 'none') {
        $("#xiangjie").attr("style", "display:block;");
        $("#xjbut").html("隐藏详解");
    }
    else if ($("#xiangjie").css("display") == 'block') {

        $("#xiangjie").attr("style", "display:none;");
        $("#xjbut").html("显示详解");
    }
}

function stringIsNotEmpty(obj) {
    if (typeof obj == "undefined" || obj == null || obj == "") {
        return false;
    } else {
        return true;
    }
}

function check1() {
    var keyV = "";
    var key = document.getElementsByName("rad");
    for (var i in key) {
        if (key[i].checked) {
            keyV = keyV + key[i].value;
        }
    }

    $.ajax({
        url: "/title/checkCarTitle",
        dataType: "json",
        type: "POST",
        contentType: 'application/x-www-form-urlencoded',
        //向后端传输的数据
        data: {
            id: $("#qid").val(),
            key: keyV,
        },
        //处理后端返回的数据
        success: function (data) {
            if (data.result == "未答题") {
                alert("此题未作答!");
            }

            if (data.result == "答题正确") {
                $("#result").html("答题正确！");
                var qid = $("#qid").val();
                $("#EOV" + qid).addClass("green");
                change("down");
            }

            if (data.result == "答题错误") {
                $("#result").html("答题错误！正确答案为" + data.carTitle.key);
                var qid = $("#qid").val();
                $("#EOV" + qid).addClass("red");
                change("down");
            }

            if (data.result == "此题已作答") {
                $("#result").html("此题已作答，请作答其它题！")
            }

            $("#rightCount").html(data.rightCount);
            $("#wrongCount").html(data.wrongCount);
            $("#accuracyRate").html(toDecimal(data.rightCount / (data.rightCount + data.wrongCount)) + "%");


        },
        //处理失败返回的数据
        error: function (data) {

        }
    })

}

function btnOn(choose) {
    $("#" + choose).click();
    $("#btn" + choose).addClass("active");
    $("#btn" + choose).attr("onclick", "btnOn1(" + "'" + choose + "'" + ")");
}

function btnOn1(choose) {
    $("#" + choose).attr("checked", false);
    // $('input[type=checkbox][name="rad"]:checked').attr("checked", false);
    $("#btn" + choose).removeClass("active");
    $("#btn" + choose).attr("onclick", "btnOn(" + "'" + choose + "'" + ")");
}

function testOver() {
    $.ajax({
        url: "/title/carFirstTestOver",
        dataType: "json",
        type: "POST",
        contentType: 'application/x-www-form-urlencoded',
        //向后端传输的数据
        data: {
            id1: 1,
        },
        //处理后端返回的数据
        success: function (data) {
            if (data.score >= 90) {
                alert("您的分数为" + data.score + "分,非常优秀!");
                window.location.href = "/user/userTotalPage";
            } else {
                alert("您的分数为" + data.score + "分,仍需努力!");
                window.location.href = "/user/userTotalPage";
            }

        },
        //处理失败返回的数据
        error: function (data) {

        }
    })
}

function delcfm() {
    if (confirm("确认交卷？")) {
        testOver();
    }
}


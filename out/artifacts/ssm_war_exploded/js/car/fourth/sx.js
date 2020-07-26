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
            id:1
        },
        //处理后端返回的数据
        success: function (data) {
            $("#dtka").html("");
            for (var i = 1; i <= data.carTitlesCount; i++) {
                $("#dtka").append(
                    "<input type=\"button\" id=\"EOV"+ i+"\" name=\"dt\"  onclick=\"gotoExam1("+ i +");\" class=\"EOVWait\" value = \""+ i +"\" >"
                )
            }
            $("#EOV1").addClass("blue");
        },
        //处理失败返回的数据
        error: function (data) {

        }
    })
}

function gotoExam1(id) {
    var qid = $("#qid").val();
    $("#EOV"+qid).removeClass("blue");
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

            if (data.carTitle.multiple == 1) {
                $("#content").html(data.qid + "/" + data.carTitlesCount + "." + data.carTitle.content + "(多选)");
                $("#A").attr('type', 'checkbox');
                $("#B").attr('type', 'checkbox');
                $("#C").attr('type', 'checkbox');
                $("#D").attr('type', 'checkbox');
                $("#multiple").html("多选题，请选择你认为正确的答案！");
            } else if (data.carTitle.multiple == 0) {
                $("#content").html(data.qid + "/" + data.carTitlesCount + "." + data.carTitle.content + "(单选)");
                $("#A").attr('type', 'radio');
                $("#B").attr('type', 'radio');
                $("#C").attr('type', 'radio');
                $("#D").attr('type', 'radio');
                $("#multiple").html("单选题，请选择你认为正确的答案！");
            }


            $("#kA").html("A." + data.carTitle.key1);
            $("#kB").html("B." + data.carTitle.key2);
            if (data.carTitle.key3 != null && data.carTitle.key3 != '') {

                $("#dC").attr("style", "display:block;");
                $("#kC").html("C." + data.carTitle.key3);
            } else {
                $("#dC").attr("style", "display:none;");
            }
            if (data.carTitle.key4 != null && data.carTitle.key4 != '') {
                $("#dD").attr("style", "display:block;");
                $("#kD").html("D." + data.carTitle.key4);
            } else {
                $("#dD").attr("style", "display:none;");
            }

            if (stringIsNotEmpty(data.carTitle.keyNow)) {
                var keyNow = data.carTitle.keyNow;

                var str = keyNow.split("");

                if (str.length == 1) {
                    $("#" + keyNow).click();
                } else {
                    for (var i = 0; i < str.length; i++) {
                        $("#" + str[i]).click();
                    }
                }
            }

            if (data.carTitle.picture != null && data.carTitle.picture != '') {
                $("#pic").attr("style", "display:block;");
                $("#pic").attr("src", data.carTitle.picture);
            } else {
                $("#pic").attr("style", "display:none;");
            }


            //设定收藏按钮样式
            if (data.carTitle.collection) {
                if (!$("#shoucang").hasClass("favor")) {
                    $("#shoucang").addClass("favor");
                    $("#shoucang").attr("onclick", "noshoucang()");
                }
            } else {
                if ($("#shoucang").hasClass("favor")) {
                    $("#shoucang").removeClass("favor");
                    $("#shoucang").attr("onclick", "shoucang()");
                }

            }


            $("#xj").html(data.carTitle.analysis);
            $("#rightCount").html(data.rightCount + "&nbsp;题");
            $("#wrongCount").html(data.wrongCount + "&nbsp;题");
            $("#accuracyRate").html(toDecimal(data.rightCount / (data.rightCount + data.wrongCount)) + "%");
            $("#result").html("");

            $("#EOV" + data.qid).addClass("blue");
        },
        //处理失败返回的数据
        error: function (data) {

        }
    })
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

function testCard() {

    if ($("#testCard").css("display") == 'none') {
        $("#testCard").attr("style", "display:block;");
        $("#cardbut").html("隐藏答题卡");
    }
    else if ($("#testCard").css("display") == 'block') {

        $("#testCard").attr("style", "display:none;");
        $("#cardbut").html("显示答题卡");
    }
}

function stringIsNotEmpty(obj) {
    if (typeof obj == "undefined" || obj == null || obj == "") {
        return false;
    } else {
        return true;
    }
}


function change(ud) {
    var qid = $("#qid").val();
    $("#EOV"+qid).removeClass("blue");
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

            if (data.carTitle.multiple == 1) {
                $("#content").html(data.qid + "/" + data.carTitlesCount + "." + data.carTitle.content + "(多选)");
                $("#A").attr('type', 'checkbox');
                $("#B").attr('type', 'checkbox');
                $("#C").attr('type', 'checkbox');
                $("#D").attr('type', 'checkbox');
                $("#multiple").html("多选题，请选择你认为正确的答案！");
            } else if (data.carTitle.multiple == 0) {
                $("#content").html(data.qid + "/" + data.carTitlesCount + "." + data.carTitle.content + "(单选)");
                $("#A").attr('type', 'radio');
                $("#B").attr('type', 'radio');
                $("#C").attr('type', 'radio');
                $("#D").attr('type', 'radio');
                $("#multiple").html("单选题，请选择你认为正确的答案！");
            }


            $("#kA").html("A." + data.carTitle.key1);
            $("#kB").html("B." + data.carTitle.key2);
            if (data.carTitle.key3 != null && data.carTitle.key3 != '') {

                $("#dC").attr("style", "display:block;");
                $("#kC").html("C." + data.carTitle.key3);
            } else {
                $("#dC").attr("style", "display:none;");
            }
            if (data.carTitle.key4 != null && data.carTitle.key4 != '') {
                $("#dD").attr("style", "display:block;");
                $("#kD").html("D." + data.carTitle.key4);
            } else {
                $("#dD").attr("style", "display:none;");
            }


            if (stringIsNotEmpty(data.carTitle.keyNow)) {
                var keyNow = data.carTitle.keyNow;

                var str = keyNow.split("");

                if (str.length == 1) {
                    $("#" + keyNow).click();
                } else {
                    for (var i = 0; i < str.length; i++) {
                        $("#" + str[i]).click();
                    }
                }
            }

            if (data.carTitle.picture != null && data.carTitle.picture != '') {
                $("#pic").attr("style", "display:block;");
                $("#pic").attr("src", data.carTitle.picture);
            } else {
                $("#pic").attr("style", "display:none;");
            }


            //设定收藏按钮样式
            if (data.carTitle.collection) {
                if (!$("#shoucang").hasClass("favor")) {
                    $("#shoucang").addClass("favor");
                    $("#shoucang").attr("onclick", "noshoucang()");
                }
            } else {
                if ($("#shoucang").hasClass("favor")) {
                    $("#shoucang").removeClass("favor");
                    $("#shoucang").attr("onclick", "shoucang()");
                }

            }


            $("#rightCount").html(data.rightCount);
            $("#wrongCount").html(data.wrongCount);
            $("#accuracyRate").html(toDecimal(data.rightCount / (data.rightCount + data.wrongCount)) + "%");
            $("#result").html("");
            $("#EOV" + data.qid).addClass("blue");
        },
        //处理失败返回的数据
        error: function (data) {

        }
    })

}


function check() {
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
                $("#result").html("此题未作答，请作答后再次提交！")
            }

            if (data.result == "答题正确") {
                $("#result").html("答题正确！");
                var qid = $("#qid").val();
                $("#EOV"+qid).addClass("green");
            }

            if (data.result == "答题错误") {
                $("#result").html("答题错误！正确答案为" + data.carTitle.key);
                var qid = $("#qid").val();
                $("#EOV"+qid).addClass("red");
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


function shoucang() {
    $.ajax({
        url: "/title/shoucang",
        dataType: "json",
        type: "POST",
        contentType: 'application/x-www-form-urlencoded',
        //向后端传输的数据
        data: {
            id: $("#qid").val()
        },
        //处理后端返回的数据
        success: function (data) {
            if (data.result == "收藏成功") {
                $("#shoucang").addClass("favor");
                $("#shoucang").attr("onclick", "noshoucang()");
            }
        },
        //处理失败返回的数据
        error: function (data) {

        }
    })
}


function noshoucang() {
    $.ajax({
        url: "/title/noshoucang",
        dataType: "json",
        type: "POST",
        contentType: 'application/x-www-form-urlencoded',
        //向后端传输的数据
        data: {
            id: $("#qid").val()
        },
        //处理后端返回的数据
        success: function (data) {
            if (data.result == "取消收藏成功") {
                $("#shoucang").removeClass("favor");
                $("#shoucang").attr("onclick", "shoucang()");
            }
        },
        //处理失败返回的数据
        error: function (data) {

        }
    })
}
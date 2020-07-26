function addTitle() {
    var obj;

    obj = new FormData();

    var keyV = "";
    var key = document.getElementsByName("key");
    for (var i in key) {
        if (key[i].checked) {
            keyV = keyV + key[i].value;
        }
    }

    obj.append("file", $('#file')[0].files[0]);
    obj.append("content", $("#content").val());
    obj.append("key1", $("#key1").val());
    obj.append("key2", $("#key2").val());
    obj.append("key3", $("#key3").val());
    obj.append("key4", $("#key4").val());
    obj.append("key", keyV);
    obj.append("multiple", $('input[name=multiple]:checked').val());
    obj.append("score", $('input[name=score]:checked').val());
    obj.append("class1", $("#cla1 option:selected").val());
    obj.append("class2", $("#cla2 option:selected").val());
    obj.append("class3", $("#cla3 option:selected").val());
    obj.append("analysis", $("#analysis").val());


    $.ajax({
        url: "/title/doAddTitle",
        dataType: "json",
        type: "POST",
        contentType: false,
        //向后端传输的数据
        cache: false,
        data: obj,
        processData: false,

        //处理后端返回的数据
        success: function (data) {
            if (data.result == "信息不可为空,请检查后重新提交!") {
                $("#div2").html("");
                $("#div1").html(data.result);
            } else if (data.result == "此题为单选,不可选择多个答案") {
                $("#div1").html("");
                $("#div2").html(data.result);
            } else if (data.result == "此题为多选,不可选择单个答案") {
                $("#div1").html("");
                $("#div2").html(data.result);
            } else {
                alert("添加成功");
                window.location.href = "/title/addTitle";
            }
        },
        //处理失败返回的数据
        error: function (data) {
            alert("插入失败");
        }
    });
}


window.onload = function () {
    selectClass3();
}


function selectClass3() {
    $.ajax({
        url: "/title/selectClass3", dataType: "json",
        type: "POST",
        contentType: "application/json;charset=utf-8",
        //向后端传输的数据
        data: JSON.stringify({
            id: 1
        }),
        //处理后端返回的数据
        success: function (data) {
            var count = data.class3.length;
            if (count == 0) {
                $("#cla3").html("<option value=\"未选择\">------------未选择------------</option>");
            } else {
                for (var i = 0; i < count; i++) {
                    $("#cla3").append("<option onclick=\"selectClass1()\" value=\"" + data.class3[i] + "\">" + data.class3[i] + "</option>");
                }
            }

        },
        //处理失败返回的数据
        error: function (data) {
        }
    })

}

function selectClass1() {
    var class3 = $("#cla3 option:selected"); //获取选中的项

    $.ajax({
        url: "/title/selectClass1",
        dataType: "json",
        type: "POST",
        contentType: 'application/x-www-form-urlencoded',
        //向后端传输的数据
        data: {
            class3: class3.val()
        },
        //处理后端返回的数据
        success: function (data) {
            var count = data.class1.length;
            if (count == 0) {
                $("#cla1").html("<option value=\"未选择\">------------未选择------------</option>");
            } else {
                for (var i = 0; i < count; i++) {
                    $("#cla1").append("<option  value=\"" + data.class1[i] + "\">" + data.class1[i] + "</option>");
                }
            }
        },
        //处理失败返回的数据
        error: function (data) {
        }
    })

}

function selectClass2() {
    var class3 = $("#cla3 option:selected"); //获取选中的项
    var class1 = $("#cla1 option:selected"); //获取选中的项

    $.ajax({
        url: "/title/selectClass2",
        dataType: "json",
        type: "POST",
        contentType: 'application/x-www-form-urlencoded',
        //向后端传输的数据
        data: {
            class3: class3.val(),
            class1: class1.val()
        },
        //处理后端返回的数据
        success: function (data) {
            var count = data.class2.length;
            if (count == 0) {
                $("#cla2").html("<option value=\"未选择\">------------未选择------------</option>");
            } else {
                $("#cla2").html("");
                for (var i = 0; i < count; i++) {
                    $("#cla2").append("<option value=\"" + data.class2[i] + "\">" + data.class2[i] + "</option>");
                }
            }
        },
        //处理失败返回的数据
        error: function (data) {
        }
    })

}



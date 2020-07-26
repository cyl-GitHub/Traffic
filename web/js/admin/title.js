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
                $("#cla3").html("<option value=\"全部\">------------全部------------</option>");
            } else {
                $("#cla3").html("<option value=\"全部\">------------全部------------</option>");

                for (var i = 0; i < count; i++) {
                    $("#cla3").append("<option onclick=\"selectClass1()\" value=\""+ data.class3[i] +"\">"+ data.class3[i] +"</option>");
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
                $("#cla1").html("<option value=\"全部\">------------全部------------</option>");
            } else {
                $("#cla1").html("<option value=\"全部\">------------全部------------</option>");

                for (var i = 0; i < count; i++) {
                    $("#cla1").append("<option  value=\""+ data.class1[i] +"\">"+ data.class1[i] +"</option>");
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
                $("#cla2").html("<option value=\"全部\">------------全部------------</option>");
            } else {
                $("#cla2").html("<option value=\"全部\">------------全部------------</option>");

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
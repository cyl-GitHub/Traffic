
function register() {
    $.ajax({
        url: "/user/doRegister",
        dataType: "json",
        type: "POST",
        contentType: "application/json;charset=utf-8",
        //向后端传输的数据
        data: JSON.stringify({
            id: $("#id").val(),
            name: $("#name").val(),
            password: $("#password").val(),
            telephone:$("#telephone").val(),
            code:$("#code").val()
        }),
        //处理后端返回的数据
        success: function (data) {
            if (data.result == "success") {
                $("#divAll").html("注册成功,3s后跳转!");
                window.setTimeout("window.location.href = '/user/login'", 3000);
            }else if (data.result == "用户已存在") {
                changeImg();
                $("#divTel").html("");
                $("#divId").html("");
                $("#divAll").html("");
                $("#divUser").html(data.result);
            }else if (data.result == "验证码错误") {
                changeImg();
                $("#divTel").html("");
                $("#divUser").html("");
                $("#divId").html("");
                $("#divAll").html(data.result);
            } else if (data.result == "身份证号格式错误") {
                changeImg();
                $("#divTel").html("");
                $("#divAll").html("");
                $("#divUser").html("");
                $("#divId").html(data.result);
            } else if (data.result == "手机号格式错误") {
                changeImg();
                $("#divId").html("");
                $("#divAll").html("");
                $("#divUser").html("");
                $("#divTel").html(data.result);
            }else {
                changeImg();
                $("#divTel").html("");
                $("#divUser").html("");
                $("#divId").html("");
                $("#divAll").html(data.result);
            }
        },
        //处理失败返回的数据
        error: function (data) {
            changeImg();
            $("#divAll").html(data.result);
        }
    })
}


function KeyDown() {
    if (event.keyCode == 13) {
        var btn_login = document.getElementById("regs");//id为登录按钮id
        btn_login.focus();
        btn_login.click();
    }
}

$(function () {
    $('#account').focus(function () {
        $('#account').val('');
    });
    $('#password').focus(function () {
        $('#password').val('');
    });
    $('#verifyCode').focus(function () {
        $('#verifyCode').val('');
    });
    $('#account').blur(function () {
        if ($('#account').val() == '') {
            $('#account').val('用户名不能为空');
            $('#account').css({'color': 'red'});
        }
    })
    $('#account').focus(function () {
        $('#account').css({'color': '#ADADAD'});
    });

    $('#password').blur(function () {
        if ($('#password').val() == '') {
            $('#password').val('密码不能为空');
            $('#password').css({'color': 'red'});
        }
    })
    $('#password').focus(function () {
        $('#password').css({'color': '#ADADAD'});
    });

    $('#verifyCode').blur(function () {
        if ($('#verifyCode').val() == '') {
            $('#verifyCode').val('验证码不能为空');
            $('#verifyCode').css({'color': 'red'});
        }
    })
    $('#verifyCode').focus(function () {
        $('#verifyCode').css({'color': '#ADADAD'});
    });

    $('#btnSubmit').click(function () {
        $.ajax({
            url: "doLogin",
            type: "GET",
            data: $(".form-horizontal").serialize(),
            success: (e) => {
                if (e.code == 200) {
                    layer.msg("登录成功", {icon: 6, time: 800});
                    setTimeout(() => {
                        location.href = "/toAttraction";
                    }, 1000);
                } else {
                    layer.msg(e.msg);
                    setTimeout(function () {
                        $("#verifyCode").val("");
                        changeImg();
                    }, 1000);
                }
            }
        });
    });
});
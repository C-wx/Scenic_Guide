<!DOCTYPE html>
<html lang="en">
<#assign base=request.contextPath />
<head>
    <title>登录页</title>
    <script src="${base}/js/jquery.min.js"></script>
    <!--layui-->
    <script src="${base}/plugins/layui/layui.all.js"></script>
    <link rel="stylesheet" href="${base}/plugins/layui/css/layui.css">
    <!-- Font Awesome CSS-->
    <link rel="stylesheet" href="${base}/plugins/font-awesome/css/font-awesome.min.css">

    <link rel="stylesheet" href="${base}/css/login.css">
    <script src="${base}/js/login.js"></script>
</head>
<body>
<div class="container">
    <div class="layui-row">
        <div class="layui-col-md-offset4 layui-col-md4">
            <form class="form-horizontal">
                <span class="heading">北墘导览后台</span>
                <div class="form-group">
                    <input name="account" type="text" class="form-control" id="account" value="请输入用户名"/>
                </div>
                <div class="form-group">
                    <input name="password" type="text" class="form-control" id="password" value="请输入密码"/>
                </div>
                <div class="form-group" style="height: 40px">
                    <div class="layui-col-md8">
                        <input name="verifyCode" type="text" class="form-control" id="verifyCode" value="请输入验证码"/>
                    </div>
                    <div class="layui-col-md4">
                        <img class="admin-captcha" width="120" height="40" src="/verycode/getImgCode" id="imgObj"
                             onclick="changeImg()">
                    </div>
                </div>
                <div class="form-group">
                    <li class="li4">
                        <input class="submit" type="button" id="btnSubmit" value="登录">
                    </li>
                </div>
            </form>
        </div>
    </div>
</div>
<!--动态背景-->
<script src="${base}/js/jquery.gradientify.min.js"></script>
<script>
    $(document).ready(function () {
        $("body").gradientify({
            gradients: [
                {start: [49, 76, 172], stop: [242, 159, 191]},
                {start: [255, 103, 69], stop: [240, 154, 241]},
                {start: [33, 229, 241], stop: [235, 236, 117]}
            ]
        });
    });
</script>
<script>
    function changeImg() {
        var imgSrc = $("#imgObj");
        var src = imgSrc.attr("src");
        imgSrc.attr("src", chgUrl(src));
    }

    function chgUrl(url) {
        var timestamp = (new Date()).valueOf();
        urlurl = url.substring(0, 17);
        if ((url.indexOf("&") >= 0)) {
            urlurl = url + "×tamp=" + timestamp;
        } else {
            urlurl = url + "?timestamp=" + timestamp;
        }
        urlurl = "${base}/verycode/getImgCode?timestamp=" + timestamp + "&imgCodeType=NUM";
        return urlurl;
    }
</script>
</body>
</html>

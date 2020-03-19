<!DOCTYPE html>
<html lang="en">
<#assign base=request.contextPath />
<head>
    <meta charset="utf-8">
    <title>商户管理</title>
    <script src="${base}/js/jquery.min.js"></script>
    <!--layui-->
    <script src="${base}/plugins/layui/layui.js"></script>
    <link rel="stylesheet" href="${base}/plugins/layui/css/layui.css">
    <!-- Font Awesome CSS-->
    <link rel="stylesheet" href="${base}/plugins/font-awesome/css/font-awesome.min.css">
</head>

<body>
    <div class="page-wrapper">
        <div class="layui-fluid" style="padding: 10px;">
            <div class="layui-row layui-form">
                <div class="layui-card">
                    <div class="layui-card-body" style="padding-top: 25px;">
                        <form  method="post" class="layui-form">
                            <input type="hidden" name="id" value="${attraction.id}">
                                <label style="display: inline-block">实时人流量：</label>
                                <input style="display: inline-block;width: 100px" type="text" name="currentnum" autocomplete="off" class="layui-input" value="${attraction.currentnum!}">
                            <div class="layui-form-item" style="text-align: center;margin-top: 20px">
                                <button class="layui-btn" lay-submit="" lay-filter="submit" type="button">更新</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
<style>
    label {
        margin-left: 10px;
        width: 150px;
        font-size: 16px;
    }
</style>
<script>
    layui.use(['form'], function () {
        var form = layui.form;
        form.render();
        form.on('submit(submit)', function (data) {
            $.ajax({
                url: "/manageAttraction",
                type: "POST",
                data: new FormData($("form")[0]),
                processData: false,
                contentType: false,
                success: function (res) {
                    if (res.code == 200) {
                        layer.msg("操作成功", {icon: 6, time: 800});
                        setTimeout(() => {
                            var index = parent.layer.getFrameIndex(window.name);
                            parent.layer.close(index);
                            parent.location.reload();
                        }, 800);
                    } else {
                        layer.msg(res.msg, {icon: 5, time: 800});
                    }
                }
            });
            return false;
        });
    });
</script>
</body>
</html>
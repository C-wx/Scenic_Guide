layui.use(['form', 'layedit', 'laydate'], function () {
    var form = layui.form;
    form.render();
    form.on('submit(submit)', function (data) {
        $.ajax({
            url: "/manageRoute",
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

function click_image(index) {
    $("#file_" + index).click();
}

function replace_image(index) {
    // 获得图片对象
    var blob_image = $("#file_" + index)[0].files[0];
    var url = window.URL.createObjectURL(blob_image);
    // 替换image
    $("#image_" + index).attr("src", url);
    console.log($("#file_" + index).val());
}
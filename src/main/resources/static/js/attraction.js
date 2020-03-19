layui.use(['form', 'table'], function () {
    var form = layui.form,
        table = layui.table;
    form.render();
    /**
     * 初始化表格
     */
    var showTable = table.render({
        elem: '#showTable'
        , url: '/attractionList'
        , page: true
        , limit: 10
        , height: 'full'
        , method: 'get'
        , request: {
            pageName: 'current' //页码的参数名称，默认：page
            , limitName: 'size' //每页数据量的参数名，默认：limit
        }
        , cols: [[
            {
                field: 'title'
                , title: '景点名称'
                , align: 'center'
            }
            , {
                field: 'brief'
                , title: '简介'
                , align: 'center'
            }
            , {
                field: 'detail'
                , title: '描述'
                , align: 'center'
                , event: "detail"
                , templet: (d) => {
                    return "<div style='cursor:pointer;color: red'>点击查看</div>"
                }
            }
            , {
                field: 'punchnum'
                , title: '打卡人数'
                , align: 'center'
            }
            , {
                title: '操作'
                , align: 'center'
                , fixed: 'right'
                , templet: (d) => {
                    var html = '';
                    html += '<a class="layui-btn layui-btn-sm" lay-event="edit">编辑</a>';
                    html += '<a class="layui-btn layui-btn-danger layui-btn-sm" lay-event="delete">删除</a>';
                    return html;
                }
            }
        ]]
    });


    /**
     * 创建监听工具
     */
    table.on('tool(showTable)', function (obj) {
        var data = obj.data;
        if (obj.event == 'detail') {         //点击查看内容详情
            layer.open({
                type: 0,
                title: '内容详情',
                btn: [],
                offset: 'auto',
                content: '<div style="padding: 20px;">' + data.detail + '</div>',
                shade: 0.4
            })
        } else if (obj.event == 'edit') {
            location.href = "/toManageAttraction?id=" + data.id;
        } else if (obj.event == 'delete') {
            layer.confirm('是否删除该景点?', {icon: 3, title: '提示'}, function (index) {
                $.ajax({
                    url: "manageAttraction",
                    type: "POST",
                    data: {'id': data.id, 'type': 'delete'},
                    success: (res) => {
                        if (res.code === 200) {
                            layer.msg("操作成功", {icon: 6, time: 800});
                            setTimeout(() => {
                                layer.close(index);
                                table.reload('showTable', {page: {curr: 1}});
                            }, 800)
                        } else {
                            layer.msg(res.msg, {icon: 5, time: 500});
                        }
                    }
                });
            });
        }
    });

    /**
     * 监听搜索事件
     */
    $('button[data-type]').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });
    var active = {
        keyLike: function () {                          //关键词模糊搜索
            const name = $('#name');
            //执行重载
            table.reload('productRecycleTable', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                , where: {
                    name: name.val()
                }
            });
        },
        reload: function () {                           //重置加载页面
            $('#name').val("");
            table.reload('productRecycleTable', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                , where: {
                    name: $('#name').val()
                }
            });
        }
    };

    /**
     * 添加景点
     */
    doAdd = () => {
        location.href = "/toManageAttraction";
    }
});

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
                field: 'currentnum'
                , title: '人流量'
                , align: 'center'
            }
            , {
                title: '操作'
                , align: 'center'
                , fixed: 'right'
                , templet: (d) => {
                    var html = '';
                    html += '<a class="layui-btn layui-btn-sm" lay-event="update">更新</a>';
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
        }else if (obj.event == 'update') {
            layer.open({
                type: 2,
                title: '',
                area: ['350px', '170px'],
                offset: 'auto',
                content: '/toUpdateTraffic?id=' + data.id,
                shade: 0.4
            })
        }
    });
    /**
     * 添加景点
     */
    doAdd = () => {
        location.href = "/toManageAttraction";
    }
});

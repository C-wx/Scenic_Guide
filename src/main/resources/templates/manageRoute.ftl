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

    <!-- CSS -->
    <link href="${base}/css/main.css" rel="stylesheet">

    <script src="${base}/js/manageRoute.js"></script>
</head>

<body>
<div id="main-wrapper" data-layout="vertical" data-navbarbg="skin5" data-sidebartype="full" data-sidebar-position="absolute" data-header-position="absolute" data-boxed-layout="full">
    <header class="topbar">
        <nav class="navbar top-navbar navbar-expand-md navbar-dark">
            <div class="navbar-header">
                <span class="navbar-brand" >
                    <h2 style="letter-spacing: 5px">
                        北墘导览后台
                    </h2>
                    <span style="margin-left: 630px;font-size: 20px"><i class="fa fa-user-circle-o"></i> 管理员 <a href="/logout" class="fa  fa-sign-out"></a></span>
                </span>
            </div>
        </nav>
    </header>
    <aside class="left-sidebar">
        <div class="scroll-sidebar">
            <nav class="sidebar-nav">
                <ul id="sidebarnav">
                    <li class="sidebar-item"> <a class="sidebar-link sidebar-link" href="/toAttraction"><i class="fa fa-globe"></i><span class="hide-menu">景点管理</span></a></li>
                    <li class="sidebar-item"> <a class="sidebar-link sidebar-link active" href="/toRoute"><i class="fa fa-location-arrow"></i><span class="hide-menu">路线管理</span></a></li>
                    <li class="sidebar-item"> <a class="sidebar-link sidebar-link" href="/toTraffic"><i class="fa fa-line-chart"></i><span class="hide-menu">人流管理</span></a></li>
                </ul>

            </nav>
        </div>
    </aside>
    <div class="page-wrapper">
        <div class="layui-fluid" style="padding: 50px;">
            <div class="layui-row layui-form">
                <div class="layui-card">
                    <div class="layui-card-body" style="padding-top: 25px;">
                        <form enctype="multipart/form-data" method="post" class="layui-form">
                            <input type="hidden" name="id" value=<#if navigation??>"${navigation.id}"</#if>>
                            <input type="hidden" name="location" id="location">
                            <input type="hidden" name="imglocation" id="imglocation">
                            <div class="layui-form-item row">
                                <div class="layui-col-md2">
                                    <label>起点：</label>
                                </div>
                                <div class="layui-col-md4" style="width: 300px">
                                    <select name="startid" lay-verify="required">
                                        <option value="">请选择</option>
                                        <#list attractionList as attraction>
                                            <option value="${attraction.id}" <#if navigation??&&navigation.startid == attraction.id>selected</#if>>${attraction.title}</option>
                                        </#list>
                                    </select>
                                </div>
                            </div>
                            <div class="layui-form-item row">
                                <div class="layui-col-md2">
                                    <label>终点：</label>
                                </div>
                                <div class="layui-col-md8" style="width: 300px">
                                    <select name="endid" lay-verify="required">
                                        <option value="">请选择</option>
                                        <#list attractionList as attraction>
                                            <option value="${attraction.id}" <#if navigation??&&navigation.endid == attraction.id>selected</#if>>${attraction.title}</option>
                                        </#list>
                                    </select>
                                </div>
                            </div>
                            <div class="layui-form-item row">
                                <div class="layui-col-md2">
                                    <label>路线描述：</label>
                                </div>
                                <div class="layui-col-md8" style="width: 500px">
                                    <input type="text" name="route" autocomplete="off" class="layui-input" value=<#if navigation??>"${navigation.route!}"</#if>>
                                </div>
                            </div>
                            <div class="layui-form-item row">
                                <div class="layui-col-md2">
                                    <label>路线图片：</label>
                                </div>
                                <div class="layui-col-md8">
                                <#if navigation?? && navigation.img??>
                                    <div id ="d_0" style="float:left;margin-left:20px;" class="imageHover">
                                        <input id="file_0" type="file" name="files" style="display:none;" onChange="replace_image(0)"/>
                                        <img id="image_0"  onclick="click_image(0)" style="cursor:pointer;" src="${navigation.img}" height="500px" width="400px"/>
                                    </div>
                                <#else >
                                    <div id ="d_0" style="float:left;margin-left:20px;" class="imageHover">
                                        <input id="file_0" type="file" name="files" style="display:none;" onChange="replace_image(0)"/>
                                        <img id="image_0" onclick="click_image(0)" style="cursor:pointer;" src="/images/upload_hover.jpg" height="500px" width="400px"/>
                                    </div>
                                </#if>
                                </div>
                            </div>
                            <div class="layui-form-item" style="text-align: center">
                                <button class="layui-btn" lay-submit="" lay-filter="submit" type="button">提交</button>
                                <a href="/toRoute" class="layui-btn layui-btn-warm">返回</a>
                            </div>
                        </form>
                    </div>
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
</body>
</html>
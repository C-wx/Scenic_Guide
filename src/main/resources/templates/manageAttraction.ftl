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

    <script src="${base}/js/manageAttraction.js"></script>
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
                </span>
            </div>
        </nav>
    </header>
    <aside class="left-sidebar">
        <div class="scroll-sidebar">
            <nav class="sidebar-nav">
                <ul id="sidebarnav">
                    <li class="sidebar-item"> <a class="sidebar-link sidebar-link active" href="/toAttraction"><i class="fa fa-globe"></i><span class="hide-menu">景点管理</span></a></li>
                    <li class="sidebar-item"> <a class="sidebar-link sidebar-link" href="/toRoute"><i class="fa fa-location-arrow"></i><span class="hide-menu">路线管理</span></a></li>
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
                            <input type="hidden" name="id" value=<#if attraction??>"${attraction.id}"</#if>>
                            <input type="hidden" name="location" id="location">
                            <input type="hidden" name="imglocation" id="imglocation">
                            <div class="layui-form-item row">
                                <div class="layui-col-md2">
                                    <label>景点名称：</label>
                                </div>
                                <div class="layui-col-md4" style="width: 300px">
                                    <input type="text" name="title" autocomplete="off" class="layui-input" value=<#if attraction??>"${attraction.title!}"</#if>>
                                </div>
                            </div>
                            <div class="layui-form-item row">
                                <div class="layui-col-md2">
                                    <label>景点简介：</label>
                                </div>
                                <div class="layui-col-md8" style="width: 300px">
                                    <textarea name="brief" rol="4" class="layui-textarea"><#if attraction??>${attraction.brief!}</#if></textarea>
                                </div>
                            </div>
                            <div class="layui-form-item row">
                                <div class="layui-col-md2">
                                    <label>景点图片：</label>
                                </div>
                                <div class="layui-col-md8">
                                <#if attraction?? && attraction.imageList?? && (attraction.imageList?size > 0) >
                                    <#list attraction.imageList as image>
                                        <div id ="d_${image_index}" style="float:left;margin-left:20px;" class="imageHover">
                                            <input id="file_${image_index}" type="file" name="files" style="display:none;" onChange="replace_image(${image_index})"/>
                                            <img id="image_${image_index}"  onclick="click_image(${image_index})" style="cursor:pointer;" src="${image.url}" height="200px" width="300px"/>
                                            <i class="fa fa-remove" style="display: none;font-size: 20px;cursor: pointer" onclick="delImage(${image.id})"></i>
                                        </div>
                                    </#list>
                                    <#if attraction.imageList?size < 3>
                                            <div id ="d_2" style="float:left;margin-left:20px;" class="imageHover">
                                                <input id="file_2" type="file" name="files" style="display:none;" onChange="replace_image(2)"/>
                                                <img id="image_2" onclick="click_image(2)" style="cursor:pointer;" src="/images/upload_hover.jpg" height="200px" width="300px"/>
                                            </div>
                                    </#if>
                                <#else >
                                    <div id ="d_0" style="float:left;margin-left:20px;" class="imageHover">
                                        <input id="file_0" type="file" name="files" style="display:none;" onChange="replace_image(0)"/>
                                        <img id="image_0" onclick="click_image(0)" style="cursor:pointer;" src="/images/upload_hover.jpg" height="200px" width="300px"/>
                                    </div>
                                </#if>
                                </div>
                            </div>
                            <div class="layui-form-item layui-row">
                                <div class="layui-col-md2">
                                    <label>显示框定位：</label>
                                </div>
                                <div class="layui-col-md4" style="width: 300px">
                                   top： <input type="text" placeholder="rpx" style="width: 100px" name="name" autocomplete="off" class="layui-input layui-show-sm-inline-block" id="frameTop" value=<#if attraction??>"${attraction.frameTop!}"</#if>>
                                   &nbsp;&nbsp;&nbsp;left：<input type="text" placeholder="rpx" style="width: 100px" name="name" autocomplete="off" class="layui-input layui-show-sm-inline-block" id="frameLeft" value=<#if attraction??>"${attraction.frameLeft!}"</#if>>
                                </div>
                            </div>
                            <div class="layui-form-item row">
                                <div class="layui-col-md2">
                                    <label>显示点定位：</label>
                                </div>
                                <div class="layui-col-md4" style="width: 300px">
                                    top： <input type="text" placeholder="rpx" style="width: 100px" name="name" autocomplete="off" class="layui-input layui-show-sm-inline-block" id="pointTop" value=<#if attraction??>"${attraction.pointTop!}"</#if>>
                                    &nbsp;&nbsp;&nbsp;left：<input type="text" placeholder="rpx" style="width: 100px" name="name" autocomplete="off" class="layui-input layui-show-sm-inline-block" id="pointLeft" value=<#if attraction??>"${attraction.pointLeft!}"</#if>>
                                </div>
                            </div>
                            <div class="layui-form-item row">
                                <div class="layui-col-md2">
                                    <label>景点介绍：</label>
                                </div>
                                <div class="layui-col-md8" style="width: 500px">
                                    <textarea name="detail" rol="4" class="layui-textarea"><#if attraction??>${attraction.detail!}</#if></textarea>
                                </div>
                            </div>
                            <div class="layui-form-item" style="text-align: center">
                                <button class="layui-btn" lay-submit="" lay-filter="submit" type="button">提交</button>
                                <a href="/toAttraction" class="layui-btn layui-btn-warm">返回</a>
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
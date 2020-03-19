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

    <script src="${base}/js/traffic.js"></script>
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
                    <li class="sidebar-item"> <a class="sidebar-link sidebar-link" href="/toAttraction"><i class="fa fa-globe"></i><span class="hide-menu">景点管理</span></a></li>
                    <li class="sidebar-item"> <a class="sidebar-link sidebar-link" href="/toRoute"><i class="fa fa-location-arrow"></i><span class="hide-menu">路线管理</span></a></li>
                    <li class="sidebar-item"> <a class="sidebar-link sidebar-link active" href="/toTraffic"><i class="fa fa-line-chart"></i><span class="hide-menu">人流管理</span></a></li>
                </ul>

            </nav>
        </div>
    </aside>
    <div class="page-wrapper">
        <div class="layui-fluid" style="padding: 50px;">
            <div class="layui-row layui-form">
                <div class="layui-card">
                    <div class="layui-card-body" style="padding-top: 25px;">
                        <table id="showTable" lay-filter="showTable"></table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
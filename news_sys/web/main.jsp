<%@ page import="cn.edu.lingnan.dao.AdminDaoImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 layui.css -->
    <link href="./layui/css/layui.css" rel="stylesheet">
    <!-- 引入 layui.js -->
    <script src="./layui/layui.js"></script>
    <link rel="shortcut icon" href="img/寿司.ico">
    <title>后台管理界面</title>
</head>
<style>
    * {
        box-sizing: border-box;
    }

    body {
        margin: 0;
    }

    #nav {
        float: left;
        width: 14%;
        height: 100%;
    }

    /*表格*/
    #message {
        float: left;
        margin: 2px 0 0 1px;
        width: 85%;
        height: 100%;
    }

    #banner1 {
        background: url("img/1.jfif") no-repeat;
        background-size: 100% 100%;
    }

    #banner2 {
        background: url("img/2.jfif") no-repeat;
        background-size: 100% 100%;
    }

    #banner3 {
        background: url("img/3.jfif") no-repeat;
        background-size: 100% 100%;
    }

    #banner4 {
        background: url("img/4.jfif") no-repeat;
        background-size: 100% 100%;
    }

    #banner5 {
        background: url("img/4.jpg") no-repeat;
        background-size: 100% 100%;
    }

</style>
<body>

<ul class="layui-nav" style="padding-left: 14%;">
    <li class="layui-nav-item layui-this"><a href="index.jsp">首页</a></li>
    <li class="layui-nav-item">
        <a href="/allAdmin.admin">管理员管理</a>
    </li>
    <li class="layui-nav-item">
        <a href="/allUsers.user">用户管理</a>
    </li>

    <li class="layui-nav-item">
        <a href="#">新闻管理</a>
        <dl class="layui-nav-child">
            <dd><a href="/allNewsType.newsType">新闻种类管理</a></dd>
            <dd><a href="/allNewsInfo.newsInfo">新闻信息管理</a></dd>
            <dd><a href="/allNewsComment.newsComment">新闻评论管理</a></dd>
        </dl>
    </li>
    <li class="layui-nav-item"><a href="/logout">注销</a></li>
    <li class="layui-nav-item" style="float: right;">欢迎您, ${username} 先生/女士！</a></li>
</ul>

<div id="nav">
    <ul class="layui-nav layui-nav-tree layui-inline" lay-filter="demo"
        style="margin-right: 10px; width: 100%; height: 100%;">
        <li class="layui-nav-item layui-nav-itemed">
            <a href="javascript:;">默认展开</a>
            <dl class="layui-nav-child">
                <dd><a href="javascript:;">选项一</a></dd>
                <dd><a href="javascript:;">选项二</a></dd>
                <dd><a href="javascript:;">选项三</a></dd>
                <dd><a href="">跳转项</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item">
            <a href="javascript:;">解决方案</a>
            <dl class="layui-nav-child">
                <dd><a href="">移动模块</a></dd>
                <dd><a href="">后台模版</a></dd>
                <dd><a href="">电商平台</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item"><a href="">云市场</a></li>
        <li class="layui-nav-item"><a href="">社区</a></li>
    </ul>
</div>
<div id="message">
    <div class="layui-carousel" id="test1">
        <div carousel-item>
            <div id="banner1"></div>
            <div id="banner2"></div>
            <div id="banner3"></div>
            <div id="banner4"></div>
            <div id="banner5"></div>
        </div>
    </div>

    <script>
        layui.use('carousel', function () {
            var carousel = layui.carousel;
            //建造实例
            carousel.render({
                elem: '#test1'
                , width: '100%' //设置容器宽度
                , height: '100%'//设置容器高度
                , arrow: 'always' //始终显示箭头
                //,anim: 'updown' //切换动画方式
            });
        });
    </script>
</div>

</body>
</html>

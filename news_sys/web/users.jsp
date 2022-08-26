<%@ page import="cn.edu.lingnan.pojo.Admin" %>
<%@ page import="cn.edu.lingnan.pojo.newsType" %>
<%@ page import="java.util.Vector" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="cn.edu.lingnan.dao.NewsTypeDaoImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <link rel="shortcut icon" href="img/favicon.ico">
    <!-- 引入 layui.css -->
    <link href="./layui/css/layui.css" rel="stylesheet">
    <!-- 引入 layui.js -->
    <script src="./layui/layui.js"></script>
    <title>夏威夷果新闻</title>
    <style>
        * {
            box-sizing: border-box;
        }

        body {
            font-family: Arial;
            padding: 10px;
            color: #f1f1f1;
            background: url("img/bg.jfif") no-repeat;
            background-size: 100% 100%;
        }

        #main {
            color: #000;
        }

        /* 头部标题 */
        .header {
            padding: 30px;
            text-align: center;
            /*透明背景*/
            background-color: transparent;
        }

        .header h1 {
            font-size: 50px;
        }

        /* 导航条 */
        .topnav {
            position: sticky;
            top: 0px;
            index: 0;
            /*overflow: hidden;*/
            background-color: #333;
        }

        /* 创建两列 */
        /* Left column */
        .leftcolumn {
            float: left;
            width: 75%;
        }

        /* 右侧栏 */
        .rightcolumn {
            float: left;
            width: 25%;
            height: auto;
            background-color: #f1f1f1;
            padding-left: 20px;
            margin-top: 10px;
        }

        /* 文章卡片效果 */
        .card {
            background-color: #f1f1f1;
            padding: 20px;
            margin-top: 10px;
            margin-right: 10px;
        }

        /* 图像部分 */
        .fakeimg {
            background-color: #aaa;
            padding: 20px;
        }

        /* 列后面清除浮动 */
        .row:after {
            content: "";
            display: table;
            clear: both;
        }

        /* 底部 */
        .footer {
            padding: 20px;
            text-align: center;
            margin-top: 20px;
        }

        /* 响应式布局 - 屏幕尺寸小于 800px 时，两列布局改为上下布局 */
        @media screen and (max-width: 800px) {
            .leftcolumn, .rightcolumn {
                width: 100%;
                padding: 0;
            }
        }

        /* 响应式布局 -屏幕尺寸小于 400px 时，导航等布局改为上下布局 */
        @media screen and (max-width: 400px) {
            .topnav a {
                float: none;
                width: 100%;
            }
        }
    </style>
</head>
<body>
<div class="header">
    <h1>夏威夷果新闻</h1>
</div>

<div id="main">
    <div class="topnav">
        <ul class="layui-nav" lay-filter="">
            <%
                Vector<newsType> allNewsType = (Vector<newsType>) new NewsTypeDaoImpl().selectAllNewsType();
                Iterator<newsType> iterator = allNewsType.iterator();
                newsType newsType = new newsType();
                while (iterator.hasNext()) {
                    newsType = iterator.next();
            %>
            <li class="layui-nav-item"><a href="#"><%=newsType.getTypeName()%></a></li>
            <%
                }
            %>

            <li class="layui-nav-item" style="float: right;">
                <a href=""><img src="img/蜡笔小新.jpg" class="layui-nav-img">我</a>
                <dl class="layui-nav-child">
                    <dd><a href="/UsersShowDetail.jsp?id=${userId}">个人中心</a></dd>
                    <dd><a href="/logout">注销</a></dd>
                </dl>
            </li>
        </ul>
    </div>

    <div class="row" style="margin-top:20px ">
        <div class="leftcolumn">
            <div class="card">
                <h2>文章标题</h2>
                <h5>2019 年 4 月 17日</h5>
                <div class="fakeimg" style="height:200px;"></div>
                <p>一些文本...</p>
                <p>菜鸟教程 - 学的不仅是技术，更是梦想！菜鸟教程 - 学的不仅是技术，更是梦想！菜鸟教程 - 学的不仅是技术，更是梦想！菜鸟教程 - 学的不仅是技术，更是梦想！</p>
            </div>
            <div class="card">
                <h2>文章标题</h2>
                <h5>2019 年 4 月 17日</h5>
                <div class="fakeimg" style="height:200px;">图片</div>
                <p>一些文本...</p>
                <p>菜鸟教程 - 学的不仅是技术，更是梦想！菜鸟教程 - 学的不仅是技术，更是梦想！菜鸟教程 - 学的不仅是技术，更是梦想！菜鸟教程 - 学的不仅是技术，更是梦想！</p>
            </div>
            <div class="card">
                <div class="fakeimg" style="float: left;height:200px;width:200px;">图片</div>
                <div style="margin-left: 220px;height: 200px;background-color: #aaa">
                    <div style="padding: 40px;">
                        <h2>文章标题</h2>
                        <h5>2019 年 4 月 17日</h5>
                        <p>一些文本...</p>
                        <p>菜鸟教程 - 学的不仅是技术，更是梦想！菜鸟教程 - 学的不仅是技术，更是梦想！菜鸟教程 - 学的不仅是技术，更是梦想！菜鸟教程 - 学的不仅是技术，更是梦想！</p>
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="fakeimg" style="float: left;height:200px;width:200px;">图片</div>
                <div style="margin-left: 220px;height: 200px;background-color: #aaa">
                    <div style="padding: 40px;">
                        <h2>文章标题</h2>
                        <h5>2019 年 4 月 17日</h5>
                        <p>一些文本...</p>
                        <p>菜鸟教程 - 学的不仅是技术，更是梦想！菜鸟教程 - 学的不仅是技术，更是梦想！菜鸟教程 - 学的不仅是技术，更是梦想！菜鸟教程 - 学的不仅是技术，更是梦想！</p>
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="fakeimg" style="float: left;height:200px;width:200px;">图片</div>
                <div style="margin-left: 220px;height: 200px;background-color: #aaa">
                    <div style="padding: 40px;">
                        <h2>文章标题</h2>
                        <h5>2019 年 4 月 17日</h5>
                        <p>一些文本...</p>
                        <p>菜鸟教程 - 学的不仅是技术，更是梦想！菜鸟教程 - 学的不仅是技术，更是梦想！菜鸟教程 - 学的不仅是技术，更是梦想！菜鸟教程 - 学的不仅是技术，更是梦想！</p>
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="fakeimg" style="float: left;height:200px;width:200px;">图片</div>
                <div style="margin-left: 220px;height: 200px;background-color: #aaa">
                    <div style="padding: 40px;">
                        <h2>文章标题</h2>
                        <h5>2019 年 4 月 17日</h5>
                        <p>一些文本...</p>
                        <p>菜鸟教程 - 学的不仅是技术，更是梦想！菜鸟教程 - 学的不仅是技术，更是梦想！菜鸟教程 - 学的不仅是技术，更是梦想！菜鸟教程 - 学的不仅是技术，更是梦想！</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="rightcolumn">
            <div class="card">
                <h3>热门文章</h3>
                <div class="fakeimg"><p>图片</p></div>
                <div class="fakeimg"><p>图片</p></div>
                <div class="fakeimg"><p>图片</p></div>
            </div>
            <div class="card">
                <h3>热门文章</h3>
                <div class="fakeimg"><p>图片</p></div>
                <div class="fakeimg"><p>图片</p></div>
                <div class="fakeimg"><p>图片</p></div>
            </div>
            <div class="card">
                <h3>热门文章</h3>
                <div class="fakeimg"><p>图片</p></div>
                <div class="fakeimg"><p>图片</p></div>
                <div class="fakeimg"><p>图片</p></div>
            </div>
            <div class="card">
                <h3>关注我</h3>
                <p>一些文本...</p>
            </div>
        </div>
    </div>
</div>


<ul class="layui-nav" lay-filter="">
    <div class="footer">
        <h2>底部区域</h2>
    </div>
</ul>
</body>
</html>

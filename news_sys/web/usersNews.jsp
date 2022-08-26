<%@ page import="cn.edu.lingnan.pojo.newsType" %>
<%@ page import="java.util.Vector" %>
<%@ page import="cn.edu.lingnan.dao.NewsTypeDaoImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="cn.edu.lingnan.pojo.newInfo" %>
<%@ page import="cn.edu.lingnan.pojo.newsComment" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="cn.edu.lingnan.pojo.Users" %>
<%@ page import="cn.edu.lingnan.dao.UsersDaoImpl" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
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
            /*justify-content: center;*/
            float: left;
            width: 75%;
            /*background-color: #b2b2b2;*/
        }

        /* 右侧栏 */
        .rightcolumn {
            float: right;
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
            height: 200px;
            width: 100%;
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

        .box-textarea {
            height: 100px;
            width: 85%;
        }

        .box-right {
            background-color: #a6eae5;
            height: 35px;
            width: 60px;
            float: right;
            margin-top: 60px;
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
                Vector<newsType> allnewsTypes = (Vector<newsType>) new NewsTypeDaoImpl().selectAllNewsType();
                Iterator<newsType> iterator = allnewsTypes.iterator();
                newsType newstype = new newsType();
                while (iterator.hasNext()) {
                    newstype = iterator.next();
            %>
            <li class="layui-nav-item"><a
                    href="/allTitle?action=selectType&typeId=<%=newstype.getTypeId()%>"><%=newstype.getTypeName()%>
            </a></li>
            <%
                }
            %>
            <li class="layui-nav-item">
                <a href=""><img src="img/蜡笔小新.jpg" class="layui-nav-img">我</a>
                <dl class="layui-nav-child">
                    <dd><a href="/UsersEdit.jsp?id=${userId}">修改信息</a></dd>
                    <dd><a href="/logout">注销</a></dd>
                </dl>
            </li>
        </ul>
    </div>

    <div class="row" style="margin-top:20px ">
        <div class="leftcolumn">
            <%
                Vector<newInfo> allNewInfo = (Vector<newInfo>) request.getAttribute("allNewInfo");
                newInfo newinfo = new newInfo();
                Iterator<newInfo> iterator1 = allNewInfo.iterator();
                while (iterator1.hasNext()) {
                    newinfo = iterator1.next();
            %>

            <div class="card">
                <h2 style="text-align:center;"><%= newinfo.getNewsTitle()%>
                </h2>
                <h5 style="text-align:left;">发表日期：<%= newinfo.getNewsPublish()%>
                </h5>
                <h5 style="text-align:left;">新闻来源：<%=newinfo.getNewsSource()%>
                </h5>
                <p><%=newinfo.getNewsContent()%>
                </p>
            </div>
            <%
                }
            %>
            <div class="card">
                <h1 style="text-align: center">评论</h1>
                <%
                    LocalDate date = LocalDate.now(); // get the current date
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                %>
                <form action="/addNewsCommentTwo.newsComment" method="post">
                    <input type="hidden" name="newsId1" value="<%= newinfo.getNewsId()%>">
                    <input type="hidden" name="userId1" value="<%= session.getAttribute("id")%>">
                    <input type="text" class="box-textarea" name="Comment1" placeholder="说两句吧...">
                    <input type="hidden" name="createDate1" value="<%=date.format(formatter)%>">
                    <button type="submit" class="box-right" value="发表">发表</button>
                </form>
            </div>

            <%
                Vector<newsComment> allComment = (Vector<newsComment>) request.getAttribute("AllComment");
                newsComment newscomment = new newsComment();
                Users users1 = new Users();
                Iterator<newsComment> iterator2 = allComment.iterator();
                while (iterator2.hasNext()) {
                    newscomment = iterator2.next();
                    Vector<Users> users = (Vector<Users>) new UsersDaoImpl().selectUsersById(newscomment.getUserId());
//                    users = new UsersDaoImpl().selectUsersById(newscomment.getNewsId());
                    Iterator<Users> iterator4 = users.iterator();
                    if (iterator4.hasNext()) {
                        users1 = iterator4.next();
            %>
            <div class="card">
                <h3>用户：<%=users1.getUsername()%>
                </h3>
                <br/>
                <p><%=newscomment.getCommContent()%>
                </p>
                <h6 style="text-align: right"><%=newscomment.getCreateDate()%>
                </h6>
            </div>
            <%
                    }
                }
            %>
        </div>
    </div>


    <ul class="layui-nav" lay-filter="">
        <div class="footer">
            <h2>底部区域</h2>
        </div>
    </ul>
</div>

</body>
</html>

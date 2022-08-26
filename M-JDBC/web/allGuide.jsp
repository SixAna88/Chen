<%@ page import="java.util.Vector" %>
<%@ page import="cn.edu.lingnan.pojo.Guide" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>导游信息</title>
    <link rel="stylesheet" type="text/css" href="style.css"/>
    <script type="text/javascript" src="/js/allGuide.js"></script>
    <script type="text/javascript" src="/js/register.js"></script>
    <style>

        body{
            background-color: #333;
        }

        h1 {
            padding:20px 0;
            text-align: center;
            color: #fff;
        }

        a{
            text-decoration: none;
            color: #fff040;
        }

        form {
            background-color: #619cff;
            /*border: 1px solid #000;*/
            color: #fff;
            border-collapse: collapse;
            margin: 0 auto;
            width: 170px;
            text-align: left;
            padding: 20px 40px;
        }

        /* 弹窗 (background) */
        .modal {
            display: none; /* 默认隐藏 */
            position: fixed; /* 固定定位 */
            z-index: 1; /* 设置在顶层 */
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgb(0,0,0);
            background-color: rgba(0,0,0,0.4);
        }
        .modal1 {
            display: none; /* 默认隐藏 */
            position: fixed; /* 固定定位 */
            z-index: 1; /* 设置在顶层 */
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgb(0,0,0);
            background-color: rgba(0,0,0,0.4);
        }

        /* 弹窗内容 */
        .modal-content {
            background-color: #fefefe;
            margin: 10% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 50%;
        }

        .modal-content1 {
            background-color: #fefefe;
            margin: 10% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 20%;
        }


        /* 关闭按钮 */
        .close {
              color: #aaa;
              float: right;
              font-size: 28px;
              font-weight: bold;
          }

        .close1 {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }

        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }

        .close1:hover,
        .close1:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }
    </style>
</head>
<body>
<h1 align="center">导游信息管理页面</h1><br>
<a href="/destroyGuide">注销</a>&nbsp;&nbsp;
<a href="main.jsp" style="color: #fff;">主页</a>&nbsp;&nbsp;
<%--<a href="insertGuide.jsp">新增操作</a>--%>

<!-- 打开弹窗按钮 -->
<button id="myBtn">添加导游信息</button>

<!-- 弹窗 -->
<div id="myModal" class="modal">

    <!-- 弹窗内容 -->
    <div class="modal-content">
        <span class="close">&times;</span>
        <h1 style="color: #000">添加导游信息</h1>
        <hr>
        <br><br>
        <form action="insertGuide" name="form">
            用户编号：<input style="margin-bottom: 10px" type="text" name="gid"/><br>
            用户姓名：<input style="margin-bottom: 10px" type="text" name="gname"/><br>
            用户密码：<input style="margin-bottom: 10px" type="password" name="password"/><br>
            密码确认：<input style="margin-bottom: 10px" type="password" name="password1"/><br>
            用户权限：<br>
            <select style="width: auto;margin-bottom: 10px;height:28px;" name="superuser">
                <option selected="0" value="1">普通用户</option>
                <option value="1">超级管理员</option>
            </select><br>
            备注信息：<br>
            <select name="flag" style="margin-bottom: 10px;height: 28px;">
                <option selected="1" value="1">正常用户</option>
                <option value="2">历史用户</option>
            </select><br>
            <input type="submit" value="确定" onclick="return check();"/>
        </form>
    </div>
</div>

<!-- 打开弹窗按钮 -->
<button id="myBtn1">查询导游</button>

<!-- 弹窗 -->
<div id="myModal1" class="modal1">

    <!-- 弹窗内容 -->
    <div class="modal-content1">
        <span class="close1">&times;</span>
        <h1 style="color: #000">查询导游信息</h1>
        <hr>
        <br><br>
        <form action="/search">
            <input  style="height:33px;" type="text" name="name" placeholder='请输入导游关键词'/><br><br>
            <input type="submit" value="确定"/>
        </form>
    </div>
</div>

<hr>
<br><br>
<table>
    <tr>
        <td><input type="checkbox" onclick="allCheck(this);">一键全选</td>
        <td>导游编号</td>
        <td>导游姓名</td>
        <td>导游密码</td>
        <td>导游权限</td>
        <td>备注信息</td>
        <td>操作&nbsp;&nbsp;<input type="button" value="批量删除" onclick="deleteAll();"></td>
    </tr>

    <%
        Vector<Guide> allGuide = (Vector<Guide>) session.getAttribute("allGuide");
        Iterator<Guide> iterator = allGuide.iterator();
        Guide guide = new Guide();
        while (iterator.hasNext()) {
            guide = iterator.next();
    %>
    <tr>
        <td><input type="checkbox" name="check" value="<%= guide.getGuideId()%>"/></td>
        <td><%= guide.getGuideId()%></td>
        <td><%= guide.getGuideName()%></td>
        <td><%= guide.getPassword()%></td>
        <td><%= guide.getSuperuser()%></td>
        <td><%= guide.getFlag()%></td>
        <td>
            <a href="updateGuide.jsp?gid=<%= guide.getGuideId()%>"  style="color: rgba(16,74,255,0.48)">修改</a> |
            <a href="deleteGuide?gid=<%= guide.getGuideId()%>" style="color: #ffa94f" onClick="deleteGuide()">删除</a>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
<script>
    // 获取弹窗
    var modal = document.getElementById('myModal');
    var modal1 = document.getElementById('myModal1');

    // 打开弹窗的按钮对象
    var btn = document.getElementById("myBtn");
    var btn1 = document.getElementById("myBtn1");

    // 获取 <span> 元素，用于关闭弹窗
    var span = document.querySelector('.close');
    var span1 = document.querySelector('.close1');

    // 点击按钮打开弹窗
    btn.onclick = function() {
        modal.style.display = "block";
    }

    btn1.onclick = function() {
        modal1.style.display = "block";
    }

    // 点击 <span> (x), 关闭弹窗
    span.onclick = function() {
        modal.style.display = "none";
    }

    span1.onclick = function() {
        modal1.style.display = "none";
    }

    // 在用户点击其他地方时，关闭弹窗
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }

    window.onclick = function(event) {
        if (event.target == modal1) {
            modal1.style.display = "none";
        }
    }

</script>
</html>

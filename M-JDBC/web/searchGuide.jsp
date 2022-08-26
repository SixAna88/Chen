<%@ page import="java.util.Vector" %>
<%@ page import="cn.edu.lingnan.pojo.Guide" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
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
    </style>
</head>
<body>
<h1 align="center">导游信息管理页面</h1><br>
<a href="/destroyGuide" style="color: #fff040;">注销</a>&nbsp;&nbsp;
<a href="main.jsp" style="color: #fff;">主页</a>&nbsp;&nbsp;
<a href="allGuide.jsp" style="color: #76b3ff;">返回</a>&nbsp;&nbsp;
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
        Vector<Guide> allGuide = (Vector<Guide>) session.getAttribute("guide");
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

    // 打开弹窗的按钮对象
    var btn = document.getElementById("myBtn");

    // 获取 <span> 元素，用于关闭弹窗
    var span = document.querySelector('.close');

    // 点击按钮打开弹窗
    btn.onclick = function() {
        modal.style.display = "block";
    }

    // 点击 <span> (x), 关闭弹窗
    span.onclick = function() {
        modal.style.display = "none";
    }

    // 在用户点击其他地方时，关闭弹窗
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }

</script>
</html>

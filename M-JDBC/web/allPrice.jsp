<%@ page import="java.util.Vector" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="cn.edu.lingnan.pojo.Price" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>价格信息</title>
    <link rel="stylesheet" type="text/css" href="style.css"/>
    <script type="text/javascript" src="/js/allPrice.js"></script>
    <style>

        body{
            background-color: #333;
        }

        h1 {
            padding-top:40px;
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

        /* 弹窗内容 */
        .modal-content {
            background-color: #fefefe;
            margin: 10% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 24%;
        }

        /* 关闭按钮 */
        .close {
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
    </style>
</head>
<body>
<h1 align="center">价格信息管理页面</h1><br>
<a href="/destroyGuide">注销</a>&nbsp;&nbsp;
<a href="main.jsp" style="color: #fff;">主页</a>&nbsp;&nbsp;
<!-- 打开弹窗按钮 -->
<button id="myBtn">添加价格信息</button>

<!-- 弹窗 -->
<div id="myModal" class="modal">

    <!-- 弹窗内容 -->
    <div class="modal-content">
        <span class="close">&times;</span>
        <h1 style="color: #000">添加价格信息</h1>
        <hr>
        <br><br>
        <form action="insertPrice" name="form">
            导游编号：<input style="margin-bottom: 10px" type="text" name="gid"/><br>
            路线编号：<input style="margin-bottom: 10px" type="text" name="pid"/><br>
            价格信息：<input style="margin-bottom: 10px" type="text" name="price"/><br>
            <input type="submit" value="提交" onclick="return check();"/>
        </form>
    </div>
</div>
<hr>
<br><br>
<table>
    <tr>
        <td>导游编号</td>
        <td>路线编号</td>
        <td>价格</td>
        <td>操作</td>
    </tr>

    <%
        Vector<Price> allPrice = (Vector<Price>) session.getAttribute("allPrice");
        Iterator<Price> iterator = allPrice.iterator();
        Price price = new Price();
        while (iterator.hasNext()) {
            price = iterator.next();
    %>
    <tr>
        <td><%= price.getGuideId()%></td>
        <td><%= price.getPathId()%></td>
        <td><%= price.getPrice()%></td>
        <td>
            <a href="updatePrice.jsp?gid=<%= price.getGuideId()%>&pid=<%= price.getPathId()%>" style="color: rgba(16,74,255,0.48)">修改</a> |
            <a href="deletePrice?gid=<%= price.getGuideId()%>&pid=<%= price.getPathId()%>" style="color: #ffa94f" onClick="deletePrice()">删除</a>
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
    btn.onclick = function () {
        modal.style.display = "block";
    }

    // 点击 <span> (x), 关闭弹窗
    span.onclick = function () {
        modal.style.display = "none";
    }

    // 在用户点击其他地方时，关闭弹窗
    window.onclick = function (event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
</script>
</html>

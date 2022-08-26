<%@ page import="cn.edu.lingnan.pojo.Users" %>
<%@ page import="java.util.Vector" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="cn.edu.lingnan.dao.UsersDaoImpl" %>
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
    <link rel="shortcut icon" href="img/favicon.ico">
    <title>后台管理界面</title>
</head>
<style>
       * {
        box-sizing: border-box;
    }

    body {
        margin: 0;
    }

    /* 头部样式 */
    .header {
        background-color: #89735d;
        padding: 20px;
        text-align: center;
        font-family: "Lucida Calligraphy", cursive, serif, sans-serif;
    }

    .center{
        width: 500px;
        height: auto;
        background-color: rgba(179, 212, 250, 0.96);
        border-radius: 5px;
        position: absolute;
        left:50%;
        top: 55%;
        transform: translate(-50%,-50%);
    }

    .layui-form-label{
        width: 110px;
    }

</style>
<body>

<div class="header">
    <h1 style="color: #f1f1f1">Users</h1>
</div>
<div class="center">
    <%
        Vector<Users> allUsers = new UsersDaoImpl().selectAllUsers();
        Iterator<Users> iterator = allUsers.iterator();
        Users users = new Users();
        while (iterator.hasNext()) {
            users = iterator.next();
            if (users.getUserId() == Integer.parseInt(request.getParameter("id"))) {
    %>
    <form class="layui-form" action="editUsers.users" method="post" style="margin-top: 60px;margin-left: 60px">
        <div class="layui-form-item">
            <label class="layui-form-label">ID</label>
            <div class="layui-input-block">
                <input onfocus=this.blur() style="width: 190px" class="layui-input" type="text" name="userId" value="<%= users.getUserId()%>">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户昵称</label>
            <div class="layui-input-block">
                <input style="width: 190px" class="layui-input" type="text" name="username" value="<%= users.getUsername()%>">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码框</label>
            <div class="layui-input-inline">
                <input class="layui-input" type="text" name="password" value="<%= users.getPassword()%>">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">联系方式</label>
            <div class="layui-input-inline">
                <input class="layui-input" type="text" name="userPhone" value="<%= users.getUserPhone()%>">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">年龄</label>
            <div class="layui-input-inline">
                <input class="layui-input" type="text" name="userAge" value="<%= users.getUserAge()%>">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">出生日期</label>
            <div class="layui-input-inline">
                <input class="layui-input" type="date" name="birth" required lay-verify="required"
                       placeholder="请输入出生日期" value="<%= users.getBirth()%>">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">备注信息</label>
            <div class="layui-input-block">
                <textarea  style="width: 200px;height: 50px;" name="remark" value="<%= users.getRemark()%>"><%= users.getRemark()%></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn">保存</button>
                <a class="layui-btn" href="/UsersShowDetail.users?id=<%= users.getUserId()%>">取消</a>
            </div>
        </div>
    </form>
    <%
            }
        }
    %>
</div>
<script>
    function show() {
        alert("修改成功！")
    }
</script>
</body>
</html>

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
    <link rel="shortcut icon" href="img/寿司.ico">
    <title>管理员管理界面</title>
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
        background-color: rgb(0, 0, 0);
        background-color: rgba(0, 0, 0, 0.4);
    }

    /* 弹窗内容 */
    .modal-content {
        background-color: #fefefe;
        margin: 15% auto;
        padding: 20px;
        border: 1px solid #888;
        width: 26%;
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

    .layui-form-select dl {
        min-width: 20%;
    }

</style>
<body>

<ul class="layui-nav" style="padding-left: 14%;">
    <li class="layui-nav-item layui-this"><a href="index.jsp">首页</a></li>
    <li class="layui-nav-item">
        <a href="/allAdmin.admin">管理员管理</a>
    </li>
    <li class="layui-nav-item">
        <a href="/allUsers.users">用户管理</a>
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
    <fieldset class="table-search-fieldset">
        <form class="layui-form layui-form-pane" action="/queryUsers.users">
            <div class="layui-inline">
                <label class="layui-form-label">ID</label>
                <div class="layui-input-inline">
                    <input type="text" name="userId" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">姓名</label>
                <div class="layui-input-inline">
                    <input type="text" name="username" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <button type="submit" class="layui-btn layui-btn-normal">查询</button>
                <button type="button" class="layui-btn" id="myBtn">增加</button>
            </div>
        </form>
    </fieldset>

    <!-- 弹窗 -->
    <div id="myModal" class="modal">
        <!-- 弹窗内容 -->
        <div class="modal-content">
            <span class="close">&times;</span>
            <form class="layui-form" action="/addUsers.users" method="post">
                <div class="layui-form-item">
                    <label class="layui-form-label">姓名</label>
                    <div class="layui-input-block">
                        <input style="width: 200px" type="text" name="username" required lay-verify="required"
                               placeholder="请输入姓名"
                               autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">密码</label>
                    <div class="layui-input-block">
                        <input style="width: 200px" type="password" name="password" required lay-verify="required"
                               placeholder="请输入密码"
                               autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">联系方式</label>
                    <div class="layui-input-block">
                        <input style="width: 200px" type="text" name="userPhone" required lay-verify="required"
                               placeholder="请输入密码"
                               autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">年龄</label>
                    <div class="layui-input-block">
                        <input style="width: 200px" type="text" name="userAge" required lay-verify="required"
                               placeholder="请输入密码"
                               autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">出生日期</label>
                    <div class="layui-input-block">
                        <input style="width: 200px" type="date" name="birth" required lay-verify="required"
                               placeholder="请输入创建日期" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button type="submit" class="layui-btn">立即提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
        </div>
    </div>


    <table class="layui-table">
        <thead>
        <tr>
            <th><input type="checkbox" onclick="allCheck(this);">一键全选</th>
            <th>用户编号</th>
            <th>姓名</th>
            <th>密码</th>
            <th>电话号码</th>
            <th>年龄</th>
            <th>出生日期</th>
            <th>备注信息1</th>
            <th>操作&nbsp;&nbsp;<input class="layui-btn layui-btn-warm" type="button" value="批量删除" onclick="deleteAll();">
            </th>
        </tr>
        </thead>
        <tbody>
        <%
            Vector<Users> allUsers = (Vector<Users>)request.getAttribute("users");
            Iterator<Users> iterator = allUsers.iterator();
            Users users = new Users();
            while (iterator.hasNext()) {
                users = iterator.next();
        %>
        <tr>
            <td><input type="checkbox" name="check" value="<%= users.getUserId()%>"/></td>
            <td><%= users.getUserId()%>
            </td>
            <td><%= users.getUsername()%>
            </td>
            <td><%= users.getPassword()%>
            </td>
            <td><%= users.getUserPhone()%>
            </td>
            <td><%= users.getUserAge()%>
            </td>
            <td><%= users.getBirth()%>
            </td>
            <td><div style="width: 200px;overflow: hidden;white-space: nowrap;text-overflow: ellipsis"><%= users.getRemark()%></div>
            </td>
            <td>
                <a href="updateUsers.jsp?id=<%= users.getUserId()%>" class="layui-btn layui-btn-sm">修改</a>
                <a href="/deleteUsers.users?id=<%= users.getUserId()%>" class="layui-btn layui-btn-sm layui-btn-danger" onClick="deleteUsers()">删除</a>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>

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

    function allCheck(checkbox) {
        var oCheck = document.getElementsByName("check");
        if (checkbox.checked) {
            for (var i = 0; i < oCheck.length; i++) {
                oCheck[i].checked = true;
            }
        } else {
            for (var i = 0; i < oCheck.length; i++) {
                oCheck[i].checked = false;
            }
        }
    }

    function deleteAll() {
        var allUsersId = new Array();
        var flag = false;
        var oCheck = document.getElementsByName("check");
        for (var i = 0; i < oCheck.length; i++) {
            if (oCheck[i].checked) {
                flag = true;
                allUsersId.push(oCheck[i].value);
            }
        }
        if (flag == true) {
            if (confirm("温馨提示：您是否确定删除这些记录，记录删除后将不可还原！")) {
                location.href = "/deleteUsers.users?flag=all&id=" + allUsersId;
            }
        } else {
            alert("温馨提示：您至少要选择一条记录，才能点击批量删除！")
        }
    }


    function deleteUsers() {
        if (!confirm("确认要删除？")) {
            window.event.returnValue = false;
        }
    }

    //Demo laiui表单
    layui.use('form', function () {
        var form = layui.form;

        //提交
        form.on('submit(formDemo)', function (data) {
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    });

</script>
</body>
</html>

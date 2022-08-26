<%@ page import="cn.edu.lingnan.pojo.Admin" %>
<%@ page import="java.util.Vector" %>
<%@ page import="java.util.Iterator" %>
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
        <form class="layui-form layui-form-pane" action="queryAdmin.admin">
            <div class="layui-inline">
                <label class="layui-form-label">姓名</label>
                <div class="layui-input-inline">
                    <input type="text" name="username" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">身份</label>
                <div class="layui-input-inline">
                    <select name="role" lay-verify="required">
                        <option></option>
                        <option value="0">超级管理员</option>
                        <option value="1">二级管理员</option>
                    </select>
                </div>
            </div>
            <div class="layui-inline">
                <button type="submit" class="layui-btn layui-btn-normal">查询</button>
                <button type="button" class="layui-btn" id="myBtn">新增</button>
            </div>
        </form>

    </fieldset>
    <!-- 弹窗 -->
    <div id="myModal" class="modal">
        <!-- 弹窗内容 -->
        <div class="modal-content">
            <span class="close">&times;</span>
            <form class="layui-form" action="addAdmin.admin" method="post">
                <div class="layui-form-item">
                    <label class="layui-form-label">姓名</label>
                    <div class="layui-input-block">
                        <input style="width: 200px" type="text" name="username" required lay-verify="required"
                               placeholder="请输入姓名" autocomplete="off" class="layui-input">
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
                    <label class="layui-form-label">角色</label>
                    <div class="layui-input-block">
                        <select name="role" required lay-verify="required">
                            <option value=""></option>
                            <option value="0">超级管理员</option>
                            <option value="1">二级管理员</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">创建日期</label>
                    <div class="layui-input-block">
                        <input style="width: 200px" type="date" name="createDate" required lay-verify="required"
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

    <form action="/updateAdmin.admin" method="post">

        <table class="layui-table">
            <thead>
            <tr>
                <th>编号</th>
                <th>姓名</th>
                <th>密码</th>
                <th>角色</th>
                <th>创建日期</th>
                <th>邮箱</th>
                <th>电话号码</th>
                <th>年龄</th>
                <th>备注信息1</th>
                <th>备注信息2</th>
                <th>备注信息3</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <%
                Vector<Admin> allAdmin = new AdminDaoImpl().selectAllAdmin();
                Iterator<Admin> iterator = allAdmin.iterator();
                Admin admin = new Admin();
                while (iterator.hasNext()) {
                    admin = iterator.next();
                    if (admin.getId() == Integer.parseInt(request.getParameter("id"))) {
            %>
            <tr>
                <td><input style="width: 10px" type="hidden" name="id" value="<%= admin.getId()%>"><%= admin.getId()%>
                </td>
                <td><input style="width: 80px" type="text" name="username" value="<%= admin.getUsername()%>">
                </td>
                <td><input style="width: 80px" type="text" name="password" value="<%= admin.getPassword()%>">
                </td>
                <td><input style="width: 80px" type="text" name="role" value="<%= admin.getRole() %>">
                </td>
                <td><input style="width: 130px" type="date" name="createDate" value="<%= admin.getCreateDate()%>">
                </td>
                <td><input style="width: 160px" type="text" name="mail" value="<%= admin.getMail()%>">
                </td>
                <td><input style="width: 100px" type="text" name="phone" value="<%= admin.getPhone()%>">
                </td>
                <td><input style="width: 30px" type="text" name="age" value="<%= admin.getAge()%>">
                </td>
                <td>
                    <textarea style="width: 60px" name="remark1"
                              value="<%= admin.getRemark1()%>"><%= admin.getRemark1()%></textarea>
                </td>
                <td>
                    <textarea style="width: 60px" name="remark2"
                              value="<%= admin.getRemark2()%>"><%= admin.getRemark2()%></textarea>
                </td>
                <td>
                    <textarea style="width: 60px" name="remark3"
                              value="<%= admin.getRemark3()%>"><%= admin.getRemark3()%></textarea>
                </td>
                <td>
                    <input type="submit" class="layui-btn layui-btn-normal" value="确定"></td>
                </td>
            </tr>
            <%
                    }
                }
            %>
            </tbody>
        </table>
    </form>
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
        var allAdminId = new Array();
        var flag = false;
        var oCheck = document.getElementsByName("check");
        for (var i = 0; i < oCheck.length; i++) {
            if (oCheck[i].checked) {
                flag = true;
                allAdminId.push(oCheck[i].value);
            }
        }
        if (flag == true) {
            if (confirm("温馨提示：您是否确定删除这些记录，记录删除后将不可还原！")) {
                location.href = "/deleteAdmin.do?flag=all&id=" + allAdminId;
            }
        } else {
            alert("温馨提示：您至少要选择一条记录，才能点击批量删除！")
        }
    }


    function deleteAdmin() {
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

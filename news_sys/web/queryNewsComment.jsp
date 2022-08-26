<%@ page import="cn.edu.lingnan.pojo.newsComment" %>
<%@ page import="java.util.Vector" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="cn.edu.lingnan.dao.NewsCommentDaoImpl" %>
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
    <title>新闻评论管理界面</title>
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
            <dd><a href="/NewsTypeBean?action=all">新闻种类管理</a></dd>
            <dd><a href="/NewsInfoBean?action=all">新闻信息管理</a></dd>
            <dd><a href="/allComment.newsComment">新闻评论管理</a></dd>
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
    <form class="layui-form layui-form-pane" action="queryNewsComment.newsComment" method="post">
        <div class="layui-inline">
            <label class="layui-form-label">评论内容</label>
            <div class="layui-input-inline">
                <input type="text" name="commContent" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <button type="submit" class="layui-btn layui-btn-normal">查询</button>
            <!-- 打开弹窗按钮 -->
            <button type="button" class="layui-btn" id="myBtn">新增</button>
        </div>
    </form>
    <!-- 弹窗 -->
    <div id="myModal" class="modal">
        <!-- 弹窗内容 -->
        <div class="modal-content">
            <span class="close">&times;</span>
            <form class="layui-form" action="/addNewsComment.newsComment" method="post">
                <div class="layui-form-item">
                    <label class="layui-form-label">新闻编号</label>
                    <div class="layui-input-block">
                        <input style="width: 200px" type="text" name="newsId1" required lay-verify="required"
                               placeholder="请输入新闻编号"
                               autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">用户编号</label>
                    <div class="layui-input-block">
                        <input style="width: 200px" type="text" name="userId1" required lay-verify="required"
                               placeholder="请输入用户编号"
                               autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">评论内容</label>
                    <div class="layui-input-block">
                        <input style="width: 200px" type="text" name="Comment1" required lay-verify="required"
                               placeholder="请输入评论内容"
                               autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">创建日期</label>
                    <div class="layui-input-block">
                        <input style="width: 200px" type="date" name="createDate1" required lay-verify="required"
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
        <tr>
            <th><input type="checkbox" onclick="allCheck(this);"></th>
            <th>评论编号</th>
            <th>新闻编号</th>
            <th>用户编号</th>
            <th>评论内容</th>
            <th>评论时间</th>

            <th>操作&nbsp;&nbsp;<input class="layui-btn layui-btn-warm" type="button" value="批量删除"
                                     onclick="deleteComment();">
            </th>
        </tr>
        <%
            Vector<newsComment> allComment =(Vector<newsComment>)request.getAttribute("queryNewsComment");
            Iterator<newsComment> iterator = allComment.iterator();
            newsComment Comment = new newsComment();
            while (iterator.hasNext()) {
                Comment = iterator.next();
        %>
        <tr>
            <td><input type="checkbox" name="check" value="<%= Comment.getComId()%>"/></td>
            <td><%= Comment.getComId()%>
            </td>
            <td><%= Comment.getNewsId()%>
            </td>
            <td><%= Comment.getUserId()%>
            </td>
            <td><%= Comment.getCommContent()%>
            </td>
            <td><%= Comment.getCreateDate()%>
            </td>
            <td>
                <a href="/updatenewsComment.jsp?comId=<%=Comment.getComId()%>" class="layui-btn layui-btn-sm">修改</a>
                <a href="/deleteNewsComment.newsComment?comId=<%= Comment.getComId()%>"
                   class="layui-btn layui-btn-sm layui-btn-danger"
                   onClick="deleteAdmin()">删除</a>
            </td>
        </tr>
        <%
            }
        %>
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

    function deleteComment() {
        var comId = new Array();
        var flag = false;
        var oCheck = document.getElementsByName("check");
        for (var i = 0; i < oCheck.length; i++) {
            if (oCheck[i].checked) {
                flag = true;
                comId.push(oCheck[i].value);
            }
        }
        if (flag == true) {
            if (confirm("温馨提示：您是否确定删除这些记录，记录删除后将不可还原！")) {
                location.href = "/deleteNewsComment.newsComment?flag=all&comId=" + comId;
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

<%@ page import="cn.edu.lingnan.pojo.Guide" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
    <link rel="stylesheet" type="text/css" href="../css/main.css"/>
</head>
<body>
<div class="header">
    <h1>你好！欢迎访问</h1>
    <p style="color: #708eff">欢迎您, ${username} 先生/女士！</p>
    <a href="/destroyGuide" style="color: yellow; display: inline-block;float: left">注销</a>&nbsp;&nbsp;
</div>

<ul>
    <li><a href="/queryAllGuide">查询所有导游信息</a></li>
    <li><a href="/queryAllPath">查询所有路线信息</a></li>
    <li><a href="/queryAllPrice">查询所有价格信息</a></li>
</ul>
</body>
</html>
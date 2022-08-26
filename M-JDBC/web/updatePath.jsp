<%@ page import="java.util.Vector" %>
<%@ page import="cn.edu.lingnan.pojo.Guide" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="cn.edu.lingnan.pojo.Path" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>路线信息</title>
    <link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
<h1 align="center" style="color: #fff;">路线信息修改页面</h1><br><br>
<a href="/destroyGuide">注销</a>&nbsp;&nbsp;
<a href="main.jsp" style="color: #fff;">主页</a>&nbsp;&nbsp;
<a href="/allPath.jsp" style="color: #76b3ff;">返回</a><hr><br><br>
<form action="/updatePath">
    <table>
        <tr>
            <td>留空</td>
            <td>路线编号</td>
            <td>路线名称</td>
            <td>备注信息</td>
            <td>操作</td>
        </tr>

        <%
            String pid = request.getParameter("pid");
            Vector<Path> allPath = (Vector<Path>)session.getAttribute("allPath");
            Iterator<Path> iterator = allPath.iterator();
            Path path = new Path();
            while(iterator.hasNext()){
                path = iterator.next();
                if(path.getPathId().equals(pid)){
        %>
        <tr>
            <td></td>
            <td> <input type="hidden" name="pid" value="<%= path.getPathId()%>"><%= path.getPathId()%></td>
            <td> <input type="text" name="pname" value="<%= path.getPathName()%>"></td>
            <td> <input type="text" name="flag" value="<%= path.getFlag()%>"></td>
            <td> <input type="submit" value="确定修改"></td>
        </tr>
        <%
                }}
        %>
    </table>
</form>
</body>
</html>
<%@ page import="java.util.Vector" %>
<%@ page import="cn.edu.lingnan.pojo.Guide" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>导游信息</title>
    <link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
<h1 align="center" style="color: #fff;">导游信息修改页面</h1><br><br>
<a href="/destroyGuide">注销</a>&nbsp;&nbsp;
<a href="main.jsp" style="color: #fff;">主页</a>&nbsp;&nbsp;
<a href="/allGuide.jsp" style="color: #76b3ff;">返回</a><hr><br><br>
<form action="/updateGuide">
    <table>
        <tr>
            <td>留空</td>
            <td>导游编号</td>
            <td>导游姓名</td>
            <td>导游密码</td>
            <td>导游权限</td>
            <td>备注信息</td>
            <td>操作</td>
        </tr>

        <%
            String gid = request.getParameter("gid");
            Vector<Guide> allGuide = (Vector<Guide>)session.getAttribute("allGuide");
            Iterator<Guide> iterator = allGuide.iterator();
            Guide guide = new Guide();
            while(iterator.hasNext()){
                guide = iterator.next();
                if(guide.getGuideId().equals(gid)){
        %>
        <tr>
            <td></td>
            <td> <input type="hidden" name="gid" value="<%= guide.getGuideId()%>"><%= guide.getGuideId()%></td>
            <td> <input type="text" name="gname" value="<%= guide.getGuideName()%>"></td>
            <td> <input type="text" name="password" value="<%= guide.getPassword()%>"></td>
            <td> <input type="text" name="superuser" value="<%= guide.getSuperuser()%>"></td>
            <td> <input type="text" name="flag" value="<%= guide.getFlag()%>"></td>
            <td> <input type="submit" value="确定修改"></td>
        </tr>
        <%
                }}
        %>
    </table>
</form>
</body>
</html>
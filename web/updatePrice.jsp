<%@ page import="java.util.Vector" %>
<%@ page import="cn.edu.lingnan.pojo.Guide" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="cn.edu.lingnan.pojo.Price" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>价格信息</title>
    <link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
<h1 align="center" style="color: #fff;">价格信息修改页面</h1><br><br>
<a href="/destroyGuide">注销</a>&nbsp;&nbsp;
<a href="main.jsp" style="color: #fff;">主页</a>&nbsp;&nbsp;
<a href="/allPrice.jsp" style="color: #76b3ff;">返回</a><hr><br><br>
<form action="/updatePrice">
    <table>
        <tr>
            <td>留空</td>
            <td>导游编号</td>
            <td>路线标号</td>
            <td>价格信息</td>
            <td>操作</td>
        </tr>

        <%
            String gid = request.getParameter("gid");
            String pid = request.getParameter("pid");
            Vector<Price> allPrice = (Vector<Price>)session.getAttribute("allPrice");
            Iterator<Price> iterator = allPrice.iterator();
            Price price = new Price();
            while(iterator.hasNext()){
                price = iterator.next();
                if(price.getGuideId().equals(gid)&& price.getPathId().equals(pid)){
        %>
        <tr>
            <td></td>
            <td> <input type="hidden" name="gid" value="<%= price.getGuideId()%>"><%= price.getGuideId()%></td>
            <td> <input type="hidden" name="pid" value="<%= price.getPathId()%>"><%= price.getPathId()%></td>
            <td> <input type="text" name="price" value="<%= price.getPrice()%>"></td>
            <td> <input type="submit" value="确定修改"></td>
        </tr>
        <%
                }}
        %>
    </table>
</form>
</body>
</html>
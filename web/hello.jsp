<%--
  Created by IntelliJ IDEA.
  User: 26345
  Date: 2022/5/13
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--Java代码--%>
<%
    String name = "橙子";
    out.println("Hello");
%>
<%=name%>

<hr>

<%----------------------------------------%>

<%--JSP表达式 ：
作用：用来将程序的输出，输出到客户端--%>
<%= new java.util.Date()%>

<%--jsp脚本片段--%>
<%
    int sum = 0;
    for (int i = 1; i <=100 ; i++) {
        sum+=i;
    }
    out.println("<h1>sum = " + sum + "</h1>" );
%>
<%----------------------------------------%>
<%
    int x = 10;
    out.println(x);
%>
<p>这是一个JSP文档！</p>
<%
    out.println(x);
%>
<%
    for (int i = 0; i < 5 ; i++) {
%>
<h1>Hello World <%=i%></h1>
<%
    }
%>
<%----------------------------------------%>
<%!
    static{
        System.out.println("Loading Servlet");
    }
    private int globalVar = 0;
    public void f1(){
        System.out.println("进入了方法f1...！");
    }
%>


</body>
</html>

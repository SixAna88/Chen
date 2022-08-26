<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--内置对象：存东西--%>
<%
    pageContext.setAttribute("name1","橙子1号");//保存的数据只在一个页面中有效
    request.setAttribute("name2","橙子2号");//保存的数据只在一次请求中有效，请求转发会携带这个数据
    session.setAttribute("name3","橙子3号");//保存的数据只在一次会话中有效，从打开浏览器到关闭
    application.setAttribute("name4","橙子4号");//保存的数据只在服务器中有效，从打开服务器到关闭
%>

<%--脚本片段中的代码，会原封不动的生成.JSP.java
要求：这里面的代码，逆序保存java语法的正确性--%>
<%
    //通过pageContext取出保存的值
    //从底层到高层（作用域）page -> request -> session -> application
    //JVM : 双亲委派机制
    String  name1 = (String) pageContext.findAttribute("name1");
    String  name2 = (String) pageContext.findAttribute("name2");
    String  name3 = (String) pageContext.findAttribute("name3");
    String  name4 = (String) pageContext.findAttribute("name4");
    String  name5 = (String) pageContext.findAttribute("name5");//不存在

%>

<%--使用EL表达式输出 ${ } --%>
<h1>取出的值：</h1>
<h3>${name1}</h3>
<h3>${name2}</h3>
<h3>${name3}</h3>
<h3>${name4}</h3>
<h3>${name5}</h3>
<h3><%=name5%></h3>
</body>
</html>

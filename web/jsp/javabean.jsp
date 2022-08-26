<%@ page import="cn.edu.lingnan.pojo.People" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
//    People people = new People();
//    people.setId();
//    people.setName();
//    people.setAge();
//    people.setAddress();
%>
<jsp:useBean id="people" class="cn.edu.lingnan.pojo.People" scope="page"/>
<jsp:setProperty name="people" property="id" value="4"/>
<jsp:setProperty name="people" property="name" value="田七"/>
<jsp:setProperty name="people" property="age" value="21"/>
<jsp:setProperty name="people" property="address" value="西安"/>

id：<jsp:getProperty name="people" property="id"/><br>
姓名：<jsp:getProperty name="people" property="name"/><br>
年龄：<jsp:getProperty name="people" property="age"/><br>
所在地：<jsp:getProperty name="people" property="address"/><br>
</body>
</html>

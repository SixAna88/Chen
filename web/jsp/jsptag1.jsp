<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>page 1</h1>
<jsp:forward page="jsptag2.jsp">
    <jsp:param name="name" value="zhangsan"></jsp:param>
    <jsp:param name="age" value="26"></jsp:param>
    <jsp:param name="value3" value="value3"></jsp:param>
</jsp:forward>

</body>
</html>

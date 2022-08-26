<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
//    pageContext.setAttribute("hello1","hello1",PageContext.SESSION_SCOPE);
//    //等价于：session.setAttribute();

    pageContext.forward("../demo01.jsp");
    request.getRequestDispatcher("/demo01.jsp").forward(request,response);
%>
</body>
</html>

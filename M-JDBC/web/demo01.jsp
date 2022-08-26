<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--定制错误页面--%>
<%@ page errorPage="error/500.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--<%--%>
    <%--int x = 1/0;--%>
<%--%>--%>

<%@ include file="header.jsp"%>
<h1>网页主体</h1>
<%@ include file="footer.jsp"%>

<jsp:include page="header.jsp"/>
<h1>网页主体</h1>
<jsp:include page="footer.jsp"/>
</body>
</html>

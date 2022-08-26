<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="aa" uri="http://lingnan.edu.cn" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%--<aa:example01/><br>--%>
  <%--<aa:tagSimple/><br>--%>
  <%--<aa:example02 name="zhangsan"/><br>--%>
  <%--<aa:example03 count="4" name="SixAn">--%>
    <%--aaaaaaaaaaaaaa<br>--%>
  <%--</aa:example03>--%>

  <c:out value="aaa"/><br>
  <c:set var="aa" value="123"/>
  <c:out value="${aa}"/><br>
  ${aa}<br>

  <%--if语句--%>
  <c:if test="${aa = '123'}">
    dddddddddddddddddd<br>
  </c:if>

  <%--捕捉异常--%>
  <c:catch var="bb">
    <%=9/0%>
  </c:catch>
  ${bb}<br>

  <%--choose语句--%>
  <c:choose>
    <c:when test="${aa='123'}">
     eeeeeeeeeeeeeeeeee<br>
    </c:when>
    <c:otherwise>
      ffffffffffffffffff<br>
    </c:otherwise>
  </c:choose>

<hr>
  <%
    String[] str = new String[5];
    str[0] = "ccc";
    str[1] = "ddd";
    str[2] = "eee";
    str[3] = "fff";
    str[4] = "ggg";
    request.setAttribute("cc",str);
  %>

  <c:forEach var="dd" items="${cc}">
    ${dd}<br>
  </c:forEach>

  <c:forTokens items="zhangsan,lisi,wangwu,zhaoliu" delims="," var="ee">
    ${ee}<br>
  </c:forTokens>

  <c:url var="ff" scope="page" value="/login">
      <c:param name="username" value="admin"/>
      <c:param name="password" value="admin"/>
  </c:url>
  <a href="${pageScope.ff}">登录</a><br>


  <sql:setDataSource
          var="mydata"
          driver="com.mysql.cj.jdbc.Driver"
          url="jdbc:mysql://localhost:3306/company"
          user="root"
          password="111111"/>
  <sql:query dataSource="${mydata}" var="result"  scope="page" sql="select * from tb_guide"/>
  <c:forEach var="guide" items="${result.rows}">
      ${guide.gid}   ${guide.gname}<br>
  </c:forEach>
  </body>
</html>

<%--<h2>Hello World!</h2>--%>

<%--&lt;%&ndash;这里提交的路径需要寻找到项目的路径&ndash;%&gt;--%>
<%--<form action="${pageContext.request.contextPath}/log" method="get">--%>
<%--用户名： <input type="text", name="username"><br>--%>
<%--密  码： <input type="password", name="password"><br>--%>
<%--<input type="submit">--%>
<%--</form>--%>
<%--</body>--%>

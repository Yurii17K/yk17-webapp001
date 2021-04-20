<%--
  Created by IntelliJ IDEA.
  User: K17
  Date: 1/26/2021
  Time: 5:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Endpoint#1</title>
    <link rel="stylesheet" type="text/css" href="index.css">
</head>
<body>

<div class="navigation">
    <ul>
        <li><a href="file_upload.jsp">FileUpload</a></li>
        <li><a href="auth.jsp">DBActions</a></li>

        <li><a href="${pageContext.request.contextPath}/DatabaseAccess">DatabaseAccess</a></li>
        <li><a href="${pageContext.request.contextPath}/SessionTrack">SessionTrack</a></li>
        <li><a href="${pageContext.request.contextPath}/Cookies">Cookies</a></li>
        <li><a href="${pageContext.request.contextPath}/ReadCookies">ReadCookies</a></li>
        <li><a href="${pageContext.request.contextPath}/DeleteCookies">DeleteCookies</a></li>
        <li><a href="${pageContext.request.contextPath}/PageRedirect">PageRedirect</a></li>
    </ul>
</div>


<form id="form1" name="form1" action = "DatabaseAccess" method = "GET">
    <input type ="submit" value = "get data">
</form>


<p>Number of elements in the Meals table: ${mealsCount}</p>

<table width = "56%" border = "1" align = "center">
    <tr bgcolor = "#949494">
        <th>m_id</th>
        <th>meal</th>
        <th>price</th>
    </tr>
<%--</table>--%>
<%--<table width = "56%" border = "1" align = "center">--%>

<c:forEach items="${mealsList}" var="meal">
    <tr>
        <td align="center"><c:out value="${meal.m_id}"/></td>
        <td align="center"><c:out value="${meal.meal}"/></td>
        <td align="center"><c:out value="${meal.price}"/></td>
    </tr>
</c:forEach>
</table>



<p>Please return to: <a href="https://yk17-webapp001.herokuapp.com/">Home Page</a></p>


</body>
</html>

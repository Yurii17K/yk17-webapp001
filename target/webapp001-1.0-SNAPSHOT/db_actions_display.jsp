<%--
  Created by IntelliJ IDEA.
  User: K17
  Date: 1/26/2021
  Time: 11:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display</title>
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

<p>${message}</p>

<table width = "56%" border = "1" align = "center">
    <tr bgcolor = "#949494">
        <th>m_id</th>
        <th>meal</th>
        <th>price</th>
    </tr>

    <tr><td>${meal.m_id}</td>
        <td>${meal.meal}</td>
        <td>${meal.price}</td>
    </tr>
</table>

<p>Please return to: <a href="https://yk17-webapp001.herokuapp.com/">Home Page</a></p>

</body>
</html>

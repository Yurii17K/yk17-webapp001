<%--
  Created by IntelliJ IDEA.
  User: K17
  Date: 1/27/2021
  Time: 1:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SessionTrack</title>
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

<h1 align = "center">SessionTrack</h1>
<h2 align = "center">${title}</h2>
<table border = 1 align = "center">

    <tr bgcolor = #949494> 
        <th>Session info</th>
        <th>Value</th>
    </tr>

    <tr>
        <td>id</td>
        <td>${sessionID}</td>
    </tr>

    <tr>
        <td>Creation Time</td>
        <td>${creationTime}</td>
    </tr>

    <tr>
        <td>Time of Last Access</td>
        <td>${lastAccessTime}</td>
    </tr>

    <tr>
        <td>User ID</td>
        <td>${userID}</td>
    </tr>

    <tr>
        <td>Number of visits</td>
        <td>${visitCount}</td>
    </tr>
</table>

<p>Please return to: <a href=https://yk17-webapp001.herokuapp.com/>Home Page</a></p>

</body>
</html>

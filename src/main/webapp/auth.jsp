<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--
  Created by IntelliJ IDEA.
  User: K17
  Date: 1/29/2021
  Time: 11:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authentication</title>
    <link rel="stylesheet" type="text/css" href="index.css">
</head>
<body>
<c:choose>
    <c:when test="${empty login_name}">
    </c:when>
    <c:otherwise>
        <style>
            .auth_body {
                display: none;
            }
        </style>
        <%@ include file="db_actions.jsp" %>
    </c:otherwise>
</c:choose>
<div class="auth_body">
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
    I see!  You don't have a name.. well.. Hello no name

    <div class="forms">

        <h3> Please authenticate to alter the database:</h3>
        Provide GitHub access token: <br>
        <form action = "Auth" method = "POST">
            GitHub Token: <input type = "password" name = "git_token" id = "git_token">
            <br />
            <input type = "submit" value = "Submit" />
        </form>

        Provide GitHub credentials: <br>
        <form action = "Auth" method = "POST">
            Login : <input type = "text" name = "git_login" id = "git_login">
            <br />
            Password : <input type = "password" name = "git_pass" id = "git_pass"/>
            <input type = "submit" value = "Submit" />
        </form>

    </div>
</div>
</body>
</html>

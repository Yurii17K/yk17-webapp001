<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
    <link rel="stylesheet" type="text/css" href="index.css">
</head>

<body>

<div class="navigation">
    <ul>
        <li><a href="file_upoad.jsp">FileUpload</a></li>
        <li><a href="db_actions.jsp">DBActions</a></li>

        <li><a href="${pageContext.request.contextPath}/DatabaseAccess">DatabaseAccess</a></li>
        <li><a href="${pageContext.request.contextPath}/SessionTrack">SessionTrack</a></li>
        <li><a href="${pageContext.request.contextPath}/Cookies">Cookies</a></li>
        <li><a href="${pageContext.request.contextPath}/ReadCookies">ReadCookies</a></li>
        <li><a href="${pageContext.request.contextPath}/DeleteCookies">DeleteCookies</a></li>
        <li><a href="${pageContext.request.contextPath}/PageRedirect">PageRedirect</a></li>
    </ul>
</div>





</body>
</html>
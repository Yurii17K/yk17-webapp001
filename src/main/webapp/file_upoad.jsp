<%--
  Created by IntelliJ IDEA.
  User: K17
  Date: 1/24/2021
  Time: 11:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FileUpload</title>
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

<div class="file">
    <h3>File Upload:</h3>
    Select a file to upload: <br>
    <form action = "UploadServlet" method = "post" enctype = "multipart/form-data">
        <input type = "file" name = "file" size = "50" />
        <br />
        <input type = "submit" value = "Upload File" />
    </form>
</div>


</body>
</html>

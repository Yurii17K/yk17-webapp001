
<%--
  Created by IntelliJ IDEA.
  User: K17
  Date: 1/24/2021
  Time: 12:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>DBActions</title>
    <link rel="stylesheet" type="text/css" href="index.css">

</head>

<body>

<%--<%--%>
<%--    request.getRequestDispatcher("auth.jsp").include(request, response);--%>
<%--%>--%>
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

        <div class="user_data">
            <img src="${img_url}" alt="Profile image">
            <p>User: ${login_name}</p>
            <form action = "Auth" method = "POST">
                <input type ="submit" value = "Log out">
            </form>
        </div>

        <div class="forms">

            <h3>Add an element to Meals table:</h3>
            Provide meal and price: <br>
            <form action = "Manager" method = "POST">
                Meal: <input type = "text" name = "meal_name" id = "meal_name">
                <br />
                Price: <input type = "text" name = "meal_price" id = "meal_price"/>
                <input type = "submit" value = "Submit" />
            </form>

            <h3>Remove an element from Meals table:</h3>
            Provide ID: <br>
            <form action = "Manager" method = "POST">
                ID: <input type = "text" name = "meal_ID" id = "meal_ID"/>
                <input type = "submit" value = "Submit" />
            </form>

            <h3>Update an element from Meals table:</h3>
            Provide ID and new price: <br>
            <form action = "Manager" method = "POST">
                ID: <input type = "text" name = "meal_ID_2" >
                <br />
                Price: <input type = "text" name = "meal_price_2"/>
                <input type = "submit" value = "Submit" />
            </form>
        </div>



</body>
</html>

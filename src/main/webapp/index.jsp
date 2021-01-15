<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>File Uploading Form</title>
</head>

<body>
<h3>File Upload:</h3>
Select a file to upload: <br>
<form action = "UploadServlet" method = "post" enctype = "multipart/form-data">
    <input type = "file" name = "file" size = "50" />
    <br />
    <input type = "submit" value = "Upload File" />
</form>

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
Provide ID amd new price: <br>
<form action = "Manager" method = "POST">
    ID: <input type = "text" name = "meal_ID_2" >
    <br />
    Price: <input type = "text" name = "meal_price_2"/>
    <input type = "submit" value = "Submit" />
</form>


</body>
</html>
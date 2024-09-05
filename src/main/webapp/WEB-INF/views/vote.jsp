<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Voting App</title>
</head>
<body>
    <h2 style="text-align: center">Voting App</h2>
    <hr>
   <form:form action="showHomePage" method="POST" modelAttribute="studentObj">
       <label>Your Name : </label>
       <form:input path="studentName" />
       <input type="submit">
   </form:form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Person</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<script type="text/javascript" src="js/app.js"></script>
</head>
<body>
<h1>New Person</h1>
<form:form method = "post" action = "/persons/new" modelAttribute = "person">
	<p>
        <form:label path="first_name">First Name: </form:label>
        <form:errors path="first_name"/>
        <form:input path="first_name"/>
    </p>
    <p>
        <form:label path="last_name">Last Name: </form:label>
        <form:errors path="last_name"/>
        <form:input path="last_name"/>
    </p>
    <p>
    </p>
    <form:input type="submit" value="Create"/>
</form:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New License</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<script type="text/javascript" src="js/app.js"></script>
</head>
<body>
<form:form method = "post" action = "/licenses/new" modelAttribute = "license">
	<p>
		<form:select path = "person">
   			<form:option value = "NONE" label = "Select"/>
   			<form:options items = "${allPersons}"/>
		</form:select>
	</p>
    <p>
        <form:label path="state">State: </form:label>
        <form:errors path="state"/>
        <form:textarea path="state"/>
    </p>
    
    <p>
        <form:label path="expiration_date">Expiration: </form:label>
        <form:errors path="expiration_date"/>
        <form:input type = "date" path="expiration_date"/>
    </p>
    <form:input type="submit" value="Create"/>
</form:form>
</body>
</html>
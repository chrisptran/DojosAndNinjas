<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>New Dojo</title>
</head>
<body>
<h1>New Dojo</h1>
<form:form action="/dojos/process" method="post" modelAttribute="newDojo">
	<div class="form-group">
		<form:label path="dojoName">Name</form:label>
		<form:errors path="dojoName" class="text-danger" />
		<form:input path="dojoName" type="text" class="form-control" />
	</div>
	<div>
		<input type="submit" value="Create" class="btn btn-primary"/>
	</div>
</form:form>
</body>
</html>
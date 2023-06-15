<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Ninja</title>
</head>
<body>
<form:form action="/ninjas/process" method="post" modelAttribute="newNinja">
	<form:label path="dojo">Dojo </form:label>
	<form:select path="dojo">
		<c:forEach var="oneDojo" items="${allDojos}">
			<form:option value="${oneDojo.id}" path="dojo">
				<c:out value="${oneDojo.dojoName}" />
			</form:option>
		</c:forEach>
	</form:select>
	<div>
		<form:label path="firstName">First Name:</form:label>
		<form:errors path="firstName" />
		<form:input path="firstName" type="text" />
	</div>
	<div>
		<form:label path="lastName">Last Name:</form:label>
		<form:errors path="lastName" />
		<form:input path="lastName" type="text" />
	</div>
	<div>
		<form:label path="age">Age:</form:label>
		<form:errors path="age" />
		<form:input path="age" type="text" />
	</div>
	<div>
		<input type="submit" value="Create" />
	</div>
</form:form>
</body>
</html>
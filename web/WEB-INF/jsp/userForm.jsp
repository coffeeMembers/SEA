<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
.even {
	background-color: silver
}
</style>
<title>Registration Page</title>
</head>
<body>

	<form:form action="add.html" commandName="user">
		<table>
			<tr>
				<td>User Name :</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><form:password path="password" /></td>
			</tr>
			<tr>
				<td>Code :</td>
				<td><form:textarea path="code" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Register"></td>
			</tr>
		</table>
	</form:form>
	<c:if test="${fn:length(userList) > 0}">
		<table cellpadding="5">
			<tr class="even">
				<th>Name</th>
				<th>Password</th>
				<th>Code</th>
			</tr>
			<c:forEach items="${userList}" var="user" varStatus="status">
				<tr class="<c:if test="${status.count % 2 == 0}">even</c:if>">
					<td>${user.name}</td>
					<td>${user.code}</td>
					<td>${user.password}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>
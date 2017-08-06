<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Student Manager</h1>
	<br />
	<form:form action="student.do" method="post" commandName="student">
		<table>
			<tr>
				<td>Id</td>
				<td><form:input path="id" /></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Cpf</td>
				<td><form:input path="cpf" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" name="action" value="Add">
					<input type="submit" name="action" value="Edit">
					<input type="submit" name="action" value="Search">
					<input type="submit" name="action" value="Delete">
				</td>
			</tr>
		</table>
		<br />
	</form:form>
	<br />
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Cpf</th>
		</tr>
		<c:forEach items="${studentAll}" var="s">
			<tr>
				<td>${s.id}</td>
				<td>${s.name}</td>
				<td>${s.cpf}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix ="form" %>
<!DOCTYPE HTML>
<html>
<head>
<title>List goals</title>
</head>
<body>
	<table border="1" width="100%">
		<thead>
			<tr>
				<th>Title</th>
				<th>CurrentProgress</th>
				<th>FinalProgress</th>
				<th> &nbsp; </th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="goalBean" items="${goalBeans}">
				<c:url var="listJobs" value="/job/list">
					<c:param name="goalId" value="${goalBean.id}" />
				</c:url>
					<tr>
						<td>${goalBean.title} </td>
						<td>${goalBean.currentProgress} </td>
						<td>${goalBean.finalProgress} </td>
						<td><a href="${listJobs}">List jobs</a></td>
					</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="<c:url value="/goal/create"/>">Add Goal</a>
    <a href="<c:url value="/"/>">Go Back</a>
</body>
</html>
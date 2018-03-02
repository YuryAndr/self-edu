<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix ="form" %>
<!DOCTYPE HTML>
<html>
<head>
<title>List jobs</title>
</head>
<body>
	<table border="1" width="100%">
		<thead>
			<tr>
				<th>Title</th>
				<th>Gain</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="jobBean" items="${jobBeans}">
					<tr>
						<td>${jobBean.title} </td>
						<td>${jobBean.gain} </td>
					</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="<c:url value="/job/create">
	        <c:param name="goalId" value='<%=request.getParameter("goalId") %>' />
	    </c:url>">
	 Add Job</a>
    <a href="<c:url value="/goal/list"/>">Go Back</a>
</body>
</html>
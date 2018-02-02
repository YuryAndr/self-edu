<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE HTML>
<html>

<body>

<table>

	<c:forEach items="${goals}" var="goal">
		<tr>
			<td><c:out value="${goal.title}"></c:out></td>
		</tr>
	</c:forEach>
</table>

</body>
</html>
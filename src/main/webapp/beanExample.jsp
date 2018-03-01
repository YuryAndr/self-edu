<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE HTML>
<html>

<body>
<h1>Goals</h1>
<jsp:useBean id="bean" class="ru.levelp.andryakov.selfedu.beans.SubjectsBean" scope="application" />

	<c:forEach items="${bean.subjects}" var="subject">
		<p>"${subject.title}"</p>
	</c:forEach>

</body>
</html>
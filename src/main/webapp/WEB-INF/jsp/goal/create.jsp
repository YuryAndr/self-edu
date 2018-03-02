<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix ="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Create goal</title>
</head>
<body>
<h1>Create new goal</h1>
<form:form modelAttribute = "goalBean">
    <table>
        <tr>
            <td>Title :</td>
            <td><form:input path="title"/></td>
        </tr>
        <tr>
            <td>Final progress:</td>
            <td><form:input path="finalProgress"/></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Create Goal"/>
            </td>
        </tr>
    </table>
</form:form>
<a href="<c:url value="/goal/list"/>">Go Back</a>
</body>
</html>
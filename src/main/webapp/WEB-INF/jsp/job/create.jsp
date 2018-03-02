<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix ="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Create job</title>
</head>
<body>
<h1>Create new job</h1>
<form:form modelAttribute = "jobBean">
    <table>
        <tr>
            <td>Title :</td>
            <td><form:input path="title"/></td>
        </tr>
        <tr>
            <td>Gain:</td>
            <td><form:input path="gain"/></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Create Job"/>
            </td>
        </tr>
    </table>
</form:form>
<a href="<c:url value="/job/list"/>">Go Back</a>
</body>
</html>
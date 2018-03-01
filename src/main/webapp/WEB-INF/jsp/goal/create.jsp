<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix ="form" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Create goal</title>
</head>
<body>
<h1>Create new goal</h1>
<form:form commandName = "goalBean">
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
</body>
</html>
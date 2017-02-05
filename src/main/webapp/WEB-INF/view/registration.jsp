<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
    <title>Registration</title>
</head>
<body>
<%@include file="header.jsp"%>

<spring:message code="message.username" var="placeholderUsername" />
<spring:message code="message.password" var="placeholderPassword" />
<spring:message code="message.confirmPassword" var="placeholderConfirmPassword" />
<form:form method="post" commandName="userForm" action="/registration" class="cssFormUser">
    <table align="center">
        <tr>
            <td>
                <form:errors path="username" cssClass="cssError"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:input path="username" cssClass="cssInput" placeholder='${placeholderUsername}'/>
            </td>
        </tr>
        <tr>
            <td>
                <form:errors path="password" cssClass="cssError"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:password path="password" cssClass="cssInput" placeholder='${placeholderPassword}'/>
            </td>
        </tr>
        <tr>
            <td>
                <form:errors path="confirmPassword" cssClass="cssError"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:password path="confirmPassword" cssClass="cssInput" placeholder='${placeholderConfirmPassword}'/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value=<spring:message code="message.registration"/> class="cssBtn"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>

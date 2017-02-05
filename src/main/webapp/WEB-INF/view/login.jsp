<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
    <title>Login</title>
</head>
<body>
    <%@include file="header.jsp"%>

    <form name="form_login" action="j_spring_security_check" method="POST" class="cssFormUser">
        <table align="center">
            <tr>
                <td>
                    <c:if test="${not empty error}">
                        <span class="cssError">
                            <spring:message code="logged.in.error"/>
                        </span>
                    </c:if>

                    <c:if test="${not empty logout}">
                        <span class="cssSuccess">
                            <spring:message code="logged.out.success"/>
                        </span>
                    </c:if>
                </td>
            </tr>
            <tr>
                <%--<td><spring:message code="message.username"/></td>--%>
                <td><input type="text" name="user_login" class="cssInput" placeholder='<spring:message code="message.username"/>'/></td>
            </tr>
            <tr>
                <%--<td><spring:message code="message.password"/></td>--%>
                <td><input type="password" name="password_login" class="cssInput" placeholder='<spring:message code="message.password"/>'/></td>
            </tr>
            <tr>
                <td><input name="submit" type="submit" value='<spring:message code="message.enter"/>' class="cssBtn" /></td>
            </tr>
            <tr>
                <td>
                    <a href="/registration" class="cssRef"><spring:message code="message.registration"/></a>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>

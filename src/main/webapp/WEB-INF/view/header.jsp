<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="cssHeader">
    <div class="cssMainImage">
        <img src="<c:url value='/resources/images/movieImage.png'/>" height="50"/>
        <br/><spring:message code="message.mainLabel"/>
    </div>

    <div class="cssLocale">
        <a href="?Lang=en"><img src="/resources/images/united-kingdom-flag-48x48.png" width="24" height="24"/></a>
        <a href="?Lang=ru"><img src="/resources/images/russia-flag-48x48.png" width="24" height="24"/></a>
    </div>

    <div class="cssLogoutFormUserName">
        <sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">
            <sec:authentication var="user" property="principal.username" />
            <%--j_spring_security_logout - специальная ссылка для разлогирования--%>
            <form action="j_spring_security_logout" >
                <table>
                    <tr>
                        <td>
                            <spring:message code="message.hello"/> ${user}
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" value="<spring:message code="message.logout"/>" class="cssBtn">
                        </td>
                    </tr>
                </table>
            </form>
        </sec:authorize>
    </div>
</div>



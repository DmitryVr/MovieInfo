<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
    <title>Welcome</title>
</head>
<body>
    <%--хедер--%>
    <%@include file="header.jsp"%>

    <%--левое меню (список жанров)--%>
    <div class="cssLeftMenu">
        <c:if test="${not empty listGenres}">
            <div align="center">
                <div class="cssUpBlock">
                    <strong style="color: #eaeaea">Жанр</strong>
                </div>
                <div>
                    <c:forEach var="genreVar" items="${listGenres}">
                        <h5>
                            <a href="<c:url value='/getMoviesByGenreId/${genreVar.id}'/>" class="cssRefGenre">&bull;${genreVar.name}</a>
                        </h5>
                    </c:forEach>
                </div>
            </div>
        </c:if>
    </div>

    <%--основной контент--%>
    <div class="cssContent">
        <%--форма для поиска по названию--%>
        <div class="cssUpBlock">
            <sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">
                <spring:message code="message.movie.title" var="placeholderMessageMovieTitle" />
                <form:form method="post" commandName="searchHelper" action="/moviesByName" cssClass="cssFormSearch">
                    <table align="center">
                        <tr>
                            <td>
                                <form:input path="helperName" placeholder='${placeholderMessageMovieTitle}' cssClass="cssInputSearch"/>
                            </td>
                            <td>
                                <input type="submit" value="<spring:message code="message.searchByName"/>" class="cssBtn"/>
                            </td>
                        </tr>
                    </table>
                </form:form>
            </sec:authorize>
        </div>

        <%--меню для редактирования или добавления--%>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
        <div align="center">
        <%--multipart/form-data - параметр для передачи двоичных данных--%>
        <form:form method="POST" enctype="multipart/form-data" commandName="movieAddOrUpdate" action="/addOrUpdateMovie">
            <form:hidden path="image"/>
            <table class="cssFontSize10">
                <c:if test="${movieAddOrUpdate.id == 0}">
                <tr>
                    <th colspan="2">
                        <spring:message code="message.label.data.add"/>
                    </th>
                </tr>
                </c:if>

                <c:if test="${movieAddOrUpdate.id != 0}">
                <tr>
                    <th colspan="2">
                        <spring:message code="message.label.data.update"/>
                    </th>
                </tr>

                <tr>
                    <td>
                        <form:label path="id">
                            id:
                        </form:label>
                    </td>
                    <td>
                        <form:input path="id" readonly="true"/>
                    </td>
                </tr>
                </c:if>

                <tr>
                    <td></td>
                    <td class="cssError">
                        <form:errors path="file" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <spring:message code="message.label.image.upload"/>
                    </td>
                    <td>
                        <input type="file" name="file" accept="image/*"/>
                    </td>
                </tr>

                <tr>
                    <td></td>
                    <td class="cssError">
                        <form:errors path="nameRussian" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="nameRussian">
                            <spring:message code="message.label.name.russian"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="nameRussian" />
                    </td>
                </tr>

                <tr>
                    <td>
                        <form:label path="nameOriginal">
                            <spring:message code="message.label.name.original"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="nameOriginal" />
                    </td>
                </tr>

                <tr>
                    <td></td>
                    <td class="cssError">
                        <form:errors path="year" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="year">
                            <spring:message code="message.label.year"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="year" />
                    </td>
                </tr>

                <tr>
                    <td></td>
                    <td class="cssError">
                        <form:errors path="country" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="country">
                            <spring:message code="message.label.country"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="country" />
                    </td>
                </tr>

                <tr>
                    <td></td>
                    <td class="cssError">
                        <form:errors path="director" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="director">
                            <spring:message code="message.label.director"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="director" />
                    </td>
                </tr>

                <tr>
                    <td>
                        <form:label path="genre">
                            <spring:message code="message.label.genre"/>
                        </form:label>
                    </td>
                    <td>
                        <form:select path="genre.id" items="${listGenres}" itemLabel="name" itemValue="id"/>
                    </td>
                </tr>

                <tr>
                    <td></td>
                    <td class="cssError">
                        <form:errors path="description" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <form:label path="description">
                            <spring:message code="message.label.description"/>
                        </form:label>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <form:textarea path="description" />
                    </td>
                </tr>

                <tr>
                    <td></td>
                    <td colspan="2">
                        <c:if test="${movieAddOrUpdate.id == 0}">
                            <input type="submit" value='<spring:message code="message.label.button.add"/>' class="cssBtn">
                        </c:if>

                        <c:if test="${movieAddOrUpdate.id != 0}">
                            <input type="submit" value='<spring:message code="message.label.button.update"/>' class="cssBtn">
                        </c:if>
                    </td>
                </tr>
            </table>
        </form:form>
        </div>
        </sec:authorize>

        <%--общий блок для всех записей Movie--%>
        <div class="cssMainContentBlock">
        <c:if test="${not empty listMovies}">
            <c:forEach var="movieVar" items="${listMovies}">
                <%--блок, состоит из левого и правого--%>
                <div class="cssMovieAllInfo" align="center">
                    <%--левая часть--%>
                    <div class="cssMovieLeftInfo">
                        <span class="cssFontSize14">${movieVar.nameRussian}</span><br/>
                        <span class="cssFontSize10">${movieVar.nameOriginal}</span>
                        <img src="/movieImage/${movieVar.id}/${false}" alt="нет изображения" width="180"><br/>

                        <span class="cssFontSize10">
                            <a href="/movieImage/${movieVar.id}/${true}">
                                <spring:message code="message.download.image"/>
                            </a>
                        </span>
                        <span class="cssFontSize10">
                            <br/><a href="/downloadPDF/${movieVar.id}">
                                <spring:message code="message.download.PDF"/>
                            </a>
                        </span>
                    </div>

                    <%--правая часть--%>
                    <div class="cssMovieRightInfo">
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <c:if test="${movieVar.id != 0}">
                            <a href="/getMovieById/${movieVar.id}">Обновить</a>
                            <a href="/deleteMovie/${movieVar.id}">Удалить</a>
                        </c:if>
                        </sec:authorize>

                        <table class="cssFontSize10">
                            <tr>
                                <td>Год:</td>
                                <td>${movieVar.year}</td>
                            </tr>
                            <tr>
                                <td>Страна:</td>
                                <td>${movieVar.country}</td>
                            </tr>
                            <tr>
                                <td>Режиссер:</td>
                                <td>${movieVar.director}</td>
                            </tr>
                            <tr>
                                <td>Жанр:</td>
                                <td>${movieVar.genre.name}</td>
                            </tr>
                        </table>
                        <div align="justify" style="padding-right: 15px">
                            <span class="cssFontSize10"><br/>${movieVar.description}</span>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </c:if>
        </div>
    </div>
</body>
</html>

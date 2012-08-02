<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf8">
        <title><spring:message code="label.title" /></title>
    </head>
    <body>

        <a href="<c:url value="./logout" />">
            <spring:message code="label.logout" />
        </a>

        <h2><spring:message code="label.title" /></h2>
        <form:form method="post" action="./registration/add" commandName="user">

            <table>
                <tr>
                    <td><form:label path="username">
                            <spring:message code="label.username" />
                        </form:label></td>
                    <td><form:input path="username" /></td>
                </tr>
                <tr>
                    <td><form:label path="password">
                            <spring:message code="label.password" />
                        </form:label></td>
                    <td><form:input path="password" /></td>
                </tr>


                <tr>
                    <td><form:label path="person.fName">
                            <spring:message code="label.fName" />
                        </form:label></td>
                    <td><form:input path="person.fName" /></td>
                </tr>
                <tr>
                    <td><form:label path="person.lName">
                            <spring:message code="label.lName" />
                        </form:label></td>
                    <td><form:input path="person.lName" /></td>
                </tr>


                <tr>
                    <td><form:label path="person.email">
                            <spring:message code="label.email" />
                        </form:label></td>
                    <td><form:input path="person.email" /></td>
                </tr>
                <tr>
                    <td><form:label path="person.phone">
                            <spring:message code="label.phone" />
                        </form:label></td>
                    <td><form:input path="person.phone" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit"
                                           value="<spring:message code="label.addperson"/>" /></td>
                </tr>
            </table>
        </form:form>

        <h3><spring:message code="label.persons" /></h3>
        <c:if test="${!empty getAllUsers}">
            <table class="db">
                <tr>
                    <th><spring:message code="label.fName" /></th>
                    <th><spring:message code="label.email" /></th>
                    <th><spring:message code="label.phone" /></th>
                    <th><spring:message code="label.username" /></th>
                    <th><spring:message code="label.password" /></th>
                    <th>&nbsp;</th>
                </tr>
                <c:forEach items="${getAllUsers}" var="user">
                    <tr>
                        <td>${user.person.lName}, ${user.person.fName}</td>
                        <td>${user.person.email}</td>
                        <td>${user.person.phone}</td>
                        <td>${user.username}</td>
                        <td>${user.password}</td>
                        <td><a href="./delete/${user.id}"><spring:message code="label.delete" /></a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>

    </body>
</html>
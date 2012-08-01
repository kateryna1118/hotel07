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
        <form:form method="post" action="./person/add" commandName="person">

            <table>
                <tr>
                    <td><form:label path="fName">
                            <spring:message code="label.fName" />
                        </form:label></td>
                    <td><form:input path="fName" /></td>
                </tr>
                <tr>
                    <td><form:label path="lName">
                            <spring:message code="label.lName" />
                        </form:label></td>
                    <td><form:input path="lName" /></td>
                </tr>


                <tr>
                    <td><form:label path="email">
                            <spring:message code="label.email" />
                        </form:label></td>
                    <td><form:input path="email" /></td>
                </tr>
                <tr>
                    <td><form:label path="phone">
                            <spring:message code="label.phone" />
                        </form:label></td>
                    <td><form:input path="phone" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit"
                                           value="<spring:message code="label.addperson"/>" /></td>
                </tr>
            </table>
        </form:form>

        <h3><spring:message code="label.persons" /></h3>
        <c:if test="${!empty getAllPersons}">
            <table class="db">
                <tr>
                    <th><spring:message code="label.fName" /></th>
                    <th><spring:message code="label.email" /></th>
                    <th><spring:message code="label.phone" /></th>
                    <th>&nbsp;</th>
                </tr>
                <c:forEach items="${getAllPersons}" var="person">
                    <tr>
                        <td>${person.lName}, ${person.fName}</td>
                        <td>${person.email}</td>
                        <td>${person.phone}</td>
                        <td><a href="delete/${person.id}"><spring:message code="label.delete" /></a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>

    </body>
</html>
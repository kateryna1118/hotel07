<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" session="true"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf8">
        <title><spring:message code="label.title" /></title>

        <!-- STYLES -->
        <link rel="stylesheet" href="resources/css/style_1.css" type="text/css" media="all" />
        <link type="text/css" href="resources/css/jquery-ui-1.8.22.custom.css" rel="stylesheet" />

        <!-- LIBS -->
        <script src="resources/css/jquery-1.7.2.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="resources/css/jquery-ui-1.8.22.custom.min.js"></script>

        <!-- SCRIPTS -->
        <script src="resources/css/tabs.js" type="text/javascript"></script>
        <script src="resources/css/selectbox.js" type="text/javascript"></script>
       <script>
            $(document).ready(function() {
                $('input[type=text]#dateIn').datepicker({ autoSize: true });
            });
            $(document).ready(function() {
                $('input[type=text]#dateOut').datepicker({ autoSize: true });
            });
        </script>

    </head>


    <body>

        <a href="<c:url value="./logout" />">
            <spring:message code="label.logout" />
        </a>

        <h2><spring:message code="label.title" /></h2>

        <h2> Hello, <c:out value="${theName}"></c:out>!</h2>

        <h2> Hello,<%= request.getSession().getAttribute("userName") %></h2>






        <h3><spring:message code="label.orders" /></h3>
        <form:form method="post" action="./booking/add_Order" commandName="hotelOrder">


            <table>
                <tr>
                    <td><form:label path="dateIn">
                            <spring:message code="label.DateIn" />
                        </form:label></td>
                    <td><form:input path="dateIn"/></td>
                </tr>

                <tr>
                    <td><form:label path="dateOut">
                            <spring:message code="label.DateOut" />
                        </form:label></td>
                    <td><form:input path="dateOut" /></td>
                </tr>

                <tr>
                    <td><form:label path="roomType.id">
                            <spring:message code="label.roomType" />
                        </form:label></td>
                    <td>

                        <form:select path="roomType.id" items="${getAllRoomTypes}" itemValue="id" itemLabel="name" />
                        </td>

                </tr>

                <tr>
                    <td colspan="2"><input type="submit"
                                           value="<spring:message code="label.billing"/>" /></td>
                </tr>
            </table>

        </form:form>


        <c:if test="${!empty getAllOrders}">
            <table class="db" border="1" >
                <tr>
                    <th><spring:message code="label.fName" /></th>
                    <th><spring:message code="label.DateIn" /></th>
                    <th><spring:message code="label.DateOut" /></th>
                    <th><spring:message code="label.roomType" /></th>
                    <th>&nbsp;</th>
                </tr>
                <c:forEach items="${getAllOrders}" var="hotelOrder">
                    <tr>
                        <td>${hotelOrder.user.person.lName}, ${hotelOrder.user.person.fName}</td>
                        <td>${hotelOrder.dateIn}</td>
                        <td>${hotelOrder.dateOut}</td>
                        <td>${hotelOrder.roomType.name}</td>
                        <td><a href="delete/${hotelOrder.id}"><spring:message code="label.delete" /></a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>

        <c:if test="${!empty getAllRoomTypes}">
            <table class="db" border="1" >
                <tr>
                    <th><spring:message code="label.fName" /></th>
                    <th><spring:message code="label.DateIn" /></th>
                    <th>&nbsp;</th>
                </tr>
                <c:forEach items="${getAllRoomTypes}" var="roomType">
                    <tr>
                        <td>${roomType.id}</td>
                        <td>${roomType.id}</td>
                        <td><a href="delete/${roomType.id}"><spring:message code="label.delete" /></a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>

        <c:if test="${!empty getAllRoomTypes}">
            <table class="db1" border="1" >
                <tr>
                    <th><spring:message code="label.roomType" /></th>
                    <th>&nbsp;</th>
                </tr>
                <c:forEach items="${getAllRoomTypes}" var="roomType">
                    <tr><td>${roomType.id}</td></tr>
                    <tr><td>${roomType.name}</td></tr>

                </c:forEach>
            </table>
        </c:if>



    </body>
</html>
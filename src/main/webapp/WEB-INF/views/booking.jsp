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
        <a href="<c:url value="./logout" />">
            <spring:message code="label.homePage" />
        </a>

        <!-- STYLES -->
        <link rel="stylesheet" href="resources/css/style_3.css" type="text/css" media="all" />
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
    <div class="borders">
        <div class="content">
            <h1><div class="logo"><a href="/" title="Наш отель!!!"></a></div></h1>
            </a>
            <ul class="reset menu">

                <li><a href="/user"/>Главная</a></li>
                <li><a href="resources/servis.jsp">Сервис</a></li>
                <li><a href="resources/nomer.jsp">Номер</a></li>
                <li><a href="resources/contact.jsp">Контакты</a></li>
                <li><a href="/hotelmanager">Менеджер</a></li>
                <li><a href="/admin">Администратор</a></li>

            </ul>
    <body>

    <body>


<div class="borders">
        <div class="contenthtml" onclick="tableSearch.init();">
<div class="page">
<h2 style="color: white"> Добро пожаловать на страничку бронирования,<%= request.getSession().getAttribute("userName") %></h2>

        <form:form method="post" action="./booking/add_Order" commandName="hotelOrder">


            <table>
                <tr>
                    <td><form:label path="dateIn">
                    <h3 style="color: white"><spring:message code="label.DateIn" /></h3>
                        </form:label></td>
                    <td><form:input path="dateIn"/></td>

                    <td><form:label path="dateOut">
                  <h3 style="color: white"><spring:message code="label.DateOut" /></h3>
                        </form:label></td>
                    <td><form:input path="dateOut" /></td>

                    <td><form:label path="roomType.id">
                   <h3 style="color: white"><spring:message code="label.roomType" /></h3>
                        </form:label></td>
                    <td>
                        <form:select path="roomType.id" items="${getAllRoomTypes}" itemValue="id" itemLabel="name" />
                    </td>
                    <td colspan="2"><input type="submit"
                                           value="<spring:message code="label.billing"/>" /></td>
                </tr>
            </table>

        </form:form>

       <h3 style="color: white"><spring:message code="label.message1" /></h3>
        <c:if test="${!empty getAllOrders}">
            <table class="table table-bordered" >
                <tr>
                    <th><spring:message code="label.fName" /></th>
                    <th><spring:message code="label.DateIn" /></th>
                    <th><spring:message code="label.DateOut" /></th>
                    <th><spring:message code="label.roomType" /></th>
                    <th><spring:message code="label.numberOfPlaces" /></th>
                    <th><spring:message code="label.numberOfRooms" /></th>
                    <th  width="30"><spring:message code="label.price" /></th>
                    <th>&nbsp;</th>
                </tr>
                <c:forEach items="${getAllOrders}" var="hotelOrder">
                    <c:if test="${hotelOrder.id== getOrderId}">
                    <tr align="center">
                        <td>${hotelOrder.user.person.lName}, ${hotelOrder.user.person.fName}</td>
                        <td>${hotelOrder.dateIn}</td>
                        <td>${hotelOrder.dateOut}</td>
                        <td>${hotelOrder.roomType.name}</td>
                        <td>${hotelOrder.roomType.numberOfPlaces}</td>
                        <td>${hotelOrder.roomType.numberOfRooms}</td>
                        <td width="30">${hotelOrder.roomType.price}</td>
                        <td><a href="/delete_order/${hotelOrder.id}"><spring:message code="label.delete" /></a></td>
                    </tr>
                     </c:if>
                </c:forEach>
            </table>
                     
        </c:if>
<p><h3 style="color: white"><spring:message code="label.message2" /></h3></p>
        <c:if test="${!empty getAllOrders}">
            <table class="table table-bordered" >
                <tr>
                    <th><spring:message code="label.fName" /></th>
                    <th><spring:message code="label.DateIn" /></th>
                    <th><spring:message code="label.DateOut" /></th>
                    <th><spring:message code="label.roomType" /></th>
                    <th><spring:message code="label.numberOfPlaces" /></th>
                    <th><spring:message code="label.numberOfRooms" /></th>
                    <th  width="30"><spring:message code="label.price" /></th>
                    <th>&nbsp;</th>
                </tr>

                <c:forEach items="${getAllOrders}" var="hotelOrder">
                    <c:if test="${hotelOrder.user.username== userName}">
                        <tr align="center">
                        <td>${hotelOrder.user.person.lName}, ${hotelOrder.user.person.fName}</td>
                        <td>${hotelOrder.dateIn}</td>
                        <td>${hotelOrder.dateOut}</td>
                        <td>${hotelOrder.roomType.name}</td>
                        <td>${hotelOrder.roomType.numberOfPlaces}</td>
                        <td>${hotelOrder.roomType.numberOfRooms}</td>
                        <td width="30">${hotelOrder.roomType.price}</td>
                        <td><a href="delete/${hotelOrder.id}"><spring:message code="label.delete" /></a></td>
                    </tr>
                    </c:if>
                </c:forEach>
            </table>
        </div> 
        </c:if>
</div>  
   </div> 

<div class="clr" style="margin-bottom: 50px; height: 50px;"></div>


    </body>
</html>
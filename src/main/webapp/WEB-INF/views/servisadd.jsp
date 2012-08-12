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
                $('input[type=text]#operationDate').datepicker({ autoSize: true });
            });
        </script>

    </head>
    <body>
    <div class="borders">
        <div class="content">
            <h1><div class="logo"><a href="/" title="Наш отель!!!"></a></div></h1>
        <a href="<c:url value="./logout" />">
            <spring:message code="label.homePage" />
        </a>
            <ul class="reset menu">

                <li><a href="/user"/>Главная</a></li>
                <li><a href="/hotelmanager">Менеджер</a></li>
                <li><a href="/admin">Администратор</a></li>

            </ul>
    <body>

    <body>
<div class="borders">
        <div class="contenthtml" onclick="tableSearch.init();">
<div class="page">

         <form:form method="POST" action="./servisadd/add_Service" commandName="addServiceHistory">
            <table>
                <tr>
                    <td><form:label path="operationDate">
                             <h5 style="color: white"><spring:message code="label.operationDate" /></h5>
                        </form:label></td>
                    <td><form:input path="operationDate"/></td>

                </tr>
                <tr>
                    <td><form:label path="order">
                             <h5 style="color: white"><spring:message code="label.lNameClient" /></h5>
                        </form:label></td>
                    <td><form:select id="clientSelect" name="orderId" path="order.id">
                    <option value="">Select to Edit</option>
                    <c:forEach var="theOrder" items="${orderList}">
                        <form:option value="${theOrder.id}"><c:out value=" ${theOrder.id}${theOrder.user.person.lName}"/></form:option>
                    </c:forEach>
                </form:select>
                        </td>
                </tr>
                <tr>
                    <td><form:label path="addService">
                            <h5 style="color: white"><spring:message code="label.AddService" /></h5>
                        </form:label></td>
                    <td><form:select id="addServiceSelect" name="addServiceId" path="addService.id">
                    <option value="">Select to Edit</option>
                    <c:forEach var="theAddService" items="${serviceList}">
                    <form:option value="${theAddService.id}"><c:out value=" ${theAddService.name}"/></form:option>
                    </c:forEach>
                        </form:select></td>
                </tr>
                <tr>
                    <td><form:label path="amount">
                             <h5 style="color: white"><spring:message code="label.amount" /></h5>
                        </form:label></td>
                    <td><form:input path="amount" ></form:input></td>
                </tr>
                    <tr>
                    <td><form:label path="clientPaid">
                             <h5 style="color: white"><spring:message code="label.clientPaid" /></h5>
                        </form:label></td>
                    <td><form:checkbox path="clientPaid"></form:checkbox></td>
                    </tr>
                <tr>
                    <td><form:label path="user">
                             <h5 style="color: white"><spring:message code="label.SelectStaff" /></h5>
                        </form:label></td>
                    <td><form:select id="userSelect" name="userId" path="user.id">
                    <option value="">Select to Edit</option>
                    <c:forEach var="theUser" items="${userList}">
                        <form:option value="${theUser.id}"><c:out value="${theUser.person.lName} ${theUser.role.description}"/></form:option>
                </c:forEach>
                    </form:select></td>
           <td colspan="2"><input type="submit"
                                   value="<spring:message code="label.addAddService"/>" /></td>

                </tr>
            </table>

</form:form>
<p><h4 style="color: white"><spring:message code="label.message4" /></h4></p>
<c:if test="${!empty getAllAddServiceHistories}" >
<table class="table table-bordered" >
                <tr>
        <th><h5><spring:message code="label.lNameClient" /></h5></th>
        <th><h5><spring:message code="label.operationDate" /></h5></th>
        <th><h5><spring:message code="label.AddServiceName" /></h5></th>
        <th><h5><spring:message code="label.amount" /></h5></th>
        <th><h5><spring:message code="label.clientPaid" /></h5></th>
        <th><h5><spring:message code="label.Staff" /></h5></h5></th>
        <th  width="30"><h5><spring:message code="label.price" /></h5></th>
                    <th>&nbsp;</th>
                </tr>

    <c:forEach items="${getAllAddServiceHistories}" var="addServiceHistory" >
        <c:if test="${addServiceHistory.id== getAddServiceHistoryId}">
            <tr align="center">
                <td>${addServiceHistory.order.user.person.lName}, ${addServiceHistory.order.user.person.fName}</td>
                <td>${addServiceHistory.operationDate}</td>
                <td>${addServiceHistory.addService.name}</td>
                <td>${addServiceHistory.amount}</td>
                <td>${addServiceHistory.clientPaid}</td>
                <td>${addServiceHistory.user.person.lName},${addServiceHistory.user.role.description}</td>
                <td width="30">${addServiceHistory.addService.price}</td>
                <td><a href="delete/${addServiceHistory.id}"><spring:message code="label.delete" /></a></td>
            </tr>
        </c:if>
                </c:forEach>
            </table>
        </c:if>

 </div>
 </div>
 </div>
<div class="clr" style="margin-bottom: 50px; height: 50px;"></div>
    </body>
</html>
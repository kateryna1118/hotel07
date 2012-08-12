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
        <script src="resources/css/tablesearch.js" type="text/javascript"></script>

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
               
                <li><a href="./user"/>Главная</a></li>
                <li><a href="./hotelmanager">Менеджер</a></li>
                <li><a href="./admin">Администратор</a></li>
                
            </ul>
    <body>

    <body>
<div class="borders">
        <div class="contenthtml" onclick="tableSearch.init();">
<div class="page">

<p><h4 style="color: white"><spring:message code="label.message3" /></h4></p>

<c:if test="${!empty getAllAddServiceHistories}" >
    <legend><h3 style="color:white">Поиск сервисов</h3></legend>
             <div class="search">
            <input type="text" size="30" maxlength="100" value="" id="textBoxSearch" onkeyup="tableSearch.runSearch();" />
           
        </div>
    <table class="table table-bordered" >
        <thead> 
        <tr>
            <th><h5><spring:message code="label.lNameClient" /></h5></th>
            <th><h5><spring:message code="label.operationDate" /></h5></th>
            <th><h5><spring:message code="label.AddServiceName" /></h5></th>
            <th><h5><spring:message code="label.amount" /></h5></th>
            <th><h5><spring:message code="label.clientPaid" /></h5></th>
            <th><h5><spring:message code="label.Staff" /></h5></th>
            <th  width="30"><h5><spring:message code="label.price" /></h5></th>
            <th>&nbsp;</th>
        </tr>
 </thead>
  <tfoot>
				    <tr>
				        <td></td>
				    </tr>
                    </tfoot>
                      <tbody id ="data"> 
        <c:forEach items="${getAllAddServiceHistories}" var="addServiceHistory" >

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

        </c:forEach>
            </tbody>
    </table>
</c:if>
 </div>
 </div>
 </div>
<div class="clr" style="margin-bottom: 50px; height: 50px;"></div>
    </body>
</html>
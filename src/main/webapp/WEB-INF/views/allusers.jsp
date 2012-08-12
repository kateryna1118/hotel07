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
         <script src="resources/css/tablesearch.js" type="text/javascript"></script>
         <!-- STYLES -->
<link rel="stylesheet" href="resources/css/style_3.css" type="text/css" media="all" />
    
    <!-- LIBS -->
    <script src="resources/css/jquery-1.7.2.min.js" type="text/javascript"></script>
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
    </body>
 <body>

    <div class="borders">
        <div class="contenthtml" onclick="tableSearch.init();">
            <div class="page">
                <c:if test="${!empty getAllUsers}">
               
            <legend><h3 style="color:white">Поиск клиентов</h3></legend>
                <div class="search">
            <input type="text" size="30" maxlength="100" value="" id="textBoxSearch" onkeyup="tableSearch.runSearch();" />
           
        </div>
              
            <table class="table table-bordered">
              
            <thead>   
                <tr>
                    <td><spring:message code="label.lName" /></td>
                    <td><spring:message code="label.fName" /></td>
                    <td><spring:message code="label.email" /></td>
                    <td><spring:message code="label.phone" /></td>
                    <td>&nbsp;</td>
                </tr>
                </thead>
                <tfoot>
				    <tr>
				        <td></td>
				    </tr>
                    </tfoot>
                      <tbody id ="data"> 
                <c:forEach items="${getAllUsers}" var="user">
                    <tr>
                        <td>${user.person.lName}</td>
                        <td>${user.person.fName}</td>
                        <td>${user.person.email}</td>
                        <td>${user.person.phone}</td>
                       
                    </tr>
                </c:forEach>
                     </tbody>  
            </table>
      </div>  
 </c:if>
   </div> 
</div>

<div class="clr" style="margin-bottom: 50px; height: 50px;"></div>
         

    </body>
</html>

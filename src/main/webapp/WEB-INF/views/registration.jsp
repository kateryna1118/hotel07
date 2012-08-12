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
                <li><a href="resources/content.jsp"/>Галлерея</a></li>
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
        

        <h2 style="color: white"><spring:message code="label.formregistr" /></h2>
        <form:form method="post" action="./registration/add" commandName="user">

            <table>
                <tr>
                    <td><form:label path="username">
                        <h3 style="color: white"><spring:message code="label.username" /></h3>
                        </form:label></td>
                    <td><form:input path="username" /></td>
                </tr>
                <tr>
                    <td><form:label path="password">
                            <h3 style="color: white"><spring:message code="label.password" /></h3>
                        </form:label></td>
                    <td><form:input path="password" /></td>
                </tr>


                <tr>
                    <td><form:label path="person.fName">
                            <h3 style="color: white"><spring:message code="label.fName" /></h3>
                        </form:label></td>
                    <td><form:input path="person.fName" /></td>
                </tr>
                <tr>
                    <td><form:label path="person.lName">
                            <h3 style="color: white"><spring:message code="label.lName" /></h3>
                        </form:label></td>
                    <td><form:input path="person.lName" /></td>
                </tr>


                <tr>
                    <td><form:label path="person.email">
                            <h3 style="color: white"><spring:message code="label.email" /></h3>
                        </form:label></td>
                    <td><form:input path="person.email" /></td>
                </tr>
                <tr>
                    <td><form:label path="person.phone">
                            <h3 style="color: white"><spring:message code="label.phone" /></h3>
                        </form:label></td>
                    <td><form:input path="person.phone" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input id="clic" type="submit"
                                           value="<spring:message code="label.addperson"/>" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                       <a href="<c:url  value="./logout" />"><h3 style="color: white">
                            <spring:message code="label.logout" /></h3>
                       </a></td>
                </tr>
                <script>
                    $('#clic').click(function(){
                    alert('Вы зарегистрированы.Войдите под своим паролем на главной странице');
                    });
                </script>
            </table>
        </form:form>
</div>
    </body>
</html>
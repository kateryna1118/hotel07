<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
     <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8" />
    <title>Наш отель!!!</title>
    <meta name="description" content="Ripario Hotel" />
    <meta name="keywords" content="hotel, ripario, egipet" />
    
    <!-- STYLES -->
   
<link rel="stylesheet" href="resources/css/style_3.css" type="text/css" media="all" />
    
    <!-- LIBS -->
    <script src="resources/css/jquery-1.7.2.min.js" type="text/javascript"></script>
</head>
<body>
    <div class="borders">
        <div class="content">
            <h1><div class="logo"><a href="/" title="Наш отель!!!"></a></div></h1>
            <ul class="reset menu">
               
                <li><a href="resources/content.jsp"/>Галлерея</a></li>
                <li><a href="resources/servis.jsp">Сервис</a></li>
                <li><a href="resources/nomer.jsp">Номер</a></li>
                <li><a href="resources/contact.jsp">Контакты</a></li>
                <li><a href="/hotelmanager">Менеджер</a></li>
                <li><a href="/admin">Администратор</a></li>
                
            </ul>
    <body>
        

        <c:if test="${not empty param.error}">
            <font color="red"> <spring:message code="label.loginerror" />
                : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message} </font>
            </c:if>

<%= request.getSession().getAttribute("userName") %>

        <form method="POST" action="<c:url value="/j_spring_security_check" />">
            <table>
                <tr>
                    <td align="right"><spring:message code="label.username" /></td>
                    <td><input type="text" name="j_username" /></td>
                </tr>
                <tr>
                    <td align="right"><spring:message code="label.password" /></td>
                    <td><input type="password" name="j_password" /></td>
                </tr>
                <tr>
                    <td align="right"><spring:message code="label.remember" /></td>
                    <td><input type="checkbox" name="_spring_security_remember_me" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="right"><input type="submit" value="Login" />
                        <input type="reset" value="Reset" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <a href="./registration" ><spring:message code="label.register"/></a></td>

                </tr>


            </table>
        </form>


<%
   String name = request.getParameter( "j_username" );
   session.setAttribute( "theName", name );
%>


    </body>
</html>
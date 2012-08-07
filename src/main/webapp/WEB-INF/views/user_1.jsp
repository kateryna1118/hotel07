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
        
<div style="margin-top: 15px; margin-left: 790px;"
        <c:if test="${not empty param.error}">
            <font color="red"> <spring:message code="label.loginerror" />
                : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message} </font>
            </c:if>

<%= request.getSession().getAttribute("userName") %>

        <form method="POST" action="<c:url value="/j_spring_security_check" />">
            <ul>
                
                <li><input type="text" name="j_username" placeholder="Логин" /></li>
                <li><input type="password" name="j_password" placeholder="Пароль" /></li>
            </ul>
		<div style="color: white; margin-top: 8px; margin-left: 15px;"><input type="checkbox" name="_spring_security_remember_me" /> - Запомнить</div>
                <input type="submit" value="Login" /> <input type="reset" value="Reset" />
                <div class="reglink"><a href="./registration" ><spring:message code="label.register"/></a></div>
        </form>
</div>

<%
   String name = request.getParameter( "j_username" );
   session.setAttribute( "theName", name );
%>


    </body>
</html>
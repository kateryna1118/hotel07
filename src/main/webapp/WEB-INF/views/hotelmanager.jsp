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
            <a href="<c:url value="./logout" />">
            <spring:message code="label.homePage" />
        </a>
            <ul class="reset menu">
               
                 <li><a href="./user"/>Главная</a></li>
                 <li><a href="./allusers"/>Отчет о клиентах</a></li>
                 <li><a href="./allorders"/>Отчет о заказах</a></li>
                 <li><a href="./allservice"/>Отчет о сервисах</a></li>
                
            </ul>
    <body>
</html>

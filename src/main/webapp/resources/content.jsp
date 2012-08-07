<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
   <!-- LIBS -->
    <script src="css/jquery-1.7.2.min.js" type="text/javascript"></script>

   <!-- STYLES -->
  
 <meta http-equiv="Content-Type" content="text/html; charset=utf8" />
    <title>Ripario Hotel Group</title>
    
    <style>
                            .menu li{float: left; font-size: 20px; margin: 10px;}
				.es-carousel ul{
					display:block;
				}
			</style>
   
</head>
<body>

    <div class="borders">
        <div class="contenthtml">
             <ul class="reset menu">
               
                <li><a href="/user"/><h1>Главная<h1></a></li>
                <li><a href="servis.jsp"><h1>Сервис<h1></a></li>
                <li><a href="nomer.jsp"><h1>Номер<h1></a></li>
                
            </ul>
            <div style="clear: both;"></div>
<head>
        
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"> 
        <link rel="stylesheet" type="text/css" href="css/demo.css" />
		<link rel="stylesheet" type="text/css" href="css/style_2.css" />
		<link rel="stylesheet" type="text/css" href="css/elastislide.css" />
		<link href='http://fonts.googleapis.com/css?family=PT+Sans+Narrow&v1' rel='stylesheet' type='text/css' />
		<link href='http://fonts.googleapis.com/css?family=Pacifico' rel='stylesheet' type='text/css' />
		<noscript>
			
		</noscript>
		<script id="img-wrapper-tmpl" type="text/x-jquery-tmpl">	
			<div class="rg-image-wrapper">
				{{if itemsCount > 1}}
					<div class="rg-image-nav">
						<a href="#" class="rg-image-nav-prev">Предыдущее изображение</a>
						<a href="#" class="rg-image-nav-next">Следующее изображение</a>
					</div>
				{{/if}}
				<div class="rg-image"></div>
				<div class="rg-loading"></div>
				<div class="rg-caption-wrapper">
					
				</div>
			</div>
		</script>
    </head>
    <body>
		<div class="container">
			<div class="header">
				
				<div class="clr"></div>
			</div><!-- header -->
			
			<div class="content">
				<div id="rg-gallery" class="rg-gallery">
					<div class="rg-thumbs">
						<!-- Elastislide Carousel Thumbnail Viewer -->
						<div class="es-carousel-wrapper">
							<div class="es-nav">
								<span class="es-nav-prev">Предыдущее</span>
								<span class="es-nav-next">Следующее</span>
							</div>
							<div class="es-carousel">
								<ul>
									<li><a href="#"><img src="css/images/thumbs/1.png" data-large="css/images/1.png" alt="image01" data-description="From off a hill whose concave womb reworded" /></a></li>
									<li><a href="#"><img src="css/images/thumbs/2.png" data-large="css/images/2.png" alt="image02" data-description="A plaintful story from a sistering vale" /></a></li>
									<li><a href="#"><img src="css/images/thumbs/3.png" data-large="css/images/3.png" alt="image03" data-description="A plaintful story from a sistering vale" /></a></li>
									<li><a href="#"><img src="css/images/thumbs/4.png" data-large="css/images/4.png" alt="image04" data-description="My spirits to attend this double voice accorded" /></a></li>
									
								</ul>
							</div>
						</div>
						<!-- End Elastislide Carousel Thumbnail Viewer -->
					</div><!-- rg-thumbs -->
				</div><!-- rg-gallery -->
			</div><!-- content -->
		</div><!-- container -->
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
		<script type="text/javascript" src="css/jquery.tmpl.min.js"></script>
		<script type="text/javascript" src="css/jquery.easing.1.3.js"></script>
		<script type="text/javascript" src="css/jquery.elastislide.js"></script>
		<script type="text/javascript" src="css/gallery.js"></script>
    </body>
</html>
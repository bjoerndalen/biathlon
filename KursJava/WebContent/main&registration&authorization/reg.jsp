<%@page import="service.ServiceFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<meta name="YURII" content="18.02.2013">
<title>Ukrainian Biathlon</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>

<body>
<jsp:useBean id="newuser" scope="page" class="model.User"></jsp:useBean>
<jsp:setProperty property="*" name="newuser" />
<!-- Регистация -->
<c:if test="${not empty newuser.login}">
	<%
		ServiceFactory.DEFAULT.getUserService().addEntity(newuser);
	%>

</c:if>



<div class="container">
  <header>
  	<a href="index.jsp" title="ИКС БИАТЛОН"><p>Биатлон</p></a>
  </header>
    
  <aside>
   	<div class="box">
      	<div class="box_head">
        		<p>Навигация</p>
    		</div>
            	<nav>
            	<ul class="nav">
                	<li><a href="auth.jsp" title="Вход/ Авторизация" target="_self">Вход/ Авторизация</a></li>
                    <li><a href="reg.jsp" title="Регистрация" target="_self">Регистрация</a></li>
                    </ul>
                </nav>
			</div>
      	<div class="box">
        	<div class="box_head">
        	<p>Полезные ссылки</p>
    		</div>
            	<ul class="nav">
                	<li><a href="http://www.biathlon.com.ua" title="Федерация биатлона Украины" target="_blank">Федерация биатлона Украины</a></li>
                    <li><a href="http://www4.biathlonworld.com/ru/home.html" title="Международный союз биатлонистов" target="_blank">Международный союз биатлонистов</a></li>
                    <li><a href="http://services.biathlonresults.com/Datacenter_IBU.aspx" title="Siwidata" target="_blank">Siwidata</a></li>
                    <li><a href="http://www.eurosport.ru/" title="Eurosport" target="_blank">Eurosport</a></li>
               </ul>
    	</div>
        <div class="box">
        	<div class="box_head">
        	<p>Реклама</p>
    		</div>
            	<ul class="nav">
                	<li><a href="http://www.fischersports.com/us/Home" title="Fisher Ski" target="_blank">Fisher Ski</a></li>
                    <li><a href="http://www.swix.no/eway/default.aspx?pid=282" title="Swix" target="_blank">Swix</a></li>
                    <li><a href="http://madshus.com/" title="Madshus" target="_blank">Madshus</a></li>
                </ul>
    	</div>
  </aside>
  <article>
  <form action="reg.jsp" method="post">
  	<p style="font-size:18px;"><center>Регистрация</center></p>
      <p><b>Ваш логин:</b><br>
   <input type="text" size="40"  name="login" maxlength="30">
  </p>
   <p><b>Ваш e-mail:</b><br>
   <input type="text" size="40" name="e_mail" maxlength="20">
  </p>
  <p><b>Ваш пароль</b><br>
   <input type="password" size="40" name="password" maxlength="50">
  </p> 
  <p><input type="submit" value="Зарегестрироваться"></p>
  </form>
  </article>
  <div class="footer">
  <footer>
    <p>&copy;Copyright 2013</p>
    <!-- end .footer --></footer>
  </div>
  <!-- end .container --></div>
 
</body>
</html>

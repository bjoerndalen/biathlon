<%@page import="model.Sportsman"%>
<%@page import="model.Referee"%>
<%@page import="service.ServiceFactory"%>
<%@page import="model.User"%>
<%@page import="org.apache.axis.constants.Use"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<meta name="YURII" content="18.02.2013">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
    <<fmt:requestEncoding value="utf-8"/>
<title>Ukrainian Biathlon</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>

<body>
<jsp:useBean id="newuser" scope="page" class="model.User"></jsp:useBean>
<jsp:setProperty property="*" name="newuser" />
<c:if test="${not empty newuser.login }">
<%
if(newuser.getLogin().contains("Admin")&&newuser.getPassword().contains("199355")){
	%>
	<script language="JavaScript"> 
		  window.location.href = "../admin/index.jsp"
		</script>
	<%
}
	User u = ServiceFactory.DEFAULT.getUserService().getUserByLoginPass(newuser.getLogin(), newuser.getPassword());
	Referee r = ServiceFactory.DEFAULT.getRefereeService().getRefByFIOPass(newuser.getLogin(), newuser.getPassword());
	Sportsman s = ServiceFactory.DEFAULT.getSportsmanService().getStortsmanByFIOPass(newuser.getLogin(),newuser.getPassword());
	
	if(u!=null){
		session.setAttribute("use", u);
		System.out.println("USER ENTER");
		%>
		<script language="JavaScript"> 
		  window.location.href = "../user/main_last_result.jsp"
		</script>
	<%}else if(r!=null){
		session.setAttribute("referee", r);
		System.out.println("REFEREE ENTER");
		%>
		<script language="JavaScript"> 
		  window.location.href = "../referee/updt_startlist.jsp"
		</script>
	<%}else if(s!=null){
		session.setAttribute("sportsman",s);
		System.out.println("SPORTSMAN ENTER");
		%>
		<script language="JavaScript"> 
		  window.location.href = "../sportsman/main_last_race.jsp"
		</script>
		<%
	}else{
		System.out.println("NOBYDY ENTER");
		System.out.println(newuser.getLogin() +"  "+ newuser.getPassword());
	}
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
  	<p style="font-size:18px;"><center>Регистрация</center></p>
  	<form action="auth.jsp" method="post">
      <p><b>Ваш логин или пароль:</b><br>
   <input type="text" size="40" name="login">
  </p>
    <p><b>Ваш пароль</b><br>
   <input type="password" size="40" name="password">
  </p>
  <p><input type="submit" value="Войти"></p>
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

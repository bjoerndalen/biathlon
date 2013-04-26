<%@page import="DBAdmin.DBAdminWorking"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="model.*" %>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
    <<fmt:requestEncoding value="utf-8"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="YURII" content="18.02.2013">
<title>Ukrainian Biathlon</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>

<body>
<jsp:useBean id="delSp" scope="page" class="DBAdmin.ForDelSportsman"></jsp:useBean>
<jsp:setProperty property="*" name="delSp"/>

<%

	String name;

if(StringUtils.isNotEmpty(delSp.getId())){
	StringTokenizer st = new StringTokenizer(delSp.getId());
	String[] s = new String[st.countTokens()];
	 name = st.nextToken();
	 name = st.nextToken();
	 name = st.nextToken();
	 if(!DBAdminWorking.getInstance().delSportsmanByName(name)){
		 DBAdminWorking.getInstance().delRefereeByName(name);
	 }
} %>
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
                	<li><a href="adding.jsp" title="Добавление пользователей" target="_self">Добавление пользователей</a></li>
                    <li><a href="deleting.jsp" title="Удаление пользователей" target="_self">Удаление пользователей</a></li>
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
  	<p style="font-size:18px;"><center>Главная страница</center></p>
      <p>Количество посещений: </p>
       <p>Количество зарегестрированных пользователей:</p>
       <p>Из них болельщиков:</p>
       <p>Из них спортсменов:</p>
       <p>Из них судьей:</p>
       <p>Количество переходов по рекламе:</p>
       
  </article>
  <div class="footer">
  <footer>
    <p>&copy;Copyright 2013</p>
    <!-- end .footer --></footer>
  </div>
  <!-- end .container --></div>
 
</body>
</html>


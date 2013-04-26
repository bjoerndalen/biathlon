<%@page import="DBAdmin.DBAdminWorking"%>
<%@page import="model.*" %>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
html>
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
  	<p style="font-size:18px;"><center>Добавление нового пользователя в систему</center></p>
  	      <p><b>Должность пользователя :</b><br>
  <form action="deleting.jsp" method="get" id="1" enctype="multipart/form-data">
   <select name="role">
  <option>Спортсмен</option>
  <option>Судья</option>
</select>
  </p>
  <p>Country: </b>
  <select name="cntr">
  <%
  Collection<Country> lst = DBAdminWorking.getInstance().getCountry();
  for(Country cntr:lst){
	  %>
	  <option><%= cntr.getName()%></option>  
  <%}%>
</select></p>
  <p><b>ФИО:</b><br>
   <input type="text" size="40" name="fio">
  </p>
  <p><b>Password:</b><br>
   <input type="password" size="40" name="password">
  </p>
  <p><b>Пол</b><br>
  <select name="pol">
  <option>Male</option>
  <option>Female</option>
</select>
  </p>
  
  <p><input type="submit" value="Добавить"></p>
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

<%@page import="java.util.StringTokenizer"%>
<%@page import="service.ServiceFactory"%>
<%@page import="DBReferee.DBRefereeWorking"%>
<%@page import="java.util.Collection"%>
<%@page import="model.*"%>
<%@page import="java.sql.Time"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<html>
<head>
<meta charset="UTF-8">
<meta name="YURII" content="18.02.2013">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<
<fmt:requestEncoding value="utf-8" />
<title>Ukrainian Biathlon</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>

<body>

<div class="container">
  <header>
  	<a href="../main&registration&authorization/index.jsp" title="ИКС БИАТЛОН"><p>Биатлон</p></a>
  </header>
    
  <aside>
   	<div class="box">
      	<div class="box_head">
        		<p>Статистика</p>
    		</div>
            	<nav>
            	<ul class="nav">
					<li><a href="main_last_race.jsp" title="Результаты гонки" target="_self">Результаты гонки</a></li>
					<li><a href="speed.jsp" title="Статистика - скорость" target="_self">Статистика - скорость</a></li>
                    <li><a href="shooting.jsp" title="Статистика - стрельба" target="_self">Статистика - стрельба</a></li>
					<li><a href="points.jsp" title="Статистика - очки" target="_self">Статистика - очки</a></li>
                	</ul>
                </nav>
			</div>
	<div class="box">
      	<div class="box_head">
        		<p>Сообщения</p>
    	</div>
            	<nav>
            	<ul class="nav">
                	<li><a href="new_mes.jsp" title="Новое сообщение" target="_self">Новое сообщение</a></li>
                    <li><a href="incoming.jsp" title="Входящие" target="_self">Входящие</a></li>
					<li><a href="outcoming.jsp" title="Исходящие" target="_self">Исходящие</a></li>
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
  <p style="font-size:18px;"><center>Просмотр статистики по скорости</center></p>
  
		
  
        <div class="table">
		<table width="100%">
			<tr>
				<th width="30%">Название кубка</th>
				<th width="10%">Название гонки</th>
				<th width="20%">Финишное время</th>
				<th width="30%">Время без учета стрельбы</th>
			</tr>
			<%
			Sportsman sp = (Sportsman)session.getAttribute("sportsman");
			Collection<Result> rslt_list = ServiceFactory.DEFAULT.getSportsmanService().getAllResults(sp.getId());
			pageContext.setAttribute("rslt_list", rslt_list);
			%>
			<c:forEach var="buf" items="${rslt_list}">
			<tr>
				<td>${buf.race.cup.cupname}</td>
				<td>${buf.race.racename}</td>
				<td>${buf.alltime}</td>
				<td>${buf.timewoshotting}</td>
			</tr>
			</c:forEach>
		</table>
		</div>
		
  </article>
  <div class="footer">
  <footer>
    <p>&copy;Copyright 2013</p>
    <!-- end .footer --></footer>
  </div>
  <!-- end .container --></div>
 
</body>
</html>
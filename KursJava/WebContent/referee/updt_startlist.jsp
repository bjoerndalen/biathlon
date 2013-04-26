<%@page import="DBReferee.DBRefereeWorking"%>
<%@page import="java.util.Collection"%>
<%@page import="model.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<meta name="YURII" content="18.02.2013">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
    <<fmt:requestEncoding value="utf-8"/>
<title>Ukrainian Biathlon</title>
<link href="style.css" rel="stylesheet" type="text/css">

</head>

<body>

<div class="container">
  <header>
  	<a href="../main&registration&authorization/main.html" title="ИКС БИАТЛОН"><p>Биатлон</p></a>
  </header>
    
  <aside>
   	<div class="box">
      	<div class="box_head">
        		<p>Статистика</p>
    		</div>
            	<nav>
            	<ul class="nav">
					<li><a href="speed_statistics.html" title="Статистика - скорость" target="_self">Статистика - скорость</a></li>
                    <li><a href="shooting_statistics.html" title="Статистика - стрельба" target="_self">Статистика - стрельба</a></li>
                	<li><a href="new_results.html" title="Добавление результатов" target="_self">Добавление результатов</a></li>
                    <li><a href="updt_startlist.html" title="Редактирование списка стартующих" target="_self">Редактирование списка стартующих</a></li>
                    </ul>
                </nav>
			</div>
	<div class="box">
      	<div class="box_head">
        		<p>Сообщения</p>
    	</div>
            	<nav>
            	<ul class="nav">
                	<li><a href="new_mes.html" title="Новое сообщение" target="_self">Новое сообщение</a></li>
                    <li><a href="incoming.html" title="Входящие" target="_self">Входящие</a></li>
					<li><a href="outcoming.html" title="Исходящие" target="_self">Исходящие</a></li>
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
  <p style="font-size:18px;"><center>Редктирование списка стартующих</center></p>
  
       <p><b>Выберите кубок:</b><br>
			<select>
			<% Collection<Cup> cuplist = DBRefereeWorking.getInstance().getAllCups();
			for(Cup cup:cuplist){
			%>
			<option><%=cup.getCupname() %></option>	
			<%}
			
			%>
			</select>
				
		<p><b>Выберите гонку:</b><br>
			<select>
			
				<% Collection<Race> racelist = null;
				
				racelist = DBRefereeWorking.getInstance().getAllRaces();
				
				for(Race race:racelist){
			%>
			<option><%=race.getRacename() %></option>	
			<%}
			
			%>
			</select>
  
        <div class="table">
		<table width="100%">
			<tr>
				<th width="30%">Спортсмен</th>
				<th width="10%">Позиция</th>
				<th width="10%">Номер</th>
				<th width="30%">Примечания</th>
			</tr>
			<tr>
				<td>Bjoerndalen</td>
				<td>1</td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>Berger</td>
				<td>1</td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
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
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
<head>
<meta name="YURII" content="18.02.2013">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<
<fmt:requestEncoding value="utf-8" />
<title>Ukrainian Biathlon</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>

<body>
<jsp:useBean id="sp_name" scope="page" class="model.Sportsman"></jsp:useBean>
	<jsp:setProperty property="*" name="sp_name" />
<div class="container">
  <header>
  	<a href="../main&registration&authorization/index.jsp" title="ИКС БИАТЛОН"><p>Биатлон</p></a>
  </header>
    <c:if test="${not empty sp_name.password}">
    <%
    Sportsman upd_sp = (Sportsman)session.getAttribute("sp");
    session.removeAttribute("sp");
    upd_sp.setShooting(sp_name.getShooting());
    ServiceFactory.DEFAULT.getSportsmanService().updateEntity(upd_sp.getId(), upd_sp);
    %>
    </c:if>
  <aside>
   	<div class="box">
      	<div class="box_head">
        		<p>Статистика</p>
    		</div>
            	<nav>
            	<ul class="nav">
					<li><a href="shooting_statistics.jsp" title="Статистика - стрельба" target="_self">Статистика - стрельба</a></li>
                    <li><a href="updt_startlist.jsp" title="Редактирование результатов" target="_self">Редактирование результатов</a></li>
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
		<p style="font-size:18px;"><center>Статистика по стрельбе</center></p>
  <%
  Collection <Sportsman> sp_list = ServiceFactory.DEFAULT.getSportsmanService().getAllEntites();
  pageContext.setAttribute("sp_list", sp_list);
  %>
  <p>Выберете спортсмена для обновления статистики стрельбы</p>
  <form action="shooting_statistics.jsp" method="post">
  <select name = "fio">
  <c:forEach var="buf" items="${sp_list}">
  <option>${buf.fio}</option>
  </c:forEach>
  </select>
  <input type="submit" value="Выбрать">
  </form>
  
  
        <div class="table">
		<table>
			<tr>
				<th width="30%">Спортсмен</th>
				<th width="10%">Текущая статистика стрельбы</th>
				<th width="100%">Обновленное значение</th>
			</tr>
			<c:if test="${not empty sp_name.fio }">
  			<%
  			Sportsman sp = ServiceFactory.DEFAULT.getSportsmanService().findByName(sp_name.getFio());
  			session.setAttribute("sp", sp);
  			%>
  			</c:if>
			<form action="shooting_statistics.jsp" method="post">
			<tr>
				<td name="fio">${sp.fio}</td>
				<td name="shooting">${sp.shooting}</td>
				<td><input type="text" name="shooting">
				<input type="submit" value="Обновить"></td>
			</tr>
			<input type="hidden" value="qwerty" name="password">
			</form>
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
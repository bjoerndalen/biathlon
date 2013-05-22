<%@page import="service.ServiceFactory"%>
<%@page import="model.Referee"%>
<%@page import="DBAdmin.DBAdminWorking"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Sportsman"%>
<%@page import="model.Country"%>
<%@page import="java.util.*"%>
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

<%-- <jsp:useBean id="newSp" scope="page" class="model.Sportsman"></jsp:useBean>
<jsp:setProperty property="fio" name="newSp" param="fio"/>
<jsp:setProperty property="password" name="newSp" param="password"/>
<jsp:useBean id="fnsp" scope="page" class="DBAdmin.ForNewUser"></jsp:useBean>
<jsp:setProperty property="*" name="fnsp"/> --%>
<jsp:useBean id="del_sp" scope="page" class="model.Sportsman"></jsp:useBean>
<jsp:setProperty property="id" name="del_sp" param="id_sp_del"/>
<jsp:useBean id="del_ref" scope="page" class="model.Referee"></jsp:useBean>
<jsp:setProperty property="id" name="del_ref" param="del_id_ref"/>


<c:if test="${not empty del_sp.id}">
	<%
		ServiceFactory.DEFAULT.getSportsmanService().delEntity(del_sp.getId());
	%>
</c:if>

<c:if test="${not empty del_ref.id}">
	<%
		ServiceFactory.DEFAULT.getRefereeService().delEntity(del_ref.getId());
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
  	<p style="font-size:18px;"><center>Удаление пользователя в систему</center></p>
  	      
  	      <div class="table">
		<table width="100%">
			<tr>
				<th width="30%">ФИО</th>
				<th width="10%">ИД</th>
				<th width="20%">Страна</th>
				<th >Управление</th>
			</tr>
			<tr><td colspan="4">Sportsmans</td></tr>
		<%
		Collection<Sportsman> lst = ServiceFactory.DEFAULT.getSportsmanService().getAllEntites();
		pageContext.setAttribute("lst", lst);
		%>
		<c:forEach var="buf" items="${lst}">
			<tr>
				<td>${buf.fio }</td>
				<td>${buf.id }</td>
				<td>${buf.country.name }</td>
				<td>
					<form action="deleting.jsp" method="post">
						<input type="hidden" value="${buf.id}" name="id_sp_del">
						<input type="submit" name="id" value="Delete">
					</form>
				</td>
			</tr>
			</c:forEach>
			<tr><td colspan="4">Referees</td></tr>
			<%
				Collection<Referee> ls = ServiceFactory.DEFAULT.getRefereeService().getAllEntites();
				pageContext.setAttribute("ls", ls);
			%>
			<c:forEach var="buf" items="${ls}">
			<tr>
				<td>${buf.fio }</td>
				<td>${buf.id }</td>
				<td>${buf.contry}</td>
				<td>
					<form action="deleting.jsp" method="post">
						<input type="hidden" value="${buf.id}" name="del_id_ref">
						<input type="submit" value="Delete">
					</form>
				</td>
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
  </article>
  <!-- end .container --></div>
 
</body>
</html>

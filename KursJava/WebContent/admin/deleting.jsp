<%@page import="model.Referee"%>
<%@page import="DBAdmin.DBAdminWorking"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
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

<jsp:useBean id="newSp" scope="page" class="model.Sportsman"></jsp:useBean>
<jsp:setProperty property="*" name="newSp"/>
<jsp:useBean id="fnsp" scope="page" class="DBAdmin.ForNewUser"></jsp:useBean>
<jsp:setProperty property="*" name="fnsp"/>
<%

if(StringUtils.isNotEmpty(newSp.getFio())){
	System.out.println(fnsp.getRole());
	Country cntr = DBAdminWorking.getInstance().getCountrybyName(fnsp.getCntr());
	if(fnsp.getRole().length()==5){
		DBAdminWorking.getInstance().addReferee(newSp.getFio(), newSp.getPassword(), fnsp.getCntr());
	}else{
	if(fnsp.getPol()=="Male"){
		DBAdminWorking.getInstance().addSportsman(newSp.getFio(), cntr, newSp.getPassword(), true);
		
	}else{
		DBAdminWorking.getInstance().addSportsman(newSp.getFio(), cntr, newSp.getPassword(), false);	
	}
	}
	
	
	
}

%>


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
  	      <form action="index.jsp" method="get" id="1" enctype="multipart/form-data">
		<table width="100%">
			<tr>
				<th width="30%">ФИО</th>
				<th width="10%">ИД</th>
				<th width="20%">Страна</th>
				<th >Управление</th>
			</tr>
			<tr><td colspan="4">Sportsmans</td></tr>
		<%
		Collection<Sportsman> lst = DBAdminWorking.getInstance().getSportsman();
		for(Sportsman sp: lst){
		%>
		
			<tr>
				<td><%=sp.getFio() %></td>
				<td><%=sp.getId() %></td>
				<td><%=sp.getCountry().getName() %></td>
				<td>
					<input type="submit" name="id" value="Delete user <%=sp.getFio() %>">
				</td>
			</tr>
			<%} %>
			<tr><td colspan="4">Referees</td></tr>
			<%
		Collection<Referee> ls = DBAdminWorking.getInstance().getReferee();
		for(Referee sp: ls){
		%>
		
			<tr>
				<td><%=sp.getFio() %></td>
				<td><%=sp.getId() %></td>
				<td><%=sp.getContry() %></td>
				<td>
					<input type="submit" name="id" value="Delete user <%=sp.getFio() %>">
				</td>
			</tr>
			<%} %>
			
		</table>
		</form>
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

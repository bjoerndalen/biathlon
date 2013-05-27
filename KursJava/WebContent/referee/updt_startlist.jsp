<%@page import="java.util.ArrayList"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="service.ServiceFactory"%>
<%@page import="DBReferee.DBRefereeWorking"%>
<%@page import="java.util.Collection"%>
<%@page import="model.*"%>
<%@page import="java.sql.Time"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
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
	<jsp:useBean id="res" scope="page" class="model.Result"></jsp:useBean>
	<jsp:setProperty property="*" name="res" />
	<jsp:useBean id="for_time" scope="page" class="DBAdmin.ForNewUser"></jsp:useBean>
	<jsp:setProperty property="cntr" name="for_time" param="timeall" />
	<jsp:setProperty property="role" name="for_time" param="onlytime" />
	<jsp:useBean id="sp_name" scope="page" class="DBAdmin.ForDelSportsman"></jsp:useBean>
	<jsp:setProperty property="id" name="sp_name" param="fio" />
	<jsp:useBean id="fnsp" scope="page" class="DBAdmin.ForNewUser"></jsp:useBean>
	<jsp:setProperty property="pol" name="fnsp" param="cup_race" />

	<c:if test="${not empty fnsp.pol }">
		<%
			StringTokenizer stk = new StringTokenizer(fnsp.getPol(), "-");
				String cupName = stk.nextToken();
				String raceName = stk.nextToken();
				System.out.println(cupName);
				System.out.println(raceName);
				Race needRace = null;
				Cup cp = ServiceFactory.DEFAULT.getCupService().getCupByName(
						cupName);
				Collection<Race> lst_race = ServiceFactory.DEFAULT
						.getRaceService().getRacesByCup(cp);
				for (Race rc : lst_race) {
					if (rc.getRacename().contains(raceName)) {
						needRace = rc;
						break;
					}

				}
				Collection<Result> curResults = ServiceFactory.DEFAULT
						.getResultService().getAllResultsByRace(needRace);
				pageContext.setAttribute("cur_res", curResults);
				session.setAttribute("race", needRace);
		%>
	</c:if>

	<c:if test="${not empty sp_name.id}">
		<%
			Result rslt = new Result();
				Sportsman sp = ServiceFactory.DEFAULT.getSportsmanService()
						.findByName(sp_name.getId());
				rslt.setSportsman(sp);
				System.out.println(sp.getFio());
				rslt.setRace(((Race) session.getAttribute("race")));
				rslt.setShfalt(res.getShfalt());
				rslt.setPlace(res.getPlace());
				rslt.setAlltime(Time.valueOf(for_time.getCntr()));
				System.out.println(Time.valueOf(for_time.getCntr()));
				rslt.setTimewoshotting(Time.valueOf(for_time.getRole()));
				rslt.setNewpoints(4);
				System.out.println(((Race) session.getAttribute("race"))
						.getRacename());
						/*System.out.println(res.getShfalt());
						System.out.println(res.getPlace());
						System.out.println(for_time.getRole());
						Result rs = new Result();
						rs.setRace(((Race) session.getAttribute("race")));
						rs.setSportsman(sp);
						rs.setAlltime(Time.valueOf("00:12:22"));
						rs.setNewpoints(10);
						rs.setPlace(3);
						rs.setShfalt(2);
						rs.setTimewoshotting(Time.valueOf("00:11:10"));*/
				ServiceFactory.DEFAULT.getResultService().addEntity(rslt);
		%>
	</c:if>

	<div class="container">
		<header>
			<a href="../main&registration&authorization/index.jsp"
				title="ИКС БИАТЛОН"><p>Биатлон</p></a>
		</header>

		<aside>
			<div class="box">
				<div class="box_head">
					<p>Статистика</p>
				</div>
				<nav>
					<ul class="nav">
						<li><a href="shooting_statistics.jsp"
							title="Статистика - стрельба" target="_self">Статистика -
								стрельба</a></li>
						<li><a href="updt_startlist.jsp"
							title="Редактирование результатов" target="_self">Редактирование
								результатов</a></li>
					</ul>
				</nav>
			</div>
			<div class="box">
				<div class="box_head">
					<p>Сообщения</p>
				</div>
				<nav>
					<ul class="nav">
						<li><a href="new_mes.jsp" title="Новое сообщение"
							target="_self">Новое сообщение</a></li>
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
					<li><a href="http://www.biathlon.com.ua"
						title="Федерация биатлона Украины" target="_blank">Федерация
							биатлона Украины</a></li>
					<li><a href="http://www4.biathlonworld.com/ru/home.html"
						title="Международный союз биатлонистов" target="_blank">Международный
							союз биатлонистов</a></li>
					<li><a
						href="http://services.biathlonresults.com/Datacenter_IBU.aspx"
						title="Siwidata" target="_blank">Siwidata</a></li>
					<li><a href="http://www.eurosport.ru/" title="Eurosport"
						target="_blank">Eurosport</a></li>
				</ul>
			</div>
			<div class="box">
				<div class="box_head">
					<p>Реклама</p>
				</div>
				<ul class="nav">
					<li><a href="http://www.fischersports.com/us/Home"
						title="Fisher Ski" target="_blank">Fisher Ski</a></li>
					<li><a href="http://www.swix.no/eway/default.aspx?pid=282"
						title="Swix" target="_blank">Swix</a></li>
					<li><a href="http://madshus.com/" title="Madshus"
						target="_blank">Madshus</a></li>
				</ul>
			</div>
		</aside>
		<article>
			<p style="font-size: 18px;">
			<center>Редктирование результатов</center>
			</p>
			<form action="updt_startlist.jsp" method="get">
				<p>
					<b>Выберите гонку:</b><br> <select name="cup_race">
						<%
							Collection<Cup> cuplist = ServiceFactory.DEFAULT.getCupService()
									.getAllEntites();
							pageContext.setAttribute("cuplist", cuplist);
						%>
						<c:forEach var="cup" items="${cuplist}">
							<%
								Cup cp = (Cup) pageContext.getAttribute("cup");
									Collection<Race> lst_race = ServiceFactory.DEFAULT
											.getCupService().getRecesFromCup(cp);
									pageContext.setAttribute("rc_lst", lst_race);
							%>
							<c:forEach var="race" items="${rc_lst}">
							<c:if test="${race.referee.id==referee.id}">
								<option>${cup.cupname}-${race.racename}</option>
								</c:if>
							</c:forEach>
						</c:forEach>
					</select> <input type="submit" value="Показaть">
			</form>
			<div class="table">
				<table width="100%">
					<tr>
						<th width="30%">Спортсмен</th>
						<th width="10%">Позиция</th>
						<th width="10%">Количество промахов</th>
						<th width="30%">Общее время гонки</th>
						<th width="30%">Время гонки на лыжне</th>

					</tr>
					<c:forEach var="crc" items="${cur_res}">
						<tr>
							<td>${crc.sportsman.fio}</td>
							<td>${crc.place}</td>
							<td>${crc.shfalt}</td>
							<td>${crc.alltime}</td>
							<td>${crc.timewoshotting}</td>
						</tr>
						<form></form>
					</c:forEach>
					<%
					Collection<Sportsman> sp_list = ServiceFactory.DEFAULT.getSportsmanService().getAllEntites();
					pageContext.setAttribute("sp_list", sp_list);
					%>
					<form action="updt_startlist.jsp" method="post">
						<tr>
							<td>
							<select name="fio">
							<c:forEach var="sp" items="${sp_list}">
							<option>${sp.fio}</option>
							</c:forEach>
							</select>
							</td>
							<td><input type="text" name="place" size="10"></td>
							<td><input type="text" name="shfalt" size="10"></td>
							<td><input type="text" name="timeall" size="10"></td>
							<td><input type="text" name="onlytime" size="10"></td>
						</tr>
						<tr>
							<td colspan="5"><input type="submit"
								value="Добавить Результат"></td>
						</tr>
					</form>
				</table>
			</div>

		</article>
		<div class="footer">
			<footer>
				<p>&copy;Copyright 2013</p>
				<!-- end .footer -->
			</footer>
		</div>
		<!-- end .container -->
	</div>

</body>
</html>
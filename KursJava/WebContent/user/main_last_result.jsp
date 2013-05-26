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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
        		<p>Навигация</p>
    		</div>
            	<nav>
            	<ul class="nav">
                	<li><a href="countries.jsp" title="Зачет стран" target="_self">Зачет стран</a></li>
                    <li><a href="man.jsp" title="Зачеты кубков среди мужчин" target="_self">Зачеты кубков среди мужчин</a></li>
                    <li><a href="lady.jsp" title="Зачеты кубков среди женщин" target="_self">Зачеты кубков среди женщин</a></li>
                    <li><a href="results.jsp" title="Результаты гонок" target="_self">Результаты гонок</a>
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

  	<center><p style="font-size:18px;">Результаты поледней гонки:</p></center>
	<p style="font-size:18px;">Результаты гонки спринт, мужчины, 10км. Этап кубка мира в Сочи.</p>
	  <div class="table">
  	      <table width="80%" border="1" cellspacing="0" cellpadding="4" align="center">
		  <tr>
		  <th>Позиция</th>
		  <th>Спортсмен</th>
		  <th>Страна</th>
		  <th>Количество промахов</th>
		  <th>Время на финише</th>
		  <th>Время без стрельбы</th>
		  <th>Количество заработанных очков</th>
		  
		  </tr>
		  
		  
		  <tr>
		  <td>1</td>
		  <td>Иванов</td>
		  <td>Украина</td>
		  <td>0</td>
		  <td>10,00</td>
		  <td>9,00</td>
		  <td>100</td>
		  
		  </tr>
		  
		  
		  <tr>
		  <td>2</td>
		  <td>Петров</td>
		  <td>Россия</td>
		  <td>1</td>
		  <td>10,25</td>
		  <td>9,15</td>
		  <td>93</td>
		  
		  </tr>
		  
		  
		  <tr>
		  <td>3</td>
		  <td>Сидоров</td>
		  <td>Конго</td>
		  <td>10</td>
		  <td>15,25</td>
		  <td>10,00</td>
		  <td>84</td>
		  
		  </tr>
		  
		  <tr>
		  <td>...</td>
		  <td>...</td>
		  <td>...</td>
		  <td>...</td>
		  <td>...</td>
		  <td>...</td>
		  <td>...</td>
		  
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
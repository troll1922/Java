<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Web App Rest</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.11.2.min.js" type="text/javascript"></script>
<script src="js/script.js" type="text/javascript"></script>
</head>
<body>
		<div id="header">
			<h2><a href="/rest">RESTful - сервис</a></h2>
		</div>  
		<h3>Реализация CRUD для сущности User</h3>
		<div id="inputDataUser">
			<table>
				<tr><td>Id</td><td><input id="Id" /></td></tr>
				<tr><td>User_name</td><td><input id="user_name" /></td></tr>
				<tr><td>Money</td><td><input id="money" /></td></tr>
				<tr><td>E-mail</td><td><input id="email" /></td></tr>
			</table>
		</div>
		<div id="buttonUser">
			<button type="button" onclick="RestGet()">GET</button>
			<button type="button" onclick="RestPost()">POST</button>
			<button type="button" onclick="RestPut()">PUT</button>
			<button type="button" onclick="RestDelete()">DELETE</button>
		</div>
		<div id="data"></div>
		<p><h3>Покупка товара пользователем c Id <input id="Id_user" size="2" /></h3></p>
		<table>
			<tr><td>Название продукта</td><td><input id="productName" /></td></tr>
			<tr><td>Цена</td><td><input id="price" /></td></tr>
			<tr><td>Категория</td><td><input id="category" /> <br/></td></tr>
			<tr><td>Описание</td><td><input id="description" /></td></tr>
		</table>
		<div id="record">
			<button type="button" onclick="RestBuy()">Записать покупку в БД</button> <br/>
		</div>
		<div id="footer">
			<h5>Задание выполнил Фомичёв А.В.</h5>
		</div>
</body>
</html>
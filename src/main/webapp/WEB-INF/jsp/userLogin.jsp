<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>登录界面</title>

<link rel="stylesheet" type="text/css" href="/statics/css/userLogin.css">
<script type="text/javascript" src="/statics/js/jquery-1.12.4.js" ></script>
	<script type="text/javascript" src="/statics/js/userLogin.js" ></script>
</head>
<body>

<div id="container">
	<div id="output">
		<div class="containerT">
			<p>用户登录</p>
			<form class="form" id="entry_form" action="/doLogin.html" method="post" name="myForm">
				<ul id="Myul">
					<li><input type="radio" value="0" name="role" id="0" checked="checked" /><label for="0">用户登录</label></li>
					<li><input type="radio" value="1" name="role" id="1"/><label for="1">房主登录</label></li>
					<li><input type="radio" value="2" name="role" id="2"/><label for="2">后台登录</label></li>
				</ul>
				<input type="text" placeholder="用户名" id="entry_name" class="wenben" name="userName">
				<input type="password" placeholder="密码" id="entry_password" class="wenben" name="passWord">
				<ul id="Mya">
					<li><a href="#">其他登录方式</a></li>
					<li><a href="#">前往注册</a></li>
					<li><a href="#">忘记密码</a></li>
				</ul>
				<p align="center">${error}</p>
				<button type="submit" id="entry_btn" >登录</button>
				<div id="prompt" class="prompt"></div>
			</form>
		</div>
	</div>
</div>

</body>
</html>
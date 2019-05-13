<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>找回密码</title>
  <meta name="description" content="particles.js is a lightweight JavaScript library for creating particles.">
  <meta name="author" content="Vincent Garreau" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <link rel="stylesheet" media="screen" href="/statics/css/findPwd.css">
  <link rel="stylesheet" type="text/css" href="/statics/css/reset.css"/>
</head>
<body>

<form action="javascript:void(0)" method="post">
<div id="particles-js">
		<div class="login">
			<div class="login-top">
				找回密码
			</div>
			<div class="login-center clearfix">
				<div class="login-center-img"><img src="/statics/img/l_img/name.png"/></div>
				<div class="login-center-input">
					<input type="text" name="userName" value="" placeholder="请输入您的用户名" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的用户名'"/>
					<div class="login-center-input-text">用户名</div>
				</div>
			</div>
			<div class="login-center clearfix">
				<div class="login-center-img"><img src="/statics/img/l_img/password.png"/></div>
				<div class="login-center-input">
					<input type="number" name="phone" placeholder="请输入手机预留号码" onfocus="this.placeholder=''" onblur="this.placeholder='请输入手机预留号码'"/>
					<div class="login-center-input-text">预留号码</div>
				</div>
			</div>
			<div class="login-center clearfix">
				<div class="login-center-img"><img src="/statics/img/l_img/yanzhengma.png"/></div>
				<div class="login-center-input">
					<input type="number" name="yanzhengma" value="" placeholder="请输入验证码" onfocus="this.placeholder=''" onblur="this.placeholder='请输入验证码'" id="yanzhengma"/>
					<input type="button" value="获取验证码" id="yanzhengmabtn" onclick="getnumber()"/>
					<div class="login-center-input-text">验证码</div>
				</div>
			</div>
				<input type="button" name="" id="finPwds" value="找回密码" class="login-button" onclick="getPwds()"/>
		</div>
		
		<div class="sk-rotating-plane"></div>
</div>
</form>

<script src="/statics/js/particles.min.js"></script>
<script src="/statics/js/app.js"></script>
<script type="text/javascript" src="/statics/js/jquery-1.12.4.js" ></script>
<script type="text/javascript" src="/statics/js/findPwd.js" ></script>
</body>
</html>
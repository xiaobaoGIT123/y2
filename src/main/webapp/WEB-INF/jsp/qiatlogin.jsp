<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>找回密码</title>
  
</head>
<body>

		<div class="login">
			<div class="login-top">
				手机验证登录
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
				<input type="button" name="" id="qitalogin" value="登录" class="login-button" onclick="getPwds()"/>
		</div>
<link rel="stylesheet" media="screen" href="/statics/css/qiatlogin.css">
<script type="text/javascript" src="/statics/js/jquery-1.12.4.js" ></script>
<script type="text/javascript" src="/statics/js/qitalogin.js" ></script>

</body>
</html>
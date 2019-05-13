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
				</ul>
				<input type="text" placeholder="用户名" id="entry_name" class="wenben" name="userName">
				<input type="password" placeholder="密码" id="entry_password" class="wenben" name="passWord">
				<ul id="Mya">
					<li><a href="/qitalogin.html">其他登录方式</a></li>
					<li><a href="#">前往注册</a></li>
					<li><a href="/findPwd.html">找回密码</a></li>
				</ul>
				<div align="center" style="color: red;font-size: 20px;margin-bottom: 10px" class="error">${error}</div>
				<button type="submit" id="entry_btn" >登录</button>
				<div id="prompt" class="prompt"></div>
			</form>

			<%--<div id="qita">--%>

					<%--<p>手机号码:<input type="text" name="phone"/></p>--%>
					<%--<p>--%>
						<%--验证码:<input type="number" name="yanzhengma"/>--%>
						<%--<input type="button" name="yanzhengbtn" value="获取验证码"/>--%>
					<%--</p>--%>
					<%--<p><input type="button" name="getyanzhengma" value="登录"/></p>--%>

			<%--</div>--%>
		</div>
	</div>
</div>

</body>
</html>
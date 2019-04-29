<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>

		<link rel="stylesheet" href="/statics/css/userInfo.css" />
	</head>
	<body>
		<div class="info">
			<div class="top">
				
			</div>
			<div class="user">
				<table >
					<tr><th colspan="2"><img src="/statics/img/c_img/c_touxiang.png"/></th></tr>
					<tr><th colspan="2">你说适合市商店飞</th></tr>
					<tr><th>手机号码:</th><th>32165165</th></tr>
					
					<tr><th colspan="2"><a href="#" class="fabu">修改密码</a> </th></tr>
					<tr><th colspan="2"><a href="#" class="fabu">发布房源</a> </th></tr>
					<tr><th colspan="2"><a href="#" class="fabu">修改我的信息</a></th></tr>
				</table>
			</div>
			
			<!--消息-->
			<div class="messageRight">
			<div id="page">
			
			<p align="center">
				<input type="button" value="未读信息" onclick="weidu(this)"/>
			<input type="button" value="历史记录" onclick="lishi(this)"/>
			</p>
			
			<!--未读信息div-->
			<div class="unreadMessage">
				
			
			
			</div>
			<!--历史记录div-->
			<div class="yesMessage">
					
			</div>
		</div>
			</div>
		</div>

		<script type="text/javascript" src="/statics/js/jquery-1.12.4.js" ></script>
		<script src="/statics/js/userInfo.js"></script>
	</body>
</html>

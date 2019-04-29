<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<style type="text/css">
			
		</style>
		<link rel="stylesheet" href="/statics/css/registered.css" />
	</head>
	<body>
		
		<div class="container">
			<p><input type="button" value="房主注册" class="qiehuan" onclick="qiehuan(this)"/></p>
			<!--普通用户注册-->
			<div class="userRegister">
				<form id="myForm" action="test.html" enctype="multipart/form-data">
				<table >
				
				<tr><th colspan="2"><h2>用户注册</h2></th></tr>
				<tr><td>用户名&nbsp;：</td><td><input name="nickName" type="text" placeholder="请在这里输入您的昵称" isEmpty=""><span></span> </td></tr>
				<tr><td> 密&nbsp;&nbsp;&nbsp;&nbsp;码：</td><td><input name="passWord"  type="text" placeholder="请输入您的密码" isEmpty=""><span></span></td></tr>
				<tr><td> 确认密码：</td><td><input name="confirm_passWord"  type="text" placeholder="两次密码必须一致" isEmpty=""><span></span></td></tr>
				<tr><td>上传头像：</td><td><input name="headPicture" type="file" value="" isEmpty="" /></td></tr>
				<tr><td> 身份证号码:</td><td><input name='cadid'  type='text' placeholder='输入身份证号码' isEmpty=""><span> </span></td></tr>
				<tr><td>手机号码：</td><td><input name="phone" type="text" size="10" isEmpty=""><span></span><input type="button" value="获取验证码" id="yzm"/> </td></tr>
				<tr><td>验证码：</td><td><input name="code" type="text" placeholder="输入验证码" isEmpty=""><span></span></td></tr>
				<tr><th colspan="2"><input type="submit" value="注册"></input><input type="button" value="取消"></input></th></tr>
	
				</table>
			</form>
			</div>
			
			
			
		</div>
		<script type="text/javascript" src="/statics/js/jquery-1.12.4.js" ></script>
		<script src="/statics/js/registered.js"></script>
	</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>


<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link href="/statics/css/userlogin.css" type="text/css" rel="stylesheet" />



	</head>
	<body>
		<div class="container">
		<form method="post" action="/user/addSave.html?role=${roleId}" id="myForm" enctype="multipart/form-data">
			
					<div><span>${user}</span>注册</div>
				
			<table>
				
				
				<tr>
					<td>用户名:</td>
					<td><input type="text" name="userName" placeholder="请在此处输入你的昵称"/></td>
					<td><span id="tishi"></span></td>
				</tr>
				<tr>
					<td>密码:</td>
					<td><input type="password" name="passWord" placeholder="输入密码"></td>
					<td><span></span></td>
				</tr>
				
				<tr>
					<td>确认密码:</td>
					<td><input type="password" name="rePassWord" placeholder="两次密码必须一致"></td>
					<td><span></span></td>
				</tr>
				
				<tr>
					<td>上传头像:</td>
					<td><input type="file" name="Picture" /></td>
					<td><span></span></td>
				</tr>
				
				<tr>
					<td>手机号码:</td>
					<td><input type="text" name="phone" placeholder="用来接收验证码"></td>
					<td><input type="button" value="获取验证码" id="yzm"></td>
				</tr>
				<tr>
					<td>验证码:</td>
					<td><input type="text" name="reCode" placeholder="输入接收的验证码" ></td>
					<td><span></span></td>
				</tr>
				
				<tr>
					<td>身份证号码:</td>
					<td><input type="text" name="userCardId" placeholder="输入身份证号码"  ></td>
					<td><span></span></td>
				</tr>
				
				<tr>
					<th colspan="3">
						<input name="1122"   type="submit" value="提交"/>
						 <input name="1122"   type="reset" value="重置"/>


					</th>
				</tr>
				
			</table>
			
		</form>
		</div>
		<script type="text/javascript" src="/statics/js/jquery-1.12.4.js"></script>
		<script src="/statics/js/registered.js"></script>
	</body>

</html>

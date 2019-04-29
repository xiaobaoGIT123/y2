<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>房子详细信息页面</title>
	
		<link rel="stylesheet" href="/statics/css/houseInfo.css" />
		<meta charset="UTF-8"/>

	</head>
	<body>
		<div class="house_info">
			<div class="house_back">
				<input type="image" src="c_img/c_back.png" id="back"/><a href="userInfo.jsp" class="user">独占阳台看万家灯火<img src="c_img/c_touxiang.png"/></a>
			</div>
			<!--房子信息-->
			<div class="house_imgdiv">
				<div class="houseimg">
					<input type="hidden" name="hid" value="ssss" />
					<!--<img src="img/5a94f9cs.jpg" /><img src="img/5a94f9cs.jpg" />
					<img src="img/5a94f9cs.jpg" />-->
					<p>备注:旁边就是小学,小孩子上学非常方便,前面两百米就是地铁站,出行也非常方便</p>
					<p>地址:金码大厦18楼602</p>
					
				</div>
				<div class="houseInfo">
					
					
					<p class="houseInfo_p">
						<span>两室一厅</span><span>简单装修</span><span>家电齐全</span>
					<span>有阳台</span>
					</p>
					<div class="houseuser">
						<table>
							<tr><th ><a href="#"><img src="c_img/touxiang2.png"/></a></th><th >飞翔的鸽子</th></tr>
							<tr><th colspan="2">1500/月</th></tr>
							<tr><th colspan="2"><a href="javascript:void(0)" onclick="showMeSend()">发送消息给房东</a></th></tr>
							<tr><td>联系方式:</td><td >131123121212</td></tr>
						</table>
					</div>
				</div>
				
			</div>
			<div class="house_write">
				<textarea name=""  class="messageBox"  maxlength="100"  ></textarea>
				<!--发送 清空-->
				<input type="image" src="c_img/c_send.png" class="send" onclick="send()"/>
				<input type="image" src="c_img/c_empty.png" class="empty" onclick="emptyMessageBox()"/>
				
			</div>
			<!--评论-->
			<div class="house_message">

			</div>
			
		</div>
		
		
		
		<div class="weibu">
			
		</div>
		<!--举报框-->
		<div id="report" align="center">
			<h2>请填写举报理由</h2>
			<form action="" method="post">
				<textarea  ></textarea>
				<p class="jinggao">举报须知:<br/>黄赌毒请举报<br/>请不要瞎举报,不然封号</p>
				<p><input type="submit" value="提交"/><input type="button" id="" value="关闭" onclick="hidebox()"/></p>
			</form>
		</div>
		<!--发送消息框-->
		<div class="mesSend">
			<p class="close_mesSend"><input type="image" src="c_img/c_closeBut.jpg" onclick="closeMesSend()"/></p>
			<div class="mse_record">
				<p><img src="c_img/c_touxiang.png" /> ? 请不要瞎举报,不然封号请不要瞎举报,不然封号请不要瞎举报,不然封号请不要瞎举报,不然封号请不要瞎举报,不然封号请不要瞎举报,不然封号请不要瞎举报,不然封号</p>
				<p class="Imes">你是hh吗?<img src="c_img/c_touxiang.png" /></p>
				<p class="Imes">你是hh吗?<img src="c_img/c_touxiang.png" /></p>
				<p class="Imes">你是hh吗?<img src="c_img/c_touxiang.png" /></p>
				<p class="Imes">你是hh吗?<img src="c_img/c_touxiang.png" /></p>
				<p class="Imes">你是hh吗?<img src="c_img/c_touxiang.png" /></p>
				<p class="Imes">你是hh吗?<img src="c_img/c_touxiang.png" /></p>
				<p class="Imes">你是hh吗?<img src="c_img/c_touxiang.png" /></p>
				<p class="Imes">你是hh吗?<img src="c_img/c_touxiang.png" /></p>
				<p class="Imes">你是hh吗?<img src="c_img/c_touxiang.png" /></p>
				<p class="Imes">你是hh吗?<img src="c_img/c_touxiang.png" /></p>
				<p class="Imes">你是hh吗?<img src="c_img/c_touxiang.png" /></p>
				<p class="Imes">你是hh吗?<img src="c_img/c_touxiang.png" /></p>
			</div>
			
			<div class="chatMessages">
				<textarea></textarea>
			</div>
			<!---->
			<p><input type="button" value="发送" onclick="fasong()"/> </p>
		</div>
		<script type="text/javascript" src="/statics/js/jquery-1.12.4.js" ></script>
		<script src="/statics/js/houseInfo.js"></script>
	</body>

</html>

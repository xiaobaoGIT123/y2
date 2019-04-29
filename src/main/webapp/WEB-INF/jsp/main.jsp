<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>主界面</title>
		<link rel="stylesheet" href="/statics/css/main.css" />
		<script type="text/javascript" src="/statics/js/jquery-1.12.4.js" ></script>
		<script src="/statics/js/main.js" ></script>
	</head>

	<body>

		<div id="bigbox">
			<%--这个span是用户id隐藏域--%>
			<span id="userId" style="display: none"></span>
			<%--这个span是用户头像隐藏域--%>
			<span id="headPicture" style="display: none"></span>
			<%--这个span是用户角色隐藏域--%>
			<span id="role" style="display: none"></span>



			<!--用户名div-->
				<div id="UserType">
					<div>
						<p align="left">
							<img src="/statics/img/l_img/undercheck.png"/>
							<span>您好！请登录</span>
						</p>
					</div>

					<a href="javascript:void(0)" id="addHouse" onclick="addHouse()">发布房源</a>
				</div>
			<!--头部-->
			<header>
				<div id="div1">
					<ul>
						<li><img src="/statics/img/l_img/head_1.png" alt=""></li>
						<li><img src="/statics/img/l_img/head_2.png" alt=""></li>
						<li><img src="/statics/img/l_img/head_3.png" alt=""></li>
						<li><img src="/statics/img/l_img/head_4.png" alt=""></li>
					</ul>
				</div>
			</header>
			<a href="javascript:void(0)" id="goOut" style="float: right;margin-top: 10px;font-size: 14px;display: none;" onclick="goOut();">退出登录</a>
			<!--主体-->
			<section>
				<!--左边登录、注册框、最新资讯-->
				<div id="logindiv">
					<p>
						<input type="button" value="登录" name="Gointo" />
						<input type="button" value="注册" name="Gonews" />
					</p>
					<!--登录表单框-->
					<div id="Loginfrom">
						<form action="javascript:void(0)" method="post" id="myForm">
							<table>
								<!--登录形态单选按钮-->
								<tr>
									<td colspan="3" align="center">
										<input type="radio" value="0" name="role" checked="checked" />用户
										<input type="radio" value="1" name="role" />房主
										<input type="radio" value="2" name="role" />后台
									</td>
								</tr>
								<tr>
									<td colspan="3" align="center">用户名:<input type="text" name="userName" /></td>
								</tr>
								<tr>
									<td colspan="3" align="right">密&nbsp;&nbsp;&nbsp;码:<input type="password" name="passWord" /><br/>
										<a href="#">第三方登录</a>&nbsp;|&nbsp;
										<a href="#">找回密码</a>
									</td>
								</tr>
								<tr>
									<td colspan="3" align="center"><span></span></td>
								</tr>
								<tr align="center">
									<td>
										<input type="button" name="subisok" value="登录" />
									</td>
									<td></td>
									<td>
										<input type="reset" name="btnexit" value="重置" />
									</td>
								</tr>

							</table>
						</form>

					</div>

					<span id="newhomes">↓↓↓最新房源资讯↓↓↓</span>
					<!--最新房源资讯div-->
					<div id="news" onmouseover="tz()" onmouseout="ks()">
						<ul id="p1">
						<c:forEach items="${houseList}" var="li">
							<li>
								<a href="">${li.houseTitle}</a>
							</li>
						</c:forEach>
						</ul>
						<ul id="p2"></ul>
					</div>

				</div>

				<!--搜索、房源信息展示div-->
				<div id="homeShow">
					<!--房源搜索-->
					<div id="findhome">
						
						<form action="#" method="post">

						<p>
							<input type="radio" value="hometype" name="homeradio" checked="checked"/>根据房源类型查询
							<input type="radio" value="price" name="homeradio" />根据房源价格查询
						</p>
						<div>
							<!--下拉框，根据房源类型查询-->
							<select id="s1" name="houseTypeId">
								<option value="0">选择房源类型</option>
								<option value="1">单间</option>
								<option value="2">一室一厅</option>
								<option value="3">二室一厅</option>
								<option value="4">二室二厅</option>
								<option value="5">三室一厅</option>
								<option value="6">四室一厅</option>
								<option value="7">其它类型</option>
								
							</select>
							<!--下拉框，根据房源价格查询-->
							<select id="s2" name="housePrice">
								<option>选择房源价格</option>
								<option>100元~500元</option>
								<option>100元~500元</option>
								<option>100元~500元</option>
								<option>100元~500元</option>
								<option>100元~500元</option>
							</select>
							
							<input type="text" name="houseAddress" placeholder=" 请输入房子的描述,支持模糊查询..." />
							<input type="submit" value="搜索房源" name="finds" id="finds"/>
						</div>
						
						</form>

					</div>
					<!--房源展示框-->
					<div id="lookhome">
						<!--房源详细信息-->
						<c:forEach items="${houseList}" var="li">
						<div class="showhome">
							<img src="/statics/img/l_img/undercheck.png" />
							<table>
								<tr>
									<td>发布时间：2018-12-21&nbsp;&nbsp;&nbsp;</td>
									<td>房子类型：三室一厅&nbsp;&nbsp;&nbsp;</td>
									<td>房子价格：1500/月</td>
								</tr>
								<tr>

									<td colspan="2">房子地址：${li.houseAddress}&nbsp;&nbsp;&nbsp;</td>
									<td>
										<a href="#">详细信息</a>
									</td>
								</tr>
							</table>
						</div>
						</c:forEach>


					<!--上一页下一页按钮-->
					<div id="pageBtn">
						<ul>
							<li>
								<a href="#">首页</a>
							</li>
							<li>
								<a href="#">上一页</a>
							</li>
							<li>
								<a href="#">下一页</a>
							</li>
							<li>
								<a href="#">末页</a>
							</li>
						</ul>
					</div>
				</div>
            </section>

			<!--尾部-->
			<footer id="footdiv">
				<div id="onediv">
					<table style="margin: 0 auto;">
						<tr>
							<td rowspan="9" colspan="2"><img src="/statics/img/l_img/undercheck.png" /></td>
						</tr>
						<tr>
							<td id="youhui">
								&nbsp;&nbsp;&nbsp;如发现图片盗用<br /> &nbsp;&nbsp;&nbsp;
								<strong>侵犯了您的合法权益</strong><br/> &nbsp;&nbsp;&nbsp;请扫描二维码和管理员取得联系！
							</td>
						</tr>
					</table>

					<!--友情链接-->
					<h2>友情链接...</h2>
					<ul>
						<li>
							<a href="https://www.baidu.com/">百度搜索</a>&nbsp;&nbsp;&nbsp;|</li>
						<li>
							<a href="https://www.ctrip.com/">携程旅行</a>&nbsp;&nbsp;&nbsp;|</li>
						<li>
							<a href="https://www.12306.cn/">12306</a>&nbsp;&nbsp;&nbsp;|</li>
						<li>
							<a href="https://qzone.qq.com/">腾讯空间</a>&nbsp;&nbsp;&nbsp;|</li>
						<li>
							<a href="https://mail.126.com/">126邮箱</a>&nbsp;&nbsp;&nbsp;|</li>
						<li>
							<a href="https://pan.baidu.com/">百度网盘</a>&nbsp;&nbsp;&nbsp;|</li>
						<li>
							<a href="https://fanyi.baidu.com/">百度翻译</a>&nbsp;&nbsp;&nbsp;|</li>
						<li>
							<a href="https://tieba.baidu.com/index.html">百度贴吧</a>&nbsp;&nbsp;&nbsp;|</li>
						<li>
							<a href="http://xiuxiu.web.meitu.com/">美图秀秀</a>&nbsp;&nbsp;&nbsp; </li>
					</ul>
					<p>
						互联网食品信息服务资格证书:(沪)-经营性-2019-0011 |沪ICP备 999999999 | 上海工商行政管理 Copyright ©2019-2 东莞北大青鸟菜鸟编辑, All Rights Reserved.
					</p>
				</div>
			</footer>
		</div>
	</body>
		

</html>
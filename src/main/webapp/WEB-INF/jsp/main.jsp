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
			<span id="userId" style="display: none">${userSession.uid}</span>
			<%--这个span是用户头像隐藏域--%>
			<span id="headPicture" style="display: none">${userSession.headPicture}</span>
			<%--这个span是用户角色隐藏域--%>
			<span id="role" style="display: none">${userSession.role}</span>
				<!--头部-->
				<header>
					<%--<img src="/statics/img/l_img/headimg.png" style="width: 88%;height: 95px;" align="right"/>--%>
					<!--用户名div-->
					<div id="UserType">
						<div>
							<p align="left">
								<c:if test="${userSession==null}">
									<img src="/statics/img/l_img/tou.png"/>
								</c:if>
								<c:if test="${userSession.headPicture!=null}">
									<img src="/statics/img/l_img/head_1.png"/>
								</c:if>
								<span>
									<a href="#" style="text-decoration: none;color: white;">${userSession.userName}</a>
									<img src="/statics/img/l_img/tongzhi.png" style="width: 20px;height: 20px;"/>
								</span>
							</p>
						</div>

						<a href="javascript:void(0)" id="addHouse" onclick="addHouse()">发布房源</a>
					</div>



				</header>

			<a href="javascript:void(0)" id="goOut" style="float: right;margin-top: 5px;font-size: 14px;display: none;" onclick="goOut()">退出登录</a>

		<!--主体-->
			<section>
				<!--左边登录、注册框、最新资讯-->
				<div id="logindiv">
					<p>
						<input type="button" value="登录" name="Gointo" />
						<input type="button" value="注册" name="Gonews" />
					</p>

					<span id="newhomes">最 新 房 源 资 讯</span>
					<!--最新房源资讯div-->
					<div id="news" onmouseover="tz()" onmouseout="ks()">
						<ul id="p1">
						<c:forEach items="${playerList}" var="li">
							<li>
								<a href="">${li.houseAddress}</a>
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

						<form action="/getList.html" method="post">

							<p>
								<input type="radio" value="hometype" name="homeradio" id="hometype" checked="checked"/><label for="hometype">根据房源类型查询</label>
								<input type="radio" value="price" name="homeradio" id="price"/><label for="price">根据房源价格查询</label>
							</p>

							<div>
								<!--下拉框，根据房源类型查询-->
								<select id="s1" name="houseTypeId" >
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
									<option value="0/0">选择房源价格</option>
									<option value="100/300">100元--300元</option>
									<option value="300/600">300元--600元</option>
									<option value="600/900">600元--900元</option>
									<option value="900/1200">900元--1200元</option>
									<option value="1200/1500">1200元--1500元</option>
								</select>

								<input type="text" name="houseAddress" placeholder=" 请输入房源地址,支持模糊查询..." />
								<input type="submit" value="搜索房源" name="finds" id="finds"/>
							</div>

						</form>

					</div>
					<!--房源展示框-->
					<div id="lookhome">
						<!--房源详细信息-->
                        <div id="selectdiv" class="scrollbar">
                            <h3 align="center">${number}</h3>
						<c:forEach items="${houseList}" var="li">
						<div class="showhome">
							<c:if test="${li.housePicture==''}">
								<img src="/statics/img/l_img/moren.png" title="房主还未上传图片"/>
							</c:if>
							<c:if test="${li.housePicture!=''}">
								<img src="/statics/uploadfiles/${li.housePicture}" title="房源图片"/>
							</c:if>
							<table>
								<tr>
									<td>发布时间：${li.houseTime}&nbsp;&nbsp;&nbsp;</td>
									<td>房源类型：${li.type}&nbsp;&nbsp;&nbsp;</td>
									<td>房源价格：${li.housePrice}</td>
								</tr>
								<tr>
									<td colspan="2">房源地址：${li.houseAddress}</td>
									<td><a href="#">房源详细信息</a></td>
								</tr>

							</table>
						</div>
						</c:forEach>
                        </div>
                    </div>
                </div>
            </section>

			<!--尾部-->
			<footer id="footdiv">
				<div id="onediv">
					<table style="margin: 0 auto;">
						<tr>
							<td rowspan="9" colspan="2"><img src="/statics/img/l_img/undercheck.png" style="width: 100px;height: 100px"/></td>
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
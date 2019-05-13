<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>发布房源</title>
		<link rel="stylesheet" href="/statics/css/addHouse.css" />

		<script type="text/javascript" src="/statics/js/jquery-1.12.4.js"></script>
		<script type="text/javascript" src="/statics/js/addHouse1.js" ></script>
		

	</head>

	<!--*******************************************************************************************-->

	<body>
		<!--全局div-->
		<div id="all">
			<!--发布房源div-->
			<div id="addHome">
				<h1 align="center">新房源发布</h1>

				<form action="/addHome.html" method="post" enctype="multipart/form-data" id="Myform">

                    <!--基本信息-->
                    <fieldset id="add1">
                        <legend> 基本信息 </legend>
                        <div id="houseinput">

                            <ul>
                                <li>
                                    房源地址:<input type="text" name="houseAddress" />
                                    房源类型:
                                    <select name="houseTypeId">
                                        <option value="0">选择类型</option>
                                        <option value="1">单间</option>
                                        <option value="2">一室一厅</option>
                                        <option value="3">二室一厅</option>
                                        <option value="4">二室二厅</option>
                                        <option value="5">三室一厅</option>
                                        <option value="6">四室一厅</option>
                                        <option value="7">其它类型</option>
                                    </select>
                                </li>
                                <li>
                                    房源状态:<input type="text" name="houseStatus" readonly="readonly" />
                                    房源价格:<input type="text" name="housePrice" />
                                </li>
                                <li>
                                    房源面积:<input type="text" name="houseArea" />
                                    房源标签:<input type="text" name="houseLabel" />
                                </li>
                                <li>
                                    房源标题:<input type="text" name="houseTitle" />
                                    <span style="text-align: center;color: red">${uploadError}</span>
                                </li>
                                <li>
                                    房源描述:<input type="text" name="houseDescribe" style="width:495px"/>
                                </li>
                            </ul>
                        </div>
                    </fieldset>

                    <!--图片上传-->
                    <fieldset id="add2">
                        <legend>图片上传</legend>

                        <p align="center"><strong>*房源图片不是必须的，若您未选择上传图片，系统将统一展示默认图片*</strong> <br/>
                            <span style="color: red;">
							----在您发布房源之前请先认真阅读服务条款---<br/>
							-----------------------------------------------------
							-----------------------------------------------
						</span>

                        </p>
                        <!--上传图片控件-->
                        <div class="container">

                            <input type="file" id="file_input" name="file_input" multiple="multiple" />
                        </div>

                    </fieldset>

					<input type="submit" id="submit"  value="提 交 房 源 信 息" align="center" />
				</form>
                    <button id="select">选择图片</button>
			</div>

		</div>
	</body>

</html>
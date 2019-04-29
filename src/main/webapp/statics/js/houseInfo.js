//随机数
			function nuber(num){
				var s =  Math.random()*num+1;
			return Math.round(s);
			}
			
			var a=["#FFA500","#FF7F00","#FF69B4","#EED5D2","#EEC900","#D1EEEE","#FF33FF","#99CCCC","#9999FF","#33FFCC","#66FF66","#3366FF","#3399CC"];
			
			var mydate = new Date();
			$(function(){
				appendSpanToHouseInfo();
				fillPicture();
//				alert(getDate());
			
			})
			
			//获取时间
			function getDate(){
				var date = new Date();
		var n = date.getFullYear();
		var y = date.getMonth()+1;
		var t = date.getDate();
		var h = date.getHours();
		var m = date.getMinutes();
		var s = date.getSeconds();
		var time = n+"-"+y+"-"+t+" "+h+":"+m+":"+s;
		return time;
			}
			//按键
//			function KeyDown()
//{
//if (event.keyCode == 13)
//{
//  alert("ssss");
//
//}
//}
			//填充图片
			function fillPicture(){
				var $Picture = $("<img src='c_img/5a94f9cs.jpg' />");
				$($Picture).addClass("hous");
				$(".houseimg").prepend($Picture);
				
			}
			//添加房子标签
			function appendSpanToHouseInfo(){
				var $spans = $("<span>一房二厅</span>");
				$($spans).css("background-color","gold");
				$(".houseInfo_p").append($spans);
			}
			//发布评论
			function send(){
				var neirong=$(".messageBox").val();
//				userid 后台拿取
//				alert($("input[name='hid']").val())

				if(neirong != ""){
					
//					$.post("",{neirong:neirong,hid:hid},function(data){
//						
//						//发送成功显示在界面
//					})
					
					
					
					var $p = $("<div class='mestiao'><div class='nei'><a href='#'><p><img src='c_img/c_touxiang.png' class='touxiang'/></p><p>我是一个粉刷匠</p></a></div><div class='pinglunRight'><div class='pinglun'><p>"+neirong+
				"</p></div><div class='ju'><a href='#' class='jubao' onclick='showbox()'>举报</a><p>&nbsp;</p><p>"+getDate()+
					"</p></div></div></div>");
				$(".house_message").prepend($p);
				}
				
			}
			//清空评论
			function emptyMessageBox(){
				
				$(".messageBox").val("");
			}
			//点击举报
			function showbox(){
				$("#report").show();
			}
			function hidebox(){
				$("#report").hide();
			}
			
			//关闭发送消息框
			function closeMesSend(){
				$(".mesSend").hide();
			}
			//发送消息给房东
			function showMeSend(){
				$(".mesSend").show();
				
			}
			
function fasong(){
	var fid=$("").val();
	var uid=$("").val();
	var coonex=$("chatMessages textarea").val();
	
	$.post("",{fid:fid,uid:uid,coonex:coonex},function(data){
		
		//发送给
	},"JSON")
	
	$(".mse_record").append("<p class='Imes'>你55555?<img src='c_img/c_touxiang.png' /></p>");
}

$(function(){
	var mesSend = $(".mesSend");
	mesSend.scrollTop(mesSend[0].scrollHeight);
	
})
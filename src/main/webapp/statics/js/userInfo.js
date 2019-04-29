
			$(function(){
				$(".unreadMessage").html("");
				$(".unreadMessage").append("<div class='userMessage'><a class='tim'>23</a><p><a href='#'><img src='c_img/c_touxiang.png'/>用户名6<span>未读信息div</span></a></p></div>");
			})
			
			//点击未读信息
			function weidu(mo){
				$(mo).css({"background-color":"#CCFFCC"});
				$("input[value='历史记录']").css({"background-color":"#DDD"});
				$(".unreadMessage").css({"display":"block"});
				$(".yesMessage").css("display","none");
				
				$(".unreadMessage").html("");
				$(".unreadMessage").append("<div class='userMessage'><a class='tim'>23</a><p><a href='#'><img src='c_img/c_touxiang.png'/>用户名6<span>未读信息div</span></a></p></div>");
				
			}
			//点击历史信息
			function lishi(mo){
				$(mo).css({"background-color":"#CCFFCC"});
				$("input[value='未读信息']").css({"background-color":"#DDD"});
				$(".yesMessage").css("display","block");
				$(".unreadMessage").css("display","none");
				
				
				
				$(".yesMessage").html("");
				$(".yesMessage").append("<div class='userMessage'><a class='tim'>23</a><p><a href='#'><img src='c_img/c_touxiang.png'/>用户名6<span>未读信息div</span></a></p></div>")
			}
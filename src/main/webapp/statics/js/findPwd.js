var yanzhengmanumber=0;
$(function() {
	//禁用输入框
	$("input[name='yanzhengma']").attr("readonly","true")

})
//点击获取验证码
function getnumber() {

	var userName = $("input[name='userName']").val(); //用户名
	var phone = $("input[name='phone']").val(); //预留号码
	var yanzhengma = $("input[name='yanzhengma']").val(); //验证码

	if(userName == "") {
		return alert("请输入用户名");
	} else if(phone == "") {
		return alert("请输入预留号码");
	}else if(!(/^1[34578]\d{9}$/.test(phone))){
		return alert("手机号码格式不正确");
	}else{
		//前往后台查询数据库是否存在此用户
		$.ajax({
			type:"post",
			url:"/changUser.html",
			data:{userName:userName,phone:phone},
			dataType:"json",
			success:function (data) {

				if(data==0){
					alert("不存在此用户...")
				}else if(data==1){
					alert("你输入的手机号码不是你注册时的预留号码...")
				}else if(data==2){//确认存在这个用户以及预留号码正确
					//启用输入框
					$("input[name='yanzhengma']").removeAttr("readonly")
					//执行定时器
					btnCheck();
					//开始发送验证码
					$.ajax({
						type:"post",
						url:"/faSong.html",
						data:{phone:phone},
						dataType:"json",
						success:function (data){
							if(data==119){
								alert("获取验证码失败，具体原因请联系开发者察看后台...")
							}else{

								yanzhengmanumber=data;
							}
					}
					})
				}
			}
		})


	}

}

//点击找回密码
function getPwds(){
	var userName = $("input[name='userName']").val(); //用户名
	var phone = $("input[name='phone']").val(); //预留号码
	var yanzhengma = $("input[name='yanzhengma']").val(); //验证码
	if(userName==""){
		return alert("请输入用户名");
	}else if(phone==""){
		return alert("请输入预留号码");
	}else if(!(/^1[34578]\d{9}$/.test(phone))){
		return alert("手机号码格式不正确");
	}else if(yanzhengma==""){
		return alert("请输入验证码");
	}else{
		var phone = $("input[name='phone']").val(); //预留号码
		//开始修改密码
		if(yanzhengma==yanzhengmanumber){
			alert("验证成功！");
			var passWord=phone.substring(5);

			$.ajax({
				type:"post",
				url:"/uopdateByNumber.html",
				data:{phone:phone,passWord:passWord},
				dataType:"json",
				success:function (data) {
					if(data==1){
						alert("系统为您重新更改了密码，您的新密码为预留号码的后6位");
						//跳转到主界面
						window.location.href="/login.html";
					}else{
						alert("密码找回失败,请联系管理员询问具体情况");
					}
				}

			})

		}else {
			alert("验证码错误...");
		}
		
	}
	
}

//设置获取验证码定时器
function btnCheck() {
  
          $("#yanzhengmabtn").addClass("on");
  
         var time = 60;
 
         $("#yanzhengmabtn").attr("disabled", true);
 
         var timer = setInterval(function() {
 
             if (time == 0) {
 
                 clearInterval(timer);//清除定时器
 
                 $("#yanzhengmabtn").attr("disabled", false);
 
                 $("#yanzhengmabtn").val("获取验证码");
 
                 $("#yanzhengmabtn").removeClass("on");
 
             } else {
                 
                 $('#yanzhengmabtn').val(time + "秒");
                 
                 time--;
 
             }
 
         }, 1000);
 
     }
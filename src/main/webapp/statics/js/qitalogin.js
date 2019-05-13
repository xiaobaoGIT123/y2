$(function () {
    //禁用输入框
    $("input[name='yanzhengma']").attr("readonly","true")
})
//点击获取验证码
function getnumber() {

	var phone = $("input[name='phone']").val(); //预留号码
	if(phone == "") {
		return alert("请输入预留号码");
	}else if(!(/^1[34578]\d{9}$/.test(phone))){
		return alert("手机号码格式不正确..");
	}else{


		//执行定时器
		btnCheck();

//		$.ajax({
//			type: "post",
//			url: "/loginOut.html",
//			data: {
//				userName: userName,
//				phone: phone
//			},
//			dataType: "json",
//			success: function(data) {
//
//				alert(userName + phone)
//
//			}
//		})
	}

}

//点击登录
function getPwds(){

	var yanzhengma = $("input[name='yanzhengma']").val(); //验证码
	if(yanzhengma==""){
		return alert("请输入验证码");
	}else{
		
	}
	
}

//设置获取验证码定时器
function btnCheck() {
  
          $("#yanzhengmabtn").addClass("on");
  
         var time = 5;
 
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
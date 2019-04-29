//点击未读信息


var nickName = null;
var passWord = null;
var confirm_passWord = null;
var cadid = null;
var phone = null;
var code = null;



			var ok=true;
			function qiehuan(one){
				
				if(ok){
					$(one).css({"background-color":"#FF9933"});
					$(one).attr("value","用户注册")
					$("table tr:eq(5)").show();
					
					 ok = false;
				}else{
					$(one).css({"background-color":"#99CCCC"});
					$(one).attr("value","房主注册")
					$("table tr:eq(5)").hide();
					ok = true;
				}
			}
			

			
$(function(){
	nickName =$("input[name='nickName']");
	passWord =$("input[name='passWord']");
	confirm_passWord =$("input[name='confirm_passWord']");
	cadid  =$("input[name='cadid']"); 
	phone =$("input[name='phone']");
	code=$("input[name='code']");
	
	$("input[type='text']").next().html("*");
	$("input[type='text']").next().css({"color":"red"});
	//初始隐藏
	$("table tr:eq(5)").hide();
	
	//验证用户名是否重复
	nickName.blur(function(){
		var name = $(this).val();
		if(name==null || name=="" || (name.length<6)){
			yes(this);
		}else{
//			$.getJSON("",{nickName:nickName.val()},function(result){
//			if(result){
//				//存在  失败
//				yes(this);
//			}else{
//			no(this);
//				//成功
//			}
//		})
			no(this);
		}
	})
	//密码
	passWord.blur(function(){
//		 || (passWord.length<6)
		if(passWord.val()=="" || (passWord.val().length<5)){

			yes(passWord);
		}else{

			no(passWord);
		}
	})
	//二次密码
	confirm_passWord.blur(function(){
		if(confirm_passWord.val()!= passWord.val()){
			yes(confirm_passWord);
		}else{
			no(confirm_passWord);
		}
	})
	
	//身份证号码
	cadid.blur(function(){
		if(cadid.length<18){
			yes(cadid);
		}else{
			no(cadid);
		}
	})
	
	//手机号码
	phone.blur(function(){
		var pone = /^1[3|4|5|8][0-9]\d{8}$/ ;
		var nou =phone.val().trim();
		if(pone.test(nou)){
			
			no(phone);
		}else{
			
			yes(phone);
		}
	})
	
	//点击获取验证码
	$("#yzm").click(function(){
		//后台判断是否过期，否则不能再次获取
		
		var p =phone.attr("isEmpty");
		if( p!= "yes" && p !=""){
			$.getJSON("",{phone:phone.val()},function(data){
				if(data=="no"){
					//不能再次获取
					
					yes(phone);
				}else if(data=="error"){
					//验证码错误
					
					yes(phone);
				}else{
					//成功
					
					no(phone);
				}
			})
		}else{
			yes(phone);
		}
		
	})
	
	//验证码  后台session 保存
	code.blur(function(){
		$.getJSON("",{code:code.val()},function(data){
			if(data){//验证码不正确
				yes(code);
			}else{
				no(code);
			}
		})
	})
	
	

	function no(dom){
		$(dom).next().html("<img src='c_img/c_yes.png' width='20px' height='20px'/>");
		$(dom).attr("isEmpty","no");
	}
	function yes(dom){
		$(dom).next().html("<img src='c_img/c_schu.png' width='20px' height='20px'/>");
		$(dom).attr("isEmpty","yes");
	}
	
	
	$("#myForm").submit(function(){
		if(nickName.attr("isEmpty") != "no"){
			nickName.blur();
			return false;
		}else if(passWord.attr("isEmpty") != "no"){
			passWord.blur();
			return false;
		}else if(confirm_passWord.attr("isEmpty") != "no"){
			confirm_passWord.blur();
			return false;
		}else if(cadid.attr("isEmpty") != "no"){//???
			cadid.blur();
			return false;
		}else if(phone.attr("isEmpty") != "no"){
			phone.blur();
			return false;
		}else if(code.attr("isEmpty") != "no"){
			code.blur();
			return false;
		}
		return true;
	})
	
	
	
	
	
	
	
})

var  code=null;
$(function () {

    $("#myForm").submit(function () {
        var userName = $("input[name='userName']").val();
        var passWord = $("input[name='passWord']").val();
        var rePassWord = $("input[name='rePassWord']").val();
        var reCode = $("input[name='reCode']").val();
        var userCardId = $("input[name='userCardId']").val();
        var phone = $("input[name='phone']").val();
        var format=/^[1][3,4,5,6,7,8,9][0-9]{9}$/;


        if (userName == "") {
            alert("用户名不能为空！");
            return false;
        } else if (userName.length<4 ) {
            alert("用户名长度不能小于4位字符！");
            return false;
        } else if (userName.length>10) {
            alert("用户名长度不能大于10位字符！");
            return false;
        } else if (passWord == "") {
            alert("密码不能为空！");
            return false;
        } else if (rePassWord == "") {
            alert("确认密码框不能为空！");
            return false;
        } else if (passWord != rePassWord) {
            alert("两次密码不一致，请重新输入密码！");
            return false;
        } else if (!format.test(phone)) {
            alert("手机号码格式不正确！");
            return false;
        } else if (userCardId == "") {
            alert("身份证框不能为空！");
            return false;
        }else if (userCardId.length!=18) {
            alert("请输入正确位数的身份证号码！");
            return false;
        } else if (reCode!=code) {
            alert(code+"====="+reCode);
            alert("验证码不正确！");
            return false;
        }
        return true;
    })


    $("input[type='text']").next().html("*");
    $("input[type='text']").next().css({"color": "red"});



    $("input[name='userName']").blur( function () {
        //ajax后台验证--userName是否已存在

        var userName =$("input[name='userName']").val();
    if(userName==""){

    }else{

        // var  uName=decodeURIComponent(userName);
        $.post("/user/ucexist.html",{ userName: userName},function (data) {

            if ( data.ok== "ok") {//账号可用，正确提示


            } else {//账号已存在，错误提示
                $("input[name='userName']").val("");
               $("#tishi").html("用户名已存在")
            }
        },"JSON")

    }




    });




   //点击获取验证码
    $("#yzm").click(function () {
        //后台判断是否过期，否则不能再次获取

        var phone = $("input[name='phone']").val()
        alert("获取验证码111")
        if (phone != "") {

            $.getJSON("/user/getCode.html", {phone: phone}, function (data) {
                alert(data);
                if (data == "") {

                alert("验证码错误")
                }else{
                    //成功

                    code= data;
                    alert(code+"验证码")
                }
            })
        } else {
            alert("请先填写电话")
        }

    })


})
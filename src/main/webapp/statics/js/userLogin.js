$(function () {
    //非空
    $("#entry_form").submit(function () {
        var userName = $("input[name='userName']").val();//用户名
        var passWord = $("input[name='passWord']").val();//密码
        if(userName==""){
            alert("请输入用户名...");
            return false;
        }else if(passWord==""){
            alert("请输入密码...");
            return false;
        }
            return true;
    })
    //用户名获得焦点
    $("input[name='userName']").focus(function () {
        $(".error").html("");
    })

})

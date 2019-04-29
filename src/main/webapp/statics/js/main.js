//加载时
$(function () {
    //最新资讯滚动条方法
    lun();

    //单击登录时表单显示，并且底部的功能禁用
    $("input[name='Gointo']").click(function () {
        $(this).css("background", "#76EEC6");
        var type = $("#Loginfrom").css("display");
        if (type == "none") {
            //表单滑出
            $("#Loginfrom").slideDown(500);
            //底层div禁用
            $("#homeShow").css("pointer-events", "none");
        } else {
            $(this).css("background", "#DBDBDB");
            //表单收起
            $("#Loginfrom").slideUp(500);
            //底层div启用
            $("#homeShow").css("pointer-events", "auto");
        }

    });

    //查询显示的房源信息隔行改变颜色
    $("#homeShow .showhome:odd").css("background", "white");


    //单选按钮被单击时
    $("input[name='homeradio']").click(function () {

        var anniu = $("input[name='homeradio']:checked").val();
        if (anniu == "price") {

            $("#s2").show();
            $("#s1").hide();
        } else {
            $("#s2").hide();
            $("#s1").show();
        }

    })

    //ajax方式登录
    $("input[name='subisok']").click(function () {

        var role = $("input[name='role']:checked").val();//单选按钮值
        var userName = $("input[name='userName']").val();//用户名
        var passWord = $("input[name='passWord']").val();//密码

        if (userName == "") {
            alert("请输入用户名！");
        } else if (passWord == "") {
            alert("请输入密码！");
        } else {
            //清空提示语句
            $("#Loginfrom span").html("");
            //清空用户名
            $("#UserType h4").html("");
            //ajax方式登录
            $.ajax({
                type: "post",
                url: "/doLogin.html",
                data: {role: role, userName: userName, passWord: passWord},
                dataType: "json",
                success: function (data) {
                    alert("回调函数》》" + data);
                    if (data != null && data != "") {
                        //用户输入框禁用
                        $("input[name='userName']").attr("disabled","disabled")
                        $("input[name='passWord']").attr("disabled","disabled")
                        //显示退出按钮
                        $("#goOut").css("display", "block");
                        //清空用户名密码
                        $("input[name='userName']").val("");
                        $("input[name='passWord']").val("");
                        //显示头部用户名
                        $("#UserType span").html(data.userName);
                        //登录按钮禁用
                        $("input[name='subisok']").attr("disabled","disabled");
                        //给隐藏域赋值
                        $("#userId").html(data.uid);
                        $("#role").html(data.role);
                        $("#headPicture").html(data.headPicture);
                        //提示语句
                        $("#Loginfrom span").html("已是登录状态,请勿重复登录");
                        alert("欢迎你" + data.userName);
                        //表单收起
                        $("#Loginfrom").slideUp(1000);
                    } else {
                        $("#Loginfrom span").html("用户名或密码错误！...");
                    }
                }
            });
        }
    });
    //用户输入框获取焦点时
    $("input[name='userName']").focus(function () {
        //清空提示语句
        $("#Loginfrom span").html("");
    })
});

//退出的方法
function goOut() {

    if (confirm("确定要退出吗？")) {
        //清空
        $("#UserType span").html("您好，请登录");
        //清空提示语句
        $("#Loginfrom span").html("");
        //清空隐藏域内容
        $("#userId").html("");
        $("#role").html("");
        $("#headPicture").html("");
        //隐藏退出按钮
        $("#goOut").css("display", "none");
        //登录按钮启用
        $("input[name='subisok']").removeAttr("disabled");
        //用户输入框启用
        $("input[name='userName']").removeAttr("disabled")
        $("input[name='passWord']").removeAttr("disabled")
        alert("已成功退出！");
    }
}
//点击添加房源的方法
function addHouse(){
    var id= $("#userId").text().trim();//获取隐藏域用户id
    var role= $("#role").text().trim();//获取隐藏域用户角色
    if(id==""){
        alert("您还未登录，请登录过后再进行新房源发布！");
        //表单滑出
        $("#Loginfrom").slideDown(500);
    }else if(role!=1){
        alert("您当前的账户为普通用户，请升级为房主用户再进行新房源发布！");
    }else {
       window.location.href="/add.html";
        // window.open('/add.html?userId=$("#userId").text().trim()');

    }

}


//头部滚播
window.onload = function () {
    var oDiv = document.getElementById('div1'); //头部滚播图片div
    var oUl = document.getElementsByTagName('ul')[0];
    var Li = oUl.getElementsByTagName('li'); //获取ul下的所有li
    oUl.innerHTML = oUl.innerHTML + oUl.innerHTML; //li下的内容进行想加
    oUl.style.width = Li[0].offsetWidth * Li.length + 'px'; //ul的宽度等于每个li的宽度乘以所有li的长度
    var speed = 2

    //主方法
    function move() {
        //如果左边横向滚动了长度一半之后,回到初始位置
        if (oUl.offsetLeft < -oUl.offsetWidth / speed) {
            oUl.style.left = '0'
        }
        //如果右边横向滚动的距离大于0 就让他的位置回到一半
        if (oUl.offsetLeft > 0) {
            oUl.style.left = -oUl.offsetWidth / speed + 'px';
        }
        oUl.style.left = oUl.offsetLeft - 2 + 'px'; //进行左横向滚动
        //oUl.style.left = oUl.offsetLeft + speed + 'px'; //进行右横向滚动
    }

    //调用方法
    var timer = setInterval(move, 50)
    //鼠标指向的时候 暂停
    oDiv.onmouseover = function () {
        clearInterval(timer);
    }
    //鼠标离开之后 继续滚动
    oDiv.onmouseout = function () {
        timer = setInterval(move, 50)
    }
}

//最新资讯滚动条方法
function lun() {
    var n = document.getElementById("news");
    var p1 = document.getElementById("p1");
    var p2 = document.getElementById("p2");
    p2.innerHTML = p1.innerHTML;
    //alert(n.offsetHeight+" 1  "+p1.offsetHeight);
    var f = function () {
        n.scrollTop++;
        if (n.scrollTop >= p1.offsetHeight) { //alert(n.scrollTop+" 1  "+p1.offsetHeight);
            n.scrollTop = 0;
        }
    }
    var i = setInterval(f, 60);
    var tz = function () {
        clearInterval(i);
    }
    var ks = function () {
        i = setInterval(f, 60);
    }
    $("#news").hover(tz, ks);
}
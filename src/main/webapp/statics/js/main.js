//加载时
$(function () {
    //最新资讯滚动条方法
    lun();

    //查询显示的房源信息隔行改变颜色
    $("#homeShow .showhome:odd").css("background", "#A4D3EE");

    //单击登录时表单显示，并且底部的功能禁用
    $("input[name='Gointo']").click(function () {

        location.href="/userLogin.html";

    });

    //查询单选按钮被单击时
    $("input[name='homeradio']").click(function () {

        var anniu = $("input[name='homeradio']:checked").val();
        $("input[name='houseAddress']").val("");//清空房源
        if (anniu == "price") {
            $("#s2").show();
            $("#s1 option:first").prop("selected", 'selected');
            $("#s1").hide();
        } else {
            $("#s2 option:first").prop("selected", 'selected');
            $("#s2").hide();
            $("#s1").show();
        }
    })

    //判断登录状态的方法
    loginChang();

});

//判断登录状态的方法
function loginChang(){
    //获取隐藏域的值
    var userId=$("#userId").text().trim();
    var role=$("#role").text().trim();
    var headPicture=$("#headPicture").text().trim();

    if(userId==""){//如果登录失败

    }else{
        //显示退出按钮
        $("#goOut").css("display", "block");

        //登录按钮禁用
        $("input[name='Gointo']").attr("disabled","disabled");
    }
}

//退出的方法
function goOut() {

    if (confirm("确定要退出吗？")) {
        $("input[name='Gointo']").removeAttr("disabled");
        location.href="/loginOut.html";

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
       window.location.href="/add.html?userId=$(\"#userId\").text().trim()";
       //  window.open('/add.html?userId=$("#userId").text().trim()');

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
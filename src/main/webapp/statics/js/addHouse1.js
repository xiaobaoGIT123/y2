
			$(function() {

				//加载页面时，功能按钮盒子动画显示
				$("#addHome").fadeTo(2500, 1);
				//非空
				$("#Myform").submit(function(){

					var houseAddress=$("input[name='houseAddress']").val().trim();//房源地址
					var houseTypeId=$("select[name='houseTypeId']").val().trim();//房源类型
					var housePrice=$("input[name='housePrice']").val().trim();//房源价格
					var houseArea=$("input[name='houseArea']").val().trim();//房源面积
					var houseLabel=$("input[name='houseLabel']").val().trim();//房源标签
					var houseDescribe=$("input[name='houseDescribe']").val().trim();//房源描述

					if(houseAddress=="" || houseAddress==null){
						alert("请输入房源地址");
						return false;
					}else if(houseTypeId==0){
						alert("请输入房源类型");
						return false;
					}else if(housePrice=="" || housePrice==null){
						alert("请输入房源价格");
						return false;
					}else if(houseArea=="" || houseArea==null){
						alert("请输入房源面积");
						return false;
					}else if(houseLabel=="" || houseLabel==null){
						alert("请输入房源标签");
						return false;
					}else if(houseDescribe=="" || houseDescribe==null){
						alert("请输入房源描述");
						return false;
					}
						return true;
				});
			});
			
			
			window.onload = function(){    
    var input = document.getElementById("file_input");    
    var result;    
    var dataArr = []; // 储存所选图片的结果(文件名和base64数据)  
    var fd;  //FormData方式发送请求    
    var oSelect = document.getElementById("select");  
    var oAdd = document.getElementById("add");  
    var oSubmit = document.getElementById("submit");  
    var oInput = document.getElementById("file_input");  
     
    if(typeof FileReader==='undefined'){    
        alert("抱歉，你的浏览器不支持 FileReader");    
        input.setAttribute('disabled','disabled');    
    }else{    
        input.addEventListener('change',readFile,false);    
    }　　　　　//handler    
    
        
    function readFile(){   
        fd = new FormData();    
        var iLen = this.files.length;
        if(iLen > 3) {
            oInput.value="";
            return alert("最多上传3张，请重新选择");
        }

        for(var i=0;i<iLen;i++){  
            if (!input['value'].match(/.jpg|.gif|.png|.jpeg|.bmp/i)){　　//判断上传文件格式    
                return alert("上传的图片格式不正确，请重新选择");    
            }  
            var reader = new FileReader();  
            fd.append(i,this.files[i]);  
            reader.readAsDataURL(this.files[i]);  //转成base64    
            reader.fileName = this.files[i].name;  
  
            reader.onload = function(e){   
                var imgMsg = {    
                    name : this.fileName,//获取文件名    
                    base64 : this.result   //reader.readAsDataURL方法执行完后，base64数据储存在reader.result里    
				}   
                dataArr.push(imgMsg);    
                result = '<div class="result"><img class="subPic" src="'+this.result+'" alt="'+this.fileName+'"/></div>';
                var div = document.createElement('div');  
                div.innerHTML = result;    
                div['className'] = 'float';  
                document.getElementsByTagName('body')[0].appendChild(div);  　　//插入dom树    
                var img = div.getElementsByTagName('img')[0];  
                img.onload = function(){    
                    var nowHeight = ReSizePic(this); //设置图片大小    
                    this.parentNode.style.display = 'block';    
                    var oParent = this.parentNode;    
                    if(nowHeight){    
                        oParent.style.paddingTop = (oParent.offsetHeight - nowHeight)/2 + 'px';    
                    }    
                }   

            }    
        }    
    }    
        
               

    oSelect.onclick=function(){   
        oInput.value = "";   // 先将oInput值清空，否则选择图片与上次相同时change事件不会触发  
        //清空已选图片  
        $('.float').remove();        
        oInput.click();   
    }   

    oAdd.onclick=function(){  
        oInput.value = "";   // 先将oInput值清空，否则选择图片与上次相同时change事件不会触发  
        oInput.click();   
    }   
  
} 

function ReSizePic(ThisPic) {    
    var RePicWidth = 100; //这里修改为您想显示的宽度值    
    
    var TrueWidth = ThisPic.width; //图片实际宽度    
    var TrueHeight = ThisPic.height; //图片实际高度    
        
    if(TrueWidth>TrueHeight){    
        //宽大于高    
        var reWidth = RePicWidth;    
        ThisPic.width = reWidth;    
        //垂直居中    
        var nowHeight = TrueHeight * (reWidth/TrueWidth);    
        return nowHeight;  //将图片修改后的高度返回，供垂直居中用    
    }else{    
        //宽小于高    
        var reHeight = RePicWidth;    
        ThisPic.height = reHeight;    
    }    
} 



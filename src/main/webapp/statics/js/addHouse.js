var iLen; //长传图片的数量；

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


			window.onload = function() {
				var input = document.getElementById("file_input");
				var result; //预览图片的变量名
				var sss;
				var dataArr = []; // 储存所选图片的结果(文件名和base64数据)  
				var fd; //FormData方式发送请求    
				var oSelect = document.getElementById("select"); //添加图片按钮
				var oInput = document.getElementById("file_input"); //图片文件名
				var submits=document.getElementById("submit");//提交按钮

				if(typeof FileReader === 'undefined') {
					alert("抱歉，你的浏览器不支持 FileReader");
					input.setAttribute('disabled', 'disabled');
				} else {
					input.addEventListener('change', readFile, false);
				}　　　　


				//选择图片并且显示出来
				function readFile() {
					fd = new FormData();
					iLen = this.files.length; //上传图片的数量
					if(iLen > 3) {
						return alert("最多上传3张，请重新选择");
					}

					for(var i = 0; i < iLen; i++) {
						if(!input['value'].match(/.jpg|.gif|.png|.jpeg|.bmp/i)) {　　 //判断上传文件格式    
							return alert("上传的图片格式不正确，请重新选择");
						}
						var reader = new FileReader();
						fd.append(i, this.files[i]);
						reader.readAsDataURL(this.files[i]); //转成base64    
						reader.fileName = this.files[i].name;

						reader.onload = function(e) {
							var imgMsg = {
								name: this.fileName, //获取文件名    
								base64: this.result //reader.readAsDataURL方法执行完后，base64数据储存在reader.result里    
							}
							dataArr.push(imgMsg);
							result = '<div class="delete">删除</div><div class="result"><img class="subPic" src="' + this.result + '" alt="' + this.fileName + '"/></div>';
							var div = document.createElement('div');
							div.innerHTML = result;
							div['className'] = 'float';
							document.getElementsByTagName('body')[0].appendChild(div);　　 //插入dom树    
							var img = div.getElementsByTagName('img')[0];
							img.onload = function() {
								var nowHeight = ReSizePic(this); //设置图片大小    
								this.parentNode.style.display = 'block';
								var oParent = this.parentNode;
								if(nowHeight) {
									oParent.style.paddingTop = (oParent.offsetHeight - nowHeight) / 2 + 'px';
								}
							}
							div.onclick = function() {
								$(this).remove(); // 在页面中删除该图片元素  
								iLen = iLen - 1;
							}
						}
					}

				}



				function send() {
					var submitArr = [];
					$('.subPic').each(function() {
						submitArr.push({
							name: $(this).attr('alt'),
							base64: $(this).attr('src')
						});
					});

					//					$.ajax({
					//						url: 'http://123.206.89.242:9999',
					//						type: 'post',
					//						data: JSON.stringify(submitArr),
					//						dataType: 'json',
					//						//processData: false,   用FormData传fd时需有这两项    
					//						//contentType: false,    
					//						success: function(data) {
					//							console.log('返回的数据：' + JSON.stringify(data))　
					//						}
					//					})
				}
				
				//选择图片被点击时
				oSelect.onclick = function() {

					oInput.value = ""; // 先将oInput值清空，否则选择图片与上次相同时change事件不会触发  
					//清空已选图片  
					$('.float').remove();
					oInput.click();//点击文件选择
				}
				//提交按钮被点击时
				submits.onclick=function(){
					
				}
			}
			/*    
			 用ajax发送fd参数时要告诉jQuery不要去处理发送的数据，    
			 不要去设置Content-Type请求头才可以发送成功，否则会报“Illegal invocation”的错误，    
			 也就是非法调用，所以要加上“processData: false,contentType: false,”    
			 * */

			function ReSizePic(ThisPic) {
				var RePicWidth = 100; //这里修改为您想显示的宽度值    

				var TrueWidth = ThisPic.width; //图片实际宽度    
				var TrueHeight = ThisPic.height; //图片实际高度    

				if(TrueWidth > TrueHeight) {
					//宽大于高    
					var reWidth = RePicWidth;
					ThisPic.width = reWidth;
					//垂直居中    
					var nowHeight = TrueHeight * (reWidth / TrueWidth);
					return nowHeight; //将图片修改后的高度返回，供垂直居中用    
				} else {
					//宽小于高    
					var reHeight = RePicWidth;
					ThisPic.height = reHeight;
				}
			}
			
			function sapnc(mo){
			//获取点击的 1标签的内容 2.追加到另一个div 3.将自身隐藏
			var sop = $(mo).html();
			$("#d2").append("<span onclick='shi(this)'>"+sop+"</span>")
			$(mo).hide()
			
		}
		
		function shi(mod){
			//1.获取自身文本 2.获取原div的所有标签 3遍历判断相等显示,把自身删除
			var sop = $(mod).html();
			 var listSpan = $("#sp span");
			 listSpan.each(function(){
			 	 var so = $(this).html();
			 	if(sop==so){
			 		$(this).show();
			 		$(mod).remove();
			 	}
			 })
			
		}
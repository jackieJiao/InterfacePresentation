 $(document).ready(function () {
            $("#input4").combobox({
                valueField: "Id",
                textField: "Name",
                data: [
                    { "Id": "order_code", "Name": "订单编码" },
                    { "Id": "name","Name": "姓名" },
                    { "Id": "cardid","Name": "身份证号" },
                    { "Id": "phone_number","Name": "手机号" }
                    
                ]
            });
            $("#input6").combobox({
                valueField: "Id",
                textField: "Name",
                data: [
                    { "Id": "3", "Name": "全部" },
                    { "Id": "1", "Name": "完成" },
                    { "Id": "0", "Name": "未完成" }
                ]
            });
            $("#input1").combobox({
                valueField: "Id",
                textField: "Name",
                data: [
                    { "Id": "click_time", "Name": "订单访问" },
                    { "Id": "sino_sign_ftime", "Name": "平台登录" },
                    { "Id": "center_sign_ftime", "Name": "系统登录" },
                    { "Id": "answer_success", "Name": "信息申请" },
                    { "Id": "get_code", "Name": "信息生成" }
                ]
            });
            
            
            $("#btn1").click(function () {
                var val1 = $("#input1").combobox("getValue");
                var val2 = $("#input2").datebox("getValue");
                var val3 = $("#input3").datebox("getValue");
                var val4 = $("#input4").combobox("getValue");
                var val5 = $("#input5").val();
                var val6 = $("#input6").combobox("getValue");
                console.info(val1 + "," + val2 + "," + val3+ "," + val4+ "," + val5+ "," + val6);
                var v1 = val1!='';
                var v2 = val2!='';
                var v3 = val3!='';
                var v4 = val4!='';
                var v5 = val5!='';
                var v6 = val6!='';
                var t1 =true;
                if(val3<val2){alert("您输入时间有误：结束时间早于开始时间")}
                var c1=!(v1)&&v4&&v5;
                var c2=v1&&v2&&v3&&t1&&!(v4);
                var c3=v1&&v2&&v3&&t1&&v4&&v5;
                var c4=!(v1)&&!(v4);
                //搜索条件判断
                console.info(v1+"这是执行的四种条件"+c1+c2+c3+c4);
                if(c1||c2||c3||c4){
                	console.info("输入正确");
                	 $.ajax({ 
                         type: 'POST',
                         url: '../test/searchBy?timeItem='+val1+'&startTime='+val2+'&stopTime='+val3+'&optionItem='+val4+'&optionValue='+val5+'&status='+val6,
                         //data:SCondition,
                         dataType:'json',
                         success:function(json){
                         	console.info("这是根据搜索条件查出来的结果:");
                         	console.info(json);
                         	resultJson=JSON.stringify(json.result);
                             var data = json.result;
                             var pama = ["order_code","name","cardid","phoneNumber","clicktime","sinoSign","centerSign","answerYN","getCode","isDone"];
                           
                             pagetool = new Pageglobal(data,pama,"list","pagecount");
                             pagetool.init();
                         },
                         error: function (xhr) {alert("获取数据出错："+xhr.statusText);}
                     }); 
                	
                }else{
                	alert("您输入有误，请重新输入！");
                }
            });            
        });
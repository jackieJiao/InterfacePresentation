/**
 * 
 */
$(function(){
	listdatagrid = $('#sinonot').datagrid({
			url:"getBillSinoNotData.action?_="+new Date(),
			pagination : true,
			pageSize : 30,
			pageList : [ 30, 40, 50, 60, 70, 80, 90, 100 ],
			rownumbers : true,
			fit : true, // 自动大小
			fitColumns : false, // 自适应列宽
			singleSelect : true, // 是否单选
			idField : 'id',
			toolbar : [
			{
				iconCls : 'icon-print',
				text : '打印',
				handler : function(){
					CreateFormPage(
							"print",
							listdatagrid,
							"getBillAllSinoNotData.action"
							);
				}
			}, '-' ],
			loadFilter : function(data) {
				return data.data;
			},
			columns:[[
						/* {field:'opt',title:'操作',width:100,align:'center' }, */	    
	                    {title:'运营商有华道没有',colspan:1},
	                    {title:'显示运营商数据',colspan:6}
	                   
	                ],[
				{
					title : 'id',
					field : 'id',
					hidden : 'true'
				},
              	{   title:'西塔侧手机号码',
					field:'sphone',
					width:'200',
					width:'150'
				},{
					title:'联通侧手机号码',
					field:'nphone',
					width:'100'
				},{
					title:'结算类型',
					field:'jstype',
					width:'100',
					formatter:function(value){
//						 return "haha";
						 if(value=="0"){return "正常结算";}
						 if(value=="1"){return "赔偿结算";}
						 if(value=="2"){return "不结算";}
						 if(value=="3"){return "补充结算";}
						 else{return "订单状态有误"}
					 }
				},{
					title:'套餐金额',
					field:'tcmoney',
					width:'100'
				},{
					title:'结算金额',
					field:'jsmoney',
					width:'100'
				},{
					title:'赔付金额',
					field:'pfmoney',
					width:'100'
				},{
					title:'上月套餐是否结清标识',
					field:'isclear',
					width:'200'
				}
			]]

		})
	});
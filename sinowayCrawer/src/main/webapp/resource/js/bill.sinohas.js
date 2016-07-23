/**
 * 
 */
$(function(){
	sinohas_listdatagrid = $('#sinohas').datagrid({
			url:"getBillSinohasData.action?_="+new Date(),
			pagination : true,
			pageSize : 30,
			pageList : [ 30, 40, 50, 60, 70, 80, 90, 100 ],
			rownumbers : true,
			fit : true, // 自动大小
			fitColumns : false, // 自适应列宽
			singleSelect : true, // 是否单选
			idField : 'sn',
			toolbar : [
			{
				iconCls : 'icon-print',
				text : '打印',
				handler : function(){
					CreateFormPage(
							"print",
							sinohas_listdatagrid,
							"getBillAllSinoHasData.action"
							);
				}
			}, '-' ],
			loadFilter : function(data) {
				return data.data;
			},
			columns : [
				[
						/* {field:'opt',title:'操作',width:100,align:'center' }, */	    
	                    {title:'运营商有华道没有',colspan:1},
	                    {title:'显示运营商数据',colspan:10}
	                   
	                ],
			 [ {
				title : 'sn',
				field : 'sn',
				hidden : 'true'
			}, {
				title:'旧手机号',
				field:'basePhonenumber',
				width:'150'
			},{
				title:'新手机号',
				field:'newnumber',
				width:'100'
			},{
				title:'订单号',
				field:'ordersId',
				width:'100'
			},{
				title:'运营商',
				field:'operatorname',
				width:'100'
			},{
				title:'券商名称',
				field:'brokerName',
				width:'100'
			},{
				title:'当前订单状态',
				field:'curStatus',
				width:'100',
				formatter:function(value){
//					 return "haha";
					 if(value=="0"){return "新增";}
					 if(value=="2"){return "订单";}
					 if(value=="3"){return "取消";}
					 if(value=="4"){return "异常停机";}
					 if(value=="5"){return "销户";}
					 
					 else{return "恢复"}
				 }
			},{
				title:'每月资费',
				field:'monthlypaymentamount',
				width:'100'
			},{
				title:'办理时间',
				field:'curTimeStr',
				width:'100'
			},{
				title:'结算金额',
				field:'billAmount',
				width:'100'
			},{
				title:'赔付金额',
				field:'compenAmount',
				width:'100'
			},{
				title:'结算类型',
				field:'billType',
				width:'100',
				formatter:function(value){
//					 return "haha";
					 if(value=="0"){return "正常结算";}
					 if(value=="1"){return "赔偿结算";}
					 if(value=="2"){return "不结算";}
					 if(value=="3"){return "补充结算";}
					 else{return "订单状态有误"}
				 }
			}
		]]

	})
});
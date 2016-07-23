$(function() {
	bill_listdatagrid = $('#bill_list').datagrid({
		url : "getBillData.action?_="+new Date(),
		pagination : true,
		pageSize : 30,
		pageList : [ 30, 40, 50, 60, 70, 80, 90, 100 ],
		rownumbers : true,
		nowrap:false,
		fit : false, // 自动大小
		fitColumns : false, // 自适应列宽
    	singleSelect : true, // 是否单选
		idField : 'ordersId',
		toolbar : [ {
			iconCls : 'icon-add',
			text : '新增',
			handler : function(){
				openAdd();
			}
		}, '-',
		{
			iconCls : 'icon-print',
			text : '打印',
			handler : function(){
				CreateFormPage(
						"print",
						bill_listdatagrid,
						"getBillAllData.action"
						);
			}
		}, '-' ],
		loadFilter : function(data) {
			return data.data;
		},
		columns : [
			[
			 {title:'对账表',colspan:11},
			],
			[
			 {title:'订单表',colspan:8},
			 {title:'公式计算(模拟)',colspan:2},
			 {title:'规则打标',colspan:1}
			],
		 [ {
			title : 'sn',
			field : 'sn',
			hidden : 'true'
		}, {
			title:'旧手机号',
			field:'basePhonenumber',
			width:'100',
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
//				 return "haha";
				 if(value=="0"){return "新增";}
				 if(value=="2"){return "订单";}
				 if(value=="3"){return "取消";}
				 if(value=="4"){return "异常停机";}
				 if(value=="5"){return "销户";}
				 if(value=="6"){return "恢复";}
				 else{return "订单号有误"}
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
				 if(value=="0"){return "正常结算";}
				 if(value=="1"){return "赔偿结算";}
				 if(value=="2"){return "不结算";}
				 if(value=="3"){return "补充结算";}
				 else{return "订单状态有误"}
			 }
				
		}, {
			title : '操作',
			field : 'action',
			align : 'center',
			width : 100,
			formatter : function(value, row, index) {
				var e = '<a href="#" onClick="openEdit('+row.sn+');">编辑</a> ';
				var d = '<a href="#" onClick="delBill(\''+row.ordersId+'\');">删除</a> ';
				
				return e + d;
			}
		} ] ]
	})
});

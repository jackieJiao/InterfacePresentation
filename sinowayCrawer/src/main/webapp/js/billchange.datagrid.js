$(function() {
	bill_listdatagrid = $('#billchanged').datagrid({
		url : "getBillChangeData.action?_="+new Date(),
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
						bill_listdatagrid,
						"getBillAllChangeData.action"
						);
			}
		}, '-' ],
		loadFilter : function(data) {
			return data.data;
		},
		columns:[[
		          {title:'修改历史记录',colspan:12},
         ],
  		 [ {
  			title : 'sn',
  			field : 'sn',
  			hidden : 'true'
  		}, {
  			title:'修改用户名',
  			field:'user',
  			width:'100',
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
  			width:'100'
  		}
		]]
	});
});

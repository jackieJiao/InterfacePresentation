function search_search(){
	$('#sinohas').datagrid('load',
			{
		     basePhonenumber : $("#search_basePhonenumber").val(),
			 newnumber : $("#search_newnumber").val(),
			 ordersId : $("#search_ordersId").val(),
			 operatorname : $("#search_operatorname").val(),
			 brokerName : $("#search_brokerName").val()
			});
}
function search_reset(){
	$("#form_search")[0].reset();
}
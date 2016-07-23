function search_search(){
	$('#billcompare').datagrid('load',
			{
		     basePhonenumber : $("#search_basePhonenumber").val(),
			 newnumber : $("#search_newnumber").val(),
			 ordersId : $("#search_ordersId").val(),
			 operatorname : $("#search_operatorname").val()
			});
}
function search_reset(){
	$("#form_search")[0].reset();
}
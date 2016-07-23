//strPrintName 打印任务名
//printDatagrid 要打印的datagrid
function CreateFormPage(strPrintName, printDatagrid,getalldataurl) {
var tableString = '<table cellspacing="0" id="pb">';
var frozenColumns = printDatagrid.datagrid("options").frozenColumns;  // 得到frozenColumns对象
console.info(frozenColumns);
var columns = printDatagrid.datagrid("options").columns;    // 得到columns对象
console.info(columns);
console.info("上面为columns");
var nameList = '';

// 载入title
if (typeof columns != 'undefined' && columns != '') {
   $(columns).each(function (index) {
       tableString += '\n<tr>';
       console.info(index);
       console.info("indexdezhi");
       if (typeof frozenColumns != 'undefined' && typeof frozenColumns[index] != 'undefined') {
           for (var i = 0; i < frozenColumns[index].length; ++i) {
               if (!frozenColumns[index][i].hidden && typeof columns[index][i].field != 'undefined' && columns[index][i].field != 'action') {
                   tableString += '\n<th width="' + frozenColumns[index][i].width + '"';
                   if (typeof frozenColumns[index][i].rowspan != 'undefined' && frozenColumns[index][i].rowspan > 1) {
                       tableString += ' rowspan="' + frozenColumns[index][i].rowspan + '"';
                   }
                   if (typeof frozenColumns[index][i].colspan != 'undefined' && frozenColumns[index][i].colspan > 1) {
                       tableString += ' colspan="' + frozenColumns[index][i].colspan + '"';
                   }
                   if (typeof frozenColumns[index][i].field != 'undefined' && frozenColumns[index][i].field != '') {
                       nameList += ',{"f":"' + frozenColumns[index][i].field + '", "a":"' + frozenColumns[index][i].align + '"}';
                   }
                   tableString += '>' + frozenColumns[0][i].title + '</th>';
               }
           }
       }
       for (var i = 0; i < columns[index].length; ++i) {
  console.info("第"+i)  	   
  console.info(i);
           if (!columns[index][i].hidden && typeof columns[index][i].field != 'undefined' && columns[index][i].field != 'action' ) {
               tableString += '\n<th width="' + columns[index][i].width + '"';
               if (typeof columns[index][i].rowspan != 'undefined' && columns[index][i].rowspan > 1) {
                   tableString += ' rowspan="' + columns[index][i].rowspan + '"';
                   console.info("columns[index][i].rowspan");
                   console.info(columns[index][i].rowspan);
               }
               if (typeof columns[index][i].colspan != 'undefined' && columns[index][i].colspan > 1) {
                   tableString += ' colspan="' + columns[index][i].colspan + '"';
                   console.info("columns[index][i].colspan"); 
                   console.info(columns[index][i].colspan);
               }
               if (typeof columns[index][i].field != 'undefined' && columns[index][i].field != '') {
                   nameList += ',{"f":"' + columns[index][i].field + '", "a":"' + columns[index][i].align + '"}';
                   console.info("columns[index][i].field");
                   console.info(columns[index][i].field);
                   console.info(columns[index][i].align);
                   console.info(nameList);
               }
               tableString += '>' + columns[index][i].title + '</th>';
               console.info( "columns[index][i].title");
               console.info( columns[index][i].title);
           }
       }
       tableString += '\n</tr>';
   });
}
console.info(tableString);
console.info("载入内容");
//载入内容

$.ajax({
	 url:getalldataurl+"?_="+new Date(),
	
	 dataType: 'json',
	 success:function(data){
		 var rows=data.data;
		 console.info(rows)
		 // 这段代码是获取当前页的所有行
		 var nl = eval('([' +nameList.substring(1) + '])');
		 console.info(nl);
		 for (var i = 0; i < rows.total; ++i) {
			 //循环去所有行；
		     tableString += '\n<tr>';
		     $(nl).each(function (j) {
		         var e = nl[j].f.lastIndexOf('_0');

		         tableString += '\n<td';
		         if (nl[j].a != 'undefined' && nl[j].a != '') {
		             tableString += ' style="text-align:' + nl[j].a + ';"';
		         }
		         tableString += '>';
		         /*if (e + 2 == nl[j].f.length) {
		             tableString += rows[i][nl[j].f.substring(0, e)];
		         }
		         else*/
		         if(nl[j].f=="curStatus"){
		        	 //tableString取决于billtype的值
		        	 if(rows.rows[i][nl[j].f]=="0"){ tableString += "新增";}
		        	 if(rows.rows[i][nl[j].f]=="2"){ tableString += "订单";}
		        	 if(rows.rows[i][nl[j].f]=="3"){ tableString += "取消";}
		        	 if(rows.rows[i][nl[j].f]=="4"){ tableString += "停机";}
		        	 if(rows.rows[i][nl[j].f]=="5"){ tableString += "销户";}
		        	 if(rows.rows[i][nl[j].f]=="6"){ tableString += "恢复";}
		        	
		        	 
		         }
		         else if(nl[j].f=="billType"){
		        	 //tableString取决于billtype的值
		        	 if(rows.rows[i][nl[j].f]=="0"){ tableString += "正常结算";}
		        	 if(rows.rows[i][nl[j].f]=="1"){ tableString += "赔偿结算";}
		        	 if(rows.rows[i][nl[j].f]=="2"){ tableString += "不结算";}
		        	 if(rows.rows[i][nl[j].f]=="3"){ tableString += "补充结算";}
		        	 
		         }else{
		        	 if(rows.rows[i][nl[j].f]==null){
		        		 tableString +=" ";
		        	 }else{
		             tableString += rows.rows[i][nl[j].f];}}
		         tableString += '</td>';
		     });	
		     tableString += '\n</tr>';
		 }
		 tableString += '\n</table>'; 
		 console.info(tableString);
		 
		 
		 
		 
		 
		window.showModalDialog("print.htm?temp="+Math.random(), tableString,
		 "location:No;status:No;help:No;dialogWidth:1000px;dialogHeight:500px;scroll:auto;");
	 }
});

}

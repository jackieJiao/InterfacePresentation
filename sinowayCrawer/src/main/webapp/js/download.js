/**
 * states2.jsp
 *
 */

var pagetool;
	var resultJson;
	function loadData(){
		$.ajax({ 
            type: 'POST',
            url: '../test/get3timetable',
            dataType:'json',
            contentType: "application/json; charset=utf-8",
            success:function(json){
            	console.info("******loadData,status2*******")
            	console.info(json);
            	resultJson=JSON.stringify(json.result);
                var data = json.result;
                var pama = ["phone","name","cardid","loginTime","updateTime","reportTime","requestTime"];
              
                pagetool = new Pageglobal(data,pama,"list","pagecount");
                pagetool.init();
            },
            error: function (xhr) {alert("获取数据出错："+xhr.statusText);} 
        });
	}
	function getExcel(){
		console.log("#####resultJson###########")
		/*console.log(resultJson);*/
		if(resultJson==null){
			alert("没有要下载的数据.");
		}else{
		//window.location.href='../test/getExcel?data='+resultJson;		
			   
			     
			//调用方法 如      
		post('../test/getExcel',resultJson);
	}}
	function post(url, params) {
	    var temp = document.createElement("form");
	    temp.action = url;
	    temp.method = "post";
	    temp.setAttribute("accept-charset","UTF-8");
	    temp.Allow = "POST";
	   /* temp.style.display = "none";*/
	   
	        var opt = document.createElement("input");
	        opt.name = "data";
	        opt.value = params;
	        console.info("***this is params",params);
	        temp.appendChild(opt);
	   
	    document.body.appendChild(temp);
	    temp.submit();
	    return temp;
	}
	function setTableData(page){
		pagetool.setTableData(page);
	}
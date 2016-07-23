<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>
function download(a){
	console.info(a);
	form.action = "${pageContext.request.contextPath}/user/addUser1";  
    //form.action = "${pageContext.request.contextPath}/user/addUser2";  
    //form.action = "${pageContext.request.contextPath}/user/addUser3";  
    form.method = "post";  
    form.submit(); 
}
</script>
<link href="../css/styles1.css" rel="stylesheet" type="text/css"></link>
<title>Insert title here</title>
</head>
<body>
<h1>查询结果</h1>
<table class='listTable'>
<thead>
		<tr style="text-align: center;">
			<td >ID </td>
			<td >生成日期</td>
			<td > 下载</td>
		</tr>
		</thead><tbody id="list1">
		<c:forEach items="${list}" var="obj" varStatus="xh"> 
			<tr>
				<td >${xh.count} </td>
				<td >${obj.requestTime }</td>
				<td ><form action="../getdata.action?rid=${obj.reportId}&rn=${obj.queriedName}&qn=${obj.queriedNumber}&rt=${obj.requestTime}" method="post"><input type="submit" value="下载"></form></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

</body>
</html>
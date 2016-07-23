<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="/sinowayCrawer/css/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="loginBox">
	<h1>用户登录</h1>

	<div id="login-error">${error}</div>

	<form action="/sinowayCrawer/j_spring_security_check" method="post">

		<div class="usr">
			<p>用户名</p> <input class="inputLoginText" id="j_username"
				name="j_username" type="text" />
		</div>

		<div class="pwd">
				<p>密码</p> <input id="j_password" class="inputLoginText"
				name="j_password" type="password" />
	    </div>
		<div class="submit">
		<input type="submit" class="btnSub" value="" />
		</div>
	</form>
	
	
</div>
</body>
</html>
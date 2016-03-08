<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>用户登录</title>
</head>
<body>
	<h1>用户登录</h1>
	<form action="${pageContext.request.contextPath }/user/login.do" method="POST">
		${ERR_login }<br>
		${ERR_user }<br>
		用户名：<input type="text" name="username" />${ERR_username }<br><br>
		密码：<input type="password" name="password" />${ERR_password }<br><br>
		验证码：<input type="text" name="code" value="1234565" /><br><br>
		<input type="submit" value="登录">
	</form>
</body>
</html>
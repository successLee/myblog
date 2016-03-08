<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>用户注册页面</title>
</head>
<body>
	<h1>用户注册</h1>
	<form action="${pageContext.request.contextPath }/user/register.do" method="POST">
		用户名：<input type="text" name="username" /><br><br>
		密码：<input type="password" name="password" /><br><br>
		确认密码：<input type="password" name="password2" /><br><br>
		邮箱：<input type="text" name="email" /><br><br>
		性别：<input type="radio" name="sex" value="male" />男 <input type="radio" name="sex" value="female">女<br><br>
		<input type="submit" value="注册">
	</form>
</body>
</html>
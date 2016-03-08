<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>user reg</title>
</head>
<body>
	<h1>user reg</h1>
	<form action="${pageContext.request.contextPath }/user/reg.do" method="POST">
		${ERR_username }用户名：<input type="text" name="username" /><br><br>
		${ERR_password } 密码：<input type="password" name="password" /><br><br>
		${ERR_password2 }确认密码：<input type="password" name="password2" /><br><br>
		${ERR_email } 邮箱：<input type="text" name="email" /><br><br>
		性别：<input type="radio" name="sex" value="male" />男 <input type="radio" name="sex" value="female">女<br>
		<br> <input type="submit" value="注册">
	</form>

</body>
</html>
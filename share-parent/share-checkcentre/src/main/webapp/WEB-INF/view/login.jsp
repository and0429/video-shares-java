<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>login</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/login.js"></script>
</head>
<body>
	<form action="login" method="post">
		<table border="0" align="center" style="margin-top: 200px;">
			<caption style="padding-bottom: 20px;">Login</caption>
			<tr style="color: red;">
				<td colspan="2" align="center"><span>${error }</span></td>
			</tr>
			<tr>
				<th>username:</th>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<th>username:</th>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<th>captcha:</th>
				<td><input type="text" name="captcha"><img id="captcha"></img></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="submit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
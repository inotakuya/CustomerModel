<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン画面</title>
</head>
<body>
	<h2>ログイン画面</h2>
	<form:form modelAttribute="user" method="post" action="login">
	<font color="red"><form:errors path="*"></form:errors></font>
	<br><br>
		<table>
			<tr>
				<td>ユーザー名前</td>
				<td><form:input path="userName" /></td>
			</tr>
			<tr>
				<td>パスワード</td>
				<td><form:password path="password" /></td>
			</tr>
		</table>
		<table>
			<tr>
				<td><input type="submit" value="ログイン"></td>
				<td><input type="reset" value="リセット"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
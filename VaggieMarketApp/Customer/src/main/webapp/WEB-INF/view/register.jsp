<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザー登録画面</title>
</head>
<body>
<h2>ユーザー登録画面</h2>
<form:form modelAttribute="customer" method="post" action="register">
<label>ユーザー名</label>
<form:input path="customerName"/>
<label>パスワード</label>
<form:password path="password"/>
<input type="submit" value="登録">
</form:form>
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ブログ</title>
</head>
<body>
	<h2>${message}</h2>
	<form:form modelAttribute="blog" action="/Blogbook/message/"
		method="post">
		<form:input path="title" />
		<form:input path="message" />
		<input type="submit" value="送信" />
	</form:form>

	<c:if test="${bloglist != null }">
		<c:forEach var="obj" items="${ bloglist}" varStatus="status">
			<ul>
				<li><c:out value="${obj.title }"></c:out><a
					href="/Blogbook/message/update?blogId=${obj.blogId }">編集</a><a href="delete?blogId=${obj.blogId }">削除</a></li>
				<li><c:out value="${obj.message }"></c:out></li>
			</ul>
		</c:forEach>
	</c:if>
</body>
</html>

<!DOCTYPE=HTML>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	<body>
		<form method="post">
			<input type="text" name="writer" size="20" value="${boardVO.writer}">
			<input type="text" name="title" size="20" value="${boardVO.title}">
			<input type="text" name="content" size="20" value="${boardVO.content}">
			<input type="submit">
		</form>
	</body>
</html>
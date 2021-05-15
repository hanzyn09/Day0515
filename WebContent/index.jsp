<%@page import="com.the.config.MybatisConfig"%>
<%@page import="org.apache.ibatis.session.SqlSessionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="fboard/write" method="post" enctype="multipart/form-data">
		<p><input type="text" name="subject" placeholder="제목">
		<p><textarea rows="5" cols="40" name="content"> </textarea>
		<p><input type="file" name="file">
<!-- 	<p><input type="submit" value="등록" name=""> -->
		<p><button type="submit">등록</button>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/common/menu.jsp"/>
	<p> 상세페이지
	<table>
		<tr>
			<td>글번호</td>
			<td>${detail.no }</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${detail.subject }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${detail.content }</td>
		</tr>
		<c:if test="${not empty detail.file}">
			<tr>
				<td>파일 정보</td>
				<td>	
					<span><a href="#">${detail.file.filename }</a></span>
					<span>${detail.file.filesize/1024 }kb</span>
					<a href="${root }/fboard/file-del?fno=${detail.file.fno}" >X</a>
					<a href="file-del?fno=${detail.file.fno}&no=${detail.no }" >X</a>
				</td>
			</tr>
		</c:if>
		<tr>
			<td colspan="2">
				<a href="#">수정</a>
				<a href="delete?no=${detail.no} ">삭제</a>
			</td>
		</tr>
	</table>
</body>
</html>
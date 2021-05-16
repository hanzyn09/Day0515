<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/common/menu.jsp"/>
	<main>
		<p> 파일 게시판 </p>
		<hr>
		<table>
			<tr>
				<td>글 번호</td>
				<td>제목</td>
			</tr>
			<!-- 데이터 출력 영역 -->
			<c:forEach items="${list }" var="dto">
			 <tr>
				<td>${dto.no }</td>
				<td> 
					<a href="detail?no=${dto.no }">
						<span>${dto.subject }</span>
						<c:if test="${not empty dto.file}">
							<span>
								<img src="${root }/images/save-solid.svg" width="16px" height="16px">
							</span>	
						</c:if>
					</a>				
				</td>
			</tr>
			</c:forEach>
			
		</table>
	</main>

	
</body>
</html>
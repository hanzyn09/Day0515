<%@page import="com.the.config.MybatisConfig"%>
<%@page import="org.apache.ibatis.session.SqlSessionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    //String root = request.getContextPath(); //day0515 : el 태그를 활용하기 위해 셋팅
    //위처럼 선언해서 <%=로 활용하면 다른페이지에서 활용 불가하므로 아래와 같이 선언
    //scope : 서블릿이 끝날 때 까지 저장하고 있는 저장소
    application.setAttribute("root", request.getContextPath());
    
    //page < request < session < application 순으로 스코프 확장
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/common/menu.jsp"/>
	<p> 인덱스페이지 입니다.
</body>
</html>
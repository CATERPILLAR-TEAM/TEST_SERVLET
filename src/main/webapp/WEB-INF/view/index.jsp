<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div>index</div>
	<div>인덱스 페이지</div>
	<a href="${pageContext.request.contextPath}/member/register">회원가입</a>
	<a href="${pageContext.request.contextPath}/member/selectAll">admin 로그인했다치고 회원목록</a>
	<a href="${pageContext.request.contextPath}/member/select">admin 로그인했다치고 회원상세</a>
	<a href="${pageContext.request.contextPath}/member/update">admin 로그인했다치고 회원수정</a>
</body>
</html>
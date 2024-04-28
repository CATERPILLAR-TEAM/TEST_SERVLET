<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>INDEX</h2>
	<div>�ε��� ������</div>
	<a href="${pageContext.request.contextPath}/member/register">ȸ������</a>
	<a href="${pageContext.request.contextPath}/member/selectAll">admin �α����ߴ�ġ�� ȸ�����</a>
	<a href="${pageContext.request.contextPath}/member/select">admin �α����ߴ�ġ�� ȸ����</a>
	<a href="${pageContext.request.contextPath}/member/update">admin �α����ߴ�ġ�� ȸ������</a>
</body>
<script>
    var sessionId = '<%= session.getAttribute("session_id") %>';

    localStorage.setItem("session_id", sessionId);
</script>

</html>
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
</body>
<script>
    var sessionId = '<%= session.getAttribute("session_id") %>';

    localStorage.setItem("session_id", sessionId);
</script>

</html>
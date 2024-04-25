<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>회원가입</h2>
	<form action="여긴 고쳐야 함!" method="POST">
		실명:<input type="text" name="realname">
		성별:<br/>
		<input type="radio" name="gender" value="m" checked>남자
		<input type="radio" name="gender" value="f">여자
		연락처:<input type="text" name="phone">
		이메일:<input type="email" name="email">
		아이디:<input type="text" name="id"><br/>
		비밀번호:<input type="password" name="password"><br/>
		<input type="submit" value="가입">
	</form>

</body>
</html>
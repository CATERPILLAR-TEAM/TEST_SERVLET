<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>ȸ������</h2>
	<form action="���� ���ľ� ��!" method="POST">
		�Ǹ�:<input type="text" name="realname">
		����:<br/>
		<input type="radio" name="gender" value="m" checked>����
		<input type="radio" name="gender" value="f">����
		����ó:<input type="text" name="phone">
		�̸���:<input type="email" name="email">
		���̵�:<input type="text" name="id"><br/>
		��й�ȣ:<input type="password" name="password"><br/>
		<input type="submit" value="����">
	</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>�α���</h2>
	<form action="${pageContext.request.contextPath}/member/login" method="post">
        <label for="username">����� �̸�:</label>
        <input type="text" id="username" name="username" required><br>

        <label for="password">��й�ȣ:</label>
        <input type="password" id="password" name="password" required><br>
        
        <button type="submit">�α���</button>
	</form>

</body>
</html>
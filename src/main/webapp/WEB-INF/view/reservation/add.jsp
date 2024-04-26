<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/reserv/add" method="post" class="w-25 m-3">
		<input type="text" name="room_info_id" placeholder="위치"  class="form-control m-3"/>
		<input type="text" name="reservation_type" placeholder="숙박/대실"  class="form-control m-3" />
		<input type="datetime-local" name="checkIn" placeholder="체크인"  class="form-control m-3"/>
		<input type="datetime-local" name="checkOut" placeholder="체크아웃"  class="form-control m-3"/>
		<button>예약하기</button>
	</form>
</body>
</html>
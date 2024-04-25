<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/reservation/add" method="post" class="w-25 m-3">
		<input type="text" name="room_info_id" placeholder="위치"  class="form-control m-3"/>
		<input type="text" name="reservation_type" placeholder="숙박/대실"  class="form-control m-3" />
		
		<input type="datetime-local"
         name="checkIn" class="form-control m-3"
         max="2077-06-20T21:00"
         min="2077-06-05T12:30"
         value="2077-06-15T13:27">
         <input type="datetime-local"
         name="checkOut" class="form-control m-3"
         max="2077-06-20T21:00"
         min="2077-06-05T12:30"
         value="2077-06-15T13:27">
		<!-- <input type="text" name="checkIn" placeholder="체크인"  class="form-control m-3"/>
		<input type="text" name="checkOut" placeholder="체크아웃"  class="form-control m-3"/> -->
		<button>예약하기</button>
	</form>
</body>
</html>
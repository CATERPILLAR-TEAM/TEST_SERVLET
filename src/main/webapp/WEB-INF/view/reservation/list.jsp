<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- link  -->
	<%@ include file="/resources/static/jsp/link.jsp" %>
	
	<!-- common.css -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/common.css" />
	
	<!-- common.js -->
	<script src="${pageContext.request.contextPath}/resources/static/js/common.js" defer></script>
	
	<!-- book/list.css -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/book/list.css" />

</head>
<body>
 <div class="wrapper">
 	<header>
 		<div class="top-header"></div>
 		<nav></nav>
 	</header>
 	<main>
 	
 	<section class="search-block layout-150">
       
            	<form action="${pageContext.request.contextPath}/reserv/list">          		
            		<div class="m-2">
	            		<select name="type" id="" class="form-select">
	            			<option value="userId" selected>사용자 아이디</option>
	            			
	            		</select>
            		</div>
            		<div class="m-2">
            			<input name="keyword" placeholder="KEYWORD" class="form-control">
            		</div>	
            		
            		<div class="m-2">
            			<button class="btn btn-secondary">조회</button>
            		</div>
 	
 		
 		<section class="show-block">
            	<table class=table>
            		<tr>
            			<td>ROOMID</td>
            			<td>USERID</td>
            			<td>reservation_type</td>
            			<td>CHECKIN</td>
            			<td>CHECKOUT</td>
            		</tr>
            		
            		<c:forEach  var="ReservDto"	items="${list}" varStatus="status">    		
		            	<tr>	
								<td>${ReservDto.room_info_id}</td>
								<td>${ReservDto.user_id}</td>
								<td>${ReservDto.reservation_type}</td>
								<td>${ReservDto.checkIn}</td>
								<td>${ReservDto.checkOut}</td>
						</tr>          		
            		</c:forEach>

									
            	</table>      
            </section>
 	</main>
 	<footer></footer>
 </div>
</body>
</html>
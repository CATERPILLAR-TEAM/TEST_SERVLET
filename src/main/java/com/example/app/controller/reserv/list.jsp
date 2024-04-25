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
 		<section class="show-block">
            	<table class=table>
            		<tr>
            			<td>ROOMID</td>
            			<td>USERID</td>
            			<td>reservation_type</td>
            			<td>CHECKIN</td>
            			<td>CHECKOUT</td>
            		</tr>
            		
            		<c:forEach  var="ResevDto"	items="${list}" varStatus="status">    		
		            	<tr>	
								<td>${ResvDto}</td>
								<td>${ResvDto.user_id}</td>
								<td>${ResvDto.reservation_type}</td>
								<td>${ResvDto.checkIn}</td>
								<td>${ResvDto.checkOut}</td>
						</tr>          		
            		</c:forEach>

									
            	</table>      
            </section>
 	</main>
 	<footer></footer>
 </div>
</body>
</html>
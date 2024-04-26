<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<div class="wrapper">
		<section >
			  <table class="table">
			       <thead class="table-secondary">			            		
				         <tr>
				            <th scope="col">ROOM TYPE</th>
				            
				            <th scope="col">CHECK IN</th>
				            
				            <th scope="col">CHECK OUT</th>
				            

				         </tr>
			       </thead>
			       <c:forEach var="reservationDto" items="${list}" varStatus="status" >
				            <tr>	
								<td>
									<a href="${pageContext.request.contextPath}/reserv/list?room_info_id=${reservationDto.room_info_id}">
										<c:out value="${reservationDto.room_info_id}" />
									</a>
								</td>
								<td><c:out value="${reservationDto.room_type}" /></td>
								<td><c:out value="${reservationDto.check_in}" /></td>
								<td><c:out value="${reservationDto.check_out}" /></td>
							 </tr>						
					</c:forEach>
			   </table>      
		</section>
	</div>
</body>
</html>
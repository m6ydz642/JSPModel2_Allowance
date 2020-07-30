<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

<title>돈 관리</title>
		

</head>
<body>
		
		<c:set var="center" value="param.center"/>
		 
		<form action="moneystatus.jsp" method="post">
			<h1 style="text-align: center;">돈관리</h1>
			<table align="center">
				<tr>
					<td width="200"><p align="right">사용내역</p></td>
					<td width="400"><input type="text" name="usedetails"></td>
				</tr>
				<tr>
					<td width="200"><p align="right">금액</p></td>
					<td width="400"><input type="text" name="amount"></td>
				</tr>				
				<tr>
					<td width="200"><p align="right">사용구분 (삼성카드 or <br> 기업은행 or 현금)</p></td>
					<td width="400"><input type="text" name="usetype"></td>
				</tr>				
<!-- 				<tr> -->
<!-- 					<td width="200"><p align="right">날짜</p></td> -->
<!-- 					<td width="400"><input type="text" name="date"></td> -->
<!-- 				</tr> -->
			
				<tr>
					<td width="200"><p>&nbsp;</p></td>
					<td width="400">
						<input type="submit" value="입력하기">
						<input type="reset" value="다시입력">
					</td>
				</tr>
			</table>	
		</form>
		
		<form action="MoneyList.me" method="post" align="center">
			<input align="center" type="submit" value="데이터조회">
		</form>
</body>
</html>












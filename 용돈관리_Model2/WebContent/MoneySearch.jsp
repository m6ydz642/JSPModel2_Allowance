<%@page import="oracle.net.aso.b"%>
<%@page import="java.util.List"%>
<%@page import="sec01.ex01.MoneyDAO"%>
<%@page import="sec01.ex01.MoneyBean"%>
<%@page import="java.sql.DriverManager"%>
   <%@page import="java.sql.Connection"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%
		//한글 처리
		request.setCharacterEncoding("UTF-8");
// ?moneysearch=${usedetails}
%>		

 	  <form action="MoneySearch.me">
		<input name="moneysearch"><input value="검색하기" type="submit">  <br> <br> 
	</form>
	
 	
 	
 	<tr>총 항목수 : </tr>
 	<c:out value="${count}"/>
 	
		<c:if test="${count > 0}">
	
	

	<table align="center" width="100%">
		<tr align="center" bgcolor="#99ccff">
			<td width="7%">순서</td>
			<td width="7%">사용내역</td>
			<td width="7%">금액</td>
			<td width="5%">사용구분</td>
			<td width="11%">작성일</td>
			
		</tr>
				
	
	
		
		<c:forEach var="i" items="${list}">
	

	

			
			<tr align="center"> 
			<td width="7%">${i.moneyid}</td>
			<td width="7%">${i.usedetails}</td>
			<td width="7%">${i.amount}</td>
			<td width="5%">${i.usetype }</td>
			<td width="5%">${i.joinDate }</td>
			
		<tr height="1" bgcolor="#99ccff">
			<td colspan="5"></td>
		</tr>
		
	</c:forEach>

</c:if>

		<c:if test="${count == 0}">
			<tr>
				<td colspan="5">
					<b><span style="font-size:9pt">등록된 자료가 없습니다.</span></b>
				</td>
			</tr>
		</c:if>
		
	</table>
	
	









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

 	
 	
 	<!-- 조만간 메인에서 한꺼번에 호출하는걸로 변경 -->
 	
 	<tr>총 항목수 : </tr>
 	<c:out value="${count}"/>
 	
		<c:if test="${count > 0}">
	
	<jsp:include page="header.jsp" />

  <form action="MoneySearch.me">
		<input name="moneysearch"><input value="검색하기" type="submit">  <br> <br> 
	</form>
	
	<if test="${moneysearch ne '' }">
		<c:out value="${moneysearch} 에 대한 "/>	<tr> 검색결과 총 합계 금액</tr>
		<font color="orange"> <c:out value="${sum}"/></font>원
	</if>
	
<%-- 	<if test="${moneysearch != null }">
		<c:out value="전체검색에 대한 "/>	<tr> 검색결과 총 합계 금액</tr>
		<font color="orange"> <c:out value="${sum}"/></font>원
	</if> --%>
	
	
	
	<table align="center" width="100%">
		<tr align="center" bgcolor="#99ccff">
			<td width="7%">순서</td>
			<td width="7%">사용내역</td>
			<td width="7%">금액</td>
			<td width="5%">사용구분</td>
			<td width="11%">기타메모</td>
			<td width="11%">작성일</td>
			
		</tr>
				
	
	
		
		<c:forEach var="i" items="${list}">
	

	

			
			<tr align="center"> 
			<td width="7%">${i.moneyid}</td>
			<td width="7%">${i.usedetails}</td>
			<td width="7%">${i.amount}</td>
			<td width="5%">${i.usetype }</td>
			<td width="5%">${i.memo }</td>
			<td width="5%">${i.joinDate }</td>
			
		<tr height="1" bgcolor="#99ccff">
			<td colspan="6"></td>
		</tr>
		
	</c:forEach>

</c:if>


<!--if문이 뭔가 잘못됐나 for문에 넣어도 제대로 안되서 다시 가져옴 ㅡ.ㅡ     -->
		<c:if test="${count eq 0}">
 	<form action="MoneySearch.me">
			<input name="moneysearch"><input value="검색하기" type="submit">  <br> <br> 
	</form>
			<tr>
				<table align="center" width="100%">
					<tr align="center" bgcolor="#99ccff">
						<td width="7%">순서</td>
						<td width="7%">사용내역</td>
						<td width="7%">금액</td>
						<td width="5%">사용구분</td>
						<td width="11%">기타메모</td>
						<td width="11%">작성일</td>

					</tr>

			</table>
				<tr align="center"> 
				<td width="7%">자료가 엄서용</td>
							
			</tr>
		</c:if>

	</table>
	
	









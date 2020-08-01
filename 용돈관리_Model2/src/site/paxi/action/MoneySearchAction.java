package site.paxi.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sec01.ex01.MoneyBean;
import sec01.ex01.MoneyDAO;

public class MoneySearchAction implements Action {
	ActionForward forward = null; // 전역으로 쓰기위해서 여기서 선언후 일단 null로 초기화
	
	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MoneySearch Action excute()함수 호출");
		MoneyDAO mdao = new MoneyDAO();
		MoneyBean bean = new MoneyBean();
		
		String 사용내역 = request.getParameter("moneysearch"); // name값 가져오기
		int count = mdao.MoneySearchCount(사용내역);
		int sum = mdao.getMoneySum(); // 전체 리스트 조회시 합계 수
		
		System.out.println("moneySearch action money count " + count);
		List<MoneyBean> moneylist = null;
		
		
		
		System.out.println("전달받은 name값 " + 사용내역);
		moneylist = mdao.SearchMoney(사용내역);
		

		
		
		request.setAttribute("count" ,count); // 나중에 jsp페이지에서 Scope해서 쓸용도로 저장해 둠
		request.setAttribute("list" ,moneylist); 
		request.setAttribute("sum" ,sum); // 합계 전송
		request.setAttribute("moneysearch" ,사용내역);
		
		forward = new ActionForward(); // 객체생성
		forward.setRedirect(false);
		forward.setPath("MoneySearch.jsp");
		
		System.out.println("머니 서치 페이지 내용 미리보기");
		
		/*********************************************/

		
		/*********************************************/
		
		return forward;
	}
	

}

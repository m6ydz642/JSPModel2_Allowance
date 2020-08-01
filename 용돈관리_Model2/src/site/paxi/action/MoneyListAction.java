package site.paxi.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sec01.ex01.MoneyBean;
import sec01.ex01.MoneyDAO;

public class MoneyListAction implements Action {
	ActionForward forward = null; // 전역으로 쓰기위해서 여기서 선언후 일단 null로 초기화
	
	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MoneyListAction excute()함수 호출");
		MoneyDAO mdao = new MoneyDAO();
		MoneyBean bean = new MoneyBean();
		int count = mdao.getMoneyCount(); // 전체 리스트 조회시 카운트 수
		int sum = mdao.getMoneySum(); // 전체 리스트 조회시 합계 수
		
		System.out.println("moneylist action money couny " + count);
		List<MoneyBean> moneylist = null;
		moneylist = mdao.Listmoney();
		

		
		
		request.setAttribute("count" ,count); // 나중에 jsp페이지에서 Scope해서 쓸용도로 저장해 둠
		request.setAttribute("list" ,moneylist); 
		request.setAttribute("sum" ,sum);
		
		forward = new ActionForward(); // 객체생성
		forward.setRedirect(false);
		forward.setPath("MoneyList.jsp");
		
		System.out.println("머니 리스트 페이지 내용 미리보기");
		
		/*********************************************/

		
		/*********************************************/
		
		return forward;
	}
	

}

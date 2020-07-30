package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sec01.ex01.MoneyBean;
import sec01.ex01.MoneyDAO;
@WebServlet("/MoneyListController.do")
public class MoneyListController extends HttpServlet{

	
	/****************************************************************/
	
	// 이제 이 컨트롤러 안씀 
	
	/****************************************************************/

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestPro(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestPro(req, resp);
	
	}
	
	protected void requestPro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("requestpro 호출");
		SearchMoney(req, resp); // 아 이거 매개변수 때문에 request안됐던거 ㅡ.ㅡ ㅋㅋㅋㅋㅋㅋㅋ
								// 난 스트립 틀릿기호처럼 request라는 메서드가 따로 있는줄
	}
	
	private void SearchMoney(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException {
		
		
		MoneyDAO dao = new MoneyDAO();
		
		List<MoneyBean> list = dao.Listmoney();
		
		request.setAttribute("money", dao);
		
		// RequestDispatcher dis = request.getRequestDispatcher("MoneyMain.jsp?center=MoneyList.jsp");
		RequestDispatcher dis = request.getRequestDispatcher("MoneyList.jsp");
		dis.forward(request, response);
		System.out.println("searchmoney호출");
		
	}
	
}

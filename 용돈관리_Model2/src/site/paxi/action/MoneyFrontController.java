package site.paxi.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MoneyFrontController extends HttpServlet {

	private void doProcess (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		
		String requestURI = req.getRequestURI(); // 전체 주소 받아냄
		System.out.println(requestURI);
		System.out.println("얻은 URI ");
		
		String contextPath = req.getContextPath(); // 경로의 주소를 얻어냄, 프로젝트 파일 전까지의 주소
		
		System.out.println("contextPath내용 " + contextPath); 
		String command = requestURI.substring(contextPath.length()); // 얻은 주소의 길이만큼 잘라냄
		
		// 전체 주소 - 앞의 컨텍스트(폴더) 주소 = 
		// 해서 그 길이만큼 잘라냄
		
		System.out.println(command);
		
		ActionForward forward = null;
		
		Action action = null;
		
		if(command.equals("/MoneyList.me")) {
			System.out.println("moneylist클릭됨 ");
			forward = new ActionForward(); // 객체생성
			forward.setRedirect(false);
			forward.setPath("MoneyList.jsp");
		}
		
		if (forward != null) { 
			if (forward.isRedirect()) { 
				resp.sendRedirect(forward.getPath());
				System.out.println("forward가 null임" + forward.isRedirect());
				System.out.println("forward값 " + forward);
			}else {
				RequestDispatcher dispatcher = req.getRequestDispatcher(forward.getPath());
				dispatcher.forward(req, resp);
				System.out.println("foward가 null이아니라서 디스패쳐 전달" + forward.isRedirect());
				System.out.println("forward값 " + forward);
				// Redirect가 false라면
			}
		}
		
	}
	
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);

	}
	
	
	
	
	
	

}



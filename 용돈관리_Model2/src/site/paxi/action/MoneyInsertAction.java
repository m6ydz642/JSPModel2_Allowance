package site.paxi.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sec01.ex01.MoneyBean;
import sec01.ex01.MoneyDAO;

public class MoneyInsertAction implements Action {
	ActionForward forward = null; // 전역으로 쓰기위해서 여기서 선언후 일단 null로 초기화

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MoneyInsert Action excute()함수 호출");
		MoneyDAO mdao = new MoneyDAO();
		MoneyBean bean = new MoneyBean();

		System.out.println("moneyinsert action money ");
		MoneyDAO dao = new MoneyDAO();
		

		int count = mdao.getMoneyCount();
		/************************************************************/
		/* insert후 바로 보여줄 리스트 */
		System.out.println("moneylist action money couny " + count);
		List<MoneyBean> moneylist = null;
		moneylist = mdao.Listmoney();

		request.setAttribute("list", moneylist);
		request.setAttribute("count" ,count);
		request.setCharacterEncoding("UTF-8");
		
		String usedetails = request.getParameter("usedetails");
		int amount = Integer.parseInt(request.getParameter("amount"));
		String usetype = request.getParameter("usetype");
		
		System.out.println("money insert action 받은 값 usedetails : " +usedetails);
		System.out.println("money insert action 받은 값 amount : " +amount);
		System.out.println("money insert action 받은 값 usetype : " +usetype);
		
		bean.setAmount(amount);
		bean.setUsedetails(usedetails);
		bean.setUsetype(usetype);
		dao.insertmoney(bean); // insert
		
		/* insert후 바로 보여줄 리스트 */
		/************************************************************/
		
		forward = new ActionForward(); // 객체생성
		forward.setRedirect(false);
		forward.setPath("MoneyInsertComplete.jsp");

		System.out.println("머니 insert페이지 내용 미리보기");

		/*********************************************/

		/*********************************************/

		return forward;
	}

}

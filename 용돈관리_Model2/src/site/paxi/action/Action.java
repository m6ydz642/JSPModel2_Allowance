package site.paxi.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

	public interface Action {
		public ActionFoward excute(HttpServletRequest request, HttpServletResponse response) throws Exception;
	

}

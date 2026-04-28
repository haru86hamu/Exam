package main;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class MenuAction extends Action {

	
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession(false);
		if (session != null) {
			System.out.println("sessionId = " + session.getId());
			System.out.println("teacher = " + session.getAttribute("teacher"));
		}


		req.getRequestDispatcher("menu.jsp").forward(req,resp);
	}
	
	
}

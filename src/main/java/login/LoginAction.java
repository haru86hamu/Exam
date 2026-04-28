package login;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class LoginAction extends Action {
	

	public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		req.getRequestDispatcher("login.jsp").forward(req,resp);
		
		/*
		HttpSession session = req.getSession();
		
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		CustomerDAO dao = new CustomerDAO();
		Customer customer = dao.search(login, password);
		
		if (customer != null) {
			session.setAttribute("customer", customer);
			return "login-out.jsp";
		}
		
		return "login-error.jsp";
		*/
	}

}

package logout;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class LogoutAction extends Action {

	public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession(/*false*/);

        if (session != null) {
            session.removeAttribute("teacher");

			req.getRequestDispatcher("logout.jsp").forward(req,resp);
		}
	}

}

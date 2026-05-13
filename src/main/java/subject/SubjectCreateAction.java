package subject;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class SubjectCreateAction extends Action {

	public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String message = (String) req.getAttribute("message");
		if (message != null) {
			req.setAttribute("message", message);
		}

		req.getRequestDispatcher("subjectcreate.jsp").forward(req, resp);
	}

}

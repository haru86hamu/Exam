package subject;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class SubjectCreateAction extends Action {


	public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		
		req.getRequestDispatcher("subjectcreate.jsp").forward(req,resp);
	}

}

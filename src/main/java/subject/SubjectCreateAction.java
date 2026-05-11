package subject;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class SubjectCreateAction extends Action {
<<<<<<< HEAD
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
=======

	public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		
		req.getRequestDispatcher("subjectcreate.jsp").forward(req,resp);
>>>>>>> branch 'master' of https://github.com/haru86hamu/Exam.git
	}

}

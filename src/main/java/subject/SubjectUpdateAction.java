package subject;

import bean.School;
import bean.Teacher;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class SubjectUpdateAction extends Action {

	public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		String message = (String) req.getAttribute("message");
		if (message != null) {
			req.setAttribute("message", message);
		}
		
		HttpSession session = req.getSession();
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		School keyword = teacher.getSchool();
		SubjectDAO dao = new SubjectDAO();
		String cd = req.getParameter("cd");
		String name = dao.getname(cd,keyword);
		
		
		req.setAttribute("cd", cd);
		req.setAttribute("name", name);
		req.getRequestDispatcher("subjectupdate.jsp").forward(req, resp);
	}

}

package subject;

import bean.School;
import bean.Teacher;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class SubjectDeleteAction extends Action {

	public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		HttpSession session = req.getSession();
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		School keyword = teacher.getSchool();
		SubjectDAO dao = new SubjectDAO();
		String cd = req.getParameter("cd");
		String name = dao.getname(cd,keyword);
		
		
		req.setAttribute("cd", cd);
		req.setAttribute("name", name);
		req.getRequestDispatcher("subjectdelete.jsp").forward(req, resp);
	}

}

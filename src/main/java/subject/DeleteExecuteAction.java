package subject;

import bean.School;
import bean.Subject;
import bean.Teacher;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class DeleteExecuteAction extends Action {

	public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		HttpSession session = req.getSession();
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		School school = teacher.getSchool();

		String cd = req.getParameter("cd");
		String name = req.getParameter("name");
		
		Subject subject = new Subject();
		subject.setSchool(school);
		subject.setCd(cd);
		subject.setName(name);
		
		SubjectDAO dao = new SubjectDAO();
		int line = dao.delete(subject);
		
		if (line > 0) {
			req.getRequestDispatcher("subjectdelete_done.jsp").forward(req, resp);
		} else {
			req.setAttribute("massege", "更新に失敗しました");
			req.getRequestDispatcher("SubjectDelete.action").forward(req, resp);
		}
	}
}

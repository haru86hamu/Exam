package subject;

import java.util.List;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class SubjectListAction extends Action {

	public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession();
		SubjectDAO dao = new SubjectDAO();
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		String keyword = teacher.getSchool();
		List<Subject> list = dao.search(keyword);
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("subjectlist.jsp").forward(req, resp);
	}

}

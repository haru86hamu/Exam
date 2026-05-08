package subject;

import bean.School;
import bean.Subject;
import bean.Teacher;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class CreateExecuteAction extends Action {

	public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession();
		SubjectDAO dao = new SubjectDAO();
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		School keyword = teacher.getSchool();
		String cd = req.getParameter("cd");
		String name = req.getParameter("name");
		
		Subject s = new Subject();
		s.setSchool(keyword);
		s.setCd(cd);
		s.setName(name);
		
		int line = dao.insert(s);
		if (line > 0) {
			req.getRequestDispatcher("subjectcreate_done.jsp").forward(req, resp);
		}else {
			String massege = "登録できませんでした";
			req.setAttribute("massege",massege);
			req.getRequestDispatcher("SubjectCreate.action").forward(req, resp);
		}
	}

}

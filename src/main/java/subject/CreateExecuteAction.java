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
		School school = teacher.getSchool();
		
		String cd = req.getParameter("cd");
		String name = req.getParameter("name");
		
		// 入力チェック
		if (cd == null || cd.isBlank() ||
			name == null || name.isBlank()) {

			req.setAttribute("message", "未入力項目があります");
			req.getRequestDispatcher("SubjectCreate.action").forward(req, resp);
			return;
		}
		
		Subject s = new Subject();
		s.setCd(cd);
		s.setName(name);
		s.setSchool(school);
		
		
		Subject ex = dao.get(cd, school);
		if (ex != null) {
			String message = "科目コードが重複しています";
			req.setAttribute("message", message);
			req.getRequestDispatcher("SubjectCreate.action").forward(req, resp);
			return; 
		}
		
		int line = dao.insert(s);
		if (line > 0) {
			req.getRequestDispatcher("subjectcreate_done.jsp").forward(req, resp);
		} else {
			String message = "登録できませんでした";
			req.setAttribute("message", message);
			req.getRequestDispatcher("SubjectCreate.action").forward(req, resp);
		}
	}
}


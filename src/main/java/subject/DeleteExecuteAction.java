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

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		
		HttpSession session = req.getSession(); 
		Teacher teacher = (Teacher)session.getAttribute("user");
		School keyword = teacher.getSchool();
		Subject subject = new Subject();
		SubjectDAO subjectDAO = new SubjectDAO ();
		
		String cd = req.getParameter("cd");
		
		subject.setCd(cd);
		subject.setSchool(keyword);
		
		int line = subjectDAO.delete(subject);
		
		if (line > 0) {
			req.getRequestDispatcher("subjectdelete_done.jsp").forward(req, resp);
		} else {
			req.setAttribute("massege", "更新に失敗しました");
			req.getRequestDispatcher("SubjectDelete.action").forward(req, resp);
		}
		
	}

}

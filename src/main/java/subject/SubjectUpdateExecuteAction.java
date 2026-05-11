package subject;

import bean.School;
import bean.Subject;
import bean.Teacher;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class SubjectUpdateExecuteAction extends Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		SubjectDAO dao = new SubjectDAO();
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		School keyword = teacher.getSchool();

		String cd = request.getParameter("cd");     
		String name = request.getParameter("name"); 

		Subject subject = new Subject();
		subject.setCd(cd);
		subject.setName(name);
		subject.setSchool(keyword);


		int line = dao.update(subject);

		if (line > 0) {
			request.getRequestDispatcher("subjectupdate_done.jsp").forward(request, response);
		} else {
			request.setAttribute("massege", "更新に失敗しました");
			request.getRequestDispatcher("SubjectUpdate.action").forward(request, response);
		}
	}
}

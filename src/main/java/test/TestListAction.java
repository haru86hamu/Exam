package test;

import java.util.List;

import bean.ClassNum;
import bean.School;
import bean.Subject;
import bean.Teacher;
import dao.ClassNumDAO;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class TestListAction extends Action {

	public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		HttpSession session = req.getSession();
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		School keyword = teacher.getSchool();
		ClassNumDAO classdao = new ClassNumDAO();
		SubjectDAO sub = new SubjectDAO();
		
		
		List<ClassNum> classlist = classdao.get(keyword);
		List<Subject> subjects = sub.search(keyword);
		
		
		String message = (String) req.getAttribute("message");
		if (message != null) {
			req.setAttribute("message", message);
		}
		
		req.setAttribute("classlist", classlist);
		req.setAttribute("subjects", subjects);
		req.getRequestDispatcher("testlist.jsp").forward(req, resp);
	}

}

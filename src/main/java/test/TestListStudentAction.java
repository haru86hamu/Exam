package test;

import java.util.List;

import bean.School;
import bean.Subject;
import bean.Teacher;
import bean.TestListStudent;
import dao.StudentDAO;
import dao.SubjectDAO;
import dao.TestListStudentDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class TestListStudentAction extends Action {

	public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		HttpSession session = req.getSession();
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		School keyword = teacher.getSchool();
		StudentDAO dao = new StudentDAO();
		SubjectDAO sub = new SubjectDAO();
		TestListStudentDAO teststdao = new TestListStudentDAO();

		String no = req.getParameter("no");
		String name = dao.searchName(keyword, no);

		List<Subject> subjects = sub.search(keyword);
		List<TestListStudent> stlist = teststdao.selectstudent(keyword,no);
		
		if (stlist != null) {
			String message = "成績が見つかりませんでした";
			if (message != null) {
				req.setAttribute("message", message);
			}
		}

		req.setAttribute("no", no);
		req.setAttribute("name", name);
		req.setAttribute("subjects", subjects);
		req.setAttribute("stlist", stlist);
		req.getRequestDispatcher("testlist.jsp").forward(req, resp);
	}

}

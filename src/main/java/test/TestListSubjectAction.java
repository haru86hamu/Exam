package test;

import java.util.List;

import bean.ClassNum;
import bean.School;
import bean.Student;
import bean.Subject;
import bean.Teacher;
import bean.TestListSubject;
import dao.ClassNumDAO;
import dao.StudentDAO;
import dao.SubjectDAO;
import dao.TestListSubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class TestListSubjectAction extends Action {

	public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		HttpSession session = req.getSession();
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		School keyword = teacher.getSchool();
		ClassNumDAO classdao = new ClassNumDAO();
		SubjectDAO sub = new SubjectDAO();
		TestListSubjectDAO testsubdao = new TestListSubjectDAO();
		StudentDAO dao = new StudentDAO();
		
		List<ClassNum> classlist = classdao.get(keyword);
		List<Subject> subjects = sub.search(keyword);

		int entYear = Integer.parseInt(req.getParameter("year"));
		String classnum = req.getParameter("classnum");
		String subject = req.getParameter("subject");
		
		String subname = sub.getname(subject, keyword);
		
		List<Student> studentno = dao.selectstudent(keyword,entYear,classnum);
		List<TestListSubject> testlist = testsubdao.selectsubject(keyword,entYear,classnum,subject,studentno);
		
		if (testlist != null) {
			String message = "登録された学生が見つかりませんでした";
			if (message != null) {
				req.setAttribute("message", message);
			}
		}
		
		
		
		req.setAttribute("year", entYear);
		req.setAttribute("classnum", classnum);
		req.setAttribute("subject", subject);
		req.setAttribute("classlist", classlist);
		req.setAttribute("subjects", subjects);
		req.setAttribute("subname", subname);
		req.setAttribute("testlist", testlist);
		req.getRequestDispatcher("testlist.jsp").forward(req, resp);
	}

}

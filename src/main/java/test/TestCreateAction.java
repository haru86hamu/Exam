package test;

import java.util.List;

import bean.ClassNum;
import bean.School;
import bean.Student;
import bean.Subject;
import bean.Teacher;
import bean.Test;
import dao.ClassNumDAO;
import dao.StudentDAO;
import dao.SubjectDAO;
import dao.TestDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class TestCreateAction extends Action {

	public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		HttpSession session = req.getSession();
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		School keyword = teacher.getSchool();
		StudentDAO dao = new StudentDAO();
		ClassNumDAO classdao = new ClassNumDAO();
		SubjectDAO sub = new SubjectDAO();
		TestDAO testdao  = new TestDAO();
		
		String entYear = req.getParameter("year");
		String classnum = req.getParameter("classnum");
		String attend = req.getParameter("attend");
		
		List<Student> list = dao.search(keyword, entYear, classnum, attend);
		List<ClassNum> classlist = classdao.get(keyword);
		List<Subject> subjects = sub.search(keyword);
		
		int st = dao.searchNo(no);
		List<Test> test = testdao.get(st);
		
		req.setAttribute("classlist",classlist);
		req.setAttribute("list", list);
		req.setAttribute("subjects", subjects);
		req.getRequestDispatcher("testcreate.jsp").forward(req, resp);
	}

}

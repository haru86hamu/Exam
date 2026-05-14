package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		TestDAO testdao = new TestDAO();

		String entYear = req.getParameter("year");
		String classnum = req.getParameter("classnum");
		String attend = req.getParameter("attend");
		String subject = req.getParameter("subject");

		List<Student> list = dao.search(keyword, entYear, classnum, attend);
		List<ClassNum> classlist = classdao.get(keyword);
		List<Subject> subjects = sub.search(keyword);
		Map<String, Integer> pointMap = new HashMap<>();

		
		String count = req.getParameter("count");
		if (count != null) {
			int testNo = Integer.parseInt(count);
			
			for (Student student : list) {
				List<Test> testList = testdao.get(student.getNo(), subject, testNo);
				if (!testList.isEmpty()) {
					pointMap.put(student.getNo(), testList.get(0).getPoint());
				}
			}
			req.setAttribute("count", count);
			req.setAttribute("pointMap", pointMap);
		}

		String message = (String) req.getAttribute("message");
		if (message != null) {
			req.setAttribute("message", message);
		}

		req.setAttribute("year", entYear);
		req.setAttribute("classnum", classnum);
		req.setAttribute("attend", attend);
		req.setAttribute("subject", subject);
		req.setAttribute("classlist", classlist);
		req.setAttribute("list", list);
		req.setAttribute("subjects", subjects);
		req.getRequestDispatcher("testcreate.jsp").forward(req, resp);
	}

}

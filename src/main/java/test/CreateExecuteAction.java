package test;

import java.util.ArrayList;
import java.util.List;

import bean.ClassNum;
import bean.School;
import bean.Student;
import bean.Subject;
import bean.Teacher;
import bean.Test;
import dao.TestDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class CreateExecuteAction extends Action {

	public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		HttpSession session = req.getSession();
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		School keyword = teacher.getSchool();
		TestDAO dao = new TestDAO();
		String[] no = req.getParameterValues("studentNo");
		String[] classnum = req.getParameterValues("classNum");
		String[] point = req.getParameterValues("point");
		String subject = req.getParameter("subject");
		int count = Integer.parseInt(req.getParameter("count"));

		boolean ins = false;		
			
		for (int i = 0; i < no.length; i++) {
			List<Test> list = new ArrayList<>();
			List<Test> testList = dao.get(no[i], subject, count);
			Student student = new Student();
			ClassNum classNum = new ClassNum();
			Subject sub = new Subject();
			Test t = new Test();

			student.setNo(no[i]);
			classNum.setClassNum(classnum[i]);
			sub.setCd(subject);
			
			if (testList.isEmpty()) {
				t.setStudent(student);
				t.setSubject(sub);
				t.setSchool(keyword);
				t.setNo(count);
				t.setPoint(Integer.parseInt(point[i]));
				t.setClassNum(classNum);
				list.add(t);
				ins = dao.insert(list);
				if (ins == false) {
					req.setAttribute("message", "成績を登録できませんでした。");
					req.getRequestDispatcher("TestCreate.action").forward(req, resp);
				}
			} else {
				t.setStudent(student);
				t.setSubject(sub);
				t.setSchool(keyword);
				t.setNo(count);
				t.setPoint(Integer.parseInt(point[i]));
				t.setClassNum(classNum);
				list.add(t);
				ins = dao.update(list);
				if (ins == false) {
					req.setAttribute("message", "成績を登録できませんでした。");
					req.getRequestDispatcher("TestCreate.action").forward(req, resp);
				}
			}
		}

		
		if (ins == true) {
			req.getRequestDispatcher("testcreate_done.jsp").forward(req, resp);
		} else {
			req.setAttribute("message", "成績を登録できませんでした。");
			req.getRequestDispatcher("TestCreate.action").forward(req, resp);
		}

	}

}

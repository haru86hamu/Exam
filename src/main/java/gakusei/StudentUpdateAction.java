package gakusei;

import java.util.List;

import bean.ClassNum;
import bean.Student;
import bean.Teacher;
import dao.ClassNumDAO;
import dao.StudentDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class StudentUpdateAction extends Action {

	public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		
		HttpSession session = req.getSession();
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		String keyword = teacher.getSchool();
		StudentDAO stdao = new StudentDAO();
		ClassNumDAO classNumDao = new ClassNumDAO();
		String no = req.getParameter("no");
		List<Student> stlist = stdao.selectNo(keyword,no);
		List<ClassNum> classNumList = classNumDao.get(keyword);
		
		if (!stlist.isEmpty()) {
			Student student = stlist.get(0);
			req.setAttribute("entYear", student.getEntYear());
			req.setAttribute("no", student.getNo());
			req.setAttribute("name", student.getName());
			req.setAttribute("classNum", student.getClassNum());
			req.setAttribute("isAttend", student.getIsAttend());
		}
		req.setAttribute("classNumList", classNumList);
		req.getRequestDispatcher("studentupdate.jsp").forward(req, resp);
	}

}

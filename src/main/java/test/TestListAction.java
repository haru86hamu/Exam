package test;

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

public class TestListAction extends Action {

	public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		HttpSession session = req.getSession();
		StudentDAO dao = new StudentDAO();
		ClassNumDAO classdao = new ClassNumDAO();
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		String keyword = teacher.getSchool();
		String entYear = req.getParameter("year");
		String classnum = req.getParameter("classnum");
		String attend = req.getParameter("attend");
		List<Student> list = dao.search(keyword, entYear, classnum, attend);
		List<ClassNum> classlist = classdao.get(keyword);
		req.setAttribute("classlist",classlist);
		req.setAttribute("list", list);
		req.getRequestDispatcher("testlist.jsp").forward(req, resp);
	}

}

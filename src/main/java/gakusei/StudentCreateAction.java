package gakusei;

import java.util.List;

import bean.ClassNum;
import bean.Teacher;
import dao.ClassNumDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class StudentCreateAction extends Action {

	public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		HttpSession session = req.getSession();
		ClassNumDAO classdao = new ClassNumDAO();
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		String keyword = teacher.getSchool();
		List<ClassNum> classlist = classdao.get(keyword);
		
		req.setAttribute("classlist",classlist);
		req.getRequestDispatcher("studentcreate.jsp").forward(req,resp);
	}

}

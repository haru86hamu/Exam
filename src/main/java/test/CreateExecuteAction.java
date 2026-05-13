package test;

import java.util.ArrayList;
import java.util.List;

import bean.School;
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
		List<Test> list = new ArrayList<>();
		TestDAO dao = new TestDAO();
		Test test = new Test();
		
		String no = req.getParameter("no");
		String name = req.getParameter("name");
		String classnum = req.getParameter("classnum");
		int score = Integer.parseInt(req.getParameter("score"));
		int count = Integer.parseInt(req.getParameter("count"));
		String subject = req.getParameter("subject");
		
		
		
	}

}

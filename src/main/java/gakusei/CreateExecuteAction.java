package gakusei;
import bean.Student;
import bean.Teacher;
import dao.StudentDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class CreateExecuteAction extends Action {

	public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		HttpSession session = req.getSession();
		StudentDAO dao = new StudentDAO();
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		String keyword = teacher.getSchool();
		int entYear = Integer.parseInt(req.getParameter("year"));
		String no = req.getParameter("no");
		String name = req.getParameter("name");
		String classnum = req.getParameter("classnum");
		
		
		
		Student s = new Student();
		s.setEntYear(entYear);
		s.setNo(no);
		s.setName(name);
		s.setClassNum(classnum);
		s.setSchool(keyword);
		s.setIsAttend(true);
		
		int st = dao.searchNo(no);
		if (st < 0) {
			String stmassege = "学生番号が重複しています";
			req.setAttribute("stmassege",stmassege);
			req.getRequestDispatcher("StudentCreate.action").forward(req, resp);
		}
		
		int line = dao.insert(s);
		if (line > 0) {
			req.getRequestDispatcher("studentcreate_done.jsp").forward(req, resp);
		}else {
			String massege = "登録できませんでした";
			req.setAttribute("massege",massege);
			req.getRequestDispatcher("StudentCreate.action").forward(req, resp);
		}
	}

}

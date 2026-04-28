package login;

import bean.Teacher;
import dao.TeacherDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class LoginExecuteAction extends Action {

	public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession();
		
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		TeacherDAO dao = new TeacherDAO();
		Teacher teacher = dao.login(id, password);
		
		if (teacher != null) {
			session.setAttribute("teacher", teacher);
			System.out.println("login sessionId = " + session.getId());
			System.out.println("login teacher = " + session.getAttribute("teacher"));


			req.getRequestDispatcher("/main/Menu.action").forward(req,resp);
		} else {
			req.getRequestDispatcher("login.jsp").forward(req,resp);

		}
		
	}
	
	
	

}

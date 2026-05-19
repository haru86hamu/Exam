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
		TeacherDAO dao = new TeacherDAO();
		
		
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		Teacher teacher = dao.login(id, password);
		
		
		if (teacher != null) {
			session.setAttribute("teacher", teacher);
			System.out.println("login sessionId = " + session.getId());
			System.out.println("login teacher = " + session.getAttribute("teacher"));
			req.getRequestDispatcher("/main/Menu.action").forward(req,resp);
		} else {
			req.setAttribute("message", "IDまたはパスワードが確認できませんでした");
			req.setAttribute("id",id);
			req.getRequestDispatcher("login.jsp").forward(req,resp);

		}
		
	}
	
	
	

}

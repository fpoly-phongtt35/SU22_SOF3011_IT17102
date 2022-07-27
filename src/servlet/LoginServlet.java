package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import model.AccountRole;
import service.AuthenticationService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private final AuthenticationService authenService = new AuthenticationService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		Account account = authenService.authenticate(username, password);
		HttpSession session = req.getSession();
		if (account == null) { // Xác thực không thành công
			session.setAttribute("error"
					, "Tài khoản/mật khẩu không chính xác");
			
			resp.sendRedirect("/SampleORM_IT17102/login");
		} else { // Đăng nhập thành công
			session.setAttribute("username", account.getUsername());
			session.setAttribute("role", account.getRole());
			
			session.removeAttribute("error"); // Xoá error message
			
			resp.sendRedirect("/SampleORM_IT17102/user");
		}
	}

}

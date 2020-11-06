package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.UserDao;
import domain.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//フォワード
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//入力値の取得
		String loginId = request.getParameter("login_id");
		String loginPass = request.getParameter("login_pass");
		System.out.println(loginId);
		System.out.println(loginPass);

		// DBを参照し、ログインIDとPassが正しいか確認する
		UserDao dao = DaoFactory.createUserDao();
		User user = null;
		try {
			user = dao.findByLoginAndLoginPass(loginId, loginPass);
		}
		 catch(Exception e) {
			 e.printStackTrace();
		 }

		if(user != null) {
			System.out.println("成功");
		}else {
			System.out.println("失敗");
		}
	}

}

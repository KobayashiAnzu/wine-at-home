package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.WineDao;
import domain.Wine;

/**
 * Servlet implementation class MyPageServlet
 */
@WebServlet("/myPage")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			//DAOを使いデータを取得
			WineDao dao = DaoFactory.createWineDao();
			List<Wine> wines = dao.findAll();

			//スコープに格納
			request.setAttribute("wines", wines);

			//フォワード
			request.getRequestDispatcher("/WEB-INF/view/myPage.jsp").forward(request, response);

	    }
		  catch(Exception e) {

			 e.printStackTrace();
		  }
		}

}

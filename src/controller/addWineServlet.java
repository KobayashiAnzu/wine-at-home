package controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.DaoFactory;
import dao.WineDao;
import domain.Wine;

/**
 * Servlet implementation class addWineServlet
 */
@WebServlet("/addWine")
@MultipartConfig(location="C:/temp")
public class addWineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/view/addWine.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//戻るボタンが押された場合マイページに戻る
		if (request.getParameter("back") != null) {
			response.sendRedirect("myPage");
			return;
		}

		//登録ボタンが押されたとき
		//入力値の取得

		String name = request.getParameter("name");
		String strEvaluation = request.getParameter("evaluation");
		String type = request.getParameter("type");
		String country = request.getParameter("country");
		String strPrice = request.getParameter("price");
		String strDate = request.getParameter("date");
		String comment = request.getParameter("comment");

		// 選択されたファイルの情報を取得
		Part part = request.getPart("image");
		String fileType = part.getContentType();
		long fileSize = part.getSize();
		String image = part.getSubmittedFileName();

		//入力値のバリデーション(不備があれば、falseにする)
		boolean isValidated = true;

		// 価格のバリデーション
		// 0～1億の間
		Integer price = null;
		try {
			price = Integer.parseInt(strPrice);
			if (price < 0 || price > 1000000000) {
				isValidated = false;
				request.setAttribute("errPrice", "※範囲外です");
			}
		} catch (NumberFormatException e) {
			isValidated = false;
			request.setAttribute("errPrice", "※整数でお願いします");
		}

		//型変換
		Integer evaluation = Integer.parseInt(strEvaluation);
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try {
			date = fmt.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// 商品名のバリデーション
		// 必須
		Pattern namePattern = Pattern.compile("^[ァ-ヶー]*$");
		Matcher nameMatcher = namePattern.matcher(name);
		if (name.isEmpty()) {
			isValidated = false;
			request.setAttribute("errName", "※必須項目です");
		} else if (name.length() > 30) {
			isValidated = false;
			request.setAttribute("errName", "※30字以内");
		} else if (!nameMatcher.matches()) {
			isValidated = false;
			request.setAttribute("errName", "※全角カナ");
		}

		// 原産国のバリデーション
		// 必須
		if (country.isEmpty()) {
			isValidated = false;
			request.setAttribute("errCountry", "※必須項目です");
		}
        
		//画像のバリデーション
		if(fileSize > 0) {
			if(!fileType.startsWith("image/")){
				isValidated = false;
				request.setAttribute("errImage", "※画像を選択して下さい");
			}
			else {
				File path = getAbsPath(request);
				System.out.println(path);
				part.write(path + "/" + image);
			}
		}


		//フォーム再表示用にスコープに格納
		request.setAttribute("image", image);
		request.setAttribute("name", name);
		request.setAttribute("evaluation", evaluation);
		request.setAttribute("type", type);
		request.setAttribute("country", country);
		request.setAttribute("price", strPrice);
		request.setAttribute("date", date);
		request.setAttribute("comment", comment);

		// もし入力に問題なければそのまま進む↓
		if (isValidated == true) {

			//Wineオブジェクトにまとめる
			Wine wine = new Wine();
			wine.setImage(image);
			wine.setName(name);
			wine.setEvaluation(evaluation);
			wine.setType(type);
			wine.setCountry(country);
			wine.setPrice(price);
			wine.setDate(date);
			wine.setComment(comment);

			//DaoにDBに追加してもらう
			WineDao dao = DaoFactory.createWineDao();
			try {
				dao.insert(wine);
			} catch (Exception e) {
				e.printStackTrace();
			}

			//完了画面を表示
			request.getRequestDispatcher("/WEB-INF/view/doneAddWine.jsp").forward(request, response);

			// 入力値に不備があった場合
			//エラーメッセージをリクエストスコープに格納
		} else {
			request.setAttribute("msg", "※不備があります");
		}

		request.getRequestDispatcher("/WEB-INF/view/addWine.jsp")
				.forward(request, response);

	}

	/**
	 * アップロードフォルダの絶対パスを取得
	 */
	private File getAbsPath(HttpServletRequest request) {
		String path = request.getServletContext()
				.getRealPath("/uploads");
		return new File(path);
	}

	/**
	 * uploadsフォルダ内のファイルを
	 * 配列として取得
	 */
	private File[] getUploadedFiles(HttpServletRequest request) {
		File filePath = getAbsPath(request);
		return filePath.listFiles();
	}

}

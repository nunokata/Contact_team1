package servlet;

import java.io.IOException;

import bean.Contact;
import dao.ContactDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 問い合わせ管理システムにおける問い合わせ詳細一覧機能に関する処理をおこなうサーブレットクラス
 *
 * @author KandaITSchool
 *
 */
public class DetailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String error = "";

		try {

			// 入力データの文字コードの指定
			request.setCharacterEncoding("UTF-8");

			// � isbnとcmd(フォワード先を区別するパラメータ)を取得
			String userNum = request.getParameter("userNum");
			userNum = "1";

			// � ContactDAOをインスタンス化
			ContactDAO objDao = new ContactDAO();

			// � 問い合わせ情報を検索し、戻り値としてContactオブジェクトを取得する
			Contact contact = objDao.selectByUserNum(userNum);

			// 詳細情報のエラーチェック
			if (contact.getUserNum() == 0) {
				error = "表示対象の問い合わせが存在しない為、詳細情報は表示出来ませんでした。";
			}

			//既読・未読ステータスを１：既読にする
			contact.setStatus(1);
			//レコードを更新
			objDao.update(contact);
			
			// � �で取得したcontactをリクエストスコープに"contact"という名前で格納する
			request.setAttribute("contact", contact);

		} catch (IllegalStateException e) {	
			error = "DB接続エラーの為、問い合わせ詳細は表示出来ませんでした。";
		} finally {
			// エラーの有無でフォワード先を呼び分ける
			if (error.equals("")) {
				request.getRequestDispatcher("/view/detail.jsp").forward(
				        request, response);
			} else {
				// エラーが有る場合はerror.jspにフォワードする
				request.setAttribute("error", error);
				request.getRequestDispatcher("/view/error.jsp").forward(
						request, response);

			}
		}

	}
}

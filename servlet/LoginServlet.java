
	package servlet;

	import java.io.IOException;

import bean.Admin;
import dao.AdminDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

	/**
	 * 書籍管理システムにおけるログイン機能に関する処理をおこなうサーブレットクラス
	 *
	 * @author KandaITSchool
	 *
	 */
	@WebServlet("/login")
	public class LoginServlet extends HttpServlet {

		public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			String error = "";
			String cmd = "";

		try {

				// � userid,password入力パラメータを取得する
				String email = (String) request.getParameter("email");
				String passward = (String) request.getParameter("passward");

				// � UserDAOをインスタンス化し、ユーザー情報の検索をおこなう
				AdminDAO adminObj = new AdminDAO();
				Admin admin = adminObj.selectByAdmin(email, passward);

				// ユーザー情報のチェック
				if (admin.getEmail() == null) {
					error = "入力データが間違っています。";
					cmd = "login";
					return;
				}

				// ユーザー情報がある場合、セッションにスコープにuserという名前で登録する
				HttpSession session = request.getSession();
				session.setAttribute("email", email);

			} catch (IllegalStateException e) {
				error = "DB接続エラーの為、ログイン出来ません。";
				cmd = "login";

			} finally {
				if (error.equals("")) {
					request.getRequestDispatcher("/view/menu.jsp").forward(request,
							response);
				} else {
					request.setAttribute("error", error);
					if (cmd.equals("login")) {
						request.getRequestDispatcher("/view/login.jsp").forward(
								request, response);
					} else {
						request.setAttribute("cmd", cmd);
						request.getRequestDispatcher("/view/error.jsp").forward(
								request, response);
					}
				}
			}

		}
	}

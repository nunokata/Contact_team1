package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.Admin;

public class AdminDAO {
	/**
	 * JDBCドライバ内部のDriverクラスパス
	 */
    private static final String RDB_DRIVE = "org.mariadb.jdbc.Driver";
	/**
	 * 接続するMySQLデータベースパス
	 */
    private static final String URL = "jdbc:mariadb://localhost/contactdb";
	/**
	 * データベースのユーザー名
	 */
	private static final String USER = "root";
	/**
	 * データベースのパスワード
	 */
	private static final String PASSWD = "root123";

	/**
	 * フィールド変数のデータベース情報を基に、DB接続をおこなう
	 *
	 * @return データベース接続情報
	 * @throws IllegalStateException
	 *             メソッド内部で例外が発生した場合
	 */
	private static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(RDB_DRIVE);
			con = DriverManager.getConnection(URL,USER,PASSWD);
			return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}
	public Admin selectByAdmin(String email, String passward) {
		Connection con = null;
		Statement smt = null;
		Admin admin = new Admin();

		try {
			con = getConnection();
			smt = con.createStatement();

			String sql = "SELECT * FROM userinfo WHERE email='" + email
					+ "' AND passward='" + passward + "'";

			ResultSet rs = smt.executeQuery(sql);

			if (rs.next()) {
				admin.setEmail(rs.getString("email"));
				admin.setPassward(rs.getString("passward"));
			}
		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}

		return admin;
	}
}


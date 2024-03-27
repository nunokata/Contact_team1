package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import bean.Reply;

public class ReplyDAO {
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
	public void insert(Reply reply) {
		Connection con = null;
		Statement smt = null;
		try {
			con = getConnection();
			smt = con.createStatement();
			String sql = "INSERT INTO bookinfo(isbn,title,price) VALUES('"
					+ reply.getSubject() + "','" + reply.getAnswerText() + "',"
					+ reply.getFlag() + ")";
			smt.executeUpdate(sql);

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
	}
}

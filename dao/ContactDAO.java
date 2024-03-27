package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Contact;

public class ContactDAO {
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
	public ArrayList<Contact> selectAll(){
		Connection con = null;
		Statement smt = null;
		ArrayList<Contact> contactList = new ArrayList<Contact>();
		
		try {
			con = getConnection();
			smt = con.createStatement();
			
			String sql = "Select * FROM userinfo ORDER BY userNum";
			ResultSet rs = smt.executeQuery(sql);
			
			while (rs.next()) {
				Contact contact = new Contact();
				contact.setUserNum(rs.getInt("userNum"));
				contact.setEmail(rs.getString("userEmail"));
				contact.setAge(rs.getInt("age"));
				contact.setName(rs.getString("userName"));
				contact.setGender(rs.getString("gender"));
				contact.setAddress(rs.getString("address"));
				contact.setPulldown(rs.getString("contactItem"));
				contact.setHowYou(rs.getString("howYou"));
				contact.setFreeText(rs.getString("freeText"));
				contact.setContactDate(rs.getString("contactDate"));
				contact.setStatus(rs.getInt("status"));
			}
		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
		return contactList;
	}
	//変更必須
	public void insert(Contact contact) {
		Connection con = null;
		Statement smt = null;
		try {
			con = getConnection();
			smt = con.createStatement();
			String sql = "INSERT INTO userinfo(userNum,userEmail,userName,gender,address,contactItem,howYou,freeText,contactDate,status)"
					+ "VALUES(NULL,'" + contact.getEmail() + "','" + contact.getName() + "','" + contact.getGender() +  "','"  + contact.getAddress() + "','" + contact.getPulldown() + "','" + contact.getHowYou() + "','" + contact.getFreeText() + "',now())";
			smt.executeUpdate(sql);
		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				}catch(SQLException ignore){
				}
			}
			if(con != null) {
				try {
					con.close();
				}catch (SQLException ignore) {
					
				}
			}
		}
	}
	public Contact selectByUserNum(String userNum) {
		Contact contact = new Contact();
		Connection con = null;
		Statement smt = null;
		try {
			con = getConnection();
			smt = con.createStatement();
			String sql = "SELECT * FROM Contactinfo WHERE userNum='" + userNum + "'";
			ResultSet rs = smt.executeQuery(sql);

			if (rs.next()) {
				contact.setUserNum(rs.getInt("userNum"));
				contact.setEmail(rs.getString("userEmail"));
				contact.setName(rs.getString("userName"));
				contact.setAge(rs.getInt("age"));
				contact.setGender(rs.getString("gender"));
				contact.setAddress(rs.getString("address"));
				contact.setPulldown(rs.getString("contactItem"));
				contact.setHowYou(rs.getString("howYou"));
				contact.setFreeText(rs.getString("freeText"));
				contact.setContactDate(rs.getString("contactDate"));
				contact.setStatus(rs.getInt("status"));
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
		return contact;
	}

	
	public ArrayList<Contact> search(int userNum, String email, String name, String address, int gender, int pulldown,  String howYou, 
			String freeText,String contactDate, int status){
		Connection con = null;
		Statement smt = null;
		ArrayList<Contact> contactList = new ArrayList<Contact>();
		try {
			con = getConnection();
			smt = con.createStatement();
			
			String sql = "SELECT * FROM userinfo WHERE userNum LIKE '%" + userNum+ "%' AND userEmail LIKE '%" + email + "%' AND userName LIKE '%" + name + 
					 	"%' AND gender LIKE '%" + gender + "%' AND address LIKE '%" + address + "%' AND gender LIKE '%" + gender + "%' AND contactItem LIKE '%"+ pulldown + 
						"%' AND howYou LIKE '%"+ howYou + "%' AND contactDate LIKE '%"+ contactDate + "%' AND contactDate LIKE '%"+ contactDate + 
						"%' AND status LIKE '%"+ status + "%'";
			
			ResultSet rs = smt.executeQuery(sql);
			
			while (rs.next()) {
				Contact contact = new Contact();
				contact.setUserNum(rs.getInt("userNum"));
				contact.setEmail(rs.getString("userEmail"));
				contact.setName(rs.getString("userName"));
				contact.setGender(rs.getString("gender"));
				contact.setAge(rs.getInt("age"));
				contact.setAddress(rs.getString("address"));
				contact.setPulldown(rs.getString("contactItem"));
				contact.setHowYou(rs.getString("howYou"));
				contact.setFreeText(rs.getString("freeText"));
				contact.setContactDate(rs.getString("contactDate"));
				contact.setStatus(rs.getInt("status"));
			}
		}catch (Exception e) {
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
		return contactList;
	}
	
	/**
	 * 引数の問い合わせデータを基にDBの問い合わせ情報を格納するuserinfoテーブルから概要問い合わせデータの更新処理をおこなう
	 *
	 * @param _contact
	 *            更新する問い合わせ情報のオブジェクト
	 * @throws IllegalStateException
	 *             メソッド内部で例外が発生した場合
	 */
	public void update(Contact _contact) {
		Connection con = null;
		Statement smt = null;
		try {
			con = getConnection();
			smt = con.createStatement();
//			String sql = "UPDATE userinfo SET status ='" + _contact.getTitle()
//					+ "', price = '" + _contact.getPrice() + "' WHERE isbn ='"
//					+ _contact.getIsbn() + "'";
			String sql = "UPDATE userinfo SET status ='" + _contact.getStatus()
			 + "' WHERE userNum ='"
			+ _contact.getUserNum() + "'";
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

 

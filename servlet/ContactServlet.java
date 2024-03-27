package servlet;

import java.io.IOException;

import bean.Contact;
import dao.ContactDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/insert")
public class ContactServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String error ="";
		ContactDAO daoObj = new ContactDAO();
		Contact contact = new Contact();
		
		try {
			    String inputUserNum = request.getParameter("userNum");
				String inputEmail = request.getParameter("userEmail");
				String inputName = request.getParameter("userName");
				String inputAge= request.getParameter("age");
				String inputGender = request.getParameter("gender");
				String inputAddress = request.getParameter("address");
				String inputHowYou = request.getParameter("howYou");
				String inputPulldown = request.getParameter("contactItem");
				String inputFreeText = request.getParameter("freeText");
				String inputContactDate = request.getParameter("contactDate");
				String inputStatus = request.getParameter("status");
			
				if (inputEmail.equals("")) {
					error = "メールアドレスが未入力の為、講師へのお問い合わせは行えませんでした。";
					return;
				}
	
				if (inputName.equals("")){
					error = "名前が未入力の為、講師へのお問い合わせは行えませんでした。";
					return;
				}
				
				if (inputAddress.equals("")) {
					error = "住所が未入力の為、講師へのお問い合わせは行えませんでした。";
					return;
				}
				
				if (inputHowYou.equals("a")) {
					error = "受講状況を入力してください。";
					return;
				}
				
				if (inputFreeText.equals("")) {
					error = "内容が未入力の為、講師へのお問い合わせは行えませんでした。";
					return;
				}
				
				if (inputPulldown.equals("o")) {
					error = "項目を選択してください。";
					return;
				}
				
				
				int age;
				
				age = Integer.parseInt(inputAge);
				
				
				contact.setEmail (inputEmail);
				contact.setName (inputName);
				contact.setAge(age);
				contact.setGender (inputGender);
				contact.setAddress (inputAddress);
				contact.setPulldown(inputPulldown);
				contact.setHowYou (inputHowYou);
				contact.setFreeText (inputFreeText);
				contact.setContactDate (inputContactDate);
				
				daoObj.insert(contact);
				
			}catch (IllegalStateException e) {
				
				error = "接続エラーの為、神田英会話スクールのお問い合わせシステム\nまで到達できませんでした";
			
			}finally {
				request.setAttribute("error",error);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
		}
	}
}


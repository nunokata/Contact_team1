<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.Contact"%>

<%
Contact contact = (Contact) request.getAttribute("contact");
%>

<html>
	<head>
		<title>問い合わせ詳細情報</title>
	</head>
	<body>
		<!--ヘッダー部分  -->
		<%@ include file="/common/headerA.jsp"%>
		<br>
		<br>
		<div id="page_title" align="center">
		<h2>お問い合わせ詳細</h2>
		</div>
		<table class="detail-table">
			<tr>
				<th>お問い合わせ番号</th>
				<td><%=contact.getUserNum()%></td>
			</tr>
			<tr>
				<th>氏名</th>
				<td><%=contact.getName()%></td>
			</tr>
			<tr>
				<th>受講状態</th>
				<td><%=contact.getHowYou()%></td>
			</tr>
			<tr>
				<th>項目</th>
				<td><%=contact.getPulldown()%></td>
			</tr>
			<tr>
				<th>内容</th>
				<td><%=contact.getFreeText()%></td>
			</tr>						
			<tr>
				<th>日時</th>
				<td><%=contact.getContactDate()%></td>
			</tr>												
		</table>

		
	</body>


</html>
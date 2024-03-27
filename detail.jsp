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
		<h2>お問い合わせ詳細No.</h2>
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
				<th>お客様メールアドレス</th>
				<td><%=contact.getEmail() %></td>
			</tr>
			<tr>
				<th>性別</th>
				<td><% if (contact.getGender().equals("a")){%>
                   	男性
                    <% }else if (contact.getGender().equals("b")){ %>
                    女性
                    <%} else{ %>
                    その他
                    <%} %></td>
			</tr>
			<tr>
				<th>受講状態</th>
				<td><% if (contact.getHowYou().equals("b")){%>
                    入学希望者
                    <% }else if (contact.getHowYou().equals("c")){ %>
                    受講生
                    <%} else{ %>
                    卒業生
                    <%} %></td>
			</tr>
			<tr>
				<th>項目</th>
                <td><% if (contact.getPulldown().equals("p")){%>
                    ① 料金・お支払いについて
                    <% }else if (contact.getPulldown().equals("q")){ %>
                    ② 講座、コース、教材について
                    <% }else if (contact.getPulldown().equals("r")){ %>
                    ③ 学習の進め方について
                    <% }else if (contact.getPulldown().equals("s")){ %>
                    ④ 受講期限について
                    <% }else if (contact.getPulldown().equals("t")){ %>
                    ⑤ 受講終了後のサポートについて
                    <%} else{ %>
                    ⑥その他
                    <%} %></td>
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



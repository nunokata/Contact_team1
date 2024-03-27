<!-- お問い合わせ一覧 -->
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.Contact"%>

<%
	ArrayList<Contact> contact_list = (ArrayList<Contact>) request
			.getAttribute("contact_list");
%>
<%
int a = 1;
%>


<html>
<head>
<title>お問い合わせ一覧</title>

</head>

<body bgcolor="#f0e68c" text="#000000">
	<!--ヘッダー部分  -->
	<%@ include file="/common/headerA.jsp"%>
	<br>
	<br>
	<div id="page_title" align="center">
		<h2>お問い合わせ一覧</h2>
		<!-- <form action="サイトURL" align = "center" method="get">
		 <input type="search" name="search" placeholder="キーワードを入力">
		 <input type="submit" name="submit" value="検索">
			</form> -->
	</div>
	<br>
	<br>

	<!-- お問い合わせ一覧 -->
	<table align="center" border="1">
		<thead>
			<tr>
				<th>No.</th>
				<th>氏名</th>
				<th>受講状態</th>
				<th>項目</th>
				<th>内容</th>
				<th>日時</th>
				<th>ステータス</th>
			</tr>
		</thead>
		<tbody>
			<%
			if (contact_list != null) {
				for (Contact contact : contact_list) {
			%>
			<tr>
				<td><a href="<%=request.getContextPath()%>/detail?userNum=<%=contact.getUserNum()%>"><%=contact.getUserNum()%></a></td>
				<td><%=contact.getName()%></td>
				<td><% if (contact.getHowYou().equals("b")){%>
					入学希望者
					<% }else if (contact.getHowYou().equals("c")){ %>
					受講生
					<%} else{ %>
					卒業生
					<%} %></td>
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
					<%} %>
					</td>
				<td><%=contact.getFreeText()%></td>
				<td><%=contact.getContactDate()%></td>
				<td>
				    <% if (contact.getStatus() == 0) { %>
				        未読
				    <% } else { %>
				        既読
					<% } %>
				</td>

			</tr>
		    <%  
		   	     }
			} else { 
			%>
				<tr>
					<td style="text-align:center; width:200px">&nbsp;aa</td>
					<td style="text-align:center; width:200px">&nbsp;</td>
					<td style="text-align:center; width:200px">&nbsp;</td>
					<td style="text-align:center; width:200px">&nbsp;</td>
					<td style="text-align:center; width:200px">&nbsp;</td>
					<td style="text-align:center; width:250px">&nbsp;</td>
					<td>
				    <% if (a == 0) { %>
				        未読
				    <% } else { %>
				        既読
					<% } %>
				    </td>
				</tr>
		    <% } %>
		</tbody>

	</table>
	<br><br>
	<div align="center">
		[<a href="<%=request.getContextPath()%>/view/title.jsp">タイトルへ戻る</a>]
</body>



</html>
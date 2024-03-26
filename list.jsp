<!-- お問い合わせ一覧 -->
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.Contact"%>





<html>
<head>
<title>お問い合わせ一覧</title>

</head>

<body>
	<!-- ブラウザ全体 -->


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
				<th>ステータス</th>
			</tr>
		</thead>
		<tbody>
			<%
			ArrayList<Contact> list =(ArrayList<Contact>)request.getAttribute("contact_list");
			if(list != null){
				for(int i=0;i<list.size();i++){
					Contact contacts = (Contact)list.get(i);
				%>
			<tr>
				<td><a
					href="<%=request.getContextPath()%><%=contacts.userNum() %><%=contacts.getEmail() %></a></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>

			</tr>
			<%
					}
				}else{
				%>
				<tr>
					<td style="text-align:center; width:200px">&nbsp;</td>
					<td style="text-align:center; width:200px">&nbsp;</td>
					<td style="text-align:center; width:200px">&nbsp;</td>
					<td style="text-align:center; width:250px" colspan="2">&nbsp;</td>
				</tr>
				<%
				}
				%>
		</tbody>

	</table>
	<div align="center">
		<a href="test.html">TOP画面に戻る</a></div>
</body>



</html>
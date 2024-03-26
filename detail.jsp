<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bms.Book,util.MyFormat"%>

<%
	Book book = (Book)request.getAttribute("Book");
	MyFormat format = new MyFormat();
%>
				
<html>
	<head>
		<title>書籍詳細情報</title>
	</head>
	<body>
		<%@include file="/common/header.jsp" %>
		<div>

		<table style="margin:auto; width:850px">
			<tr>
				<td style="text-align:center; width:80px">[<a href="<%=request.getContextPath() %>/view/menu.jsp">メニュー</a>]</td>
				<td style="text-align:center; width:80px">[<a href="<%=request.getContextPath() %>/view/insert.jsp">書籍登録</a>]</td>
				<td style="text-align:center; width:80px">[<a href="<%=request.getContextPath() %>/view/list">書籍一覧</a>]</td>
				<td style="text-align:center; width:508px; font-size:24px;">書籍詳細情報</td>
				<td style="width:80px">&nbsp;</td>
				<td style="width:80px">&nbsp;</td>
			</tr>
		</table>
		
		<form action ="<%=request.getContextPath()%>/detail">
			<input type = "submit" value = "変更" >
			<input type="hidden" name="isbn" value="<%=book.getIsbn()%>">
			<input type="hidden" name="cmd" value="update">
		</form>
		<form action="<%=request.getContextPath()%>/delete" class="inline-block">				<input type="hidden" name="isbn" value="<%=book.getIsbn() %>">
				<input type="hidden" name="isbn" value="<%=book.getIsbn() %>">
			<input type="submit" value="削除" ">
		</form>
		
		<table align="center" border="0" style="align:center" >
		
					<br><br>
					
					<tr>
						<th style="background-color:blue ;" >ISBN　　</th>
						<td style="background-color:#5AFF19 ;"><%=book.getIsbn() %></td>
					</tr>
					
					<tr>
						<th style="background-color:blue ;">TITLE　　</th>
						<td style="background-color:#5AFF19 ;"><%=book.getTitle() %></td>
					</tr>
					
					<tr>
						<th style="background-color:blue ;">価格　　</th>
						<td style="background-color:#5AFF19 ;">><%=format.moneyFormat(book.getPrice())%></td>
					</tr>
					
				</table>
		</div>
		<%@include file="/common/footer.jsp" %>
	</body>
</html>

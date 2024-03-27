<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.Admin"%>

<%
	//各データをセッションから取得
	String email = "";
	String passward = "";
	String error = (String) request.getAttribute("error");
	if (error == null) {
		error = "";
	}
%>
<html>
	<head>
		<title>神田英会話スクール管理者ログイン</title>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
	</head>

	<body>
	<br><br>
		<!-- ブラウザ全体 -->
		<div id="wrap">
			<!-- ヘッダー部分 -->
			<%@ include file="/common/headerB.jsp" %>

			<!-- ログインのコンテンツ部分 -->
			<div align = "center" id="main" class="container">

				<p><%=error %></p>
				<form action="<%=request.getContextPath()%>/login" method="POST">
					<table class="input-table">
						<tr>
								<br><br>
							<th><h2>管理者ID</h2></th>
							<td>
								<h2><input type="text" size="25" name="email" value="<%=email %>"></h2>
							</td>
						</tr>
						<tr>
							<th><h2>パスワード</h2></th>
							<td>
								<h2><input type="password" size="25" name="passward" value="<%=passward %>"></h2>
							</td>
						</tr>
					</table>
					<h2><input type="submit" value="ログイン"></h2>
				</form>
			</div>
			[<a href="<%=request.getContextPath()%>/view/title.jsp">タイトルへ戻る</a>]
			<!-- フッター部分 -->
			<%@ include file="/common/footerB.jsp" %>
		</div>
	</body>
</html>

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
		<!-- ブラウザ全体 -->
		<div id="wrap">
			<!-- ヘッダー部分 -->
			<%@ include file="/common/headerB.jsp" %>

			<!-- ログインのコンテンツ部分 -->
			<div id="main" class="container">

				<p><%=error %></p>
				<form action="<%=request.getContextPath()%>/login" method="POST">
					<table class="input-table">
						<tr>
							<th>管理者メールアドレス</th>
							<td>
								<input type="text" size="25" name="id" value="<%=email %>">
							</td>
						</tr>
						<tr>
							<th>パスワード</th>
							<td>
								<input type="password" size="25" name="passward" value="<%=passward %>">
							</td>
						</tr>
					</table>
					<input type="submit" value="ログイン">
				</form>
			</div>

			<!-- フッター部分 -->
			<%@ include file="/common/footerB.jsp" %>
		</div>
	</body>
</html>

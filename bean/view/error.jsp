<%@page contentType="text/html; charset=UTF-8"%>
<%@page contentType="text/html; charset=UTF-8"%>

<%
	String error = (String) request.getAttribute("error");
	if (error == null) {
		error = "";
	}
	String cmd = (String) request.getAttribute("cmd");
	if (cmd == null) {
		cmd = "menu";
	}
%>

<html>
	<head>
		<title>エラー画面</title>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
	</head>
	<%@ include file="/common/headerA.jsp" %>
	<body id ="error" bgcolor="#FAEBD7" text="#FF0000">
		<!-- ブラウザ全体 -->
		<div id="wrap">
			<!-- ヘッダー部分 -->
			

			<!-- メニュー部分 -->
			<div id="menu">
				<div class="container">
					<!-- ページタイトル -->
					<div id="page_title">
						<h2>■■エラー■■<br><br><br></h2>
					</div>
				</div>
			</div>

			<!-- コンテンツ部分 -->
			<div id="main" class="container">

				<p class="error-msg"><%=error %></p>

				<p class="back-link">
					<%
					if (cmd.equals("menu")) {
					%>
						<a href="<%=request.getContextPath()%>/view/insert.jsp">[書き直す]</a>
					<%
					} else if (cmd.equals("logout")) {
					%>
						<a href="<%=request.getContextPath()%>/view/title.jsp">[タイトルへ戻る]</a>
					<%
					}
					%>
				</p>
			</div>

			<!-- フッター部分 -->
			

		</div>
	</body>
	
	<%@ include file="/common/footerA.jsp" %>
</html>
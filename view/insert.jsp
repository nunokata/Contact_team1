<%@page contentType="text/html; charset=UTF-8"%>

<html>
	<head>
	<title>神田英会話スクールお問い合わせサイト</title>
	<link rel="stylesheet"  href="<%=request.getContextPath()%>/css/style.css">
	</head>
	
	<body>
		<form action ="<%=request.getContextPath()%>/insert">
			<table align="center" >
				<tr>
					<td>メールアドレス：</td>
					<td><input type="text" placeholder="例：example@gmail.com" name="userEmail"></td>
				</tr>
				
				<tr>
					<td>氏名：</td>
					<td><input type="text" placeholder="例：神田　一郎" name="userName"></td>
				</tr>
				
				<tr>
					<td>年齢：</td>
					<td><input type="number" min="5" max="130" name="age">歳</td>
				</tr>
				
				<tr>
					<td>性別：</td>
					<td>
						
						<div>
						    <input type="radio" id="a" name="gender" value="a" checked />
						    <label for="1">男性</label>
					  	</div>
					
					  	<div>
						    <input type="radio" id="b" name="gender" value="b" />
						    <label for="2">女性</label>
					 	 </div>
					
					  	<div>
						    <input type="radio" id="c" name="gender" value="c" />
						    <label for="3">答えたくない</label>
					 	 </div>
					 	 
				</tr>
				
				<tr>
					<td>住所：</td>
					<td><input type="text" placeholder="例：東京都 千代田区　神田町 1-1-1" name = "address"></td>
				</tr>
				
				<tr>
					<td>受講状態：</td>
					<td>
						<select name="howYou" align="center">
						<option value="a" id="0" >※受講状態を入力してください。</option>
						  <option value="b" id="1" >入学希望者</option>
						  <option value="c" id="2" >受講生</option>
						  <option value="d" id="3" >卒業者</option>
						</select>
				 	 </td>
			 	 </tr>
				<tr>
					<td>要件項目：</td>
					<td>
						<select name="contactItem" align="center">
						<option  id="o" value="o" >※要件項目を入力してください。</option>
						  <option id="p" value="p" >① 料金・お支払いについて</option>
						  <option id="q" value="q" >② 講座、コース、教材について</option>
						  <option id="r" value="r" >③ 学習の進め方について</option>
						  <option id="s" value="s" >④ 受講期限について</option>
						  <option id="t" value="t" >⑤ 受講終了後のサポートについて</option>
						  <option id="u" value="u" >⑥その他</option>
						</select>
				 	 </td>
			 	 </tr>
			 	 
			 	 <tr>
					<td>内容：</td>
					<td><input type="text"maxlength="200" placeholder="制限：200字" name="freeText"></td>
				</tr>
				
				
				
				<tr>
				<td></td>
					<td> <input type="submit" value="確認画面へ"></td>
				</tr>
				
			</table>
		</form>
		
		<a href="[<%=request.getContextPath()%>/view/login.jsp">管理者ログイン]</a>
		<a href="[<%=request.getContextPath()%>/view/personal.jsp">個人情報取り扱いについて]</a>
	</body>
</html>
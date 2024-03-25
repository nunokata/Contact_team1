<%@page contentType="text/html; charset=UTF-8"%>
<html>
     <head>
     <title>お問い合わせ一覧</title>
     <link rel="stylesheet"  href="<%=request.getContextPath()%>/css/Contact.css">
     </head>
     <body>
      <div class="header_user">
     
     神田英会話スクール
     </div>
     <br><br>
      <div align ="center">
     お問い合わせ一覧
   		<!-- <form action="サイトURL" align = "center" method="get">
		 <input type="search" name="search" placeholder="キーワードを入力">
		 <input type="submit" name="submit" value="検索"> -->
			</form>
   		<br><br>
   		
     <table align="center" border="1">
     <thead>
     <tr><th>No.</th><th>氏名</th><th>受講状態</th><th>項目</th><th>内容</th><th>ステータス</th></tr>
     </thead>
     <tr>
        <td value="1">1</td>
        <td value="田中　太郎">田中　太郎</td>
        <td value="在校生">在校生</td>
        <td value="料金・お支払いについて">料金・お支払いについて</td>
        <td value="お世話になっており...">お世話になっており...</td>
        <td value="未読">未読</td>
    </tr>
     
     </table>
     <div align ="center">
     <a href= "test.html">TOP画面に戻る</a>
     </body>
     
     

</html>
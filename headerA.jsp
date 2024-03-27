<%@page contentType="text/html; charset=UTF-8"%>
<link rel="stylesheet" href="./../css/style.css">
  <!-- Header Start -->
    <header class="site-header">
        <a href="#" class="brand"><h1>
        <link href="style.css">
        
        </h1></a>
          <button class="nav__toggle" aria-expanded="false" type="button">
            menu
          </button>
          <nav>
	          <ul>
	            <li><img src="../imgmogi/KES.jpg" width="100" height="100" alt="ロゴ">
	            <a href="<%=request.getContextPath()%>/view/title.jsp">ホーム</a>
	            <a href="<%=request.getContextPath()%>/view/insert.jsp">お問い合わせ</a>
	            <a href="<%=request.getContextPath()%>/view/personal.jsp">個人情報取扱いについて</a>
	          </ul>
        </nav>
      </div>
    </header>
    <!-- Header End -->
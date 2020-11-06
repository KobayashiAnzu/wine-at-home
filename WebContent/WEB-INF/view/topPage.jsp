<!DOCTYPE html>
<%@ page pageEncoding="UTF-8" %>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/topPage.css">
</head>
<body>
    <header>
        <main class="main">
        <div class="center-container">
            <div class="flex-container">
                <h1>TopList</h1>
                <nav>
                    <ul class="flex-container">
                        <li><a href="login.jsp">ログアウト</a></li>
                        <li><a href="myPage.jsp">MyPage</a></li>
                    </ul>
                </nav>
            </div><!-- /.flex-container -->
        </div><!-- /.center-container -->
    </header>
    <form action="">
          <p>
              <input type="search" name="search">
              <input type="submit" value="検索">
          </p>
    </form>
      <div class="section-group">
         <section class="list">
                    <h3>Recent</h3>
                    <ul class="flex-container">
                        <li>
                            <a href="detail.jsp">
                            <img src="images/animal5.jpg" width=200px>
                            <p class="caption">イニシャル ブリュット</p>
                            </a>
                        </li>
                        <li>
                            <a href="detail.jsp">
                            <img src="images/animal6.jpg" width=200px>
                            <p class="caption">アムール・ド・ドゥッツ</p>
                            </a>
                        </li>
                        <li>
                            <a href="detail.jsp">
                            <img src="images/animal7.jpg" width=200px>
                            <p class="caption">クリュッグ グランド・キュヴェ</p>
                            </a>
                        </li>
                        <li>
                            <a href="detail.jsp">
                            <img src="images/animal8.jpg" width=200px>
                            <p class="caption">シャトー モンペラ ルージュ</p>
                            </a>
                        </li>
                    </ul>
         </section><!-- /.menu -->
      </div><!-- /.section-group -->
    </main>

      <footer>
          <div class="center-container">
            </div><!-- /.center-container -->
        </footer>
</body>
</html>
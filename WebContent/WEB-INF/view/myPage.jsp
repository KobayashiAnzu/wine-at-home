<!DOCTYPE html>
<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/topPage.css">
</head>
<body>
<div style="overflow:scroll;">
    <header>
        <main class="main">
        <div class="center-container">
            <div class="flex-container">
                <h1>MyList</h1>
                <nav>
                    <ul class="flex-container">
                        <li><a href="login">ログアウト</a></li>
                        <li><a href="topPage">TopPage</a></li>
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
         <c:forEach var="wine" items="${wines}">
          <ul class="flex-container">
              <li>
                <img src="uploads/<c:out value="${wine.image}"/>" width="300"/>
                <p class="caption"><a href="detail"><c:out value="${wine.name}"/></p></a>
              </li>
          </ul>
       </c:forEach>
         </section>
      </div><!-- /.section-group -->

      <p><a href="addWine">追加登録</a></p>

      <footer>
          <div class="center-container">
            </div><!-- /.center-container -->
        </footer>
        </div><!-- /.overflow:scroll -->
</body>
</html>
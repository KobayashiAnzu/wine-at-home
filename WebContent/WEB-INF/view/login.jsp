<!DOCTYPE html>
<%@ page pageEncoding="UTF-8" %>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
<link rel="stylesheet" href="css/login.css">
</head>
<body>
<div class="wrapper">
<header>
        <div class="center-container">

        </div><!-- /.center-container -->
</header>

<div class="main">
<h1>ログイン</h1>
<form action="" method="post">
   <p>ID <input type="text" name="login_id"></p>
   <p>Pass <input type="password" name="login_pass"></p>
   <input type="submit" value="Login">
</form>
   <p><a href="addUser.jsp">新規会員登録</a></p>
</div>
        <footer>
          <div class="center-container">
            </div><!-- /.center-container -->
        </footer>
  </div>
</body>
</html>
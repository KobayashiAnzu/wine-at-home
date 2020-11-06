<!DOCTYPE html>
<%@ page pageEncoding="UTF-8" %>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/addUser.css">
</head>
<body>
<div class="wrapper">
<header>
        <div class="center-container">
        </div><!-- /.center-container -->
</header>
<div class="main">
    <h1>新規会員登録</h1>
 <form action="" method="post">

    <p>ユーザーID <input type="text" name="user_id"></p>
    <p>Email <input type="text" name="email"></p>
    <p>password <input type="password"" name="password"></p>

    <p>
        <input type="submit" name="add" value="登録">
        <input type="submit" name="cancel" value="戻る" >
    </p>
 </form>
 </div>
       <footer>
          <div class="center-container">
            </div><!-- /.center-container -->
        </footer>
</body>
</html>
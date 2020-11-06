<!DOCTYPE html>
<%@ page pageEncoding="UTF-8" %>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
<link rel="stylesheet" href="css/addWine.css">
</head>
<body>
<div class="wrapper">
<header>
        <div class="center-container">

        </div><!-- /.center-container -->
</header>
<div class="main">
    <h1>登録画面</h1>
    <form action="" method="post" enctype="multipart/form-data">
    <p>
        画像ファイル: <input type="file" name="image" value="${image}">
        <span style="color:red">${errImage}</span>
    </p>
    <p>商品名:<input type="text" name="name" value="${name}">
    <span style="color:red">${errName}</span>
    </p>
    <p>
        評価:
        <select name="evaluation" value="${evaluation}">
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
        </select>
    </p>
    <p>
        種類:<input type="text" name="type" value="${type}">
    </p>
    <p>
        原産国:<input type="text" name="country" value="${country}">
         <span style="color:red"> ${errCountry}</span>
    </p>
    <p>
        価格:<input type="text" name="price" value="${price}">
        <span style="color:red"> ${errPrice}</span>
    </p>
    <p>
       購入日:<input type="date" name="date" value="${date}">
    </p>
    <p>
        コメント:
        <textarea name="comment" value="${comment} "rows="4" cols="40">
        </textarea>
    </p>
     <input type="submit" name="add" value="登録">
     <input type="submit" name="back" value="戻る">
    </form>

    <span style="color:red"> ${msg}</span>

   </div>
       <footer>
          <div class="center-container">
            </div><!-- /.center-container -->
        </footer>
</body>
</html>
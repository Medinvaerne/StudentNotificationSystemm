<!DOCTYPE html>
<html>
<head>
    <title>StudentNotificationSystem</title>
</head>
<body>
<h1>Система оповещения студентов о пересдачах</h1><hr>
<h4>Регистрация</h4>
<form action="/registration" method="post">
    Имя пользователя: <input type="text" name="name"><br><br>
    Эл. почта: <input type="email" name="email"><br><br>
    Пароль: <input type="password" name="password"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Зарегистрироваться"/>
</form>
<#if errorMessage??>
    <h2 style="color: red">${errorMessage}"</h2>
</#if>

<div class="popup" onclick="myFunction()">Click me!
    <span class="popuptext" id="myPopup">Popup text...</span>
</div>
</body>
</html>
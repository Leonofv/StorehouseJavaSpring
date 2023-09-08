<#import "/spring.ftl" as spring />
<!DOCTYPE html>
<html>
<head>
    <title>STOREHOUSE</title>
</head>
<body>
<h1>STOREHOUSE</h1><hr>
<h4>Авторизация</h4>
<form action="/login" method="post">
    Эл. почта: <input type="email" name="username"><br><br>
    Пароль: <input type="password" name="password"><br><br>
    <input type="submit" value="Вход"/>
    <br><br>
<a href="/registration">Регистрация</a>
    <a href="/">Общая информация</a><br><br>
</form>
</body>
</html>
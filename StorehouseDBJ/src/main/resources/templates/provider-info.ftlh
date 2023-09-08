<!DOCTYPE html>
<html>
<#if user.isAdmin()>
<head>
    <title>STOREHOUSE</title>
</head>
<body>
<h1>STOREHOUSE</h1><hr>
<h4>Подробная информация о товаре</h4>
<b>Наименование поставщика: </b>${provider.title}<br>
<b>Id поставщика: </b>${provider.id}<br>
<b>Телефонный номер: </b>${provider.phoneNumber}<br>
<b>Электронная почта: </b>${provider.mail}<br>
<b>Адрес: </b>${provider.address}<br>
<b>Сайт: </b>${provider.website}<br>
<hr>
<form action="/provider/delete/${provider.id}" method="post">
    <input type="submit" value="Удалить поставщика"/>
</form>

<hr>
<form action="/provider/update/${provider.id}" method="post">
    <h4>Изменение товара </h4>
    Наименование поставщика: <input type="text" value="${provider.title}" name="title"/><br><br>
    Телефонный номер: <input type="number" value="${provider.phoneNumber}" name="phoneNumber"/><br><br>
    Электронная почта: <input type="text" value="${provider.mail}" name="mail"/><br><br>
    Адрес: <input type="text" value="${provider.address}" name="address"/><br><br>
    Сайт: <input type="text" value="${provider.website}" name="website"/><br><br>
    <hr>
    <input type="submit" value="Изменить данные"/>
    <hr>
</form>
<a href="/providers">Назад</a>
</body>
</#if>
</html>
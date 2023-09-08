<!DOCTYPE html>
<html>
<head>
    <title>STOREHOUSE</title>
</head>
<body>
<h1>STOREHOUSE</h1><hr>
<h4>Подробная информация о зааказе</h4>
<b>Id заказа: </b>${shop.id}<br>
<b>Наименование магазина: </b>${shop.title}<br>
<b>Телефонный номер: </b>${shop.phoneNumber}<br>
<b>Электронная почта: </b>${shop.mail}<br>
<b>Адрес: </b>${shop.address}<br>
<b>Наименование товара: </b>${shop.productTitle}<br>
<b>Колличество: </b>${shop.productQuantity}<br>
<b>Цена за единицу: </b>${shop.productPrice}<br>
<b>Автор: </b> <a href="/user/${shop.user.id}">${shop.user.name}</a><br>
<hr>
<#if user.isAdmin() || user.id = shop.user.id>
<form action="/shop/delete/${shop.id}" method="post">
    <input type="hidden" name="_csrf" value="">
    <input type="submit" value="Удалить завку"/>
</form>
</#if>
<hr>
    <hr>
</form>
<a href="/shops">Назад</a>
</body>
</html>
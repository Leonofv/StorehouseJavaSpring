<!DOCTYPE html>
<html>
<head>
    <title>STOREHOUSE</title>
    <style>
        .layer {
            overflow: scroll;
            width: 300px;
            height: 150px;
            padding: 5px;
            border: solid 1px black;
        }
    </style>
</head>
<body>
<h1>STOREHOUSE</h1><hr>
<h3>Подробная информация о пользователе: ${user.name}</h3>
<hr>
<b>Номер телефона: </b> ${user.phoneNumber}<br>
<b>Email: </b> ${user.email}<br>
<hr>
<h4>Заказы пользователя: ${user.name}</h4>
<div class="layer">
<#list shops as shop>
        <p><b>${shop.title}</b> ${shop.mail} | <a href="/shop/${shop.id}">Подробнее...</a></p>
<#else>
    <h3>Товаров нет</h3>
</#list>
</div>
<hr>
<a href="/shops">Назад</a>
<hr>
</body>
</html>
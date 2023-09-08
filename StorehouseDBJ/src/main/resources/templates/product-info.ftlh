<!DOCTYPE html>
<html>
<head>
    <title>STOREHOUSE</title>
</head>
<body>
<h1>STOREHOUSE</h1><hr>
<h4>Подробная информация о товаре</h4>
<b>Название товара: </b>${product.title}<br>
<b>Id товара: </b>${product.id}<br>
<b>Цена: </b>${product.price}<br>
<b>Количество: </b>${product.quantity}<br>
<b>Дата доставки: </b>${product.dateOfDelivery}<br>
<b>Описание товара: </b>${product.description}<br>
<b>Производитель: </b>${product.manufacturer}<br>
<hr>
<#if user.isAdmin()>
<form action="/product/delete/${product.id}" method="post">
    <input type="hidden" name="_csrf" value="">
    <input type="submit" value="Удалить товар"/>
</form>

<hr>
<form action="/product/update/${product.id}" method="post">
    <h4>Изменение товара </h4>
    Наименование товара: <input type="text" value="${product.title}" name="title"/><br><br>
    Цена за единицу: <input type="text" value="${product.price}" name="price"/><br><br>
    Колличество: <input type="text" value="${product.quantity}" name="quantity"/><br><br>
    Дата доставки: <input type="text" value="${product.dateOfDelivery}" name="dateOfDelivery"/><br><br>
    Описание товара: <input type="text" value="${product.description}" name="description"/><br><br>
    Производитель: <input type="text" value="${product.manufacturer}" name="manufacturer"/><br><br>
    <hr>
<#--    <input type="hidden" name="_csrf" value="${_csrf.token}">-->
    <input type="submit" value="Изменить товар"/>
    <hr>
</form>
</#if>
<#if user.isUser()>
    <form action="/shop/create/" method="post">
        <h4>Заказать товар</h4>
        Наименование Магазина: <input type="text"  name="title"/><br><br>
        Телефонный номер: <input type="number" value="${user.phoneNumber}" name="phoneNumber"/><br><br>
        Электронная почта: <input type="text" value="${user.email}" name="mail"/><br><br>
        Адрес: <input type="text" name="address"/><br><br>
        Наименование товара: <input type="text" value="${product.title}" name="productTitle"/><br><br>
        Колличество: <input type="number" name="productQuantity"/><br><br>
        Цена за единицу: <input type="text" value="${product.price}" name="productPrice"/><br><br>
        <hr>
        <input type="hidden" name="_csrf" value="">
        <input type="submit" value="Заказать"/>
        <hr>
    </form>
</#if>
<a href="/products">Назад</a>
</body>
</html>
<!DOCTYPE html>
<html>
<head>
    <title>STOREHOUSE</title>
    <style>
        .layer {
            overflow: scroll; /* Добавляем полосы прокрутки */
            width: 300px; /* Ширина блока */
            height: 150px; /* Высота блока */
            padding: 5px; /* Поля вокруг текста */
            border: solid 1px black;          /* Параметры рамки */
        }
    </style>
</head>
<body>

<h1>STOREHOUSE</h1>
<#if user.email??>
    <h3> Добро пожаловать: <i>${user.name}</i></h3>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="">
        <input type="submit" value="Выйти"/>
    </form>
<#else>
    <a href="/login">Войти</a></h1>
</#if>
<hr>
<form action="/" method="get">
    Поиск по наименованию: <input type="text" name="title">
    <input type="submit" value="Поиск"/>
    <a href="/products">Отмена</a>
</form>
<hr>
<#assign temp = 1>
<#list products as product>
    <#if product_has_next>
        <#assign temp++>
    </#if>
</#list>
<#if temp == 1 >
    <h4>Всего сущетсвующих позиций:</h4>
<#else>
    <h4>Всего сущетсвующих позиций: ${temp} шт.</h4>
</#if>

<div class="layer">
<#list products as product>
        <p><b>${product.title}</b> ${product.price} руб. | <a href="/product/${product.id}">Подробнее...</a></p>
<#else>
    <h3>Товаров нет</h3>
</#list>
    </div>
<#if user.isAdmin()>
<hr>
<h3>Создать новый товар</h3>
<form action="/product/create" method="post">
    Наименование товара: <input type="text" name="title"/><br><br>
    Цена за единицу: <input type="number" name="price"/><br><br>
    Колличество: <input type="number" name="quantity"/><br><br>
    Дата доставки: <input type="text" name="dateOfDelivery"/><br><br>
    Описание товара: <input type="text" name="description"/><br><br>
    Производитель: <input type="text" name="manufacturer"/><br><br>
    <hr>
    <input type="hidden" name="_csrf" value="">
    <input type="submit" value="Добавить товар"/>
    <a href="/providers">Список поставщиков</a>
    </#if>
    <a href="/shops">Заявки магазинов</a>
    <hr>
</form>
</body>
</html>
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
            border: solid 1px black; /* Параметры рамки */
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
<form action="/shops" method="get">
    Поиск по наименованию: <input type="text" name="title">
    <input type="submit" value="Поиск"/>
    <a href="/shops">Отмена</a>
</form>
<hr>
<#if user.isAdmin()>
<#assign temp = 1>
<#list shops as shop>
    <#if shop_has_next>
        <#assign temp++>
    </#if>
</#list>
<#if temp != 1 >
    <h4>Всего заявок пользователей: ${temp} шт.</h4>
    </#if>
<#else>
    <h4>Всего заявок пользователей:</h4>
</#if>
<div class="layer">
    <#list shops as shop>
        <#if user.isAdmin() || user.id = shop.user.id>
        <p><b>${shop.title}</b> ${shop.user.name} | <a href="/shop/${shop.id}">Подробнее...</a></p>
        </#if>
    <#else>
        <h3>Заявок нет</h3>
    </#list>
</div>
<hr>
    <#if user.isAdmin()>
    <a href="/providers">Список поставщиков</a>
    </#if>
    <a href="/products">Список продуктов</a>
    <hr>
</form>
</body>
</html>
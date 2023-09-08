<!DOCTYPE html>
<html>
<#if user.isAdmin()>
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
<form action="/providers" method="get">
    Поиск по наименованию: <input type="text" name="title">
    <input type="submit" value="Поиск"/>
    <a href="/providers">Отмена</a>
</form>
<hr>
<#assign temp = 1>
<#list providers as provider>
    <#if provider_has_next>
        <#assign temp++>
    </#if>
</#list>
<#if temp == 1 >
    <h4>Всего поставщиков:</h4>
<#else>
    <h4>Всего поставщиков: ${temp}шт.</h4>
</#if>
<div class="layer">
    <#list providers as provider>
        <p><b>${provider.title}</b> | <a href="/provider/${provider.id}">Подробнее...</a></p>
    <#else>
        <h3>Поставщиков нет</h3>
    </#list>
</div>
<#if user.email??>
<hr>
<h3>Добавить нового поставщика</h3>
<form action="/provider/create" method="post">
    Наименование поставщика: <input type="text" name="title"/><br><br>
    Телефонный номер: <input type="number" name="phoneNumber"/><br><br>
    Электронная почта: <input type="text" name="mail"/><br><br>
    Адрес: <input type="text" name="address"/><br><br>
    Сайт: <input type="text" name="website"/><br><br>
    <hr>
    <input type="hidden" name="_csrf" value="">
    <input type="submit" value="Добавить поставщика"/>
    <a href="/products">Список продуктов</a>
    <a href="/shops">Заявки магазинов</a>
    <hr>
</form>
</#if>
</#if>
</body>
</html>
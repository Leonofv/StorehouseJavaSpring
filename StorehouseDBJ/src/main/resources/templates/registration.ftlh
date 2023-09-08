<#import "/spring.ftl" as spring />
<!DOCTYPE html>
<html>
<head>
    <title>STOREHOUSE</title>
</head>
<body>
<h1>STOREHOUSE</h1><hr>
<h4>Регистрация</h4>
<form action="/registration" method="post">
    <#if user?? && noErrors??>
        Имя пользователя: <input type="text" name="name"><br>
        Эл. почта: <input type="email" name="email"><br><br>
        Номер телефона: <input type="text" name="phoneNumber"><br><br>
        Пароль: <input type="password" name="password"><br><br>
        Повтор пароля: <input type="password" name="repeatPassword"><br><br>
     <#else>
         Имя пользователя:
         <@spring.formInput "user.name"/>
         <@spring.showErrors "<br>"/>
         <br><br>
         Эл. почта:
         <@spring.formInput "user.email"/>
         <@spring.showErrors "<br>"/>
         <#if emailError??>${emailError}</#if>
         <br><br>
         Номер телефона:
         <@spring.formInput "user.phoneNumber"/>
         <@spring.showErrors "<br>"/>
         <br><br>
         Пароль:
         <@spring.formInput "user.password"/>
         <@spring.showErrors "<br>"/>
         <br><br>
         Повтор пароля:
         <@spring.formInput "user.repeatPassword"/>
         <@spring.showErrors "<br>"/>
         <#if passwordError??>${passwordError}</#if>
         <br><br>
    </#if>
    <input type="submit" value="Регистрация"/><br><br>
    <a href="/login">Назад</a>
</form>
</body>
</html>
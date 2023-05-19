<!DOCTYPE html>
<html>
<head>
    <title>StudentNotificationSystem</title>
</head>
<h1>Система оповещения студентов о пересдачах</h1><hr>
<#if user.email??>
    <h3>Имя пользователя: <i>${user.name}</i></h3>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Выйти"/>
        <h4> личный список пересдач </h4>
    </form>
    <#if user.isAdmin()>
        <a href="/admin">Панель администратора</a>
    </#if>
<#else>
    <a href="/login">Войти</a></h1>
</#if>
<hr>
<#if user.isStudent()>
    <#list retakes as retake>
        <div>
            <p><b>${retake.title}</b>  </p>
        </div>
    </#list>
</#if>
    <#if user.isLecturer()>
        <#list leacturSubjects as leacturSubject>
            <div>
                <p><b>${leacturSubject.title}</b></p>
            </div>
        </#list>
    </#if>
<hr>
<h4> Список пересдач </h4>
<form action="/" method="get" >
      Поиск по названию пересдачи: <input type="text" name="title"> <br>
      <input type="submit" value="Поиск"/>
</form>
<#list subjects as subject>
    <div>
        <p><b>${subject.title}</b> | <a href="/subject/${subject.id}">Подробнее...</a> </p>
    </div>
    <#else>
    <h3>Пересдачи по этому предмету пока что отсутствуют</h3>
</#list>
<#if user.email??>
<#if user.isTeacher()>
<hr>
<h3>Создать новую пересдачу</h3>
<form action="/subject/create" method="post">
    Название предмета: <input type="text" name="title"/><br><br>
    Преподаватель <input type="text" name="lecturer"/><br><br>
    Логин(email студента) <input type="text" name="email"/><br><br>
    Аудитория <input type="text" name="auditorium"/><br><br>
    Дата <input type="text" name="date"/><br><br>
    Время <input type="text" name="time"/><br><br>
    <input type="hidden" name="_csrf" value=${_csrf.token}>
    <input type="submit"  value="Добавить предмет"/>
      </form>
</#if>
</#if>
</body>
</html>
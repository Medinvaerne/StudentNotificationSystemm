<!DOCTYPE html>
<html>
<head>
    <title>StudentNotificationSystem</title>
</head>
<body>
<h1> Система оповещения студентов о пересдачах </h1><hr>
<h4> Информация о пересдаче </h4>
<b>Название </b> ${subject.title}<br>
<b>Преподаватель: </b> ${subject.lecturer}<br>
<b>Аудитория: </b> ${subject.auditorium}<br>
<b>Дата </b> ${subject.date}<br>
<b>Время: </b> ${subject.time}<br>
<form action="/subject/delete/${subject.id}" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Удалить">
</form>
<hr>
</form>
</body>
</html>
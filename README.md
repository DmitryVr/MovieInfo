## Web приложение "MovieInfo" @author Dmitry Vremesh

### 1 Общие сведения

**1.1 Стек технологий:**
  * Spring(MVC, Security), Hibernate, JSP, CSS, сборщик Maven, база данных MySQL
![1](https://github.com/DmitryVr/MovieInfo/blob/master/screenshots/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA%20%D1%8D%D0%BA%D1%80%D0%B0%D0%BD%D0%B0%20%D0%BE%D1%82%202017-02-05%2020-10-45.png)
  
**1.2 Описание приложения:**
  Приложение предоставляет информацию о фильмах. В приложении предусмотрена аутентификация с хешированием паролей(bcrypt) и авторизация. Есть 2 роли обычный пользователь (ROLE_USER) и администратор (ROLE_ADMIN). Есть страница регистрации нового пользователя, новый пользователь получает роль (ROLE_USER). Что может пользователь с ролью (ROLE_USER): войти в систему, выйти из системы, частично изменить локаль, получить список фильмов по жанру, получить список фильмов по названию (русское или оригинальное), скачать PDF-файл, скачать изображение. Что может пользователь с ролью (ROLE_ADMIN): все что может обычный пользователь, создать новую запись, редактировать запись, удалить запись.       

### 2 Страница логина (если пользователь ввел данные, которые нет в БД)

![1](https://github.com/DmitryVr/MovieInfo/blob/master/screenshots/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA%20%D1%8D%D0%BA%D1%80%D0%B0%D0%BD%D0%B0%20%D0%BE%D1%82%202017-02-05%2019-43-58.png)

### 3 Страница регистрации (если пользователь ввел неверные данные)

![1](https://github.com/DmitryVr/MovieInfo/blob/master/screenshots/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA%20%D1%8D%D0%BA%D1%80%D0%B0%D0%BD%D0%B0%20%D0%BE%D1%82%202017-02-05%2019-44-04.png)

### 4 Пользователь вошел в систему

![1](https://github.com/DmitryVr/MovieInfo/blob/master/screenshots/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA%20%D1%8D%D0%BA%D1%80%D0%B0%D0%BD%D0%B0%20%D0%BE%D1%82%202017-02-05%2019-44-23.png)

### 5 Пользователь выбрал получить списк фильмов по жанру

![1](https://github.com/DmitryVr/MovieInfo/blob/master/screenshots/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA%20%D1%8D%D0%BA%D1%80%D0%B0%D0%BD%D0%B0%20%D0%BE%D1%82%202017-02-05%2019-44-30.png)
![1](https://github.com/DmitryVr/MovieInfo/blob/master/screenshots/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA%20%D1%8D%D0%BA%D1%80%D0%B0%D0%BD%D0%B0%20%D0%BE%D1%82%202017-02-05%2019-44-35.png)

### 6 Пользователь кликнул на флаг, чтобы изменить локаль

![1](https://github.com/DmitryVr/MovieInfo/blob/master/screenshots/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA%20%D1%8D%D0%BA%D1%80%D0%B0%D0%BD%D0%B0%20%D0%BE%D1%82%202017-02-05%2019-44-54.png)

### 7 Пользователь решил воспользоваться поиском

![1](https://github.com/DmitryVr/MovieInfo/blob/master/screenshots/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA%20%D1%8D%D0%BA%D1%80%D0%B0%D0%BD%D0%B0%20%D0%BE%D1%82%202017-02-05%2019-45-10.png)
![1](https://github.com/DmitryVr/MovieInfo/blob/master/screenshots/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA%20%D1%8D%D0%BA%D1%80%D0%B0%D0%BD%D0%B0%20%D0%BE%D1%82%202017-02-05%2019-45-17.png)

### 8 Пользователь кликнул на "Download Image" и скачал изображение

![1](https://github.com/DmitryVr/MovieInfo/blob/master/screenshots/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA%20%D1%8D%D0%BA%D1%80%D0%B0%D0%BD%D0%B0%20%D0%BE%D1%82%202017-02-05%2019-45-41.png)

### 9 Пользователь кликнул на "Download PDF"

![1](https://github.com/DmitryVr/MovieInfo/blob/master/screenshots/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA%20%D1%8D%D0%BA%D1%80%D0%B0%D0%BD%D0%B0%20%D0%BE%D1%82%202017-02-05%2019-46-12.png)


### 10 Пользователь кликнул на "Logout" и вышел из системы

![1](https://github.com/DmitryVr/MovieInfo/blob/master/screenshots/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA%20%D1%8D%D0%BA%D1%80%D0%B0%D0%BD%D0%B0%20%D0%BE%D1%82%202017-02-05%2019-46-30.png)

### 11 Пользователь с ролью администратор вошел в систему

![1](https://github.com/DmitryVr/MovieInfo/blob/master/screenshots/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA%20%D1%8D%D0%BA%D1%80%D0%B0%D0%BD%D0%B0%20%D0%BE%D1%82%202017-02-05%2019-47-31.png)

### 12 Администратор удаляет запись

![1](https://github.com/DmitryVr/MovieInfo/blob/master/screenshots/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA%20%D1%8D%D0%BA%D1%80%D0%B0%D0%BD%D0%B0%20%D0%BE%D1%82%202017-02-05%2019-47-50.png)

### 13 Администратор обновляет запись

![1](https://github.com/DmitryVr/MovieInfo/blob/master/screenshots/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA%20%D1%8D%D0%BA%D1%80%D0%B0%D0%BD%D0%B0%20%D0%BE%D1%82%202017-02-05%2019-48-09.png)
![1](https://github.com/DmitryVr/MovieInfo/blob/master/screenshots/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA%20%D1%8D%D0%BA%D1%80%D0%B0%D0%BD%D0%B0%20%D0%BE%D1%82%202017-02-05%2019-48-53.png)
![1](https://github.com/DmitryVr/MovieInfo/blob/master/screenshots/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA%20%D1%8D%D0%BA%D1%80%D0%B0%D0%BD%D0%B0%20%D0%BE%D1%82%202017-02-05%2019-49-12.png)

### 14 Администратор добавляет новую запись

![1](https://github.com/DmitryVr/MovieInfo/blob/master/screenshots/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA%20%D1%8D%D0%BA%D1%80%D0%B0%D0%BD%D0%B0%20%D0%BE%D1%82%202017-02-05%2020-06-26.png)
![1](https://github.com/DmitryVr/MovieInfo/blob/master/screenshots/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA%20%D1%8D%D0%BA%D1%80%D0%B0%D0%BD%D0%B0%20%D0%BE%D1%82%202017-02-05%2020-07-21.png)
![1](https://github.com/DmitryVr/MovieInfo/blob/master/screenshots/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA%20%D1%8D%D0%BA%D1%80%D0%B0%D0%BD%D0%B0%20%D0%BE%D1%82%202017-02-05%2020-08-31.png)

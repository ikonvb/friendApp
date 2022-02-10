# Find friend app

[Рабочая версия на Heroku](https://clients-firends-app.herokuapp.com/)    
Так как приложение развернуто на Heroku без подписки, следует подождать пока оно запуститься.
Ожидание может составить от 10 секунд и более.

**Описание**

Приложение позволяет регистрировать нового пользователя, искать уже зарегистрированных ползователей, добавлять их в друзья или удалять из друзей.    
Технологии:    
+ Java 11.0.9
+ Maven 3.3.6
+ Spring Boot 5
+ Thymeleaf

**Установка**

1. Скачать и установить JDK 11 версии или выше.    
[ссылка для скачивания](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)

2. Скачать и устанвоить Maven.    
[ccылка для скачивания](https://maven.apache.org/download.cgi)

3. Скачать и установить IDE.    
[IntelliJ IDEA](https://www.jetbrains.com/ru-ru/idea/download/#section=windows)

4. Скачать и установить PostgreSQL и PgAdmin.    
[PostgreSQL](https://www.postgresql.org/)

5. Создать базу данных с именем friends   
6. Создать две таблицы: clients и friends    
    sql script для *clients*    
    ~~~
    CREATE TABLE IF NOT EXISTS clients (
      id BIGINT NOT NULL PRIMARY KEY,
      login VARCHAR(100) NOT NULL,
      user_name VARCHAR(100) NOT NULL,
      email VARCHAR(100) NOT NULL,
      password VARCHAR(255) NOT NULL
    );
    ~~~
    sql script для *friends*    
    ~~~
    CREATE TABLE IF NOT EXISTS friends (
      client_id BIGINT NOT NULL,
      friend_id BIGINT NOT NULL
    );    
    ~~~

7. Создать новый проект в IntelliJ IDEA используя git-hub ссылку этого проекта 
![idea](https://user-images.githubusercontent.com/42876203/153384662-85f4d7a5-28d3-4762-952b-aa7a3b022d77.png)

Ссылка этого проекта
[Ссылка](https://github.com/kostyaFrom/friendApp.git)

8. Найти файл application.properties и отредактировать его используя свои логин и пароль от базы данных.

![idea](https://user-images.githubusercontent.com/42876203/153388641-51761ef8-e1a3-4e55-aad2-bd6d9585a29f.png)
![idea](https://user-images.githubusercontent.com/42876203/153389766-2e51dd2f-4932-44df-8d19-7a3f3b45a056.png)

9. Пробовать запускать.

# Screenshots

### Login page
![login](https://user-images.githubusercontent.com/42876203/153273270-fa9cc245-31f4-444c-a172-cd05e8795004.jpg)

### Register page
![register](https://user-images.githubusercontent.com/42876203/153273577-afda30ab-0bb3-4ac9-b60e-5f318907f25c.jpg)

### Profile page
![profile](https://user-images.githubusercontent.com/42876203/153392670-2d92227a-366a-4055-88fa-9b56282ffce3.png)



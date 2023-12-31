

```markdown
# RESTful Веб-Приложение

Это простое RESTful веб-приложение, которое предоставляет один эндпоинт для подсчета количества символов в строке.

## Использование

### Предварительные требования

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Apache Maven](https://maven.apache.org/)

### Сборка и Запуск

1. Склонируйте этот репозиторий на свой локальный компьютер.

   ```bash
   git clone https://github.com/dayaDanya/t1consalt.git
   ```

2. Перейдите в каталог проекта.

   ```bash
   cd t1consalt
   ```

3. Соберите проект с помощью Maven.

   ```bash
   mvn clean install
   ```

4. Запустите приложение.

   ```bash
   java -jar target/t1consalt-1.0.jar
   ```

   Приложение будет доступно по адресу [http://localhost:8080](http://localhost:8080).

### API Эндпоинт

- **Подсчет символов в строке**

  Этот API-эндпоинт считает количество символов в предоставленной строке.

    - **URL**: `/count`
    - **Метод**: GET
    - **Параметры**:
        - `str` (обязательно): Входная строка для подсчета символов.
    - **Пример запроса**:

      ```http
      GET http://localhost:8080/count?str=aaaaabcccc
      ```

    - **Пример ответа**:

      ```string
      "a": 5, "c": 4, "b": 1
      ```

    - Если параметр `str` не предоставлен или пуст, ответ будет содержать сообщение об ошибке.

### Обработка Ошибок

Приложение обрабатывает ошибки и возвращает соответствующие сообщения об ошибках, если предоставлены недопустимые или отсутствующие параметры.


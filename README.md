## Описание
* При запуске приложения, получаем список актуальных валют и их курсов с сайта Европейского центрального банка https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml и записывает их в базу данных с привязкой на дату запроса.

* На главной странице в первом поле указывается количество конвертируемых средств, выбираем валюту которую продаем и ниже выбираем которую покупаем.
* Нажимает на кнопку "Конвертировать”
* После чего происходит запрос в БД на получение актуального курса на текущую дату. Если данные на текущую дату отсутствуют и на данный момент уже больше чем 17:00, то производиться запрос новых курсов с сайта Европейского центрального банка и добавляется в базу данных. 
* Также в приложении ведется запись истории всех произведенных конвертаций с записью в базу данных со ссылкой на курс, по которому была произведена конвертация.

## Установка и запуск

Официальный образ PostgreSQL берем на Docker Hub. В докере создаем контейнер Postgres:
```
$ docker run --name some-postgres -e POSTGRES_PASSWORD=mysecretpassword -p 5432:5432 -d postgres
```
Забираем проект
```
$ gh repo clone AntonKuksov/testing_task_exchange_rates
```
Переходим в директорию
```
$ cd ../testing_task_exchange_rates
```
Устанавливаем зависимости
```
$ mvn package
```
Запускаем
```
$ mvnw spring-boot:run
```
## Дополнительно
* Если после запуска база данных сама не сгенерировалась, то импортируем в базу файл postgres.txt

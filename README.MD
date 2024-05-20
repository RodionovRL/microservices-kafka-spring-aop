# microservices-kafka-spring-aop 
##### [_первоначальная(до рефакторинга) версия приложения доступна в ветке SpringAOP_](https://github.com/RodionovRL/spring-aop/tree/SpringAOP)
Приложение реализует систему учета времени выполнения методов в приложении с использованием Spring AOP,
оно способно асинхронно логировать и анализировать данные о времени выполнения методов

Приложение было доработано, проведён рефакторинг, выделено 2 микросервиса: consumer-service  и  producer-service:
- producer-service - основной демо-функционал owners + solutions
- consumer-service - функционал хранения и выдачи данныx о времени выполнения методов
- для взаимодействия микросервисов используется kafka


 ***   

_by Ruslan Rodionov_

 ___

### Общее описание приложения:
#### producer-service
- реализует CRUD методы для работы с сущностями Owner и Solutions;
- аннотации @TrackTime и @TrackAsyncTime, применяются к методам работы с демо-сущностями для отслеживания времени их выполнения;
- посредством kafka направляет полученные статистические данные в consumer-service
#### consumer-service
- из kafka получает статистические данные из consumer-service и сохраняет из в БД;
- реализует API для получения статистических данных.

 ---

### Струтура БД:
#### producer-service:
![img.png](data/solutions-owners.png)
#### consumer-service:
![img.png](data/track_times.png)

---
### Запуск приложения:
необходимо выбрать один из вариантов запуска приложения
##### из IDE:
Поднимаем все контейнеры Docker (БД и сервисы kafka) из файла:   
[docker-compose-spring-aop-db.yaml](docker-compose-only-db.yaml)

после запускаем микросервисы consumer-service  и  producer-service в приложении в IDE


##### Docker:
Поднимаем все контейнеры Docker из файла:   
[docker-compose-microservices-kafka-spring-aop.yaml](docker-compose-microservices-kafka-spring-aop.yaml)

Приложение полностью готово к работе

---
### Работа с приложением:
  
producer-service доступен по адресу [http://localhost:8080/](http://localhost:8080/)

consumer-service доступен по адресу [http://localhost:8081/](http://localhost:8081/)

---
### API:
[producer-service api](api/producer-service-api-docs.json)   
[consumer-service api](api/consumer-service-api-docs.json)


###  Postman 
Для полного тестирования приложения предусмотрена коллекция Postman.
Запуск коллекции необходимо производить последовательно, так как тесты зависят от результатов выполнения предшествующих
[Microservices Kafka SpringAOP.postman_collection.json](postman/Microservices Kafka SpringAOP.postman_collection.json)

***

### _Техстэк:_
- #### Java 17
- #### Spring Boot
- #### PostgreSQL
- #### Maven
- #### Hibernate
- #### Kafka
- #### Mapstruct
- #### Lombok
- #### Slf4j
- #### OpenAPI
- #### MockMVC
- #### Docker

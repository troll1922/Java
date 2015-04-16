Задание
Выбрать понравившуюся реализацию RESTful в java.
Попытаться обосновать свой выбор, т.е. написать плюсы и
минусы.
Реализовать CRUD для одной из сущностей.
Реализовать возможность покупки товара пользователем.

Мной была выбрана реализация Jersey, т.к. на оффициальном сайте очень подробная документация с примерами, плюс мне показались аннотации в ней очень простыми и понятными.
В выполненном проекте реализована CRUD сущности User:
- GET выводит информацию о юзерах на экран в формате Json, если не указан Id - выведутся все юзеры, если Id указан - то конкретный юзер.
- POST создает юзера в БД.
- PUT обновляет юзера в БД по Id.
- DELETE удаляет юзера по Id, если Id не указан, удалятся все юзеры из БД.
Так же реализована покупка товара пользователем, по указанному Id юзера считываются деньги в зависимости от стоимости товара, создаются сущности покупка и продукт.
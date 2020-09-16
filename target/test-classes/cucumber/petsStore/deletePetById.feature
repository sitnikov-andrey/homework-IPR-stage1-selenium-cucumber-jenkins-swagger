# language: ru
@delete_pet_by_id
Функция: Удалить питомца из БД по id

  Структура сценария: Удалить питомца по id
    Когда у меня есть доступ к разделу <SwaggerURL>
    И я могу получить данные питомца по id = <id>
    Тогда я могу удалить питомца по id = <id>

    Примеры:
      |SwaggerURL                  |id  |
      |"https://petstore.swagger.io/#/pet"|110 |
# language: ru
@get_pet_by_id
Функция: Получаем питомца из БД по id

  Структура сценария: Получить питомца по id
    Когда у меня есть доступ к разделу <SwaggerURL>
    Тогда я могу получить данные питомца по id = <id>

    Примеры:
      |SwaggerURL                  |id  |
      |"https://petstore.swagger.io/#/pet"|111 |
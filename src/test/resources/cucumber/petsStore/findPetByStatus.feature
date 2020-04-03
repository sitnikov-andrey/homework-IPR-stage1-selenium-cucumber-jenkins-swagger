# language: ru
@find_pet_by_status
Функция: Получаем питомца из БД по id

  Структура сценария: Получить питомца по id
    Когда у меня есть доступ к разделу <SwaggerURL>
    Тогда я могу получить данные питомцев по статусу = <Status>

    Примеры:
      |SwaggerURL                  |Status  |
      |"http://petstore.swagger.io"|"open"  |
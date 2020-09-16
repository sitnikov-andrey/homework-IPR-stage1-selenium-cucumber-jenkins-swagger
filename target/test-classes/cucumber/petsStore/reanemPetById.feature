# language: ru
@rename_pet_by_id
Функция: Изменяем питомца из БД по id

  Структура сценария: Получить питомца по id
    Когда у меня есть доступ к разделу <SwaggerURL>
    Тогда я могу по id = <id> изменить имя пиомца на <Name> и статус на <Status>

    Примеры:
      |SwaggerURL                  |id        |Name      |Status      |
      |"https://petstore.swagger.io/#/pet"|111       |"Snoopy"  |"Action"    |
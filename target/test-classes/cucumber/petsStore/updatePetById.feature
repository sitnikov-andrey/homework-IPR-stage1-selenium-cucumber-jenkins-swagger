# language: ru
@update_pet_by_id
Функция: Изменение данных питомца

  Структура сценария: обновить данные питомца по заданным параметрам
    Когда у меня есть доступ к разделу <SwaggerURL>
    И я могу получить данные питомца по id = <id>
    Тогда я могу обновить данные питомца по заданным параметрам : <id>, <Category id>, <Category name>, <Pet name>, <Photo URLs>, <Tags id>, <Tags name>, <Status>

    Примеры:
      |SwaggerURL                  |id |Category id|Category name |Pet name|Photo URLs|Tags id|Tags name|Status |
      |"https://petstore.swagger.io/#/pet"|110|101        |"New Category"|"Fill"  |"Same URL"|102    |"New Tag"|"new open" |
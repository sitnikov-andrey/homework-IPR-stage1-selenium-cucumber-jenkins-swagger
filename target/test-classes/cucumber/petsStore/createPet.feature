# language: ru
@create_pet
Функция: Создать питомца

  Структура сценария: создать питомца по заданным параметрам
    Когда у меня есть доступ к разделу <SwaggerURL>
    Тогда я могу создать питомца по заданным параметрам : <id>, <Category id>, <Category name>, <Pet name>, <Photo URLs>, <Tags id>, <Tags name>, <Status>

    Примеры:
      |SwaggerURL                  |id |Category id|Category name |Pet name|Photo URLs|Tags id|Tags name|Status |
      |"http://petstore.swagger.io"|110|101        |"New Category"|"Fill"  |"Same URL"|102    |"New Tag"|"open" |
      |"http://petstore.swagger.io"|111|101        |"New Category"|"Fill"  |"Same URL"|102    |"New Tag"|"open" |
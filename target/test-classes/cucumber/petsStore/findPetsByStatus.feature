# language: ru
@find_pets_by_status
Функция: Получение списка животных по статусу

  Предыстория:
    Дано что сушествуют питомцы со статусами: available, pending, sold

  Структура сценария: Получение списка животных по статусу
    Когда у меня есть доступ к разделу <SwaggerPetStore>
    Тогда я могу получить данные питомцев по статусу = <Status>

    Примеры:
      |SwaggerPetStore                      |Status      |
      |"https://petstore.swagger.io/#/pet"|"available" |
      |"https://petstore.swagger.io/#/pet"|"pending"   |
      |"https://petstore.swagger.io/#/pet"|"sold"      |

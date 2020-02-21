[![Build status](https://ci.appveyor.com/api/projects/status/p6yww2hc4aj0aoph?svg=true)](https://ci.appveyor.com/project/TatyanaGV/akita-homework-2-4)

## MoneyTransferTest (Page Object)

### MoneyTransferTest - автотесты формы "Личный кабинет интернет банка".
transferToCard1Positive - позитивный сценарий теста (перевод суммы с карты №2 на карту №1);

transferToCard2Positive - позитивный сценарий теста (перевод суммы с карты №1 на карту №2);

transferToCard2AmountOverCard1Negative - негативный сценарий теста (перевод с карты №1 суммы превышающей баланс данной карты);

transferToCard1DoubleAmountWithCard2 - позитивный сценарий теста (перевод с карты №2 дробной суммы на карту №1).

##### Инструментарий:
- JAVA8 - язык написания авто-тестов;
- JUnit - платформа для написания авто-тестов и их запуска;
- Gradle - система управления зависимостями;
- Git - хранение тестов;
- Continuous Integration (Appveyor) - система для сбора авто-тестов в автоматическом режиме;
- Selenide - фреймворк для автоматизированного тестирования веб-приложений;
- SUT - целевой сервис SUT (app-order.jar);
- Faker - библиотека для генерации данных для автозаполнения;
- Lombok;
- Page Object.
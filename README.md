# BDD

## Задача №2: BDD

Используя Page Object's из предыдущей задачи, на базе шаблона Cucumber с лекции реализуйте кастомные steps:
* когда пользователь переводит 5 000 рублей с карты с номером 5559 0000 0000 0002 на свою 1 карту с главной страницы,
* тогда баланс его 1 карты из списка на главной странице должен стать 15 000 рублей.

Тогда вместе с логином, который мы сделали на лекции, всё должно выглядеть вот так:
* пусть пользователь залогинен с именем «vasya» и паролем «qwerty123»,
* когда пользователь переводит 5 000 рублей с карты с номером 5559 0000 0000 0002 на свою 1 карту с главной страницы,
* тогда баланс его 1 карты из списка на главной странице должен стать 15 000 рублей.

Для запуска тестов в консоли запустить jar файл командой java -jar artifacts/app-ibank-build-for-testers.jar.
На адресе http://localhost:9999 можно посмотреть работу приложения, перейти в пакет scenarions в нем 2 теста для запуска.

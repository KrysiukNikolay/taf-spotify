# taf-spotify

# **Тестирование Spotify UI и API.**

Этот проект разработан для тестирования функциональности приложения Spotify через UI и API тесты.

## **Spotify UI.**

Пакет spotify.ui.tests содержит тесты для проверки функциональности пользовательского интерфейса приложения Spotify. В данном пакете тестируется авторизация пользователя и поиск артиста в приложении Spotify.

Тесты авторизации.

**testLoginCorrectDataUser** - Тест проверяет успешную авторизацию пользователя с корректными данными.

**testLoginIncorrectName** - Тест проверяет авторизацию пользователя с пустым логином(email).

**testLoginIncorrectPassword** - Тест проверяет авторизацию пользователя с пустым паролем.

**testLoginRandomDataUser** - Тест проверяет авторизацию пользователя с рандомными данными.

Тест поиска артиста.

**testSearchArtist** - Тест проверяет функциональность поисковой строки и поиск артиста в приложении Spotify.


## **Spotify API.**


Пакет spotify.api.tests содержит тесты для проверки функциональности API приложения Spotify.
В данном пакете тестируется получение ответа от API, проверка авторизации пользователя и создание плейлиста через API.

Тесты API.

**testGetRequestReturns200** - Тест проверяет получение ответа 200 от запроса к API сайта.

**testAuthorizedUserGetsUserInfo** - Тест проверяет авторизацию пользователя и получение информации о пользователе через API.

**testCreatePlaylistReturns201** - Тест проверяет создание плейлиста через API.



## Проект содержит две ветки: Main и Parallel.

### **Описание ветки main:**

В главной ветке проекта используется метод из JavascriptExecutor In Selenium WebDriver для подсветки выбираемых элементов. Этот метод используется для улучшения визуальной отдачи пользователю при выполнении автоматизированных тестов. Он позволяет выделить интересующие элементы на странице, сделав их более заметными и понятными для пользователя. Таким образом, мы можем убедиться в правильности выбранных элементов и убедиться, что они соответствуют требованиям тест-кейсов.
В этой ветке был использован фреймворк Allure для создания и вывода отчетов о прохождении тестов. Возможна загрузка на Jenkins для автоматических запусков тестов в определенное время и получения отчетов на почту.

### **Описание ветки parallel:**

В этой ветке было использовано распараллеливание на 4 потока для увеличения скорости выполнения тестов. Это существенно сократило время, затрачиваемое на выполнение тестов, что позволило увеличить количество тестов, которые можно выполнять за определенное время. Для реализации этой функциональности была использована Аннотация "@ExecutionMode" использующая для определения режима выполнения тестов значение "ExecutionMode.CONCURRENT" указывающее, что тесты должны выполняться параллельно в несколько потоков. В Классе DriverSetup используется ThreadLocal который позволяет сохранять и получать экземпляры объектов в потокобезопасном режиме, чтобы каждый поток имел свой экземпляр и не было конфликтов между потоками при работе с общим ресурсом. Кроме того, была добавлена опция "--headless" для запуска тестов в фоновом режиме, что ускорило процесс и позволило улучшить производительность.


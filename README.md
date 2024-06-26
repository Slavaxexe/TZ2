[![Java CI](https://github.com/Slavaxexe/TZ2/actions/workflows/build.yml/badge.svg)](https://github.com/Slavaxexe/TZ2/actions/workflows/build.yml)
# NumberProcessor

Простая программа на Java для обработки чисел из файла.

## Функциональность

- Чтение чисел из файла.
- Поиск минимального и максимального числа.
- Расчет суммы и произведения чисел.

## Как использовать

1. Укажите путь к файлу с числами.
2. Запустите программу.
3. Результаты будут выведены в консоль.

## Как запускать тесты
1. Открыть терминал и написать mvn test
2. Если нужно запустить определенные классы тестов, написать mvn -Dtest=<название класса> test

## Графики зависимости скорости выполнения от количества чисел
<figure>
    <figcaption>Скорость min функции</figcaption>
    <img src="charts/min.png" title="Скорость min функци">
    <figcaption>Скорость max функции</figcaption>
    <img src="charts/max.png" title="Скорость max функци">
    <figcaption>Скорость sum функции</figcaption>
    <img src="charts/sum.png" title="Скорость sum функци">
    <figcaption>Скорость mult функции</figcaption>
    <img src="charts/mult.png" title="Скорость mult функци">
</figure>
При увеличении количества чисел с 10000 до 100000 скорость выполнения резко уменьшается из-за сложности обработки больших чисел


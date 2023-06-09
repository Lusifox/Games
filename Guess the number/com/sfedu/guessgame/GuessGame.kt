package com.sfedu.guessgame

import com.sfedu.guessgame.races.gameraces.Robot
import com.sfedu.guessgame.races.gameraces.Troll
import com.sfedu.guessgame.races.gameraces.Wizard
import com.sfedu.guessgame.races.initial.Player
import kotlin.math.roundToInt

fun main() {
    // Переменная для хранения информации о созданном персонаже
    val name = playerNaming()
    //Выбор рассы игрока
    val race = choosingRace()
    //Создаём персонаж игрока
    val player = createCharacter(name, race)
    // Играем
    playGame(player)
}

// Функция для ввода имени игрока
private fun playerNaming(): String {
    // Вывод текстового сообщения на экран
    println("Добрый день! Представьтесь, пожалуйста!")
    // Получение текста, что вводит пользователь с клавиатуры
    // Возвращение значения имени
    return readln()
}

// Функция для ввода расы игрока
private fun choosingRace(): String {
    // Вывод текстового сообщения на экран
    println(
        """Введите, пожалуйста, расу своего персонажа!
            |\"1\" - Робот;
            |\"2\" - Тролль;
            |\"3\" - Волшебник.""".trimMargin()
    )
    // Получение текста, что вводит пользователь с клавиатуры
    val raceNumberString = readln()
    // Ввод и инициализация переменной для выбора расы персонажа
    var raceNumber = 2
    // Безопасное реобразование String в int
    try {
        raceNumber = raceNumberString.toInt()
        // Отработка исключения
    } catch (e: Exception) {
        // Вывод сообщения об ошибке
        println(
            """Вы ввели неправильное значение,
               поэтому будете играть троллем :-)!""".trimMargin()
        )
    }
    // Возвращение значение переменной, содержащей наименование выбранной расы
    return when (raceNumber) {
        1 -> "robot"
        3 -> "wizard"
        else -> "troll"
    }
}

// Создание персонажа в зависимости от переданного значения расы
private fun createCharacter(name: String, race: String) =
    when (race) {
        "robot" -> Robot(name)
        "wizard" -> Wizard(name)
        else -> Troll(name)
    }

// Функция, содержащая логику игры
fun playGame(player: Player) {
    // Комп загадает число
    val compMystery = (Math.random() * 10).roundToInt()
    // Пользователя просим ввести число
    println("Добрый день! У Вас три попытки угадать правильное число. Введите, пожалуйста, число с 0 по 10!")
    // Вводим и инициализируем переменную для номера попытки
    var count = 1
    // Вводим и инициализируем переменную для хранения пользовательского ответа
    var userGuess = 0
    // Вводим и инициализируем переменную для хранения информации об успешном угадывании числа
    var successFlag = false
    // Запускаем цикл для угадывания
    println("Число, загаданное компом: $compMystery")
    // Запускаем цикл для угадывания
    while ((count <= 3) && (successFlag == false)) {
        // Просим ввести число-ответ
        println("Ваша попытка угадать число № $count :")
        // Считываем пользовательский ответ
        userGuess = readln().toInt()
        // Сравнить загаданное число компом и ответ человека
        if (compMystery == userGuess) {
            // Сообщение об удаче
            println("Ваша попытка угадать число увенчалась успехом!")
            // Действие игрока при выигрыше
            player.actionWin()
            // Изменяем значение флага по причине угадывания пользователем числа
            successFlag = true
        }
        // Увеличиваем счётчик
        count++
    }
    // Отслеживание превышения количества попыток
    if ((count >= 4) || (successFlag != true)) {
        // Информирование пользователя о его неудаче
        println("Ваша попытка угадать число не увенчалась успехом! Вы - неудачник!")
        // Действие игрока при проигрыше
        player.actionLoose()
    }
}
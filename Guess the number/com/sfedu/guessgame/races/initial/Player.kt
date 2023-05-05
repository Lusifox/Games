package com.sfedu.guessgame.races.initial

// Класс является абстрактным, поэтому тела для методов не требуются
abstract class Player {
    // Определили только наименование поля для ввода имени игрока
    var name: String? = null

    // Определили только наименование метода для действия игрока при выигрыше
    abstract fun actionWin()

    // Определили только наименование метода для действия игрока при поражении
    abstract fun actionLoose()
}
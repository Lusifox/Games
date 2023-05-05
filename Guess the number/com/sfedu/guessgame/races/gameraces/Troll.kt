package com.sfedu.guessgame.races.gameraces

import com.sfedu.guessgame.races.initial.Player

// Наследуем класс Robot от класса Player
class Troll(name: String) : Player() {
    // Введение переменной для имени игрока
    var trollName = name

    // Переопределение последовательности действий в методе при выигрыше
    override fun actionWin() {
        println("Моя выиграл!")
    }

    // Переопределение последовательности действий в методе при проигрыше
    override fun actionLoose() {
        println("Моя не может проиграть! Арррр!")
    }
}
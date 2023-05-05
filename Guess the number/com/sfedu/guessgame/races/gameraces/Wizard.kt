package com.sfedu.guessgame.races.gameraces

import com.sfedu.guessgame.races.initial.Player

// Наследуем класс Robot от класса Player
class Wizard(name: String) : Player() {
    // Введение переменной для имени игрока
    var wizardName = name

    // Переопределение последовательности действий в методе при выигрыше
    override fun actionWin() {
        println("Магия - рулит!")
    }

    // Переопределение последовательности действий в методе при проигрыше
    override fun actionLoose() {
        println("Я предвидел это и подготовился к худшему!")
    }
}
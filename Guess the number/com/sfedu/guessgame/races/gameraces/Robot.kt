package com.sfedu.guessgame.races.gameraces

import com.sfedu.guessgame.races.initial.Player

// Наследуем класс Robot от класса Player
class Robot(name: String) : Player() {
    // Введение переменной для имени игрока
    var robotName = name

    // Переопределение последовательности действий в методе при выигрыше
    override fun actionWin() {
        println("Ис-кусс-твен-ный ин-тел-лект о-пять о-дер-жал вверх!")
    }

    // Переопределение последовательности действий в методе при проигрыше
    override fun actionLoose() {
        println("За-пус-каю ра-ке-ту в пре-пят-ствие!")
    }
}
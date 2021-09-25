package ru.sber.functional

import kotlin.math.pow

object PowFactory {
    /**
     * Возвращает функцию, которая всегда возводит аргумент в нужную степень, указанную при создании функции.
     */
    fun buildPowFunction(power: Int): (Int) -> Int {
        return { it -> it.toDouble().pow(power).toInt() }
    }
}

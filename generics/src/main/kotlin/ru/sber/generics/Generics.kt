package ru.sber.generics

//import com.sun.org.apache.xpath.internal.operations.Bool
import java.util.*

// 1.
fun <K, V> compare(p1: Pair<K, V>, p2: Pair<K, V>): Boolean {
    return p1 == p2
}

// 2.
fun <T: Comparable<T>> countGreaterThan(anArray: Array<T>, elem: T): Int {
    return anArray.filter { it > elem }.size
}

// 3.
class Sorter <E: Comparable<E>>{
    val list: MutableList<E> = mutableListOf()

    fun add(value: E) {
        list.add(value)
        list.sort()
    }
}

// 4.
class Stack<E> {
    val list: MutableList<E> = mutableListOf()

    fun push(element: E) {
        list.add(element)
    }

    fun pop(): E {
        return list.removeLast()
    }

    fun isEmpty(): Boolean {
        return list.isEmpty()
    }

}
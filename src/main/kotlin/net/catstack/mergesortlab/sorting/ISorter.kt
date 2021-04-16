package net.catstack.mergesortlab.sorting

/**
 * Интерфейс для класса сортировщика
 */
interface ISorter<T> {
    fun sort(list: List<T>): List<T>
}
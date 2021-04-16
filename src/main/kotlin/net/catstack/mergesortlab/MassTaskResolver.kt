package net.catstack.mergesortlab

import net.catstack.mergesortlab.models.PlanModel
import net.catstack.mergesortlab.sorting.StringsMergeSorter
import java.io.File

/**
 * Класс для решения массовой задачи
 * @param plan - модель массовой задачи
 */
class MassTaskResolver(val plan: PlanModel) {
    private val dictionary = "абвгдежзийклмнопрстуфхцчшщъыьэюя123."
    private val sorter = StringsMergeSorter()

    /**
     * Метод решения массовой задачи и сохранения реультатов в CSV файл. Вид файла: длина_массива;количество_операций
     */
    fun resolve() {
        plan.experiments.forEach { experiment ->
            val totalStringBuilder = StringBuilder()

            experiment.nodes.forEach { node ->
                var listLength = node.startLength
                val resultStringBuilder = StringBuilder()

                while (listLength <= node.maxLength) {
                    repeat(node.repeat) {
                        val randomList = generateRandomStringList(listLength)

                        sorter.sort(randomList)

                        resultStringBuilder.append("$listLength;${sorter.operationsCount}\n")
                    }

                    if (node.name == "Arithmetic Progression")
                        listLength += node.diff
                    else if (node.name == "Geometric Progression")
                        listLength = (listLength * node.znamen).toInt()
                }

                totalStringBuilder.append(resultStringBuilder.toString())
                File("${experiment.name} - ${node.name}.csv").writeText(resultStringBuilder.toString())
            }

            File("${experiment.name} - total.csv").writeText(totalStringBuilder.toString())
        }
    }

    /**
     * Метод генерации массива со случайными строками
     * @param listLength - длина массива
     * @param stringLength - длина строки
     * @return возвращает сгенерированный массив
     */
    fun generateRandomStringList(listLength: Int, stringLength: Int = 20): List<String> {
        val resultList = arrayListOf<String>()

        repeat(listLength) {
            resultList.add(generateRandomString(stringLength))
        }

        return resultList
    }

    /**
     * Метод генерации случайной строки заданной длины
     * @param stringLength - длина строки
     * @return возвращает сгенерированную строку
     */
    fun generateRandomString(stringLength: Int): String {
        val result = StringBuilder()

        repeat(stringLength) {
            result.append(dictionary.random())
        }

        return result.toString()
    }
}
package net.catstack.mergesortlab.repository

import net.catstack.mergesortlab.models.Experiment
import net.catstack.mergesortlab.models.Node
import net.catstack.mergesortlab.models.PlanModel
import net.catstack.mergesortlab.utils.forEach
import net.catstack.mergesortlab.utils.get
import javax.xml.parsers.DocumentBuilderFactory

/**
 * Класс, который связывает файл с данными с представлением этих данных в виде объектов
 * @param filePath - путь к файлу с данными массовой задачи
 */
class PlanRepository(val filePath: String) {
    /**
     * Функция, которая производит парсинг XML файла и возвращающая программное представление массовой задачи
     * @return - Объект плана массовой задачи
     */
    fun getPlan(): PlanModel {
        val documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder()
        val document = documentBuilder.parse(filePath);

        val root = document.documentElement

        val experimentsElements = root.childNodes
        val experiments = arrayListOf<Experiment>()

        experimentsElements.forEach {
            val name = it.attributes["name"] ?: ""
            val nodesElements = it.childNodes
            val nodes = arrayListOf<Node>()

            nodesElements.forEach {
                val name = it.attributes["name"] ?: ""
                val minElement = it.attributes["minElement"]?.toInt() ?: 0
                val maxElement = it.attributes["maxElement"]?.toInt() ?: 0
                val startLength = it.attributes["startLength"]?.toInt() ?: 0
                val diff = it.attributes["diff"]?.toInt() ?: 0
                val znamen = it.attributes["znamen"]?.toFloat() ?: 0f
                val maxLength = it.attributes["maxLength"]?.toInt() ?: 10
                val repeat = it.attributes["repeat"]?.toInt() ?: 0
                nodes.add(Node(
                    name = name,
                    minElement = minElement,
                    maxElement = maxElement,
                    startLength = startLength,
                    diff = diff,
                    znamen = znamen,
                    maxLength = maxLength,
                    repeat = repeat
                ))
            }

            experiments.add(Experiment(name, nodes))
        }

        return PlanModel(experiments)
    }
}
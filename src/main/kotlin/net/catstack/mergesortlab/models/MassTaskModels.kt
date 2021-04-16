package net.catstack.mergesortlab.models

/**
 * Представление массовой задачи в виде объектов
 */
data class PlanModel(
    val experiments: List<Experiment>
)

data class Experiment(
    val name: String,
    val nodes: List<Node>
)

data class Node(
    val name: String,
    val minElement: Int,
    val maxElement: Int,
    val startLength: Int,
    val diff: Int,
    val znamen: Float,
    val maxLength: Int,
    val repeat: Int,
)

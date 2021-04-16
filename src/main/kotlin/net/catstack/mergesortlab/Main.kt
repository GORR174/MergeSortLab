package net.catstack.mergesortlab

import net.catstack.mergesortlab.repository.PlanRepository

fun main(args: Array<String>) {
    val plan = PlanRepository("MassTask.xml").getPlan()
    MassTaskResolver(plan).resolve()
}
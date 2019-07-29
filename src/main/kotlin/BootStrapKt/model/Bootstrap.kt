package BootStrapKt.model

import java.util.*
import kotlin.random.Random

fun exampleAdd(num: Int) = num + 1

fun bootstrapMean(sample: List<Double>, size: Int): List<Double> {
    val result = LinkedList<Double>()
    repeat(size) {
        val resample = LinkedList<Double>()
        repeat(sample.size) {
            resample.add(sample[Random.nextInt(sample.size)])
        }

        val resampleMean = resample.sum()/resample.size
        result.add(resampleMean)
    }

    return result.toList()
}
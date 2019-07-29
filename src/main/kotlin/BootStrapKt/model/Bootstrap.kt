package BootStrapKt.model

import kotlinx.coroutines.*
import java.util.*
import kotlin.random.Random

fun exampleAdd(num: Int) = num + 1

suspend fun bootstrapMean(sample: List<Double>, size: Int): List<Double> {
    val result = LinkedList<Deferred<Double>>()
    repeat(size) {
        result.add(resampleMeanAsync(sample))
    }
    return result.awaitAll()
}

fun resampleMeanAsync(sample: List<Double>) : Deferred<Double> = GlobalScope.async(Dispatchers.Default) {
    val resample = LinkedList<Double>()
    repeat(sample.size) {
        resample.add(sample[Random.nextInt(sample.size)])
    }

    resample.sum()/resample.size
}
package BootStrapKt.model

import kotlinx.coroutines.*
import java.lang.Error
import java.util.*
import kotlin.math.ceil
import kotlin.random.Random

fun exampleAdd(num: Int) = num + 1

suspend fun bootstrapMean(sample: List<Double>, size: Int): List<Double> {
    val result = LinkedList<Deferred<Double>>()
    repeat(size) {
        result.add(resampleMeanAsync(sample))
    }
    return result.awaitAll()
}

class Percentile(data: List<Double>) {
    private val data: List<Double> = data.sorted()

    fun percent(value: Double) : Double {
        if (!(0.1..100.0).contains(value)) throw Error("percentage must between 0 and 100.")
        val idx = ceil(data.count().toDouble() * value / 100.0).toInt() - 1
        return data[idx]
    }
}

suspend fun bootstrapMeanPercentile(sample: List<Double>, size: Int): Percentile {
    val result = LinkedList<Deferred<Double>>()
    repeat(size) {
        result.add(resampleMeanAsync(sample))
    }
    return Percentile(result.awaitAll())
}

fun resampleMeanAsync(sample: List<Double>) : Deferred<Double> = GlobalScope.async(Dispatchers.Default) {
    val resample = LinkedList<Double>()
    repeat(sample.size) {
        resample.add(sample[Random.nextInt(sample.size)])
    }

    resample.sum()/resample.size
}
/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package BootStrapKt

import BootStrapKt.model.bootstrapMean
import BootStrapKt.model.bootstrapMeanPercentile

class App {
    val greeting: String
        get() {
            return "Hello world."
        }
}

suspend fun main(args: Array<String>) {
    val sample = listOf( // n=200
            10.0, 20.0, 12.0, 23.5, 14.9, 32223.0, 32.0, 22.2, 1.2, 23.0,
            10.0, 20.0, 12.0, 23.5, 14.9, 32223.0, 32.0, 22.2, 1.2, 23.0,
            10.0, 20.0, 12.0, 23.5, 14.9, 32223.0, 32.0, 22.2, 1.2, 23.0,
            10.0, 20.0, 12.0, 23.5, 14.9, 32223.0, 32.0, 22.2, 1.2, 23.0,
            10.0, 20.0, 12.0, 23.5, 14.9, 32223.0, 32.0, 22.2, 1.2, 23.0,
            10.0, 20.0, 12.0, 23.5, 14.9, 32223.0, 32.0, 22.2, 1.2, 23.0,
            10.0, 20.0, 12.0, 23.5, 14.9, 32223.0, 32.0, 22.2, 1.2, 23.0,
            10.0, 20.0, 12.0, 23.5, 14.9, 32223.0, 32.0, 22.2, 1.2, 23.0,
            10.0, 20.0, 12.0, 23.5, 14.9, 32223.0, 32.0, 22.2, 1.2, 23.0,
            10.0, 20.0, 12.0, 23.5, 14.9, 32223.0, 32.0, 22.2, 1.2, 23.0,
            10.0, 20.0, 12.0, 23.5, 14.9, 32223.0, 32.0, 22.2, 1.2, 23.0,
            10.0, 20.0, 12.0, 23.5, 14.9, 32223.0, 32.0, 22.2, 1.2, 23.0,
            10.0, 20.0, 12.0, 23.5, 14.9, 32223.0, 32.0, 22.2, 1.2, 23.0,
            10.0, 20.0, 12.0, 23.5, 14.9, 32223.0, 32.0, 22.2, 1.2, 23.0,
            10.0, 20.0, 12.0, 23.5, 14.9, 32223.0, 32.0, 22.2, 1.2, 23.0,
            10.0, 20.0, 12.0, 23.5, 14.9, 32223.0, 32.0, 22.2, 1.2, 23.0,
            10.0, 20.0, 12.0, 23.5, 14.9, 32223.0, 32.0, 22.2, 1.2, 23.0,
            10.0, 20.0, 12.0, 23.5, 14.9, 32223.0, 32.0, 22.2, 1.2, 23.0,
            10.0, 20.0, 12.0, 23.5, 14.9, 32223.0, 32.0, 22.2, 1.2, 23.0,
            10.0, 20.0, 12.0, 23.5, 14.9, 32223.0, 32.0, 22.2, 1.2, 23.0
    )
    val start = System.currentTimeMillis()
    val res = bootstrapMean(sample, 100_000)
    val end = System.currentTimeMillis()
    println("処理時間: ${end - start}ms")
    println("結果: ${res.sum()/res.size} (元サンプル: ${sample.sum()/sample.size})")
    val ptile = bootstrapMeanPercentile(sample, 100_000)
    println("2.5%: ${ptile.percent(2.5)} 50%: ${ptile.percent(50.0)} 97.5%: ${ptile.percent(97.5)}")

}

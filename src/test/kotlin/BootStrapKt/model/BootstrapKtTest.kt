package BootStrapKt.model

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class BootstrapKtTest {

    @Test
    fun exampleAdd() {
        assertEquals(2, exampleAdd(1))
        assertEquals(3, exampleAdd(2))
    }

    @Test
    fun bootstrapMean() {
        val sample = listOf(
                10.0, 20.0, 12.0, 23.5, 14.9, 32223.0, 32.0, 22.2, 1.2, 23.0
        )
        val act = runBlocking { bootstrapMean(sample, 1000) }
        assertEquals(1000, act.size)
        assertEquals(3238.18, act.sum() / act.size, 300.0) // 10%くらいの誤差ならOK
    }
}
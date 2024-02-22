package nl.codecraftr.kata.unusualspending

import io.kotest.matchers.booleans.shouldBeTrue
import org.approvaltests.Approvals
import org.junit.jupiter.api.Test

class UnusualSpendingTest {
    @Test
    fun unusualSpendingDetected() {
        Approvals.verify(App.hello())
        true.shouldBeTrue()
    }
}

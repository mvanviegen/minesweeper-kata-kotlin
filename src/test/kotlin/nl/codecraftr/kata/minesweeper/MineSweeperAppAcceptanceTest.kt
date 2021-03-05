package nl.codecraftr.kata.minesweeper

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class MineSweeperAppAcceptanceTest : BehaviorSpec({
    lateinit var mineSweeperApp: MineSweeperApp
    beforeTest {
        val mineSweeperNotationParser = MineSweeperNotationParser()
        val mineSweeperOutputParser = MineSweeperOutputParser()

        mineSweeperApp = MineSweeperApp(mineSweeperNotationParser, mineSweeperOutputParser)
    }

    given("an empty minefield") {
        val input = ""

        `when`("it is solved") {
            val result = mineSweeperApp.solve(input)

            then("it should return zero solved minefields") {
                result shouldBe ""
            }
        }
    }

    given("end of input") {
        val input = "0 0"

        `when`("it is solved") {
            val result = mineSweeperApp.solve(input)

            then("it should return zero solved minefields") {
                result shouldBe ""
            }
        }
    }

    given("a single minefield") {
        val input = """
                    1 1
                    .
                    0 0
                """.trimIndent()

        val expected = """
                    Field #1:
                    0
                """.trimIndent()

        `when`("it is solved") {

            val result = mineSweeperApp.solve(input)

            then("it should return the solved minefield") {

                result shouldBe expected
            }
        }
    }
})
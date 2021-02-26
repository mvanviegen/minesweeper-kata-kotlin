package nl.codecraftr.kata.minesweeper

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldBeEmpty
import io.mockk.every
import io.mockk.mockk

internal class MineSweeperAppTest : WordSpec({
    lateinit var mineSweeperNotationParser : MineSweeperNotationParser
    lateinit var mineSweeperOutputParser : MineSweeperOutputParser
    lateinit var mineSweeperApp : MineSweeperApp

    beforeTest {
        mineSweeperNotationParser = mockk()
        mineSweeperOutputParser = mockk()
        mineSweeperApp = MineSweeperApp(mineSweeperNotationParser, mineSweeperOutputParser)
    }

    "solve" should {
        "return empty output given no minefields" {
            every {
                mineSweeperNotationParser.parse("")
            } returns emptyList()

            every {
                mineSweeperOutputParser.parse(emptyList())
            } returns ""

            val result = mineSweeperApp.solve("")

            result.shouldBeEmpty()
        }

        "return empty output given only end of input" {
            val input = "0 0"

            every {
                mineSweeperNotationParser.parse(input)
            } returns emptyList()

            /**
             * Minefield ..* -> solve -> Minefield 01*
             * Minefield
             */

            every {
                mineSweeperOutputParser.parse(emptyList())
            } returns ""

            val result = mineSweeperApp.solve(input)

            result.shouldBeEmpty()
        }

        "return solved output given a minefield within input" {
            val input = """
                    1 1
                    .
                    0 0
                """.trimIndent()

            val minefield = mockk<Minefield>()
            val solvedMinefield = Minefield(listOf(MinefieldRow(listOf(Square("0")))))

            val output = """
                    Field #1:
                    0 
                """.trimIndent()

            every {
                mineSweeperNotationParser.parse(input)
            } returns listOf(minefield)

            every {
                minefield.solve()
            } returns solvedMinefield

            every {
                mineSweeperOutputParser.parse(listOf(solvedMinefield))
            } returns output

            val result = mineSweeperApp.solve(input)

            result shouldBe output
        }
    }
})
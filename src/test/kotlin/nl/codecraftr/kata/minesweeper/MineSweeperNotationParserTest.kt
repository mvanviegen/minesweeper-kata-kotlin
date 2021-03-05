package nl.codecraftr.kata.minesweeper

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

internal class MineSweeperNotationParserTest : WordSpec({
    "parse" should {
        "return empty list given no input" {
            val result = MineSweeperNotationParser().parse("")

            result shouldBe emptyList()
        }

        "return empty list given end of file input" {
            val result = MineSweeperNotationParser().parse("0 0")

            result shouldBe emptyList()
        }

        "return a minefield given a valid input" {
            val notation = """
                1 1
                .
                0 0
            """.trimIndent()

            val expected = listOf(Minefield(listOf(MinefieldRow(listOf(Square("."))))))

            val result = MineSweeperNotationParser().parse(notation)

            result shouldBe expected
        }
    }
})
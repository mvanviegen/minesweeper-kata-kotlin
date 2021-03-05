package nl.codecraftr.kata.minesweeper

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldBeBlank

class MineSweeperOutputParserTest : WordSpec({
    "parse" should {
        "return empty string given no minefields" {
            val result = MineSweeperOutputParser().parse(emptyList())

            result.shouldBeBlank()
        }
        "return a string representation given solved minefields" {
            val solvedFields = listOf(Minefield(listOf(MinefieldRow(listOf(Square("0"))))))

            val expected = """
                    Field #1:
                    0
                """.trimIndent()

            val result = MineSweeperOutputParser().parse(solvedFields)

            result shouldBe expected
        }
    }
})

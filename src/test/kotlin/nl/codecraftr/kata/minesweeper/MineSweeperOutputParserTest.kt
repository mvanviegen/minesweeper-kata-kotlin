package nl.codecraftr.kata.minesweeper

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldBeBlank
import nl.codecraftr.kata.minesweeper.MineSweeperTestBuilder.Companion.aMineSweeper
import nl.codecraftr.kata.minesweeper.MinefieldRowTestBuilder.Companion.aRow
import nl.codecraftr.kata.minesweeper.MinefieldTestBuilder.Companion.aMinefield

class MineSweeperOutputParserTest : WordSpec({
    "parse" should {
        "return empty string given no minefields" {
            val result = MineSweeperOutputParser().parse(emptyList())

            result.shouldBeBlank()
        }
        "return a string representation given solved minefields" {
            val solvedFields = aMineSweeper()
                .withMineField(
                    aMinefield()
                        .withRow(
                            aRow()
                                .withSquare("0")
                        )

                )
                .build()

//            Minefield(listOf(MinefieldRow(listOf(Square("0")))))

            val expected = """
                    Field #1:
                    0
                """.trimIndent()

            val result = MineSweeperOutputParser().parse(solvedFields)

            result shouldBe expected
        }
    }
})

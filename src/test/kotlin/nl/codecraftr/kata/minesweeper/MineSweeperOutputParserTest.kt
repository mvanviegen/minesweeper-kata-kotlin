package nl.codecraftr.kata.minesweeper

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldBeBlank
import nl.codecraftr.kata.minesweeper.MineSweeperTestBuilder.Companion.aMineSweeper
import nl.codecraftr.kata.minesweeper.MinefieldRowTestBuilder.Companion.aRow
import nl.codecraftr.kata.minesweeper.MinefieldTestBuilder.Companion.aMinefield

class MineSweeperOutputParserTest : WordSpec({
    lateinit var parser: MineSweeperOutputParser

    beforeTest {
        parser = MineSweeperOutputParser()
    }

    "parse" should {
        "return empty string given no minefields" {
            val result = parser.parse(emptyList())

            result.shouldBeBlank()
        }
        "return a string representation given a solved minefield" {
            val solvedFields = aMineSweeper()
                .withMineField(
                    aMinefield()
                        .withRow(
                            aRow()
                                .withSquare("0")
                        )

                )
                .build()

            val expected = """
                    Field #1:
                    0
                """.trimIndent()

            val result = parser.parse(solvedFields)

            result shouldBe expected
        }

        "return a string representation given multiple solved minefields" {
            val solvedFields =
                aMineSweeper()
                    .withMineField(
                        aMinefield()
                            .withRow(
                                aRow()
                                    .withSquare("0")
                            )
                    )
                    .withMineField(
                        aMinefield()
                            .withRow(
                                aRow()
                                    .withSquare("0")
                            )
                    )
                    .build()

            val expected = """
                Field #1:
                0
                
                Field #2:
                0
            """.trimIndent()

            val result = parser.parse(solvedFields)

            result shouldBe expected
        }
    }
})

package nl.codecraftr.kata.minesweeper

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldBeBlank
import io.mockk.every
import io.mockk.mockk
import nl.codecraftr.kata.minesweeper.MineSweeperTestBuilder.Companion.aMineSweeper
import nl.codecraftr.kata.minesweeper.MinefieldRowTestBuilder.Companion.aRow
import nl.codecraftr.kata.minesweeper.MinefieldTestBuilder.Companion.aMinefield

class MineSweeperOutputParserTest : WordSpec({
    lateinit var parser: MineSweeperOutputParser
    lateinit var fieldParser: MinefieldOutputParser

    beforeTest {
        fieldParser = mockk()
        parser = MineSweeperOutputParser(fieldParser)
    }

    "parse" should {
        "return empty string given no minefields" {
            val result = parser.parse(emptyList())

            result.shouldBeBlank()
        }

        "return a string representation given a solved minefield with multiple rows" {
            val field =
                aMinefield()
                    .withRows(
                        aRow()
                            .withSquare("0"),
                        aRow()
                            .withSquare("0"),
                        aRow()
                            .withSquare("0"),
                        aRow()
                            .withSquare("0")
                    ).build()

            every { fieldParser.parse(field) } returns """
                0
                0
                0
                0
            """.trimIndent()

            val expected = """
                    Field #1:
                    0
                    0
                    0
                    0
                """.trimIndent()

            val result = parser.parse(listOf(field))

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

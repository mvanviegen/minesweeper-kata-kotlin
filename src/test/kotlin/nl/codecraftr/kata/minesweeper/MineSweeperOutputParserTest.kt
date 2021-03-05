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

        "return a string representation given multiple solved minefields" {
            val field =
                aMinefield()
                    .withRow(
                        aRow()
                            .withSquare("0")
                    )
            val solvedFields =
                aMineSweeper()
                    .withMineField(
                        field
                    )
                    .withMineField(
                        field
                    )
                    .build()

            every { fieldParser.parse(field.build()) } returns """
                0
                """.trimIndent()

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

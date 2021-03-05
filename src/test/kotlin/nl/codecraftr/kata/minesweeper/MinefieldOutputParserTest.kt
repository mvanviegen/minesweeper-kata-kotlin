package nl.codecraftr.kata.minesweeper

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe
import nl.codecraftr.kata.minesweeper.MinefieldRowTestBuilder.Companion.aRow
import nl.codecraftr.kata.minesweeper.MinefieldTestBuilder.Companion.aMinefield

internal class MinefieldOutputParserTest : WordSpec({
    lateinit var parser: MinefieldOutputParser

    beforeTest {
        parser = MinefieldOutputParser()
    }

    "parse" should {
        "return a string representation given a single row" {
            val field = aMinefield()
                .withRows(
                    aRow()
                        .withSquare("1"),
                    aRow()
                        .withSquare("0")
                )
                .build()

            val expected = """
                1
                0
            """.trimIndent()

            val result = parser.parse(field)

            result shouldBe expected
        }

        "return a string representation given a row with multiple squares" {
            val field = aMinefield()
                .withRows(
                    aRow()
                        .withSquare("0")
                        .withSquare("1")
                )
                .build()

            val expected = """
                01
            """.trimIndent()

            val result = parser.parse(field)

            result shouldBe expected
        }
    }
})

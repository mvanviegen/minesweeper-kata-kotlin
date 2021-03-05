package nl.codecraftr.kata.minesweeper

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import nl.codecraftr.kata.minesweeper.MinefieldRowTestBuilder.Companion.aRow
import nl.codecraftr.kata.minesweeper.MinefieldTestBuilder.Companion.aMinefield

internal class MinefieldOutputParserTest : WordSpec({
    lateinit var parser: MinefieldOutputParser
    lateinit var rowParser: MinefieldRowOutputParser

    beforeTest {
        rowParser = mockk()
        parser = MinefieldOutputParser(rowParser)
    }

    "parse" should {
        "return a string representation given a single row" {
            val firstRow = aRow()
                .withSquare("1")
            val secondRow = aRow()
                .withSquare("0")
            val field = aMinefield()
                .withRows(
                    firstRow,
                    secondRow
                )
                .build()

            every { rowParser.parse(firstRow.build()) } returns "1"
            every { rowParser.parse(secondRow.build()) } returns "0"

            val expected = """
                1
                0
            """.trimIndent()

            val result = parser.parse(field)

            result shouldBe expected
        }

        "return a string representation given a row with multiple squares" {
            val row = aRow()
                .withSquare("0")
                .withSquare("1")
            val field = aMinefield()
                .withRows(
                    row
                )
                .build()

            every { rowParser.parse(row.build()) } returns "01"

            val expected = """
                01
            """.trimIndent()

            val result = parser.parse(field)

            result shouldBe expected
        }
    }
})

package nl.codecraftr.kata.minesweeper

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.string.shouldBeEmpty
import io.mockk.every
import io.mockk.mockk

internal class MineSweeperAppTest : WordSpec({
    lateinit var mineSweeperNotationParser : MineSweeperNotationParser

    beforeTest {
        mineSweeperNotationParser = mockk()
    }

    "solve" should {
        "return empty string given no minefields" {
            every {
                mineSweeperNotationParser.parse("")
            } returns emptyList()

            val result = MineSweeperApp(mineSweeperNotationParser).solve("")

            result.shouldBeEmpty()
        }
    }
})
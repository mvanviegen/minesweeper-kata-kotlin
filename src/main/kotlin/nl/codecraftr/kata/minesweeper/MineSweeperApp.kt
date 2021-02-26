package nl.codecraftr.kata.minesweeper

class MineSweeperApp(
    private val mineSweeperNotationParser: MineSweeperNotationParser,
    private val mineSweeperOutputParser: MineSweeperOutputParser
) {
    fun solve(minefields: String) =
        minefields
            .let(mineSweeperNotationParser::parse)
            .map(Minefield::solve)
            .let(mineSweeperOutputParser::parse)
}

fun main() {
    val mineSweeperNotationParser = MineSweeperNotationParser()
    val mineSweeperOutputParser = MineSweeperOutputParser()

    MineSweeperApp(mineSweeperNotationParser, mineSweeperOutputParser).solve(
        """
   4 4
   *...
   ....
   .*..
   ....
   3 5
   **...
   .....
   .*...
   0 0
""".trimIndent()
    ).run(::print)
}
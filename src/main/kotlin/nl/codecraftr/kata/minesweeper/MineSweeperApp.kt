package nl.codecraftr.kata.minesweeper

class MineSweeperApp(mineSweeperNotationParser: MineSweeperNotationParser) {
    fun solve(minefields: String) = ""
}

fun main() {
    val mineSweeperInputParser = MineSweeperNotationParser()

    MineSweeperApp(mineSweeperInputParser).solve(
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
package nl.codecraftr.kata.minesweeper

class MineSweeperOutputParser {
    fun parse(minefields: List<Minefield>): String {
        if (minefields.isNotEmpty()) {
            return """
                Field #1:
                0
            """.trimIndent()
        }
        return ""
    }
}

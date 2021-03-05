package nl.codecraftr.kata.minesweeper

class MineSweeperNotationParser {
    fun parse(input: String): List<Minefield> {
        if (input.isEmpty())
            return emptyList()

        return listOf(Minefield(listOf(MinefieldRow(listOf(Square("."))))))
    }
}

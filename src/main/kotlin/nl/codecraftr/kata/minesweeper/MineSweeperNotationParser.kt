package nl.codecraftr.kata.minesweeper

class MineSweeperNotationParser {
    private companion object {
        const val EMPTY_FIELD_HEADER = "0 0"
    }
    fun parse(input: String): List<Minefield> {
        if (input.isEmpty() || input == EMPTY_FIELD_HEADER)
            return emptyList()

        return listOf(Minefield(listOf(MinefieldRow(listOf(Square("."))))))
    }
}

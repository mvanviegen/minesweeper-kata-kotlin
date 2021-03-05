package nl.codecraftr.kata.minesweeper

class MinefieldOutputParser {
    fun parse(field: Minefield) =
        field.rows.joinToString("\n", transform = ::parseRow)

    private fun parseRow(row: MinefieldRow) =
        row.squares.map(Square::value).joinToString(separator = "")
}

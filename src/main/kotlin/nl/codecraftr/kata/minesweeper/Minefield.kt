package nl.codecraftr.kata.minesweeper

data class Minefield(
    val rows: List<MinefieldRow>
) {
    fun solve(): Minefield {
        return this
    }
}
package nl.codecraftr.kata.minesweeper

data class Minefield(
    private val rows: List<MinefieldRow>
) {
    fun solve(): Minefield {
        return this
    }
}
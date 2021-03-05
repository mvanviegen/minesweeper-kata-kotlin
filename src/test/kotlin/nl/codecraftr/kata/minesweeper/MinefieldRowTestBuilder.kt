package nl.codecraftr.kata.minesweeper

class MinefieldRowTestBuilder {
    companion object {
        fun aRow() = MinefieldRowTestBuilder()
    }

    private var squares = emptyList<Square>()

    fun withSquare(square: String): MinefieldRowTestBuilder {
        squares = squares + Square(square)
        return this
    }

    fun build() = MinefieldRow(squares)
}
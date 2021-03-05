package nl.codecraftr.kata.minesweeper

class MinefieldTestBuilder {
    companion object {
        fun aMinefield() = MinefieldTestBuilder()
    }

    private var rows = emptyList<MinefieldRow>()

    fun withRow(builder: MinefieldRowTestBuilder): MinefieldTestBuilder {
        rows = rows + builder.build()
        return this
    }

    fun build() = Minefield(rows)
}
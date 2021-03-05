package nl.codecraftr.kata.minesweeper

class MineSweeperTestBuilder {
    companion object {
        fun aMineSweeper() = MineSweeperTestBuilder()
    }

    private var minefields = emptyList<Minefield>()

    fun withMineField(builder: MinefieldTestBuilder): MineSweeperTestBuilder {
        minefields = minefields + builder.build()
        return this
    }

    fun build(): List<Minefield> {
        return minefields
    }
}


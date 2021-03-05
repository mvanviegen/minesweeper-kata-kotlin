package nl.codecraftr.kata.minesweeper

class MineSweeperOutputParser internal constructor(private val fieldParser: MinefieldOutputParser) {
    constructor() : this(MinefieldOutputParser())

    fun parse(minefields: List<Minefield>): String {
        return minefields.mapIndexed { idx, field ->
            header(idx) + "\n" + fieldParser.parse(field)
        }.joinToString(separator = "\n\n")
    }

    private fun header(index: Int): String {
        val fieldNumber = index + 1
        return "Field #$fieldNumber:"
    }
}
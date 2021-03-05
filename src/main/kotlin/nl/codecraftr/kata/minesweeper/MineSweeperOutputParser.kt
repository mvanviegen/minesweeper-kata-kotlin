package nl.codecraftr.kata.minesweeper

class MineSweeperOutputParser internal constructor(private val fieldParser: MinefieldOutputParser) {
    constructor() : this(MinefieldOutputParser())

    fun parse(minefields: List<Minefield>) =
        minefields
            .map(fieldParser::parse)
            .mapIndexed {  idx, fieldContents -> FieldOutput(idx + 1, fieldContents) }
            .map(FieldOutput::present)
            .joinToString(separator = "\n\n")
}

private class FieldOutput(private val fieldNumber: Int, private val fieldContents: String) {
    fun present(): String {
        return header(fieldNumber) + "\n" + fieldContents
    }

    private fun header(fieldNumber: Int) = "Field #$fieldNumber:"
}

package nl.codecraftr.kata.minesweeper

class MinefieldOutputParser internal constructor(private val rowParser: MinefieldRowOutputParser) {
    constructor() : this(MinefieldRowOutputParser())
    fun parse(field: Minefield) =
        field.rows
            .map(rowParser::parse)
            .joinToString("\n")
}

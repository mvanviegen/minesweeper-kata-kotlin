package nl.codecraftr.kata.minesweeper

class MineSweeperOutputParser {
    fun parse(minefields: List<Minefield>): String {
        if (minefields.isNotEmpty()) {
            return minefields.mapIndexed { idx, field->
                val header = "Field #${idx+1}:"
                val fieldOutput = "0"
                header + "\n" + fieldOutput
            }.joinToString(separator = "\n\n")
        }
        return ""
    }
}

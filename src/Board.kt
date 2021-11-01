import java.awt.Color
import java.awt.Graphics

enum class PlayerSet {
    BLACK, WHITE, UNDEFINED
}

data class Position(var x:Int, var y:Int)

data class Cell(val position: Position, var piece: Piece = Piece.makePiece(), var cellColor: ColorSet = ColorSet.UNDEFINED, var selected: CellFeature = CellFeature.DEFAULT) {
    fun displayCell(g: Graphics) {
        g.color = when (selected) {
            CellFeature.SELECTED, CellFeature.HIGHLIGHTED -> Color(0xffd35c)
            else -> when(cellColor) {
                ColorSet.WHITE -> Color(0x4E9B6A)
                ColorSet.BLACK -> Color(0xB7E7C9)
                ColorSet.UNDEFINED -> Color(0xFFFFFF)
            }
        }
        g.fillRect(Board.marginX + position.x, Board.marginY + position.y, Board.cellSize, Board.cellSize)
        piece.display(g, position)
//        if(selected == CellFeature.SELECTED) {
//            piece.displayMovable(g, position)
//        }
    }


    //TODO : 활성화 토글
    fun toggleSelected(g: Graphics) {
        selected = selected.toggleSelected()
        displayCell(g)
    }
}

/*
class WasBoard {
    val board:Array<Array<Cell>>

    companion object {
        val cellSize = 80
        val marginX = 20
        val marginY = 20
    }

    init {
        board = Array(8) {
            Array(8) {
                it2 -> Cell(Position(it * cellSize, it2 * cellSize))
            }
        }
        resetBoard()
    }

    fun resetBoard() {
        board.forEachIndexed {
            index, arrayOfCells -> arrayOfCells.forEachIndexed {
                index2, cell -> board[index][index2] = Cell(Position(index * cellSize, index2 * cellSize))
            }
        }
    }
}
*/

class Board : ArrayList<Array<Cell>>() {
    companion object {
        val cellSize = 80
        val marginX = 20
        val marginY = 20
    }

    init {
        resetBoard()
    }

    fun resetBoard() {
        clear()
        for(i in 0..7) {
            add(Array(8){
                Cell(Position(i * cellSize, it * cellSize))
            })
        }
/*
        forEachIndexed {
            index, arrayOfCells -> arrayOfCells.forEachIndexed {
                index2, cell -> this[index][index2] = Cell(Position(index * cellSize, index2 * cellSize))
            }
        }
*/
    }

/*    fun getCell(position: Position):Cell {
        return this[position.x][position.y]
    }*/
}

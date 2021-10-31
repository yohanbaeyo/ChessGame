import java.awt.*
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import javax.swing.JFrame
import javax.swing.JPanel

enum class CellFeature {
    SELECTED, DEFAULT, HIGHLIGHTED;

    fun toggleHighlighted():CellFeature {
        return when(this) {
            HIGHLIGHTED -> DEFAULT
            else -> HIGHLIGHTED
        }
    }

    fun toggleSelected():CellFeature {
        return when(this) {
            SELECTED -> DEFAULT
            else -> SELECTED
        }
    }
    //TODO : compainon object 없이 toggle 구현
   /*fun toggle() {
        this = when(this) {
            SELECTED -> NOT_SELECTED
            NOT_SELECTED -> SELECTED
        }
    }*/
}

enum class ColorSet {
    WHITE, BLACK, UNDEFINED;

    fun toggleColor():ColorSet{
        return when(this) {
            WHITE -> BLACK
            BLACK -> WHITE
            else -> this
        }
    }
}

class MainFrame : JFrame("Chess Game") {
    init {
        bounds = Rectangle(0, 0, Board.cellSize * 8 + Board.marginX * 4, Board.cellSize * 8 + Board.marginY * 4)
        addWindowListener(object : WindowAdapter() {
            override fun windowClosing(e: WindowEvent?) {
                isVisible = false
                System.exit(0)
            }
        })
        contentPane = MainPanel()
        isVisible = true
    }

    class MainPanel : JPanel() {
        val board = Board()

        init {
            /*addMouseListener(object : MouseAdapter() {
                override fun mouseClicked(me: MouseEvent?) {
                    val g = graphics
                    foreground = Color.BLUE
                    g.font = Font("Roboto", Font.BOLD, 20)
                    g.drawString("YOHAN", me!!.x, me.y)
                }
            })*/
            addMouseListener(GameController(this))
        }

        override fun paintComponent(g: Graphics) {
            super.paintComponent(g)
            displayNewBoard(g)
        }

        fun displayNewBoard(g: Graphics) {
            board.resetBoard()
            var cellColor = ColorSet.WHITE
            board.forEach {
                it.forEach {
                    it.cellColor = cellColor
                    it.displayCell(g)
                    cellColor = cellColor.toggleColor()
                }
                cellColor = cellColor.toggleColor()
            }
        }
    }
}

fun main() {
    val mf = MainFrame()
}
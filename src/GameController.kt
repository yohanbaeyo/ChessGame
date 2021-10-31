import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent

class GameController(val mainPanel:MainFrame.MainPanel) : MouseAdapter(){
    lateinit var currentSelected: Position
    private var doesSelectionExist: Boolean = false

    override fun mouseClicked(me: MouseEvent) {
        /*val g=mainPanel.graphics
//        foreground = Color.BLUE
        g.font = Font("Roboto", Font.BOLD, 20)
        g.drawString("YOHAN", me.x, me.y)*/

        val g = mainPanel.graphics

        if(me.x<Board.marginX || me.x>Board.marginX+Board.cellSize*8 ||
            me.y<Board.marginY || me.y>Board.marginY+Board.cellSize*8) {
            println("Invalid Click")
            return
        }

        val x = (me.x - Board.marginX)/Board.cellSize
        val y = (me.y - Board.marginY)/Board.cellSize

        mainPanel.board[x][y].toggleSelected(g)
        if(doesSelectionExist) {
            if(currentSelected == Position(x,y)) {
                doesSelectionExist = false
            } else {
                mainPanel.board[currentSelected.x][currentSelected.y].toggleSelected(g)
                currentSelected = Position(x,y)
            }
        } else {
            currentSelected = Position(x,y)
            doesSelectionExist = true
        }

        println("$x $y")
    }
}
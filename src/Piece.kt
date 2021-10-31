import java.awt.Graphics
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

enum class PieceType {
    PAWN, KNIGHT, BISHOP, ROOK, QUEEN, KING, UNDEFINED
}

abstract class Piece {
    companion object {
        fun makePiece(pieceType: PieceType = PieceType.UNDEFINED, playerSet: PlayerSet = PlayerSet.UNDEFINED):Piece {
            return when (pieceType) {
                PieceType.PAWN -> Pawn(playerSet)
                /*PieceType.KNIGHT -> Knight(playerSet)
                PieceType.BISHOP -> Bishop(playerSet)
                PieceType.ROOK -> Rook(playerSet)
                PieceType.QUEEN -> Queen(playerSet)
                PieceType.KING -> King(playerSet)*/
                else -> NoPiece(playerSet)
            }
        }
    }

    abstract val playerSet:PlayerSet
//    abstract val imageBlack: BufferedImage
//    abstract val imageWhite: BufferedImage

    abstract fun display(mainPanel: MainFrame.MainPanel, position: Position)
    abstract fun displayMovable(graphics: Graphics, position: Position)
}

class NoPiece(override val playerSet: PlayerSet):Piece() {
//    override val imageBlack: BufferedImage
////        get() = TODO("Not yet implemented")
//    override val imageWhite: BufferedImage
////        get() = TODO("Not yet implemented")
//    init {
//        imageBlack = ImageIO.read(File(Piece.javaClass!!.classLoader.getResource("PawnBlack.png")!!.path))
//        imageWhite = ImageIO.read(File(Piece.javaClass!!.classLoader.getResource("PawnWhite.png")!!.path))
//    }

    override fun display(mainPanel: MainFrame.MainPanel, position: Position) {

    }

    override fun displayMovable(graphics: Graphics, position: Position) {

    }

}

class Pawn(override val playerSet: PlayerSet):Piece() {
//    override val imageBlack: BufferedImage
//    override val imageWhite: BufferedImage
//
//    init {
//        imageBlack = ImageIO.read(File(Piece::class.java.getResource("PawnBlack.png")!!.path))
//        imageWhite = ImageIO.read(File(Piece::class.java.getResource("PawnWhite.png")!!.path))
//    }

    override fun display(mainPanel: MainFrame.MainPanel, position: Position) {
//        val g = mainPanel.graphics
//        g.drawImage(when(playerSet) {
//            PlayerSet.WHITE -> imageWhite
//            PlayerSet.BLACK -> imageBlack
//            else -> imageBlack
//        }, position.x, position.y, mainPanel)
    }

    override fun displayMovable(graphics: Graphics, position: Position) {

    }
}
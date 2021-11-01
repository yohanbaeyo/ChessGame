import java.awt.Graphics
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

enum class PieceType {
    Pawn, KNIGHT, BISHOP, ROOK, QUEEN, KING, NoPiece;
}

fun inputFilePath(fileName:String):String {
    return Piece::class.java.getResource("$fileName.png")!!.path.replace("%20", " ")
}

abstract class Piece {
    companion object {
        fun makePiece(pieceType: PieceType = PieceType.NoPiece, playerSet: PlayerSet = PlayerSet.UNDEFINED):Piece {
            return when (pieceType) {
                PieceType.Pawn -> Pawn(playerSet)
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
    val imageBlack: BufferedImage
    val imageWhite: BufferedImage

    init {
//        println(this.javaClass.name.toString()+"Black")
        imageBlack = ImageIO.read(File(inputFilePath(javaClass.name.toString()+"Black")))
        imageWhite = ImageIO.read(File(inputFilePath(javaClass.name.toString()+"White")))
    }

    fun display(g: Graphics, position: Position) {
        val padding = 0.15
        g.drawImage(when(playerSet) {
            PlayerSet.WHITE -> imageWhite
            PlayerSet.BLACK -> imageBlack
            else -> imageBlack
        }, position.x+Board.marginX+(Board.cellSize * padding).toInt(), position.y+Board.marginY+(Board.cellSize * padding).toInt(), (Board.cellSize*(1-2*padding)).toInt(), (Board.cellSize*(1-2*padding)).toInt(), null)
    }
    abstract fun displayMovable(graphics: Graphics, position: Position)
}

class NoPiece(override val playerSet: PlayerSet):Piece() {
//    override val imageBlack: BufferedImage
//    override val imageWhite: BufferedImage

    init {
//        println(this::class.java.classLoader.getResource("PawnBlack.png")!!.path)
//        imageBlack = ImageIO.read(File(inputFilePath("Black")))
//        imageWhite = ImageIO.read(File(inputFilePath(javaClass.name+"White")))
    }

    override fun displayMovable(graphics: Graphics, position: Position) {

    }

}

class Pawn(override val playerSet: PlayerSet):Piece() {
//    override val imageBlack: BufferedImage
//    override val imageWhite: BufferedImage

    init {
//        println(this::class.java.classLoader.getResource("PawnBlack.png")!!.path)
//        imageBlack = ImageIO.read(File(inputFilePath("PawnBlack")))
//        imageWhite = ImageIO.read(File(inputFilePath("PawnWhite")))
    }

    override fun displayMovable(graphics: Graphics, position: Position) {

    }
}
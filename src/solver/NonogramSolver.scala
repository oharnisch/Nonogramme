package solver
import api._

/**
  * Created by Ole on 27.05.2016.
  */
object NonogramSolver {
  def solve(nono: Nonogram): Unit ={
      println("I am a dummy solver but I do only take Nonogram Objects")
      println("Proof I can work with the Nonogramobject:")
      println("Before:")
      println(nono)
      println("After: (setting field 0 0 to filled and 0 1 to empty")
    nono.board.setField(0,0,Field.filled)
    nono.board.setField(0,1,Field.empty)
    println(nono)
  }

}

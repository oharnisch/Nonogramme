package solver
import api._

/**
  * Created by Ole on 27.05.2016.
  */
object NonogramSolver {
  def solve(nono: Nonogram): Nonogram ={
      println("I am a dummy solver but I do only take Nonogram Objects")
      println("Proof I can work with the Nonogramobject:")
      println("Before:")
      println(nono)
      println("After: (scripted)")
    nono.board.setField(0,0,Field.filled)
    nono.board.setField(0,1,Field.empty)
    nono.board.setField(0,2,Field.filled)
    nono.board.setField(1,0,Field.filled)
    nono.board.setField(1,1,Field.empty)
    nono.board.setField(1,2,Field.empty)
    nono.board.setField(2,0,Field.filled)
    nono.board.setField(2,1,Field.empty)
    nono.board.setField(2,2,Field.filled)



    println(nono)
    nono
  }

}

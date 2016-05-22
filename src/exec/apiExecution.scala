package exec

import api._

/**
* Created by Ole on 21.05.2016.
*/
object apiExecution{
  def main(args: Array[String]) {
    val r = {
      NonogramDeclaration(2,2,List(rowDeclaration(List(3, 4)),rowDeclaration(List(1,7))), List(columnDeclaration(List(3, 4)),columnDeclaration(List(2, 9))))
    }
    val f = new Nonogram(r)
    println(f)

    val b = new Board(2,2)
    b.setField(1,1,Field.empty)
    b.setField(0,1,Field.filled)
    println(b)


  }


}

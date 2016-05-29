package exec

import api._

/**
* Created by Ole on 21.05.2016.
*/
object apiExecution{
  def main(args: Array[String]) {
    val nd = {
      NonogramDeclaration(2,2,List(rowDeclaration(List(1)),rowDeclaration(List(2))), List(columnDeclaration(List(2)),columnDeclaration(List(1))))
    }
    val nono = new Nonogram(nd)
    println(nono)




  }


}

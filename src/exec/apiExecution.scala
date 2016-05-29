package exec

import api._

/**
* Created by Ole on 21.05.2016.
*/
object apiExecution{
  def main(args: Array[String]) {
    val nd = {
      NonogramDeclaration(2,2,List(rowDeclaration(List(3, 4)),rowDeclaration(List(1,7))), List(columnDeclaration(List(3, 4)),columnDeclaration(List(2, 9))))
    }
    val nono = new Nonogram(nd)
    println(nono)




  }


}

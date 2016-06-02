package exec

import api._

/**
* Created by Ole on 21.05.2016.
*/
object apiExecution{
  def main(args: Array[String]) {
    val nd = {
      NonogramDeclaration(2,2,List(RowDeclaration(List(1)),RowDeclaration(List(2))), List(ColumnDeclaration(List(2)),ColumnDeclaration(List(1))))
    }
    val nono = new Nonogram(nd)
    println(nono)




  }


}

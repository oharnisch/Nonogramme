import api._

/**
* Created by Ole on 21.05.2016.
*/
object Runner{
  def main(args: Array[String]) {
    val r = {
      NonogramDeclaration(2,2,Seq(rowDeclaration(List(3, 4)),rowDeclaration(List(1,7))), Seq(columnDeclaration(Seq(3, 4)),columnDeclaration(Seq(2, 9))))
    }
    val f = new Nonogram(r)
    println(f)

    val v = Field.unknown()
  }


}

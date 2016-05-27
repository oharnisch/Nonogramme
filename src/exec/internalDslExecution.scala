package exec
import dsl.NonogramImplicits._

/**
  * Created by Ole on 22.05.2016.
  */
object internalDslExecution {
  def main(args: Array[String]){

    import dsl.NonogramImplicits._

    val nonogramm = 3 x 3 Nonogramm (Zeilen(List(List(3),List(1),List(1))),Spalten(List(List(2),List(1),List(1))))
    //val lis:List[Int] = (2, 34, 5)
    print(nonogramm)
  }

}

package exec
import dsl.NonogramImplicits._

/**
  * Created by Ole on 22.05.2016.
  */
object dslExecution {
  def main(args: Array[String]){
    import dsl.NonogramImplicits._
    val nonogramm = 3 x 3 Nonogramm(new Zeilen(List(List(2),List(1),List(1))),new Spalten(List(List(2),List(1),List(1)))) d()
    print(nonogramm)
  }

}

package exec
import solver.NonogramSolver

/**
  * Created by Ole on 22.05.2016.
  */
object internalDslExecution {
  def main(args: Array[String]){

    import dsl.NonogramImplicits._

    var nonogram = 3 x 3 Nonogramm (Zeilen(List(List(3),List(1),List(1))),Spalten(List(List(2),List(1,1),List(1))))
    //val lis:List[Int] = (2, 34, 5)

    nonogram = NonogramSolver.solve(nonogram)
    print(nonogram)
  }

}

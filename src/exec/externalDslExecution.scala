package exec
import dsl.NonogramParser
import solver.NonogramSolver

/**
  * Created by Ole on 27.05.2016.
  */
object externalDslExecution {
  def main(args: Array[String]) {

    val t = "2 x 2 Nonogramm Zeilen ( 22 ) ( 2 1 )  Spalten ( 3 ) ( )"


    NonogramParser.parseAll(NonogramParser.model,t) match {
      case NonogramParser.Success(res,_) => println("Parsing Success! : \n" +res)
      case x => println(x)
    }

    NonogramParser.parseAll(NonogramParser.model,t) match {
      case NonogramParser.Success(res,_) => NonogramSolver.solve(res)
      case x => println(x)
    }

  }

}

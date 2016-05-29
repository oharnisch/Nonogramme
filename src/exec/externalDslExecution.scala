package exec
import dsl.NonogramParser
import solver.NonogramSolver

/**
  * Created by Ole on 27.05.2016.
  */
object externalDslExecution {
  def main(args: Array[String]) {

    val t = "3 x 3 Nonogramm Zeilen ( 1 1 ) (1) (1 1)  Spalten ( 3 ) ( ) (1 1)"


    NonogramParser.parseAll(NonogramParser.model,t) match {
      case NonogramParser.Success(res,_) => println("Parsing Success! : \n" +res)
      case x => println(x)
    }

  /**
    NonogramParser.parseAll(NonogramParser.model,t) match {
      case NonogramParser.Success(res,_) => NonogramSolver.solve(res)
      case x => println(x)
    }
    **/


  }

}

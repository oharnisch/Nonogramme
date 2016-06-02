package dsl

import scala.util.parsing.combinator.JavaTokenParsers
import api._
import solver.NonogramSolver._

/**
  * Created by Ole on 27.05.2016.
  */
object NonogramParser extends JavaTokenParsers {

  def createOrSolve = "erstelle"|"löse" ^^ {
    case "erstelle" => true
    case "löse" => false
  }

  def model = createOrSolve ~ ratio ~ nonoDec ^^ {
    case true~r ~ nd => createNono(r,nd)
    case false ~ r~ nd => solver.NonogramSolver.solve(createNono(r,nd))
  }

  def ratio = (wholeNumber <~ "x") ~ wholeNumber ^^ {
    case row ~ column   => Ratio(row.toInt,column.toInt)
  }

  def nonoDec = "Nonogramm" ~ "Zeilen" ~> rowSpecifier.* ~ ("Spalten" ~> columnSpecifier.*) ^^{
    case roSpec ~ colSpec => NonoDec(roSpec,colSpec)
  }
  def rowSpecifier = "("~> wholeNumber.* <~ ")" ^^ {
    case numberOfBlocks => RowDeclaration(numberOfBlocks.map(x => x.toInt))
  }

  def columnSpecifier = "("~> wholeNumber.* <~ ")" ^^ {
    case numberOfBlocks => ColumnDeclaration(numberOfBlocks.map(x => x.toInt))
  }
  case class NonoDec(rowDecs:List[RowDeclaration], colDecs:List[ColumnDeclaration])
  case class Ratio (rowNumber:Int,colNumber:Int)

  def createNono (r:Ratio,nd:NonoDec): Nonogram ={
    val ndObj = NonogramDeclaration(r.rowNumber,r.colNumber,nd.rowDecs,nd.colDecs)
    Nonogram(ndObj)
  }
}

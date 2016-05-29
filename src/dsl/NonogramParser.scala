package dsl

import scala.util.parsing.combinator.JavaTokenParsers
import api._

/**
  * Created by Ole on 27.05.2016.
  */
object NonogramParser extends JavaTokenParsers {
  //lexical.reserved += ("x","Nonogramm","Zeilen","Spalten")
  def model = ratio ~ nonoDec ^^ {
    case r ~ nd => createNono(r,nd)
  }
  def ratio = (wholeNumber <~ "x") ~ wholeNumber ^^ {
    case row ~ column   => Ratio(row.toInt,column.toInt)
  }

  def nonoDec = "Nonogramm" ~ "Zeilen" ~> rowSpecifier.* ~ ("Spalten" ~> columnSpecifier.*) ^^{
    case roSpec ~ colSpec => NonoDec(roSpec,colSpec)
  }
  def rowSpecifier = "("~> wholeNumber.* <~ ")" ^^ {
    case numberOfBlocks => rowDeclaration(numberOfBlocks.map(x => x.toInt))
  }

  def columnSpecifier = "("~> wholeNumber.* <~ ")" ^^ {
    case numberOfBlocks => columnDeclaration(numberOfBlocks.map(x => x.toInt))
  }
  case class NonoDec(rowDecs:List[rowDeclaration],colDecs:List[columnDeclaration])
  case class Ratio (rowNumber:Int,colNumber:Int)

  def createNono (r:Ratio,nd:NonoDec): Nonogram ={
    val ndObj = NonogramDeclaration(r.rowNumber,r.colNumber,nd.rowDecs,nd.colDecs)
    Nonogram(ndObj)
  }
}

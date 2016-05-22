package dsl

import api._
/**
  * Created by Ole on 21.05.2016.
  */
object NonogramImplicits {
  type Rows = Int
  type Columns = Int
  type RowDec = Array[Int]
  case class Rate  (r:Rows,c:Columns)
  case class NonoDec  (ra:Rate,z:Zeilen,s:Spalten)
  //ratio
  implicit class Ratio (r:Rows){
    def x (c:Columns) = new Rate(r,c)
  }
  implicit class Nono(ra:Rate) {
    def Nonogramm(z: Zeilen, s: Spalten): Nonogram = {
      val rds: List[rowDeclaration] = z.seq.map(x => new rowDeclaration(x))
      val cds: List[columnDeclaration] = s.seq.map(x => new columnDeclaration(x))
      new Nonogram(new NonogramDeclaration(ra.c, ra.r, rds, cds))
    }
  }

  implicit def ints2List (x: Int*) : List[Int] = {
    x.toList
  }
  implicit def lists2Listlist (x: List[Int]*) : List[List[Int]] = {
    x.toList
  }

  case class Zeilen(seq: List[List[Int]])
  case class Spalten(seq: List[List[Int]])

//  implicit def rows2Ratio(r : rows)=
  //  new Ratio(r)




}

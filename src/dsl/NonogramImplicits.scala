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
  case class NonoDec  (ra:Rate, z:row, s:column)
  //ratio
  implicit class Ratio (r:Rows){
    def x (c:Columns) = new Rate(r,c)
  }
  implicit class Nono(ra:Rate) {
    def Nonogramm(z: row, s: column): Nonogram = {
      val rds: List[RowDeclaration] = z.seq.map(x => new RowDeclaration(x))
      val cds: List[ColumnDeclaration] = s.seq.map(x => new ColumnDeclaration(x))
      new Nonogram(new NonogramDeclaration(ra.c, ra.r, rds, cds))
    }
  }

  implicit def ints2List (x: Int*) : List[Int] = {
    x.toList
  }
  implicit def lists2Listlist (x: List[Int]*) : List[List[Int]] = {
    x.toList
  }
  def Zeilen (seq: List[List[Int]]) = new row(seq)
  def Spalten (seq: List[List[Int]]) = new column(seq)

  case class row(seq: List[List[Int]])
  case class column(seq: List[List[Int]])

//  implicit def rows2Ratio(r : rows)=
  //  new Ratio(r)




}

package dsl

import api._
/**
  * Created by Ole on 21.05.2016.
  */
object NonogramImplicits {
  type Rows = Int
  type Columns = Int
  type RowDec = Array[Int]
  private case class Rate  (r:Rows,c:Columns)
  private case class NonoDec  (ra:Rate, z:row, s:column)
  //ratio
  implicit class Ratio (r:Rows){
    def x (c:Columns) = new Rate(r,c)
  }
  implicit class Nono(ra:Rate) {
    def Nonogramm(z: row, s: column): Nonogram = {
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
  def Zeilen (seq: List[List[Int]]) = new row(seq)
  def Spalten (seq: List[List[Int]]) = new column(seq)

  private case class row(seq: List[List[Int]])
  private case class column(seq: List[List[Int]])

//  implicit def rows2Ratio(r : rows)=
  //  new Ratio(r)




}

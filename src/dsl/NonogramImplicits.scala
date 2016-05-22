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
  implicit class Nono(ra:Rate){
    def Nonogramm(z:Zeilen,s:Spalten)=new NonoDec(ra,z,s)
  }

  implicit class NonoCreator(nd:NonoDec){
    def d ():Nonogram ={
      val rds : List[rowDeclaration] =nd.z.seq.map(x=> new rowDeclaration(x))
      val cds : List[columnDeclaration]= nd.s.seq.map(x => new columnDeclaration(x))
      new Nonogram(new NonogramDeclaration(nd.ra.c,nd.ra.r,rds,cds))
    }
  }

  case class Zeilen(seq: List[List[Int]])
  case class Spalten(seq: List[List[Int]])

//  implicit def rows2Ratio(r : rows)=
  //  new Ratio(r)




}

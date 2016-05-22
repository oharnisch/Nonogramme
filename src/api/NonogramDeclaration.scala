package api

/**
* Created by Ole on 21.05.2016.
*/
case class NonogramDeclaration(numberRows:Int, numberColumns:Int, rows: Seq[rowDeclaration], columns : Seq[columnDeclaration]){
  //restrictions
  if (numberRows!=rows.length){
    //abort
    println("not matching row length")
  }
  if (numberColumns!=columns.length){
    //abort
    println("not matching columns length")
  }
  if (numberColumns==0 || numberRows == 0){
    //abort
    println ("0 length not allowed")
  }

  //output Helper vars
  var outputRow = ""
  rows.foreach{outputRow += _.toString()+"\n"}
  var outputColumn = ""
  columns.foreach{outputColumn += _.toString()}

  override def toString =
    s"""        $outputColumn\n$outputRow
     """




}

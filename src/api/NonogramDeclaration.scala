package api

/**
* Created by Ole on 21.05.2016.
*/
case class NonogramDeclaration(numberRows:Int, numberColumns:Int, rows: List[rowDeclaration], columns : List[columnDeclaration]){
  //restrictions
  if (numberRows!=rows.length){
    //abort
    throw new Error("Number of row length does not match number of rows")
  }
  if (numberColumns!=columns.length){
    //abort
    throw new Error("Number of columns does not match number of columns")
  }
  if (numberColumns==0 || numberRows == 0){
    //abort
    throw new Error("0 length not allowed")
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

package api

/**
  * Created by Ole on 22.05.2016.
  */
class Board(numberRows : Int , numberColumns : Int) {
  var board = Array.ofDim[Field.Value](numberRows,numberColumns)

  for (i <- 0 until numberRows){
    for (j <- 0 until numberColumns) {
      board(i)(j) = Field.unknown
    }
  }

  def getField(row:Int, column:Int): Field.Value ={
    if(row < numberRows && column < numberColumns){
      return board(row)(column)
    }else  {
      throw new Exception("Field call out of Bounds.")
    }
  }

  def setField (row:Int,column:Int,field: Field.Value) : Boolean = {
    if (getField(row,column)== Field.unknown){
      board(row)(column) = field
      return true
    }else{
      println(s"The field at ${row},${column} was already set.")
      return false
    }
  }

  override def toString: String = {
    return ""

  }
}

package api

/**
  * Created by Ole on 21.05.2016.
  */
case class Nonogram(nonoDec: NonogramDeclaration){
  var  board = new Board(nonoDec.numberRows,nonoDec.numberColumns)


  // dummy method for checking a nonogram
  def check(): Boolean = true


  override def toString: String = {

    var output:String = ""
    // left margin for line 0
    val margin = 9
    for (e <- 0 to (margin+1)){
      output += " "
    }
    output += nonoDec.outputColumn + "\n"
    for (i <- 0 until nonoDec.numberRows){
      output+= nonoDec.rows(i)
      for (m<-0 until (margin-nonoDec.rows(i).toString.length)){
        output +=" "
      }
      output +=" | "
      for (j <- 0 until nonoDec.numberColumns){
        output += board.fieldToString(i,j)
        for (k <- 0 to (nonoDec.columns(j).toString().length()-board.fieldToString(i,j).length)){
          output += " "
        }
      }
      output += "\n"
    }
    output

  }

}

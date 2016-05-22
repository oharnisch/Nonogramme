package api

/**
  * Created by Ole on 21.05.2016.
  */
case class Nonogram(nonogrammDeclaration: NonogramDeclaration){
  var  matrix = new Array[Array[Boolean]](nonogrammDeclaration.numberRows)
  for (i <- 0 until nonogrammDeclaration.numberRows){
    //creates Matrix with only false in it
    matrix(i)=new Array[Boolean](nonogrammDeclaration.numberColumns)
  }


  // dummy method for checking a nonogram
  def check(): Boolean = true


  override def toString: String = {

    var output:String = ""
    for (e <- 0 to nonogrammDeclaration.rows.head.toString().length+3){
      output += " "
    }
    output += nonogrammDeclaration.outputColumn + "\n"
    for (i <- 0 until nonogrammDeclaration.numberRows){
      output+= nonogrammDeclaration.rows(i) + " | "
      for (j <- 0 until nonogrammDeclaration.numberColumns){
        output += matrix(i)(j)
        for (k <- 0 to (nonogrammDeclaration.columns(j).toString().length()-matrix(i)(j).toString.length)){
          output += " "
        }
      }
      output += "\n"
    }
    output

  }

}

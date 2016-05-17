/**
  * Created by Ole on 10.05.2016.
  */

class fieldDescriber(numberOfBlocks : Seq[Integer]){
}

case class rowDeclaration(numberOfBlocks : List[Integer]) {

      var output = ""
      numberOfBlocks.foreach(output += ", "+_ )
      output = output.replaceFirst(", ","(")
      output += ")"

    override def toString = s"$output"
}

  case class columnDeclaration(numberOfBlocks : Seq[Integer]){

      var output = ""
      numberOfBlocks.foreach(output += ", "+_ )
      output = output.replaceFirst(", ","(")
      output += ")"

    override def toString = s"$output  "
  }

  case class NonogrammDeclaration(numberRows:Int,numberColumns:Int,rows: Seq[rowDeclaration], columns : Seq[columnDeclaration]){
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

    //output
    var outputRow = ""
    rows.foreach{outputRow += _.toString()+"\n"}
    var outputColumn = ""
    columns.foreach{outputColumn += _.toString()}
    override def toString =
      s"""        $outputColumn\n$outputRow
       """




  }

case class Nonogram(nonogrammDeclaration: NonogrammDeclaration){
  var  matrix = new Array[Array[Boolean]](nonogrammDeclaration.numberRows)
  for (i <- 0 until nonogrammDeclaration.numberRows){
    //creates Matrix with only false in it
    matrix(i)=new Array[Boolean](nonogrammDeclaration.numberColumns)
  }
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


  object runEnv{
    def main(args: Array[String]) {
      val r = {
        NonogrammDeclaration(2,2,Seq(rowDeclaration(List(3, 4)),rowDeclaration(List(1,7))), Seq(columnDeclaration(Seq(3, 4)),columnDeclaration(Seq(2, 9))))
      }
      val f = new Nonogram(r)
      println(f)
    }

  }


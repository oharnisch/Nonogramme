package api

/**
  * Created by Ole on 21.05.2016.
  */
case class RowDeclaration(numberOfBlocks : List[Int]) {

      var output = ""
  if(numberOfBlocks.isEmpty){
    output = "( )"
  }else {
    numberOfBlocks.foreach(output += ", " + _)
    output = output.replaceFirst(", ", "(")
    output += ")"
  }
    override def toString = s"$output"
}

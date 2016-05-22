package api

/**
* Created by Ole on 21.05.2016.
*/
case class columnDeclaration(numberOfBlocks : Seq[Integer]){

    var output = ""
    numberOfBlocks.foreach(output += ", "+_ )
    output = output.replaceFirst(", ","(")
    output += ")"

  override def toString = s"$output  "
}

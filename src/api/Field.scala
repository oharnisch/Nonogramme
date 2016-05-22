package api

/**
* Created by Ole on 21.05.2016.
*/
object Field extends Enumeration{
  val unknown, empty, filled = Value
  override def toString : String ={
    Value match {
      case unknown => return "?"
      case empty => return "_"
      case filled => return "x"
    }
  }
}

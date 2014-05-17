package cn.hjmao.rosalind.ini

object Main extends App {
  val lines = scala.io.Source.fromFile("dataset.txt").mkString.trim()
  val order = List('A', 'C', 'G', 'T')
  val valueMap = lines.toList.groupBy((char: Char) => char).mapValues(_.length)
  println(order.map(index => valueMap(index)).mkString(" "))
}

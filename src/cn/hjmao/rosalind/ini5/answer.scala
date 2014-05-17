package cn.hjmao.rosalind.ini3

object Main extends App {
  val lines = scala.io.Source.fromFile("dataset.txt").getLines().toList
  val indices = 1 until lines.size by 2
  indices.map(index => println(lines(index)))
}

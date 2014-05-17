package cn.hjmao.rosalind.ini2

object Main extends App {
  val lines = scala.io.Source.fromFile("dataset.txt").mkString
  println(lines.split("\\s+").map(num => num.toInt * num.toInt).reduce(_+_))
}

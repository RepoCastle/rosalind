package cn.hjmao.rosalind.ini4

object Main extends App {
  val lines = scala.io.Source.fromFile("dataset.txt").mkString
  val range = lines.split("\\s+").map(num => num.toInt).toArray
  println((range(0) until range(1)+1).filter(_ % 2 == 1).reduce( _ + _ ))
}

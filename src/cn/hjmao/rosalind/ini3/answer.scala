package cn.hjmao.rosalind.ini3

object Main extends App {
  val lines = scala.io.Source.fromFile("dataset.txt").getLines().toList
  val string = lines(0)
  val indices = lines(1).split("\\s+").map(num => num.toInt)
  val first = string.substring(indices(0), indices(1)+1)
  val second = string.substring(indices(2), indices(3)+1)

  println(first + " " + second)
}

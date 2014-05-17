package cn.hjmao.rosalind.ini6

object Main extends App {
  val lines = scala.io.Source.fromFile("dataset.txt").mkString
  lines.split("\\s+").groupBy((word: String) => word).mapValues(_.length).map(pair => println(pair._1 + " " + pair._2))
}

package cn.hjmao.rosalind.rna

object Main extends App {
  val lines = scala.io.Source.fromFile("dataset.txt").mkString.trim()
  println(lines.replace('T', 'U'))
}

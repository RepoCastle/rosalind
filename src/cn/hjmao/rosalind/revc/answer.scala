package cn.hjmao.rosalind.revc

object Main extends App {
  val lines = scala.io.Source.fromFile("dataset.txt").mkString.trim()
  val replaceMap: Map[Char, Char] = Map('A'->'T', 'T'->'A', 'G'->'C', 'C'->'G')
  println(lines.reverse.toList.map(replaceMap(_)).mkString)
}

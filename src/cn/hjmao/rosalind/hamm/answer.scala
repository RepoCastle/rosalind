package cn.hjmao.rosalind.hamm

object Main extends App {
  val lines = scala.io.Source.fromFile("dataset.txt").getLines().toList
  val string0 = lines(0)
  val string1 = lines(1)

  val indices = 0 until string0.length

  println(indices.filter(index => string0(index) != string1(index)).length)
}

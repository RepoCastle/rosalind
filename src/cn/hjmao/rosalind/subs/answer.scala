package cn.hjmao.rosalind.rna

object Main extends App {
  val lines = scala.io.Source.fromFile("dataset.txt").getLines().toList
  val s = lines(0).mkString
  val t = lines(1).mkString

  val tsize = t.length

  val indices = 0 until (s.length - tsize + 1)
  val result = indices.filter(index => s.substring(index, index + tsize).equals(t)).map(_+1)

  println(result.mkString(" "))
}

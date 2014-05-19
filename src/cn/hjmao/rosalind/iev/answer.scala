package cn.hjmao.rosalind.fib

object Main extends App {
  val couples = scala.io.Source.fromFile("dataset.txt").mkString.trim().split("\\s+").map(_.toInt).toList
  val probs = List(1, 1, 1, 0.75, 0.5, 0)
  val result = probs.indices.map { index =>
    probs(index) * couples(index)
  }.reduce(_ + _) * 2
  println(result)
}

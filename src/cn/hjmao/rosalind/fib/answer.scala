package cn.hjmao.rosalind.fib

object Main extends App {
  val nk = scala.io.Source.fromFile("dataset.txt").mkString.trim().split("\\s+")
  val n = nk(0).toInt
  val k = nk(1).toInt

  def fib(n: Long, k: Long): Long = {
    n match {
      case 1 => 1
      case 2 => 1
      case _ => fib(n-1, k) + k * fib(n-2, k)
    }
  }

  println(fib(n, k))
}

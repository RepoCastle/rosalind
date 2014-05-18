package cn.hjmao.rosalind.fibd

object Main extends App {
  val nk = scala.io.Source.fromFile("dataset.txt").mkString.trim().split("\\s+")
  val n = nk(0).toInt
  val m = nk(1).toInt

  def fibd(n: Int, m: Int): Long = {
    n match {
      case 0 => 1
      case 1 => 1
      case 2 => 1
      case i if i<=m => fibd(n-1, m) + fibd(n-2, m)
      case _ => fibd(n-1, m) + fibd(n-2, m) - fibd(n-m-1, m)
    }
  }

  println(fibd(n, m))
}

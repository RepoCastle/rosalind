package cn.hjmao.rosalind.fib

object Main extends App {
  val kN = scala.io.Source.fromFile("dataset.txt").mkString.trim().split("\\s+")
  val k = kN(0).toInt
  val N = kN(1).toInt


  def g(n: Int): Double = {
    n match {
      case 1 => 0.5
      case _ => 0.5 * (g(n-1) * f(n-1))
    }
  }

  def f(n: Int): Double = {
    n match {
      case 1 => 0.5
      case _ => 0.5 * g(n-1) + 0.5 * f(n-1)
    }
  }

  println(math.pow(0.684, 0.5))
  val prob = f(N)
  val result = (N until (math.pow(2,k)+1).toInt).map(i => math.pow(prob, i)*math.pow(1-prob, math.pow(2,k)-i)).reduce(_ + _)
  println(result)
}

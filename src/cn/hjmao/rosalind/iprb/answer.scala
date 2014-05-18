package cn.hjmao.rosalind.iprb

object Main extends App {
  val mkns = scala.io.Source.fromFile("dataset.txt").mkString.trim().split("\\s+").map(_.toInt)
  val sum = mkns.sum
  val k = mkns(0)
  val m = mkns(1)
  val n = mkns(2)

  val bothHomoRece = 1.0 * n/sum * (n-1)/(sum-1)
  val homoReceAndHete = 1.0 * n/sum * m/(sum-1) + 1.0 * m/sum * n/(sum-1)
  val bothHete = 1.0 * m/sum * (m-1)/(sum-1)
  val result = 1 - (bothHomoRece +  homoReceAndHete*0.5 + bothHete*0.25)


  println(result)
}

package cn.hjmao.rosalind.fibd

object Main extends App {

  def fibd(n: Int, m:Int, i: Int, table: Map[Int, BigInt]): Map[Int, BigInt] = {
    table.contains(n) match {
      case true => table
      case false => {
        val i_1th = table(i-1)
        val i_2th = table(i-2)

        val ith = i match {
          case j if j<=m => i_1th + i_2th
          case _ => i_1th + i_2th - table(i-m-1)
        }

        fibd(n, m, i+1, table.filter(_._1 > i-m-1) + ((i, ith)))
      }
    }
  }
  
  val nm = scala.io.Source.fromFile("dataset.txt").mkString.trim().split("\\s+")
  val n = nm(0).toInt
  val m = nm(1).toInt
  println(fibd(n, m, 3, Map(0->1, 1->1, 2->1))(n))
}

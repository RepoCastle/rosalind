package cn.hjmao.rosalind.fibd

object Main extends App {

  /*
  def fibd(n: Int, m: Int): Long = {
    n match {
      case 0 => 1
      case 1 => 1
      case 2 => 1
      case i if i<=m => fibd(n-1, m) + fibd(n-2, m)
      case _ => fibd(n-1, m) + fibd(n-2, m) - fibd(n-m-1, m)
    }
  }
  */

  def fibd(n: Int, m:Int, table: Map[Int, Long]): Map[Int, Long] = {
    table.contains(n) match {
      case true => table
      case false => {
        val n_1th = table(n-1)
        val n_2th = table(n-2)

        val nth = n match {
          case i if i<=m => n_1th + n_2th
          case _ => val m_prevth = table(n-m-1); n_1th + n_2th - m_prevth
        }

        fibd(n, m,table.filter(_._1 != n-m-1) + ((n, nth)))
      }
    }
  }

  
  val nm = scala.io.Source.fromFile("dataset.txt").mkString.trim().split("\\s+")
  // val n = nm(0).toInt
  // val m = nm(1).toInt
  val n = 3
  val m = 3
  println(fibd(n, m, Map(1->1, 2->1)).getOrElse(n, 0))
}

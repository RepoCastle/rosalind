package cn.hjmao.rosalind.lcsm

object Main extends App {
  val lines = scala.io.Source.fromFile("dataset.txt").getLines().toList
  val idIndices = lines.indices.filter(index => lines(index).startsWith(">"))
  val strings = idIndices.indices.map(index => index match {
      case index if (index == idIndices.size-1) => (idIndices(index)+1, lines.size)
      case _ => (idIndices(index)+1, idIndices(index+1))
    }).map(strIndex => (strIndex._1 until strIndex._2).map(lines(_)).mkString)

  val shortestStr = strings(strings.zipWithIndex.minBy(_._1.length)._2)
  val shortestStrSize = shortestStr.length

  var result: String = ""
  val patMap = (1 until shortestStrSize+1).map { patSize =>
    val thisSizePatMap = (0 until shortestStrSize-patSize+1).map { patIndex =>
      val pat = shortestStr.substring(patIndex, patIndex + patSize)
      val cnt = strings.map(string => if (string.contains(pat)) 1 else 0).reduce(_ + _)
      if (cnt == strings.length) pat
      else null
    }.filter(_ != null)
    if(thisSizePatMap.length == 0) {
      println(result)
      System.exit(0)
    }
    result = thisSizePatMap.head
  }
}

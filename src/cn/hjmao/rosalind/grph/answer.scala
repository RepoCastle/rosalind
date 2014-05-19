package cn.hjmao.rosalind.grph

object Main extends App {
  val lines = scala.io.Source.fromFile("dataset.txt").getLines().toList
  val idIndices = lines.indices.filter(index => lines(index).startsWith(">"))
  val strings = idIndices.indices.map(index => index match {
      case index if (index == idIndices.size-1) => (idIndices(index)+1, lines.size)
      case _ => (idIndices(index)+1, idIndices(index+1))
    }).map(strIndex => (strIndex._1 until strIndex._2).map(lines(_)).mkString)

  val nodeMap = strings.indices.map{ i =>
    strings.indices.filter( _ != i ).map { j =>
      if (strings(i).takeRight(3) equals strings(j).take(3)) (i, j)
      else null
    }.filter(_ != null)
  }.filter(_ != Nil).flatMap(x => x)

  nodeMap.map { edge =>
    val start = edge._1
    val end = edge._2
    println(lines(idIndices(start)).substring(1) + " " + lines(idIndices(end)).substring(1))
  }
}

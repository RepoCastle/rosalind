package cn.hjmao.rosalind.gc

object Main extends App {
  val lines = scala.io.Source.fromFile("dataset.txt").getLines().toList
  val idIndices = lines.indices.filter(index => lines(index).startsWith(">"))
  val stringIndices = idIndices.indices.map(index => index match {
      case index if (index == idIndices.size-1) => (idIndices(index)+1, lines.size)
      case _ => (idIndices(index)+1, idIndices(index+1))
    })

  def gc(start: Int, end: Int): Double = {
    val string = (start until end).map(lines(_)).mkString
    val length = string.length
    val gcCnt = string.toList.filter(nt => nt == 'G' || nt == 'C').size
    1.0 * gcCnt / length
  }

  val gcs = stringIndices.map(index => gc(index._1, index._2))
  val maxOfIndex = gcs.zipWithIndex.maxBy(_._1)._2
  println(lines(idIndices(maxOfIndex)).substring(1))
  println(gcs(maxOfIndex) * 100)
}

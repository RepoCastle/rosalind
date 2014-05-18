package cn.hjmao.rosalind.rna

object Main extends App {
  val lines = scala.io.Source.fromFile("dataset.txt").getLines().toList
  val idIndices = lines.indices.filter(index => lines(index).startsWith(">"))
  val stringIndices = idIndices.indices.map(index => index match {
      case index if (index == idIndices.size-1) => (idIndices(index)+1, lines.size)
      case _ => (idIndices(index)+1, idIndices(index+1))
    })
  val strings = stringIndices.map{index =>
    (index._1 until index._2).map(lines(_)).mkString
  }
  val n = strings(0).size

  def calc(col: List[Char]): Map[Char, Int] = {
    col.groupBy((char: Char) => char).mapValues(_.length)
  }

  val profileMap = (0 until n).map { index =>
    calc(strings.map(string => string.toList(index)).toList)
  }
  println(profileMap.map(profile => profile.maxBy(_._2)._1).mkString)
  val bases = List('A', 'C', 'G', 'T')
  bases.map{ base =>
    val baseProfile = profileMap.map { profile=>
      profile.getOrElse(base, 0)
    }.mkString(" ")
    println(base + ": " + baseProfile)
  }
}

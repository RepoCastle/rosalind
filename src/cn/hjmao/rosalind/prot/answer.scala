package cn.hjmao.rosalind.prot

object Main extends App {
  val lines = scala.io.Source.fromFile("dataset.txt").mkString.trim()

  val condonTable = Map(
    "UUU" -> 'F',      "CUU" -> 'L',      "AUU" -> 'I',      "GUU" -> 'V',
    "UUC" -> 'F',      "CUC" -> 'L',      "AUC" -> 'I',      "GUC" -> 'V',
    "UUA" -> 'L',      "CUA" -> 'L',      "AUA" -> 'I',      "GUA" -> 'V',
    "UUG" -> 'L',      "CUG" -> 'L',      "AUG" -> 'M',      "GUG" -> 'V',
    "UCU" -> 'S',      "CCU" -> 'P',      "ACU" -> 'T',      "GCU" -> 'A',
    "UCC" -> 'S',      "CCC" -> 'P',      "ACC" -> 'T',      "GCC" -> 'A',
    "UCA" -> 'S',      "CCA" -> 'P',      "ACA" -> 'T',      "GCA" -> 'A',
    "UCG" -> 'S',      "CCG" -> 'P',      "ACG" -> 'T',      "GCG" -> 'A',
    "UAU" -> 'Y',      "CAU" -> 'H',      "AAU" -> 'N',      "GAU" -> 'D',
    "UAC" -> 'Y',      "CAC" -> 'H',      "AAC" -> 'N',      "GAC" -> 'D',
    "UAA" -> '_',      "CAA" -> 'Q',      "AAA" -> 'K',      "GAA" -> 'E',
    "UAG" -> '_',      "CAG" -> 'Q',      "AAG" -> 'K',      "GAG" -> 'E',
    "UGU" -> 'C',      "CGU" -> 'R',      "AGU" -> 'S',      "GGU" -> 'G',
    "UGC" -> 'C',      "CGC" -> 'R',      "AGC" -> 'S',      "GGC" -> 'G',
    "UGA" -> '_',      "CGA" -> 'R',      "AGA" -> 'R',      "GGA" -> 'G',
    "UGG" -> 'W',      "CGG" -> 'R',      "AGG" -> 'R',      "GGG" -> 'G'
  )

  val mRNA = lines
  val protPre = mRNA.grouped(3).map(condonTable(_)).mkString
  val end = protPre.indexOf('_')
  val result = protPre.substring(0, end)

  println(result)
}

package io.github.mitchelllisle

import scala.io.Source
import scala.util.matching.Regex


object DayOnePartTwo {
  /* Day One - Part Two
  * It looks like some of the digits are actually spelled out with letters: one,
  * two, three, four, five, six, seven, eight, and nine also count as valid "digits".
  * Equipped with this new information, you now need to find the real first and last digit on each line
  * */
  private val words = Seq("one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
  private val digitsExpr = new Regex(s"(?=(${words.mkString("|")}|[0-9]))")
  private val wordToDigit = words.zip(1 to 9).toMap

  private def readFile(path: String): Iterator[String] = {
    val source = Source.fromFile(path)
    source.getLines()
  }

  private def getMatches(line: String): Int = {
    val matches = digitsExpr.findAllMatchIn(line).map(_.group(1)).toList

    val first = matches.head
    val last = matches.lastOption.getOrElse(first)

    f"${wordToDigit.getOrElse(first, first)}${wordToDigit.getOrElse(last, last)}".toInt
  }

  def fromFile(path: String): Int = {
    val lines = readFile(path)
    apply(lines)
  }

  def apply(lines: Iterator[String]): Int = {
    val calculated = lines.map(getMatches)
    calculated.sum
  }
}

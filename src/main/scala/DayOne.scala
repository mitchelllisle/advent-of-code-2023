package io.github.mitchelllisle

import scala.util.matching.Regex


object DayOnePartOne extends Solver {
  /* Day One - Part One
  * The newly-improved calibration document consists of lines of text; each line originally contained a specific
  * calibration value that the Elves now need to recover. On each line, the calibration value can be found by combining
  * the first digit and the last digit (in that order) to form a single two-digit number.
  * */
  private val nonNumericChars = new Regex("[^0-9.-]+")

  private def getNumericChars(line: String): String = {
    nonNumericChars.replaceAllIn(line, "")
  }

  private def extractNumericValues(line: String): Int = {
    val numericOnly = getNumericChars(line)

    if (numericOnly.length > 1) {
      val splitChars = numericOnly.toList
      val firstAndLast = f"${splitChars.head}${splitChars.last}"
      return firstAndLast.toInt
    }
    (numericOnly * 2).toInt
  }

  override def apply(lines: Iterator[String]): Int = {
    lines
      .map(extractNumericValues)
      .toList
      .sum
  }
}

object DayOnePartTwo extends Solver {
  /* Day One - Part Two
  * It looks like some of the digits are actually spelled out with letters: one,
  * two, three, four, five, six, seven, eight, and nine also count as valid "digits".
  * Equipped with this new information, you now need to find the real first and last digit on each line
  * */
  private val words = Seq("one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
  private val digitsExpr = new Regex(s"(?=(${words.mkString("|")}|[0-9]))")
  private val wordToDigit = words.zip(1 to 9).toMap

  private def getMatches(line: String): Int = {
    val matches = digitsExpr.findAllMatchIn(line).map(_.group(1)).toList

    val first = matches.head
    val last = matches.lastOption.getOrElse(first)

    f"${wordToDigit.getOrElse(first, first)}${wordToDigit.getOrElse(last, last)}".toInt
  }

  override def apply(lines: Iterator[String]): Int = {
    val calculated = lines.map(getMatches)
    calculated.sum
  }
}

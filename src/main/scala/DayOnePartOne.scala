package io.github.mitchelllisle

import scala.io.Source
import scala.util.matching.Regex


object DayOnePartOne {
  /* Day One - Part One
  * The newly-improved calibration document consists of lines of text; each line originally contained a specific
  * calibration value that the Elves now need to recover. On each line, the calibration value can be found by combining
  * the first digit and the last digit (in that order) to form a single two-digit number.
  * */
  private val nonNumericChars = new Regex("[^0-9.-]+")

  private def readFile(path: String): Iterator[String] = {
    val source = Source.fromFile(path)
    source.getLines()
  }

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

  def fromFile(path: String): Int = {
    val lines = readFile(path)
    apply(lines)
  }

  def apply(lines: Iterator[String]): Int = {
    lines
      .map(extractNumericValues)
      .toList
      .sum
  }
}

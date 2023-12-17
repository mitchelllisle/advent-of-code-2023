package io.github.mitchelllisle

import scala.io.Source;
import scala.util.matching.Regex

object DayOne {

  private def readFile(path: String): Iterator[String] = {
    val source = Source.fromFile(path)
    source.getLines()
  }

  private def getNumericChars(line: String): String = {
    val nonNumericChars = new Regex("[^0-9.-]+")
    nonNumericChars.replaceAllIn(line, "")
  }

  private def getNumericAndWordChars(line: String): String = {
    val nonNumericChars = new Regex("[^0-9.-]+")
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

  def partOne(path: String): Int = {
    val lines = readFile(path)
    lines
      .map(extractNumericValues)
      .toList
      .sum
  }

  def partTwo(path: String) : Int = {
    val lines = readFile(path)
    10
  }
}

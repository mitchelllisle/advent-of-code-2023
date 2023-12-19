package io.github.mitchelllisle

import org.scalatest.flatspec.AnyFlatSpec


class DayOnePartOneTest extends AnyFlatSpec {
  "giving valid input" should "return the correct result" in {
    val lines = Seq(
      "two1nine",
      "4eightwothree",
      "abcone2threexyz",
      "xtwone3four",
      "4nineeightseven2",
      "zoneight234",
      "7pqrstsixteen",
      "sevenine8"
    )
    assert(DayOnePartOne(lines.iterator) == 341)
  }
}

class DayOnePartTwoTest extends AnyFlatSpec {
  "giving valid input" should "return the correct result" in {
    val lines = Seq(
      "two1nine",
      "eightwothree",
      "abcone2threexyz",
      "xtwone3four",
      "4nineeightseven2",
      "zoneight234",
      "7pqrstsixteen",
      "sevenine"
    )
    assert(DayOnePartTwo(lines.iterator) == 360)
  }
}

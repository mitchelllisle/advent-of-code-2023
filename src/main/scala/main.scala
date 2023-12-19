package io.github.mitchelllisle

@main
def main(): Unit = {
  // Day One
  val dayOnePartOne = DayOnePartOne.fromFile("src/main/resources/day1.txt")
  println(s"What is the sum of all of the calibration values? $dayOnePartOne")
  
  val dayOnePartTwo = DayOnePartTwo.fromFile("src/main/resources/day1.txt")
  println(s"What is the sum of all of the calibration values? $dayOnePartTwo")

  // Day Two
  val dayTwoPartOne = DayTwoPartOne.fromFile("src/main/resources/day2.txt")
  println(s"What is the sum of the IDs of those games? $dayTwoPartOne")

  val dayTwoPartTwo = DayTwoPartTwo.fromFile("src/main/resources/day2.txt")
  println(s"What is the sum of the power of these sets? $dayTwoPartTwo")
}

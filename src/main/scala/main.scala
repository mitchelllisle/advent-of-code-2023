package io.github.mitchelllisle

@main
def main(): Unit = {
  // Day One
  val dayOnePartOne = DayOnePartOne.fromFile("src/main/resources/day1.txt")
  println(f"What is the sum of all of the calibration values? $dayOnePartOne")
  
  val dayOnePartTwo = DayOnePartTwo.fromFile("src/main/resources/day1.txt")
  println(s"What is the sum of all of the calibration values? $dayOnePartTwo")
}

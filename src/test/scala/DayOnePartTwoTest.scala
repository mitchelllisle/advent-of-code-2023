import io.github.mitchelllisle.DayOnePartTwo
import org.scalatest.flatspec.AnyFlatSpec


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
    )
    assert(DayOnePartTwo(lines.iterator) == 281)
  }
}

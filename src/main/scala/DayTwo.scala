package io.github.mitchelllisle

case class Round(blue: Int, red: Int, green: Int)
case class Game(id: Int, rounds: List[Round])

private def getGameId(s: String): Int = {
  "\\d+".r.findFirstIn(s).get.toInt
}

private def getColourResults(s: String, colour: String): Int = {
  val colourExpr = s"(\\d+) $colour".r
  val counts = s.split(",")
  val matches = colourExpr.findAllMatchIn(s)

  val found = matches.toList.map(_.group(1).toInt)
  if (found.nonEmpty) {
    return found.head
  }
  0
}

private def getGameResults(s: String): Round = {
  Round(
    red = getColourResults(s, "red"),
    green = getColourResults(s, "green"),
    blue = getColourResults(s, "blue")
  )
}

private def parseGame(row: String): Game = {
  val elements = row.split("[:;]")
  val gameId = getGameId(elements(0))
  val rounds = elements.slice(1, elements.length).map(getGameResults).toList
  Game(id = gameId, rounds = rounds)
}

object DayTwoPartOne extends Solver {
  /* Day Two - Part One
  The Elf would first like to know which games would have been possible if the bag contained only 12 red cubes, 13 green
  * cubes, and 14 blue cubes?
  * */
  private val totalRed = 12
  private val totalGreen = 13
  private val totalBlue = 14

  private def evaluateRound(round: Round): Boolean = {
    if (round.blue <= totalBlue && round.green <= totalGreen && round.red <= totalRed) {
      return true
    }
    false
  }

  private def getGameColourCounts(game: Game): Int = {
    val possibleGames = game.rounds.map(evaluateRound)
    if (possibleGames.contains(false)) {
      return 0
    }
    game.id
  }

  override def apply(lines: Iterator[String]): Int = {
    val games = lines.map(parseGame).map(getGameColourCounts)
    games.sum
  }
}

object DayTwoPartTwo extends Solver {
  /* Day Two - Part Two
  * The power of a set of cubes is equal to the numbers of red, green, and blue cubes multiplied together. The power of
  * the minimum set of cubes in game 1 is 48. In games 2-5 it was 12, 1560, 630, and 36, respectively. Adding up these
  * five powers produces the sum 2286. For each game, find the minimum set of cubes that must have been present. What is
  * the sum of the power of these sets?
  * */

  private def evaluateGame(game: Game): Int = {
    val largestBlue = game.rounds.map(_.blue).max
    val largestRed = game.rounds.map(_.red).max
    val largestGreen = game.rounds.map(_.green).max
    largestBlue * largestRed * largestGreen
  }

  override def apply(lines: Iterator[String]): Int = {
    val games = lines.map(parseGame).map(evaluateGame).toList
    games.sum
  }
}

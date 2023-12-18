package io.github.mitchelllisle

case class Round(blue: Int, red: Int, green: Int)
case class Game(id: Int, rounds: List[Round])

object DayTwoPartOne extends Solver {
  private val idExpr = "\\d+".r
  private val totalRed = 12
  private val totalGreen = 13
  private val totalBlue = 14

  private def getGameId(s: String): Int = {
    idExpr.findFirstIn(s).get.toInt
  }

  private def getColourResults(s: String, colour: String): Int = {
    val colourExpr = s"(\\d) $colour".r
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

  private def getGameColourCounts(game: Game): Int = {
    val blueThreshold = game.rounds.map(_.blue).sum < totalBlue
    val redThreshold = game.rounds.map(_.red).sum < totalRed
    val greenThreshold = game.rounds.map(_.green).sum < totalGreen
    if (blueThreshold && greenThreshold && redThreshold) {
      return game.id
    }
    0
  }

  override def apply(lines: Iterator[String]): Int = {
    val games = lines.map(parseGame).map(getGameColourCounts).toList
    games.sum
  }
}

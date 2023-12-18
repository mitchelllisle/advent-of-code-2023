package io.github.mitchelllisle

import scala.io.Source

trait Solver {
  private def readFile(path: String): Iterator[String] = {
    val source = Source.fromFile(path)
    source.getLines()
  }

  def fromFile(path: String): Int = {
    val lines = readFile(path)
    apply(lines)
  }
  
  def apply(lines: Iterator[String]): Int
}

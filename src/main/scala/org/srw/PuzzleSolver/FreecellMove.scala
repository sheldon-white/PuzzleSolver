package org.srw.PuzzleSolver

case class FreecellMove(card: Card, source: CardDestination, destination: CardDestination) {
  override def toString: String = "(" + source.prefix + ": " + card + " -> " + destination.prefix + ")"

}

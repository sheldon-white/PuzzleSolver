package org.srw.PuzzleSolver

import scala.collection.immutable._

class Foundation(maxCardRank: Int) extends CardDestination {
  val cardsPlayed: Map[Suit, Int] = Map()

  def isComplete: Boolean = !cardsPlayed.values.exists(_ < maxCardRank)

  override def canPlaceCard(card: Card): Boolean = cardsPlayed(card.suit) == card.rank - 1
}

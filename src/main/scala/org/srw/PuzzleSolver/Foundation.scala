package org.srw.PuzzleSolver

import scala.collection.immutable.{Map, _}

class Foundation(cards: Map[Suit, Int], maxCardRank: Int) extends CardDestination {

  def isComplete: Boolean = !cards.values.exists(_ < maxCardRank)

  override def canPlaceCard(card: Card): Boolean = cards(card.suit) == card.rank - 1

  override def availableCards: Set[Card] = Set()

  override def applyMove(move: FreecellMove): Foundation = {
    new Foundation(cards + (move.card.suit -> move.card.rank), maxCardRank)
  }
}

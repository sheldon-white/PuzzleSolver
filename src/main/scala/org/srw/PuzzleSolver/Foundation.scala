package org.srw.PuzzleSolver

import scala.collection.immutable.{Map, _}

class Foundation(cards: Map[Suit, Card], deck: Deck) extends CardDestination {

  def isComplete: Boolean = !cards.values.exists(_.rank < deck.maxRank)

  override def canPlaceCard(card: Card): Boolean = cards(card.suit).rank == card.rank - 1

  override def availableCards: Set[Card] = Set()

  override def prefix: String = "FN"

  override def applyMove(move: FreecellMove): Foundation =
    new Foundation(cards + (move.card.suit -> move.card), deck)


  override def toString: String = String.join(cards.values.toString, " ") + (".. " * (deck.suits.size - cards.size))
}

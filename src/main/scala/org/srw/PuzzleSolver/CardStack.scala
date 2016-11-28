package org.srw.PuzzleSolver

import scala.collection.immutable.List
import scala.collection.immutable.Set

class CardStack(val cards: List[Card]) extends CardDestination {
  def this() = this(List[Card]())

  override def availableCards: Set[Card] = Set(cards.head)

  override def canPlaceCard(card: Card): Boolean =
    cards.size match {
      case 0 => true
      case _ => cards.head.rank == card.rank + 1 && cards.head.isOppositeColor(card)
    }

  override def applyMove(move: FreecellMove): CardStack = {
    move.source match {
      case c if c == this => new CardStack(cards.drop(1))
      case _ => new CardStack(move.card :: cards)
    }
  }
}
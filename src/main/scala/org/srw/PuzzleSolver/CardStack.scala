package org.srw.PuzzleSolver

import scala.collection.immutable.List

class CardStack(cards: List[Card]) extends CardDestination {
  def this() = this(List[Card]())

  override def canPlaceCard(card: Card): Boolean =
    cards.size match {
      case 0 => true
      case _ => cards.head.rank == card.rank + 1 && cards.head.isOppositeColor(card)
    }
}
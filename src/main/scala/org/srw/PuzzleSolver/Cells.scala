package org.srw.PuzzleSolver

import scala.collection.immutable.List

class Cells(cards: List[Card]) extends CardDestination {

  override def canPlaceCard(card: Card): Boolean = cards.size < FreecellPuzzleState.cellSize

  override def availableCards: Set[Card] = cards.toSet

  override def prefix: String = "CL"

  override def applyMove(move: FreecellMove): Cells =
    move.source match {
      case c if c == this => new Cells(cards.filterNot(_ == move.card))
      case _ => new Cells(move.card :: cards)
        // FIXME should test size, throw exception if no room
    }

  override def toString: String = cards.mkString(" ") + (" .." * (FreecellPuzzleState.cellSize - cards.size))
}

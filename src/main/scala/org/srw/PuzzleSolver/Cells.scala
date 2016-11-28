package org.srw.PuzzleSolver

class Cells(cards: Set[Card]) extends CardDestination {

  override def canPlaceCard(card: Card): Boolean = cards.size < FreecellPuzzleState.cellSize

  override def availableCards: Set[Card] = cards

  override def applyMove(move: FreecellMove): Cells = {
    move.source match {
      case c if c == this => new Cells(cards - move.card)
      case _ => new Cells(cards + move.card)
    }
  }
}

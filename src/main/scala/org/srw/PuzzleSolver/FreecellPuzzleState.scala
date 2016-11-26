package org.srw.PuzzleSolver

import scala.collection.immutable._

object FreecellPuzzleState {
  val cellSize = 2
  val tableauSize = 3
}

class FreecellPuzzleState(foundation: Foundation, tableau: Seq[CardStack], cells: Cells) extends PuzzleState {
  def this(deck: Deck) = this(new Foundation(deck.maxCardRank), Seq[CardStack](), new Cells(FreecellPuzzleState.cellSize))

  override def isSolution: Boolean = foundation.isComplete

  override def legalMoves: Iterable[Move] = {
  //  foundation.legalMoves ++ tableau.legalMoves ++ cells.legalMoves
    null
  }

  override def apply(move: Move): PuzzleState = {
    null
  }
}

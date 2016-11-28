package org.srw.PuzzleSolver

import scala.collection.immutable._

object FreecellPuzzleState {
  val cellSize = 2
  val tableauSize = 3
}

class FreecellPuzzleState(foundation: Foundation, tableau: Seq[CardStack], cells: Cells) {
  def this(deck: Deck) = this(new Foundation(Map[Suit, Int](), deck.maxCardRank), Seq[CardStack](), new Cells(Set[Card]()))

  def isSolution: Boolean = foundation.isComplete

  def legalMoves: Iterable[FreecellMove] = {
    val allSources = tableau :+ cells
    val allDestinations = tableau :+ cells :+ foundation
    val legalMoves = for (source <- allSources;
                          card <- source.availableCards;
                          destination <- allDestinations if source != destination && destination.canPlaceCard(card))
      yield FreecellMove(card, source, destination)
    legalMoves
  }

  def apply(move: FreecellMove): FreecellPuzzleState = {
    move match {
      case FreecellMove(card, src: Cells, dst: CardStack) =>
        val newTableau = tableau.filterNot(_ == dst) :+ dst.applyMove(move)
        new FreecellPuzzleState(foundation, newTableau, src.applyMove(move))

      case FreecellMove(card, src: Cells, dst: Foundation) =>
        new FreecellPuzzleState(dst.applyMove(move), tableau, src.applyMove(move))

      case FreecellMove(card, src: CardStack, dst: Cells) =>
        val newTableau = tableau.filterNot(_ == dst) :+ src.applyMove(move)
        new FreecellPuzzleState(foundation, newTableau, dst.applyMove(move))

      case FreecellMove(card, src: CardStack, dst: Foundation) =>
        val newTableau = tableau.filterNot(_ == dst) :+ src.applyMove(move)
        new FreecellPuzzleState(dst.applyMove(move), newTableau, cells)

      case FreecellMove(card, src: CardStack, dst: CardStack) =>
        val newTableau = tableau.filter(cs => cs == dst || cs == src) :+ src.applyMove(move) :+ dst.applyMove(move)
        new FreecellPuzzleState(foundation, newTableau, cells)
    }
  }
}

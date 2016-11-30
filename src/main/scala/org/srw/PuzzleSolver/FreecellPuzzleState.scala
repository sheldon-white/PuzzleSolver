package org.srw.PuzzleSolver

import scala.collection.immutable._

object FreecellPuzzleState {
  val cellSize = 2
  val tableauSize = 3
}

class FreecellPuzzleState(foundation: Foundation, tableau: Seq[CardStack], cells: Cells) {
  def this(deck: Deck) = this(new Foundation(Map[Suit, Card](), deck), Seq[CardStack](), new Cells(Set[Card]()))

  override def toString: String = foundation + "    " + cells + "\n\n" + tableau.mkString(" ")

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
      case FreecellMove(card, src: Cells, dst: Foundation) =>
        new FreecellPuzzleState(dst.applyMove(move), tableau, src.applyMove(move))

      case FreecellMove(card, src: Cells, dst: CardStack) =>
        val newTableau = tableau.map {
          case `dst` => dst.applyMove(move);
          case x => x
        }
        new FreecellPuzzleState(foundation, newTableau, src.applyMove(move))

      case FreecellMove(card, src: CardStack, dst: Cells) =>
        val newTableau = tableau.map {
          case `src` => src.applyMove(move);
          case x => x
        }
        new FreecellPuzzleState(foundation, newTableau, dst.applyMove(move))

      case FreecellMove(card, src: CardStack, dst: Foundation) =>
        val newTableau = tableau.map {
          case `src` => src.applyMove(move);
          case x => x
        }
        new FreecellPuzzleState(dst.applyMove(move), newTableau, cells)

      case FreecellMove(card, src: CardStack, dst: CardStack) =>
        val newTableau = tableau.map {
          case `src` => src.applyMove(move);
          case `dst` => dst.applyMove(move);
          case x => x
        }
        new FreecellPuzzleState(foundation, newTableau, cells)

      case _ => null
    }
  }
}

package org.srw.PuzzleSolver

trait CardDestination {
  /**
    * What cards can be moved from here?
    * @return Ths set of moveable cards.
    */
  def availableCards: Set[Card]

  /**
    *
    * @param card
    * @return
    */
  def canPlaceCard(card: Card): Boolean

  /**
    *
    * @param move
    * @return
    */
  def applyMove(move: FreecellMove): CardDestination
}

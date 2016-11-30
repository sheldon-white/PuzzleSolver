package org.srw.PuzzleSolver

trait CardDestination {
  /**
    * What cards can be moved from here?
    * @return Ths set of moveable cards.
    */
  def availableCards: Set[Card]

  /**
    * Can the card be placed here?
    * @param card The card.
    * @return true if it can, false otherwise
    */
  def canPlaceCard(card: Card): Boolean

  /**
    * Create the new destination resulting from the supplied move.
    * @param move The move.
    * @return The new resulting CardDestination.
    */
  def applyMove(move: FreecellMove): CardDestination

  /**
    * @return The name of the thing.
    */
  def prefix: String
}

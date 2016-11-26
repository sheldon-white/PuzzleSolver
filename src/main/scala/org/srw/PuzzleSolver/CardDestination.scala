package org.srw.PuzzleSolver

/**
  * Created by swhite on 11/25/16.
  */
trait CardDestination {

  def canPlaceCard(card: Card): Boolean
}

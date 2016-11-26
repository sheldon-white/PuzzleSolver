package org.srw.PuzzleSolver

import scala.collection.immutable.List

class Cells(size: Int) extends CardDestination {

  override def canPlaceCard(card: Card): Boolean = cards.size < size

  private val cards = List[Card]()
}

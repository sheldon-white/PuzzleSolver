package org.srw.PuzzleSolver

class Card(val suit: Suit, val rank: Int) {
  def isOppositeColor(card: Card): Boolean = this.suit.isBlack != card.suit.isBlack
  override def toString: String = suit.name + rank
}

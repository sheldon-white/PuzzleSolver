package org.srw.PuzzleSolver

class Deck(val suits: Set[Suit], val maxRank: Int) {
  def cards: Iterable[Card] =
    for (suit <- suits; rank <- 1 to maxRank)
      yield new Card(suit, rank)
}

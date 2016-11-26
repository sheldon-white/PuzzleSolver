package org.srw.PuzzleSolver

class Deck(suits: Set[Suit], maxRank: Int) {
  def cards: Iterable[Card] =
    for (suit <- suits; rank <- 1 to maxRank)
      yield new Card(suit, rank)

  def maxCardRank: Int = this.maxRank
}

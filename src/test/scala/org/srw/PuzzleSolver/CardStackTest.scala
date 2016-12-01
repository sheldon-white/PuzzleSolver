package org.srw.PuzzleSolver

import org.scalatest.{FunSpec, Matchers}

class CardStackTest extends FunSpec with Matchers {
  private val hearts = new Suit("H", false)
  private val diamonds = new Suit("D", false)
  private val clubs = new Suit("C", true)
  private val h2 = new Card(hearts, 2)
  private val c3 = new Card(clubs, 3)
  private val d7 = new Card(diamonds, 7)

  describe("A CardStack") {

    it("converts to a string correctly") {
      val cardStack = new CardStack(List(h2, c3, d7))
      cardStack.toString shouldBe "H2 C3 D7"
    }

    it("can accept a card when empty") {
      val cardStack = new CardStack()
      assert(cardStack.canPlaceCard(d7))
    }

    it("can accept the correct card") {
      val cardStack = new CardStack(List(c3))
      assert(cardStack.canPlaceCard(h2))
    }

    it("will reject the wrong card") {
      val cardStack = new CardStack(List(c3))
      assert(!cardStack.canPlaceCard(d7))
    }

    it("has at most one available card") {
      val cardStack = new CardStack(List(c3, d7, h2))
      assert(cardStack.availableCards.size == 1)
    }

    it("adds a card when a move is applied and it's the destination") {
      val cells = new Cells(List(c3, h2))
      val cardStack = new CardStack(List(d7))
      val move = FreecellMove(h2, cells, cardStack)
      val newCardStack = cardStack.applyMove(move)
      newCardStack.toString shouldBe "H2 D7"
    }

    it("removes a card when a move is applied and it's the source") {
      val cells = new Cells(List(c3))
      val cardStack = new CardStack(List(h2, d7))
      val move = FreecellMove(h2, cardStack, cells)
      val newCardStack = cardStack.applyMove(move)
      newCardStack.toString shouldBe "D7"
    }
  }
}

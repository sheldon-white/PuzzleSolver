package org.srw.PuzzleSolver

import org.scalatest.{FunSpec, Matchers}

class CardStackTest extends FunSpec with Matchers {

  private val cells = new Cells(Set())
  private val hearts = new Suit("H", false)
  private val diamonds = new Suit("D", false)
  private val clubs = new Suit("C", true)
  private val spades = new Suit("S", true)
  private val h2 = new Card(hearts, 2)
  private val c3 = new Card(clubs, 3)
  private val d7 = new Card(diamonds, 7)
  private val cardStack = new CardStack(List(h2, c3, d7))

  describe("A CardStack") {

    it("converts to a string correctly") {
      cardStack.toString shouldBe "H2 C3 D7"
    }
  }
}

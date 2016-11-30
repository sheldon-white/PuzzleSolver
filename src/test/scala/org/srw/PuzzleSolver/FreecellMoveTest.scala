package org.srw.PuzzleSolver

import org.scalatest.{FunSpec, Matchers}

class FreecellMoveTest extends FunSpec with Matchers {

  private val cardStack = new CardStack
  private val cells = new Cells(Set())
  private val card = new Card(new Suit("H", false), 2)

  describe("A FreecellMove") {

    it("converts to a string correctly") {
      val move = new FreecellMove(card, cardStack, cells)
      move.toString shouldBe "(CS: H2 -> CL)"
    }
  }
}

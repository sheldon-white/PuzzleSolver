package org.srw.PuzzleSolver

import org.scalatest.{FunSpec, Matchers}

class CellsTest extends FunSpec with Matchers {

  private val cells = new Cells(List())
  private val hearts = new Suit("H", false)
  private val diamonds = new Suit("D", false)
  private val clubs = new Suit("C", true)
  private val h1 = new Card(hearts, 1)
  private val h2 = new Card(hearts, 2)
  private val c3 = new Card(clubs, 3)
  private val d7 = new Card(diamonds, 7)
  private val d8 = new Card(diamonds, 8)

  describe("A Cells object") {

    it("converts to a string correctly") {
      val cells = new Cells(List(h2, c3))
      cells.toString shouldBe "H2 C3 .."
    }

    it("can accept a card when not full") {
      val cells = new Cells(List(c3))
      assert(cells.canPlaceCard(h2))
    }

    it("will reject the card when full") {
      val cells = new Cells(List(c3, d7, h2))
      assert(!cells.canPlaceCard(d8))
    }

    it("has all cards available") {
      val cells = new Cells(List(c3, d7, h2))
      assert(cells.availableCards.size == 3)
    }

    it("adds a card when a move is applied and it's the destination") {
      val cells = new Cells(List(c3))
      val cardStack = new CardStack(List(h2, d7))
      val move = FreecellMove(h2, cardStack, cells)
      val newCells = cells.applyMove(move)
      newCells.toString shouldBe "H2 C3 .."
    }

    it("removes a card when a move is applied and it's the source") {
      val cells = new Cells(List(c3, h2))
      val cardStack = new CardStack(List(d7))
      val move = FreecellMove(h2, cells, cardStack)
      val newCells = cells.applyMove(move)
      newCells.toString shouldBe "C3 .. .."
    }
  }
}

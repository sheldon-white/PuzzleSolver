package org.srw.PuzzleSolver

import org.scalatest.{FunSpec, Matchers}

class DeckTest extends FunSpec with Matchers {

  private val hearts = new Suit("hearts", false)
  private val clubs = new Suit("clubs", true)
  private val suits = Set[Suit](hearts, clubs)

  describe("A Deck") {

    it("creates a deck of the right size") {
      val deck = new Deck(suits, 4)
      deck.cards.size shouldBe 8
    }
  }
}
//    it("gives out the correct value when an asynchronous block is submitted and is completed through a Promise") {
//      val promiseInternals = new PromiseInternals
//      val longCalculationFuture = promiseInternals.someExternalDelayedCalculation{()=>
//        Thread.sleep(2000)
//        100
//      }
//      println (s"We have submitted a block to be executed asynchronously ${longCalculationFuture.isCompleted}") //false at this point
//      assertTypeAndValue(longCalculationFuture, "class scala.concurrent.impl.Promise$DefaultPromise", 100)
//      assertValue(longCalculationFuture, 100)
//    }
//
//    it("gives out the correct value when a Promise is created with a value") {
//      val promiseInternals = new PromiseInternals
//      val immediateCalculatedFuture = promiseInternals.valueSetOnCreation(100)
//      assertTypeAndValue(immediateCalculatedFuture, "class scala.concurrent.impl.Promise$KeptPromise", 100)
//      assertValue(immediateCalculatedFuture, 100)
//    }
//
//    it("should throw an error if a Promise is attempted to be completed more than once") {
//      val promiseInternals = new PromiseInternals
//      intercept[IllegalStateException] {
//        promiseInternals.alreadyCompletedPromise()
//      }
//    }
//
//  }
//
//  def assertTypeAndValue(future: Future[Int], expectedClass: String, expectedValue: Int): Unit = {
//    val resultVal=Await.result(future, 3000 seconds)
//    resultVal shouldBe expectedValue
//    future.getClass.toString shouldBe expectedClass
//  }
//
//
//  def assertValue(future: Future[Int], expectedValue: Int): Unit = {
//    val resultVal=Await.result(future, 3000 seconds)
//    resultVal shouldBe expectedValue
//  }
//
//  def assertValueUsingOnComplete(future: Future[Int], expectedValue: Int): Unit = {
//    future.onComplete {
//      case Success(result) => {
//        println (s"Result is $result and expectedValue is $expectedValue")
//        result shouldBe expectedValue
//      }
//      case Failure (msg) => fail(msg)
//    }
//  }
//}




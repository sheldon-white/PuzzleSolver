package org.srw.PuzzleSolver

trait PuzzleState {
  def apply(move: Move): PuzzleState

  def legalMoves: Iterable[Move]

  def isSolution: Boolean

  val failedStates: Set[String] = Set[String]()
}

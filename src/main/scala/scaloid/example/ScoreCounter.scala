package scaloid.example

import scaloid.example.AnswerType.AnswerType

/**
  * Created by Wojciech on 15.06.2017.
  */
class ScoreCounter() {
  var correctScore = 0
  var partiallyScore = 0
  var incorrectScore = 0
  val allScore = 0
  def updateScore(answer: AnswerType) = {
    match answer {
      case Correct => correctScore++
      case Partially => partiallyScore++
      case Wrong => incorrectScore++
    }
    allScore++

  }

}

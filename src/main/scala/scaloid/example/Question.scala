package scaloid.example

/**
  * Created by Wojciech on 15.06.2017.
  */


class Question(val rawQuestion: String) {
  val title = rawQuestion.split("\n").head
  val goodAnswers = generateGoodAnswers(rawQuestion)
  val badAnswers = generateBadAnswers(rawQuestion)
  val correctnessMap = goodAnswers.map(x => x._1 -> 1).toMap ++ badAnswers.map(y => y._1 -> 0).toMap

  override def toString: String = {
    correctnessMap mkString "\n"
  }

  def generateGoodAnswers(rawQuestion: String): Array[(String, String)] = {
    val allAnswers = rawQuestion.split("\n").tail
    val goodAnswersIndexes = allAnswers.filter(_.startsWith(">>>")).map(_.stripPrefix(">>>").trim).map(_.substring(0, 1))
    val goodAnswersTexts = allAnswers.filter(_.startsWith(">>>")).map(_.stripPrefix(">>>").trim).map(_.substring(3))
    goodAnswersIndexes.zip(goodAnswersTexts)
  }

  def generateBadAnswers(rawQuestion: String): Array[(String, String)] = {
    val allAnswers = rawQuestion.split("\n").tail
    val badAnswersIndexes = allAnswers.filterNot(_.startsWith(">>>")).map(_.substring(0, 1))
    val badAnswersTexts = allAnswers.filterNot(_.startsWith(">>>")).map(_.substring(1))
    badAnswersIndexes.zip(badAnswersTexts)
  }

}
package scaloid.example

import org.scaloid.common._
import android.graphics.Color
import android.widget.CompoundButton


//TODO : Change the big pile of shit on the loops
//TODO : Make RadioButtons Clickable
//TODO : Add logic to RadioButtons
//TODO : Import already written class

class HelloScaloid extends SActivity {

  lazy val correct= new STextView("Correct: ")
  lazy val partially = new STextView("Partially: ")
  lazy val incorrect = new STextView("Incorrect: ")


  lazy val correct_percentage = new STextView("0%")
  lazy val partially_percentage = new STextView("0%")
  lazy val incorrect_percentage = new STextView("0%")



  onCreate {
    contentView = new SVerticalLayout {
      style {
        case b: SButton => b.textColor(Color.WHITE).onClick(correct.text = "PRESSED")
        case t: STextView => t textSize 15.dip
        case e: SEditText => e.backgroundColor(Color.YELLOW).textColor(Color.BLACK)
      }

      new SLinearLayout{
        correct.here
        correct_percentage.here
      }.wrap.here

      new SLinearLayout{
        partially.here
        partially_percentage.here
      }.wrap.here

      new SLinearLayout{
        incorrect.here
        incorrect_percentage.here
      }.wrap.here

      new SLinearLayout{
        STextView("Question: ") textSize 22.dip
      }.padding(15.dip).wrap.here

      new SListView {
        new SRadioButton("Dobry wieczor").here
        new SRadioButton("Dobry wieczor").here
        new SRadioButton("Dobry wieczor").here
        new SRadioButton("Dobry wieczor").here
        new SRadioButton("Dobry wieczor").here
        new SRadioButton("Dobry wieczor").here
        new SRadioButton("Dobry wieczor").here
      }.wrap.here

      new SListView {
        new SButton("Check Answers").here
      }.wrap.here

    } padding 20.dip
  }

}
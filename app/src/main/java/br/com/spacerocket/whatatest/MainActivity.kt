package br.com.spacerocket.whatatest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var questions: ArrayList<Question>
    private var current = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questions = arrayListOf(
            Question("O que significa a palavra \"Truck\"?", arrayListOf(
                Answers("Troca"),
                Answers("Truque"),
                Answers("Caminhão", true),
                Answers("Painel"))
            ),
            Question("Qual dessas palavras é um sinônimo de \"Fairness\"?", arrayListOf(
                Answers("Fairy"),
                Answers("Justice", true),
                Answers("Pain"),
                Answers("Sickness"))
            ),
            Question("Qual das palavras abaixo não se correlaciona com \"Fish\"?", arrayListOf(
                Answers("Silk", true),
                Answers("Dog"),
                Answers("Cat"),
                Answers("Horse"))
            )
        )
        selectQuestion()
        current++

        initListeners()
    }

    private fun selectQuestion() {
        if (current == questions.size) current = 0
        questionTXT?.text = questions[current].description
        firstTXT?.text = questions[current].answers[0].description
        secondTXT?.text = questions[current].answers[1].description
        thirdTXT?.text = questions[current].answers[2].description
        fourthTXT?.text = questions[current].answers[3].description
    }

    private fun showError() = Toast.makeText(this, "Opa, você errou", Toast.LENGTH_LONG).show()

    private fun initListeners() {
        firstCard?.setOnClickListener {
            if (questions[current].answers[0].correct) current++
            else showError()
            selectQuestion()
        }
        secondCard?.setOnClickListener {
            if (questions[current].answers[1].correct) current++
            else showError()
            selectQuestion()
        }
        thirdhCard?.setOnClickListener {
            if (questions[current].answers[2].correct) current++
            else showError()
            selectQuestion()
        }
        fourthCard?.setOnClickListener {
            if (questions[current].answers[3].correct) current++
            else showError()
            selectQuestion()
        }
    }
}

package com.example.assignment2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.compose.ui.test.isEnabled
import org.w3c.dom.Text

data class Question(val text: String, val isTrue: Boolean)

class Questions : AppCompatActivity() {

    private val questions = listOf(
        Question("The capital city of South Africa is Pretoria.", true),
        Question("The mountain range along the western edge of South Africa is Drakensberg.", true),
        Question("The largest desert in South Africa is the Kalahari.", true),
        Question("The famous South African author is Zakes Mda", true)
    )

    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        val questionTextView = findViewById<TextView>(R.id.questionsText)
        val feedbackTextView = findViewById<TextView>(R.id.feedbackTextView)
        val trueButton = findViewById<Button>(R.id.trueButton)
        val falseButton = findViewById<Button>(R.id.falseButton)
        val nextQuestionButton = findViewById<Button>(R.id.nextQustionButton)

        fun showQuestion() {
            val question = questions[currentQuestionIndex]
            questionTextView.text = question.text
            feedbackTextView.text = ""
            trueButton.isEnabled = true
            falseButton.isEnabled = true
        }

        fun checkAnswer(userAnswer: Boolean) {
            val correctAnswer = questions[currentQuestionIndex].isTrue
            if (userAnswer == correctAnswer) {
                feedbackTextView.text = "Correct answer"
                score++
            } else {
                feedbackTextView.text = "Incorrect answer"
            }
            trueButton.isEnabled = true
            falseButton.isEnabled = true
        }

        trueButton.setOnClickListener {
            checkAnswer(true)
        }

        falseButton.setOnClickListener {
            checkAnswer(false)
        }

        nextQuestionButton.setOnClickListener {
            currentQuestionIndex++
            if (currentQuestionIndex < questions.size) {
                showQuestion()
            } else {
                Toast.makeText(this, "Quiz finished. Navigating to score screen...", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ScoreActivity3::class.java)
                intent.putExtra("score", score)
                startActivity(intent)
                finish()
            }
        }

        showQuestion()
    }
}















         








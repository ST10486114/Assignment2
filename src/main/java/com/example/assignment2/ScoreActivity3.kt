package com.example.assignment2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class ScoreActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score3)

        val scoreText = findViewById<TextView>(R.id.scoreText)
        val score = intent.getIntExtra("score" , 0)
        val reviewQuestions = findViewById<Button>(R.id.reviewbutton)
        scoreText.text = "Your Score: $score out of 4"


        reviewQuestions.setOnClickListener {
            Toast.makeText(this, "Navigating to Review Questions", Toast.LENGTH_SHORT).show()
            val intent = Intent(this , ReviewQuestions::class.java)
            startActivity(intent)
            finish()
        }
    }
}









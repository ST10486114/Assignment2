package com.example.assignment2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class ReviewQuestions : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review_questions)

        val reviewTextView = findViewById<TextView>(R.id.reviewtextView)
        val exitButton = findViewById<Button>(R.id.exitButton)
        val tryagainbutton = findViewById<Button>(R.id.tryagainbutton)

        reviewTextView.text = """
            1. The capital city of South Africa is Pretoria. ✓
            2. The mountain range along the western edge is Drakensberg. ✓
            3. The largest desert is the Kalahari. ✓
            4. Zakes Mda is a famous author. ✗
        """.trimIndent()

        tryagainbutton.setOnClickListener {
            Toast.makeText(this, "Restarting quiz...!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this , Questions::class.java)
            startActivity(intent)
            finish()
        }

        exitButton.setOnClickListener {
            Toast.makeText(this, "Thank you for playing the Quiz", Toast.LENGTH_SHORT).show()
            finishAffinity()
        }
    }
}


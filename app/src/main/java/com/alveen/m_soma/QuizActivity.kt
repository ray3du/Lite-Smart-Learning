package com.alveen.m_soma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.cardview.widget.CardView

class QuizActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val drawerBack = findViewById<ImageView>(R.id.drawerBack)
        val biology = findViewById<CardView>(R.id.biology)
        val math = findViewById<CardView>(R.id.math)
        val chemistry = findViewById<CardView>(R.id.chemistry)
        val physics = findViewById<CardView>(R.id.physics)


        //handles quizes
        biology.setOnClickListener {
            val intent = Intent(this, WebActivity::class.java)
            intent.putExtra("subject", "biology")
            startActivity(intent)
            finish()
        }

        math.setOnClickListener {
            val intent = Intent(this, WebActivity::class.java)
            intent.putExtra("subject", "math")
            startActivity(intent)
            finish()
        }

        chemistry.setOnClickListener {
            val intent = Intent(this, WebActivity::class.java)
            intent.putExtra("subject", "chemistry")
            startActivity(intent)
            finish()
        }

        physics.setOnClickListener {
            val intent = Intent(this, WebActivity::class.java)
            intent.putExtra("subject", "physics")
            startActivity(intent)
            finish()
        }

        //Handle return events
        drawerBack.setOnClickListener {
            startActivity(Intent(this, MainViewActivity::class.java))
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, MainViewActivity::class.java))
        finish()
    }
}
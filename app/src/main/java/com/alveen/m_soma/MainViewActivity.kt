package com.alveen.m_soma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class MainViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val math = findViewById<CardView>(R.id.math)

        math.setOnClickListener {
            val intent = Intent(this, UnitActivity::class.java)
            intent.putExtra("subject", "math")
            startActivity(intent)
            finish()
        }
    }
}
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
        val bio = findViewById<CardView>(R.id.biology)
        val chem = findViewById<CardView>(R.id.chemistry)
        val physics = findViewById<CardView>(R.id.physics)

        math.setOnClickListener {
            val intent = Intent(this, UnitActivity::class.java)
            intent.putExtra("subject", "math")
            startActivity(intent)
            finish()
        }

        bio.setOnClickListener {
            val intent = Intent(this, UnitActivity::class.java)
            intent.putExtra("subject", "biology")
            startActivity(intent)
            finish()
        }

        chem.setOnClickListener {
            val intent = Intent(this, UnitActivity::class.java)
            intent.putExtra("subject", "chemistry")
            startActivity(intent)
            finish()
        }

        physics.setOnClickListener {
            val intent = Intent(this, UnitActivity::class.java)
            intent.putExtra("subject", "physics")
            startActivity(intent)
            finish()
        }
    }
}
package com.alveen.m_soma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_unit.*

class UnitActivity : AppCompatActivity() {
    private lateinit var recyclerViewAdapter: TopicRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unit)

        lateinit var subject: String

        val bundle: Bundle? = intent.extras

        if (bundle != null){
            subject = bundle.getString("subject", "")
        }

        recyclerViewAdapter = TopicRecyclerViewAdapter(ArrayList())
        rcView.adapter = recyclerViewAdapter
        rcView.layoutManager = LinearLayoutManager
        //Handle returning to main activity
        val returnButton = findViewById<ImageView>(R.id.returnButton)
        val rcView = findViewById<ListView>(R.id.rcView)



        returnButton.setOnClickListener {
            startActivity(Intent(this, MainViewActivity::class.java))
        }

    }
}
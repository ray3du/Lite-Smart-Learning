package com.alveen.m_soma

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class UnitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unit)

        //Handle returning to main activity
        val returnButton = findViewById<ImageView>(R.id.returnButton)
        val rvTopics = findViewById<RecyclerView>(R.id.rvTopics)
        val topics = findViewById<TextView>(R.id.topic)

        var newData: Array<String> = arrayOf("edwin")


        returnButton.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
        }

        class DataAdapter(var data: Array<String>): RecyclerView.Adapter<DataAdapter.MyViewHolder>() {

            inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view)
            @SuppressLint("ResourceType")
            override fun onCreateViewHolder(
                parent: ViewGroup,
                viewType: Int
            ): MyViewHolder {
                val itemView = LayoutInflater.from(parent.context).inflate(R.id.topic, parent, false)
                return MyViewHolder(itemView)
            }

            override fun getItemCount(): Int {
                return data.size
            }

            override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
                val text = data[position]
                holder.itemView = text
            }
        }

        val dataAdapter = DataAdapter(newData)

        val layoutManager = LinearLayoutManager(applicationContext)
        rvTopics.layoutManager = layoutManager
        rvTopics.adapter = dataAdapter


    }
}
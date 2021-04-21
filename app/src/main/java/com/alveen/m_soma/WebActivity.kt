package com.alveen.m_soma

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import com.google.firebase.database.*

class WebActivity : AppCompatActivity() {
    private lateinit var database: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        val webViewLayout = findViewById<WebView>(R.id.webViewLayout)

        //Initialize firebase
        database = FirebaseDatabase.getInstance()
        databaseReference = database.reference

        //Creating intents
        val bundle: Bundle? = intent.extras

        val settings: WebSettings = webViewLayout.settings
        settings.javaScriptEnabled = true
        settings.allowContentAccess = true
        settings.domStorageEnabled = true
        webViewLayout.webViewClient = WebViewClient()

        if (bundle != null){
            val subject = bundle.getString("subject")
            val id = bundle.getString("id")

            if (id == "meet"){
                databaseReference.child("MeetingData/$subject").addValueEventListener(
                    object : ValueEventListener {
                        @SuppressLint("SetTextI18n")
                        override fun onDataChange(snapshot: DataSnapshot) {
                            val value = snapshot.getValue(Quiz::class.java)
                            webViewLayout.loadUrl("${value?.link}")
                        }

                        override fun onCancelled(error: DatabaseError) {
                            Toast.makeText(this@WebActivity, "Failed to load data from database", Toast.LENGTH_SHORT).show()
                        }
                    })
            }

            databaseReference.child("Data/$subject").addValueEventListener(
                object : ValueEventListener {
                    @SuppressLint("SetTextI18n")
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val value = snapshot.getValue(Quiz::class.java)
                        webViewLayout.loadUrl("${value?.link}")
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Toast.makeText(this@WebActivity, "Failed to load data from database", Toast.LENGTH_SHORT).show()
                    }
                })
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, QuizActivity::class.java))
        finish()
    }
}
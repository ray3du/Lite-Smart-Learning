package com.alveen.m_soma

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.*

class AdminActivity : AppCompatActivity() {
    private lateinit var database: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        //Initialize firebase
        database = FirebaseDatabase.getInstance()
        databaseReference = database.reference

        val subject = findViewById<EditText>(R.id.subjectET)
        val link = findViewById<EditText>(R.id.subjectLink)
        val buttonSubmit = findViewById<Button>(R.id.buttonQuiz)
        val meetingSubject = findViewById<EditText>(R.id.meetingSubjectLink)
        val meetingLink = findViewById<EditText>(R.id.meetingLink)
        val buttonMeetingSubmit = findViewById<Button>(R.id.meetingButtonSubmit)
        val logout = findViewById<FloatingActionButton>(R.id.logout)

        //handle submitting quiz
        buttonSubmit.setOnClickListener {
            buttonSubmit.isEnabled = false
            buttonSubmit.text = "Uploading.."
            writeNewQuiz(meetingSubject.text.toString().toLowerCase(Locale.ROOT), meetingLink.text.toString(), buttonMeetingSubmit)
        }

        buttonMeetingSubmit.setOnClickListener {
            buttonSubmit.isEnabled = false
            buttonSubmit.text = "Uploading.."
            writeNewMeetingQuiz(subject.text.toString().toLowerCase(Locale.ROOT), link.text.toString(), buttonSubmit)
        }

        logout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }


    }

    override fun onBackPressed() {
        super.onBackPressed()
        val builder = AlertDialog.Builder(this)
        builder.apply {
            title = "Exit Alert"
            setIcon(R.drawable.ic_baseline_exit_to_app_24)
            setMessage("Are you sure you want to logout?")
            setPositiveButton("Ok", DialogInterface.OnClickListener { dialog, id ->
                val intent = Intent(this@AdminActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            })
            setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, id ->
                Toast.makeText(this@AdminActivity, "Canceled", Toast.LENGTH_SHORT).show()
            })
        }

        builder.create()

    }

    @SuppressLint("SetTextI18n")
    private fun writeNewQuiz(subject: String, link: String, button: Button){
        val quiz = Quiz(subject, link)
        databaseReference.child("Data/$subject").setValue(quiz)
        Toast.makeText(this, "Uploaded successfully..", Toast.LENGTH_SHORT).show()
        button.isEnabled = true
        button.text = "UPLOAD"
    }

    @SuppressLint("SetTextI18n")
    private fun writeNewMeetingQuiz(subject: String, link: String, button: Button){
        val quiz = Quiz(subject, link)
        databaseReference.child("MeetingData/$subject").setValue(quiz)
        Toast.makeText(this, "Uploaded successfully..", Toast.LENGTH_SHORT).show()
        button.isEnabled = true
        button.text = "UPLOAD"
    }
}
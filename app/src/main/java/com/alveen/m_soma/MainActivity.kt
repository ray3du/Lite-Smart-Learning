package com.alveen.m_soma

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isVisible
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance();

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val btnRegistration = findViewById<Button>(R.id.registrationButton)
        val btnLogin = findViewById<Button>(R.id.loginButton)
        val emailUser = findViewById<EditText>(R.id.email)
        val passwordUser = findViewById<EditText>(R.id.password)
        val spinnerProgress = findViewById<ProgressBar>(R.id.spinnerLogin)
        val successErrorMessage = findViewById<TextView>(R.id.successError)

        //Handle intent extras
        var bundle: Bundle? = intent.extras

        if (bundle != null){
            successErrorMessage.text = bundle.getString("message")
        }

        setSupportActionBar(toolbar)

        //onclick listener
        btnRegistration.setOnClickListener {
            val intent = Intent(this@MainActivity, RegistrationActivity::class.java)
            startActivity(intent)
        }

        //onclick listener
        btnLogin.setOnClickListener {
            spinnerProgress.isVisible = true
            val email: String = emailUser.text.toString()
            val password: String = passwordUser.text.toString()

            if (email != "" || password != "") {
                verifyUser(email, password, spinnerProgress)
            } else {
                spinnerProgress.isVisible = false
                Toast.makeText(this, "Email and password cannot be empty", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun verifyUser(email: String, password: String, spinnerProgress: ProgressBar){
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(
                this
            ) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val intent = Intent(this, MainActivity2::class.java)
                    spinnerProgress.isVisible = false
                    startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.
                    spinnerProgress.isVisible = false
                    Toast.makeText(
                        this, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                // ...
            }
    }
}
package com.alveen.m_soma

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class RegistrationActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        //Firebase
        mAuth = FirebaseAuth.getInstance()

        val btnRegister = findViewById<Button>(R.id.buttonLayout)
        val btnBack = findViewById<ImageView>(R.id.backButton)
        val username = findViewById<EditText>(R.id.emailRegister)
        val passCode = findViewById<EditText>(R.id.passwordRegister)
        val confirm = findViewById<EditText>(R.id.passwordConfirm)
        val spinnerProgress = findViewById<ProgressBar>(R.id.spinnerRegister)

        //Returning back button
        btnBack.setOnClickListener {
            val intent = Intent(this@RegistrationActivity, MainActivity::class.java)
            startActivity(intent)
        }

        //Registration button
        btnRegister.setOnClickListener {
            //register fun

            spinnerProgress.isVisible = true
                if (confirm.text.toString() != passCode.text.toString()){
                    spinnerProgress.isVisible = false
                    Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                    passCode.setText("")
                    confirm.setText("")
                }else {
                    createUser(username, passCode, spinnerProgress)
                }
            }
    }

    override fun onStart() {
        super.onStart()
        val currentUser: FirebaseUser? = mAuth.currentUser
        println(currentUser)
    }

    private fun createUser(user: EditText, pass: EditText, spinnerProgress: ProgressBar){
        val email: String = user.text.toString()
        val password: String = pass.text.toString()

        if (email != "" || password != ""){
            mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(
                    this
                ) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        spinnerProgress.isVisible = false
                        val intent = Intent(this, MainActivity::class.java)
                        intent.putExtra("message", "Successfully registered")
                        startActivity(intent)
                    } else {
                        // If sign in fails, display a message to the user.
                        spinnerProgress.isVisible = false
                        Toast.makeText(
                            this, "Registration failed.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }else{
            spinnerProgress.isVisible = false
            Toast.makeText(
                this, "Fields cannot be empty",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
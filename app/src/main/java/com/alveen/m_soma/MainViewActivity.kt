package com.alveen.m_soma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.cardview.widget.CardView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val math = findViewById<CardView>(R.id.math)
        val bio = findViewById<CardView>(R.id.biology)
        val chem = findViewById<CardView>(R.id.chemistry)
        val physics = findViewById<CardView>(R.id.physics)
        val geo = findViewById<LinearLayout>(R.id.geo)
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        val navView = findViewById<NavigationView>(R.id.navView)
        val drawer = findViewById<ImageView>(R.id.drawer)


        geo.setOnClickListener {
            startActivity(Intent(this, WebActivity::class.java))
            finish()
        }

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

        val toggle = object : ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close){
            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
            }

            override fun onDrawerClosed(drawerView: View) {
                super.onDrawerClosed(drawerView)
            }
        }

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> {
                    Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
                }
                R.id.nav_logout -> {
                    FirebaseAuth.getInstance().signOut()
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
                R.id.nav_meeting -> {
                    FirebaseAuth.getInstance().signOut()
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
                R.id.nav_quiz-> {
                    FirebaseAuth.getInstance().signOut()
                    startActivity(Intent(this, QuizActivity::class.java))
                    finish()
                }
                else -> {
                    println("Not pressed")
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }


        toggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        drawer.setOnClickListener {
            drawerLayout.openDrawer(navView)
        }


    }
}
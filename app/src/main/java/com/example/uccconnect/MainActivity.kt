package com.example.uccconnect

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var directory_button: ImageButton
    private lateinit var courses_button: ImageButton
    private lateinit var admissions_button: ImageButton
    private lateinit var social_button: ImageButton
    private lateinit var intent: Intent
    private lateinit var fAButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        directory_button = findViewById(R.id.directory_button)
        courses_button = findViewById(R.id.courses_button)
        admissions_button = findViewById(R.id.admissions_button)
        social_button = findViewById(R.id.social_button)
        fAButton = findViewById(R.id.fAButton)

        directory_button.setOnClickListener {
            intent = Intent(this@MainActivity, DirectoryActivity::class.java)
            startActivity(intent)
        }
        courses_button.setOnClickListener {
            intent = Intent(this@MainActivity, CoursesActivity::class.java)
            startActivity(intent)
        }
        admissions_button.setOnClickListener {
            intent = Intent(this@MainActivity, AdmissionsActivity::class.java)
            startActivity(intent)
        }
        social_button.setOnClickListener {
            intent = Intent(this@MainActivity, SocialActivity::class.java)
            startActivity(intent)
        }
        fAButton.setOnClickListener {
            intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:ithod@ucc.edu.jm")
            startActivity(intent)
        }
    }
}

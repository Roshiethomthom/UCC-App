package com.example.uccconnect

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class StaffViewActivity : AppCompatActivity() {

    private lateinit var callIcon: ImageView
    private lateinit var emailIcon: ImageView
    private lateinit var telephoneTxt: TextView
    private lateinit var emailTxt: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staff_view)

        // Set the support action bar color
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#5e5eef")))
        // Get the current window
        val window: Window = this.window
        // Set the status bar color
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = Color.parseColor("#5e5eef")

        // Retrieve staff member information from intent extras
        val title = intent.getStringExtra("title")
        val firstname = intent.getStringExtra("firstname")
        val lastname = intent.getStringExtra("lastname")
        val position = intent.getStringExtra("position")
        val email = intent.getStringExtra("email")
        val telephone = intent.getStringExtra("telephone")
        val image = intent.getStringExtra("image")

        // Populate the views with the retrieved information
        findViewById<TextView>(R.id.titleTxt).text = title
        findViewById<TextView>(R.id.fNameTxt).text = firstname
        findViewById<TextView>(R.id.lNameTxt).text = lastname
        findViewById<TextView>(R.id.positionTxt).text = position
        findViewById<TextView>(R.id.emailTxt).text = email
        findViewById<TextView>(R.id.telephoneTxt).text = telephone

        // Load the image using Glide or Picasso
        Glide.with(this)
            .load(image)
            .into(findViewById(R.id.avatarImage))

        // Setting of action bar title after getAndSetIntentData method
        val acbar: ActionBar? = supportActionBar
        if (acbar != null) {
            acbar.title = title+" "+firstname+" "+lastname
        }

        // Set up click listeners for call and email actions
        callIcon = findViewById(R.id.callIcon)
        emailIcon = findViewById(R.id.emailIcon)
        telephoneTxt = findViewById(R.id.telephoneTxt)
        emailTxt = findViewById(R.id.emailTxt)

        callIcon.setOnClickListener {
            if (telephone != null) {
                dialPhoneNumber(telephone)
            }
        }

        telephoneTxt.setOnClickListener {
            if (telephone != null) {
                dialPhoneNumber(telephone)
            }
        }

        emailIcon.setOnClickListener {
            if (email != null) {
                sendEmail(email)
            }
        }

        emailTxt.setOnClickListener {
            if (email != null) {
                sendEmail(email)
            }
        }
    }

    private fun dialPhoneNumber(phoneNumber: String) {
        val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
        startActivity(dialIntent)
    }

    private fun sendEmail(email: String) {
        val emailIntent = Intent(Intent.ACTION_SENDTO)
        emailIntent.data = Uri.parse("mailto:$email")
        startActivity(Intent.createChooser(emailIntent, "Send email..."))
    }
}

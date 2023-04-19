package com.example.uccconnect

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView


class SocialActivity : AppCompatActivity() {

    private lateinit var facebookButton: CardView
    private lateinit var twitterButton: CardView
    private lateinit var instagramButton: CardView
    private lateinit var youtubeButton: CardView
    private lateinit var linkedInButton: CardView
    private lateinit var intent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_social)

        facebookButton = findViewById(R.id.facebook)
        twitterButton = findViewById(R.id.twitter)
        instagramButton = findViewById(R.id.instagram)
        youtubeButton = findViewById(R.id.youtube)
        linkedInButton = findViewById(R.id.linkedIn)

        // Set the support action bar color
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#ff4848")))
        // Get the current window
        val window: Window = this.window
        // Set the status bar color
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = Color.parseColor("#ff4848")

        facebookButton.setOnClickListener {
            launchWebViewActivity("https://www.facebook.com/uccjamaica")
        }
        twitterButton.setOnClickListener {
            launchWebViewActivity("https://twitter.com/uccjamaica")
        }
        instagramButton.setOnClickListener {
            launchWebViewActivity("https://www.instagram.com/uccjamaica")
        }
        youtubeButton.setOnClickListener {
            launchWebViewActivity("https://www.youtube.com/user/uccjamaica")
        }
        linkedInButton.setOnClickListener {
            launchWebViewActivity("https://www.linkedin.com/company/uccjamaica")
        }
    }

    private fun launchWebViewActivity(url: String) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            // Invalid URL scheme, show an error message and return
            return
        }
        intent = Intent(this, WebViewActivity::class.java)
        intent.putExtra(WebViewActivity.EXTRA_URL, url)
        startActivity(intent)
    }
}

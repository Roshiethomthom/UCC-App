package com.example.uccconnect

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AdmissionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admissions)

        // Set the support action bar color
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#199ffb")))
        // Get the current window
        val window: Window = this.window
        // Set the status bar color
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = Color.parseColor("#199ffb")

        val button = findViewById<Button>(R.id.uccAppltBtn)
        button.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://apply.online.ucc.edu.jm/s/login/?ec=302&startURL=%2Fs%2F"))
            startActivity(intent)
    }
    }
}
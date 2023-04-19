package com.example.uccconnect

import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

class CourseViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_view)

        // Set the support action bar color
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#6ec17d")))
        // Get the current window
        val window: Window = this.window
        // Set the status bar color
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = Color.parseColor("#6ec17d")

        // Retrieve course information from intent extras
        val courseCode = intent.getStringExtra("course code")
        val courseTitle = intent.getStringExtra("course title")
        val credit = intent.getIntExtra("credits",0)
        val prerec = intent.getStringExtra("prerequisites")
        val desc = intent.getStringExtra("description")

        // Setting of action bar title after getAndSetIntentData method
        val acbar: ActionBar? = supportActionBar
        if (acbar != null) {
            acbar.title = courseTitle
        }

        // Populate the views with the retrieved information
        findViewById<TextView>(R.id.courseCode).text = courseCode?.let { getBoldText("Course Code: \n", it) }
        findViewById<TextView>(R.id.courseTitle).text = courseTitle?.let { getBoldText("Course Title: \n", it) }
        findViewById<TextView>(R.id.credits).text = getBoldText("Credit Weight: \n", credit.toString())
        findViewById<TextView>(R.id.prereq).text = prerec?.let { getBoldText("Prerequisites: \n", it)}
        findViewById<TextView>(R.id.descript).text = desc?.let { getBoldText("Description: \n", it) }

    }
    private fun getBoldText(prefix: String, text: String): SpannableString {
        val spannableString = SpannableString(prefix + text)
        spannableString.setSpan(StyleSpan(Typeface.BOLD), 0, prefix.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        return spannableString
    }

}
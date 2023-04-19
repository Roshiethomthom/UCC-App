package com.example.uccconnect

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class CoursesActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var coursesList:ArrayList<Courses>
    private lateinit var coursesAdapter: CoursesAdapter
    private var db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)

        // Set the support action bar color
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#6ec17d")))
        // Get the current window
        val window: Window = this.window
        // Set the status bar color
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = Color.parseColor("#6ec17d")


        coursesList = arrayListOf()

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        coursesAdapter = CoursesAdapter(coursesList)
        recyclerView.adapter = CoursesAdapter(coursesList)

        db = FirebaseFirestore.getInstance()

        db.collection("Course").get().addOnSuccessListener {
            if(!it.isEmpty){
                for (data in it.documents){
                    val courses: Courses? = data.toObject(Courses::class.java)
                    if (courses != null) {
                        coursesList.add(courses)
                    }
                }
                recyclerView.adapter = CoursesAdapter(coursesList)
            }
        }
            .addOnFailureListener {
                Toast.makeText(this, "Error getting documents: ", Toast.LENGTH_SHORT).show()
            }
    }
}
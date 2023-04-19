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

class DirectoryActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var facultyList:ArrayList<FacultyMember>
    private lateinit var facultyAdapter:FacultyAdapter
    private var db = Firebase.firestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_directory)

        // Set the support action bar color
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#5e5eef")))
        // Get the current window
        val window: Window = this.window
        // Set the status bar color
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = Color.parseColor("#5e5eef")

        facultyList = arrayListOf()

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        facultyAdapter = FacultyAdapter(facultyList)
        recyclerView.adapter = FacultyAdapter(facultyList)


        db = FirebaseFirestore.getInstance()

        db.collection("Faculty").get().addOnSuccessListener {
                if(!it.isEmpty){
                    for (data in it.documents){
                        val facultyMember: FacultyMember? = data.toObject(FacultyMember::class.java)
                        if (facultyMember != null) {
                            facultyList.add(facultyMember)
                        }
                    }
                    recyclerView.adapter = FacultyAdapter(facultyList)
                }
            }
            .addOnFailureListener {
                Toast.makeText(this, "Error getting faculty members: ", Toast.LENGTH_SHORT).show()
            }
        }
    }
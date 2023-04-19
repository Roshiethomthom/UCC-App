package com.example.uccconnect

import android.content.Intent
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class CoursesAdapter (private val coursesList: ArrayList<Courses>) : RecyclerView.Adapter<CoursesAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val courseCodeTextView: TextView = itemView.findViewById(R.id.courseCode)
        val courseTitleTextView: TextView = itemView.findViewById(R.id.courseTitle)
        val creditsTextView: TextView = itemView.findViewById(R.id.credits)
        val prereqTextView: TextView = itemView.findViewById(R.id.prereq)
        val descriptTextView: TextView = itemView.findViewById(R.id.descript)
        val couresCardView: CardView = itemView.findViewById(R.id.courescardview)

        init {
            couresCardView.setOnClickListener {
                // Get the clicked item from the courses list
                val position = adapterPosition
                val clickedCourse = coursesList[position]

                // Create an intent to start the CourseViewActivity
                val intent = Intent(itemView.context, CourseViewActivity::class.java)

                // Pass the information of the clicked item as extras
                intent.putExtra("course code", clickedCourse.Course_Code)
                intent.putExtra("course title", clickedCourse.Course_Title)
                intent.putExtra("credits", clickedCourse.Credits)
                intent.putExtra("prerequisites", clickedCourse.Prerequisites)
                intent.putExtra("description", clickedCourse.Description)

                // Start the activity
                itemView.context.startActivity(intent)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.my_courses, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
       return coursesList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentCourse = coursesList[position]
        holder.courseCodeTextView.text = currentCourse.Course_Code?.let { getBoldText("Course Code: ", it) }
        holder.courseTitleTextView.text = currentCourse.Course_Title?.let { getBoldText("Course Title: ", it) }
        holder.creditsTextView.text = getBoldText("Credits: ", currentCourse.Credits.toString())
        holder.prereqTextView.text = currentCourse.Prerequisites?.let { getBoldText("Pre-requisites: ", it) }
        holder.descriptTextView.text =
            currentCourse.Description?.let { getBoldText("Course Description: ", it) }
    }

    private fun getBoldText(prefix: String, text: String): SpannableString {
        val spannableString = SpannableString(prefix + text)
        spannableString.setSpan(StyleSpan(Typeface.BOLD), 0, prefix.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        return spannableString
    }
}
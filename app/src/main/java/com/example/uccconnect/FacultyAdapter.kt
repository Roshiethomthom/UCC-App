package com.example.uccconnect

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide



class FacultyAdapter(private val facultyList: ArrayList<FacultyMember>) : RecyclerView.Adapter<FacultyAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.titleTxt)
        val fnameTextView: TextView = itemView.findViewById(R.id.fNameTxt)
        val lnameTextView: TextView = itemView.findViewById(R.id.lNameTxt)
        val positionTextView: TextView = itemView.findViewById(R.id.positionTxt)
        val emailTextView: TextView = itemView.findViewById(R.id.emailTxt)
        val telephoneTextView: TextView = itemView.findViewById(R.id.telephoneTxt)
        val imageView: ImageView = itemView.findViewById(R.id.avatarImage)
        val staffCardView: CardView = itemView.findViewById(R.id.staffcardview)

        init {
            staffCardView.setOnClickListener {
                // Get the clicked item from the faculty list
                val position = adapterPosition
                val clickedFaculty = facultyList[position]

                // Create an intent to start the StaffViewActivity
                val intent = Intent(itemView.context, StaffViewActivity::class.java)

                // Pass the information of the clicked item as extras
                intent.putExtra("title", clickedFaculty.Title)
                intent.putExtra("firstname", clickedFaculty.Firstname)
                intent.putExtra("lastname", clickedFaculty.Lastname)
                intent.putExtra("position", clickedFaculty.Position)
                intent.putExtra("email", clickedFaculty.Email)
                intent.putExtra("telephone", clickedFaculty.Telephone)
                intent.putExtra("image", clickedFaculty.Image)


                // Start the activity
                itemView.context.startActivity(intent)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.my_list, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentFaculty = facultyList[position]
        holder.titleTextView.text = currentFaculty.Title
        holder.fnameTextView.text = currentFaculty.Firstname
        holder.lnameTextView.text = currentFaculty.Lastname
        holder.positionTextView.text = currentFaculty.Position
        holder.emailTextView.text = currentFaculty.Email
        holder.telephoneTextView.text = currentFaculty.Telephone

        // Load image using Glide
        Glide.with(holder.itemView.context)
            .load(currentFaculty.Image)
            .into(holder.imageView)

    }

//        // Load image using Picasso
//        Picasso.get()
//            .load(currentFaculty.Image)
//            .into(holder.imageView)
//    }
    override fun getItemCount() = facultyList.size
}

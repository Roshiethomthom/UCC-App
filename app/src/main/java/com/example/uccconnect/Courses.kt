package com.example.uccconnect

data class Courses(
    val Course_Code: String? = "",
    val Course_Title: String? = "",
    val Credits: Int = 0,
    val Description: String? = "",
    val Prerequisites: String? = "",
    )
    {
        constructor() : this("", "", 0, "", "")
}
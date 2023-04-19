package com.example.uccconnect

data class FacultyMember(
    val Email: String? = "",
    val Firstname: String? = "",
    val Lastname: String? = "",
    val Image: String? = "",
    val Position: String? = "",
    val Telephone: String? = "",
    val Title: String? = ""
) {
    constructor() : this("", "", "", "", "", "", "")
}


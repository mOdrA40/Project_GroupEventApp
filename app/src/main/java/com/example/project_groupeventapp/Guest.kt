package com.example.project_groupeventapp

data class Guest(
    val name: String,
    val rsvpStatus: String,
    var isSelected: Boolean = false
)

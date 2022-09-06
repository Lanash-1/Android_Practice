package com.example.practice.model

import android.text.Editable
import java.io.Serializable

data class Stat(
    val firstName: String,
    val lastName: String,
    val centuries: Int,
    val country: String,
    val status: String
): Serializable

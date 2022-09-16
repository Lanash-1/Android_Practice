package com.example.practice.model

import java.io.Serializable

data class Stat(
    val firstName: String,
    val lastName: String,
    val centuries: Int,
    val country: String,
    val status: String
): Serializable

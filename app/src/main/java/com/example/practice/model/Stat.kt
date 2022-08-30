package com.example.practice.model

import java.io.Serializable

data class Stat(
    val name: String,
    val centuries: Int,
    val country: String,
    val isRetired: Boolean
): Serializable

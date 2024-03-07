package com.example.aston_intensiv_4.model

import java.io.Serializable

data class User(
    val id: Int,
    val name: String,
    val surname: String,
    val phoneNumber: String,
    val imgUri: String
) : Serializable

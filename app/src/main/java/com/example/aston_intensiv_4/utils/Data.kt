package com.example.aston_intensiv_4.utils

import com.example.aston_intensiv_4.model.User
import kotlin.random.Random

val listOfNames = listOf("Daniil", "Sasha", "Jenya", "Maxim", "Jonathon")
val listOfSurnames = listOf("Franchesko", "Jostar", "Kenya", "Svaytopolc", "Beluga")
fun getRandomPhoneNumber() = "+ ${Random.nextLong(7_900_000_0000, 7_999_999_9999)}"
val listOfUris = listOf(
    "https://placekitten.com/300/300",
    "https://placekitten.com/400/400",
    "https://placekitten.com/500/500",
    "https://placebeard.it/300/300"
)

fun getUsers() =
    List(4) {
        User(
            it, listOfNames.random(), listOfSurnames.random(),
            getRandomPhoneNumber(),
            listOfUris.random()
        )
    }

package com.example.nursesapp.data.models

import java.lang.reflect.Type


data class Nurse(
    val id: Long,
    val name: String,
    val age: Int,
    val specialized: Type,
    val image: String,
    val gender: Type,
    val workingTime: Type,
    var token: String?
)
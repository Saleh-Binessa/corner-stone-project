package com.example.nursesapp.data.models

import java.lang.reflect.Type


data class Nurse(
    val id: Long,
    val name: String,
    val price: String,
    val specialized: Type,
    val rating: Int,
    val image: Int,
    val gender: Type,
    val workingTime: Type,
)
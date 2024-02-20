package com.example.nursesapp.data.models

import java.lang.reflect.Type

data class User(
    var username: String,
    var password: String,
    var name: String,
    var age: Int,
    var gender: Type,
    var height: Double,
    var weight: Double,
    var token: String?
)
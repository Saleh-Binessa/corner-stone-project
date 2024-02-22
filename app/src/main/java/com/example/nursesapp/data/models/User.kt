package com.example.nursesapp.data.models

import java.lang.reflect.Type

data class User(
    var username: String,
    var password: String,
    var civilId: String,
    var name: String,
    var age: String,
    var gender: String,
    var address: String,
    var medicalRecord: String,
    var token: String?
)
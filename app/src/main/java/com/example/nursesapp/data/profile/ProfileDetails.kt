package com.example.nursesapp.data.profile

import java.lang.reflect.Type

data class ProfileDetails(
    var username: String,
    var name: String,
    var age: Int,
    var height: Double,
    var weight: Double,
    var token: String?
)
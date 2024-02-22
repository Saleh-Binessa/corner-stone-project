package com.example.nursesapp.utils

sealed class Routes {
    companion object {
        val homeRoute = "homeRoute"
        const val nursesRoute = "nursesRoute"
        const val dateRoute = "dateRoute"
        const val specialityRoute = "specialityRoute"
        const val periodRoute = "periodRoute"
        const val signupRoute = "signupRoute"
        const val signinRoute = "signinRoute"
        const val bookingsRoute = "bookingsRoute"
        const val profileRoute = "profileRoute"
        const val updateProfileRoute = "updateProfileRoute"
    }
}
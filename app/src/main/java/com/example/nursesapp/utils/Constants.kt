package com.example.nursesapp.utils

class Constants {
    companion object {
        const val baseUrl = "http://10.0.2.2/:8080/"
        const val dateEndpoint = "date"
        const val specialityEndpoint = "speciality"
        const val periodEndpoint = "period"

        const val nursesEndpoint = "api/v1/nurse/create"
        const val allNursesEndpoint = "api/v1/nurse/all"

        const val signupEndpoint = "api/v1/auth/signup"
        const val signinEndpoint = "api/v1/auth/signin"

        const val showbookingEndpoint = "booking"
        const val showProfileEndpoint = "profile"
        const val bookingEndPoint = "api/v1/book/create"
        const val getBookingDetailsEndpoints = "api/v1/book/get-book-details"
        const val getAllBookingDetailsEndpoints = "api/v1/book/get-all-book-details"


    }

}
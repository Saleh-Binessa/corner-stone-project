package com.example.nursesapp.data.booking_data

import java.text.SimpleDateFormat

data class BookingDetails (
    var bookedDate: SimpleDateFormat,
    var nursename: String,
    var speciality: String,
    var period: String,
)
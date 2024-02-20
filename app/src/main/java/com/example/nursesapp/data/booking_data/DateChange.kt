package com.example.nursesapp.data.booking_data

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

data class DateChange(
    var date: LocalDate = LocalDate.parse("2024-12-31"),
    var formatter: DateTimeFormatter? = DateTimeFormatter.ofPattern("dd-MMMM-yyyy"),
    var formattedDate: String? = date?.format(formatter),
    var period: Period? = Period.of(1, 2, 3)
)
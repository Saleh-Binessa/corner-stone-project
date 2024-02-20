package com.example.nursesapp.repository

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Build
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.nursesapp.network.NurseApiService


class NurseRepo (private val api: NurseApiService){
        suspend fun getAllPets() = api.getAllNurses(token = null)
    }
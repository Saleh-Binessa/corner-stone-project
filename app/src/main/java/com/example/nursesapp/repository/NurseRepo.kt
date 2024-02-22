package com.example.nursesapp.repository

import com.example.nursesapp.R
import com.example.nursesapp.data.models.Nurse
import com.example.nursesapp.network.NurseApiService
import com.example.nursesapp.utils.enum.GenderEnum
import com.example.nursesapp.utils.enum.SpecialityEnum
import com.example.nursesapp.utils.enum.WorkingPeriodEnum


class NurseRepo (private val api: NurseApiService){
        suspend fun getAllNurses() = api.getAllNurses(token = null)

    companion object {
        var dummyNursesList = listOf(
            Nurse(1, "Name: Noura", "20 KWD/Hour", SpecialityEnum.Adults, 5, R.drawable.nurse1, GenderEnum.FEMALE, WorkingPeriodEnum.AM),
            Nurse(2, "Name: Saleh", "20 KWD/Hour", SpecialityEnum.Elderly, 5, R.drawable.nurse2, GenderEnum.MALE, WorkingPeriodEnum.PM),
            Nurse(3,"Name: Haya", "20 KWD/Hour", SpecialityEnum.Kids, 3, R.drawable.nurse1, GenderEnum.FEMALE, WorkingPeriodEnum.FullTime),
            Nurse(4,"Name: Abdullah", "20 KWD/Hour", SpecialityEnum.Kids, 4, R.drawable.nurse2, GenderEnum.MALE, WorkingPeriodEnum.AM),
                Nurse(5,"Name: Fatima", "20 KWD/Hour", SpecialityEnum.Adults, 5, R.drawable.nurse1, GenderEnum.FEMALE, WorkingPeriodEnum.PM)
        )
    }
    }
package com.example.nursesapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nursesapp.data.booking_data.BookingDetails
import com.example.nursesapp.data.booking_data.DateChange
import com.example.nursesapp.data.profile.ProfileDetails
import com.example.nursesapp.data.response.TokenResponse
import com.example.nursesapp.data.models.Nurse
import com.example.nursesapp.data.models.User
import com.example.nursesapp.network.NurseApiService
import com.example.nursesapp.network.RetrofitHelper
import com.example.nursesapp.repository.NurseRepo
import com.example.nursesapp.utils.enum.GenderEnum
import com.example.nursesapp.utils.enum.SpecialityEnum
import com.example.nursesapp.utils.enum.WorkingPeriodEnum
import kotlinx.coroutines.launch
import java.time.LocalDate

class NurseViewModel : ViewModel(){

    private val apiService = RetrofitHelper.getInstance().create(NurseApiService::class.java)
    private val repository = NurseRepo(apiService)


    var token: TokenResponse? by mutableStateOf(null)
    var user: User? by mutableStateOf(null)
    var nurse by mutableStateOf(listOf<Nurse>())
    var bookings: List<BookingDetails>? by mutableStateOf(null)
    var profile: List<ProfileDetails>? by mutableStateOf(null)

    var addSuccess by mutableStateOf(false)

    fun signup(username: String, password: String, image: String = "", navigation: () -> Unit) {
        viewModelScope.launch {
            try {
                val response = apiService.signup(User(username, password, "",0, GenderEnum.MALE , 0.0, 0.0, null))
                token = response.body()
            } catch (e: Exception) {
                println("Error $e")
            } finally {
                if (token != null) {
                    showProfile()
                    // Transactions()
                    navigation()
                }
            }
        }
    }

    fun signin(username: String,password: String){
        viewModelScope.launch {
            try {
                val response = apiService.signup(User(username, password, "",0, GenderEnum.MALE,0.0, 0.0, null))
                token = response.body()
                println("TOKEN SIGNIN ${token?.token}")
               // transactions()
                showProfile()



            } catch (e: Exception) {
                println("Error $e")
            }
        }
    }

    fun showProfile() {
        viewModelScope.launch {
            try {
                val response = apiService.showProfile(token = token?.getBearerToken())
                user = response.body()
            } catch (e: Exception) {
                println("Error $e")
            }
        }

    }

    fun selectDate(date: DateChange) {
        viewModelScope.launch {
            try {
                val response = apiService.selectDate(
                    token = token?.getBearerToken(),
                    DateChange(LocalDate.now())
                )
                if (response.isSuccessful) {
                    println("Deposit Successful")
                } else {
                    println("Deposit Failed")
                }
            } catch (e: Exception) {
                println("Error $e")
            }

        }
    }
    fun selectSpeciality(speciality: SpecialityEnum) {
        viewModelScope.launch {
 //           try {
                val response = apiService.selectSpeciality(
                    token = token?.getBearerToken(),
                    specialityEnum = SpecialityEnum.entries
                )
//                if (response.isSuccessful) {
//                    println("Withdraw Successful")
//                } else {
//                    println("Withdraw Failed")
//                }
//            } catch (e: Exception) {
//                println("Error $e")
//            } finally {
//                showProfile()
//
//            }

        }
    }
    fun selectPeriod(workingPeriodEnum: WorkingPeriodEnum) {
        viewModelScope.launch {
           // try {
                val response = apiService.period(
                    token = token?.getBearerToken(),
                    workingPeriodEnum = WorkingPeriodEnum.entries
                )
//                if (response.isSuccessful) {
//
//                    println("Successful transfer")
//                } else {
//
//                    println("Failed transfer")
//                }
//            } catch (e: Exception) {
//                println("Error $e")
//            } finally {
//                showProfile()
//
//
//            }
        }
    }
    fun updateProfile(username: String, password: String){
        viewModelScope.launch {
            try {
                val response = apiService.updateProfile(token = token?.getBearerToken(),
                    user = User(username, password, "", 0, GenderEnum.MALE,0.0, 0.0, null)
                )
            } catch (e: Exception){
                println("Error $e")
            }


        }
    }
    fun bookings(){
        viewModelScope.launch {
            try {
                val response = apiService.Bookings(token = token?.getBearerToken())
                bookings = response.body()
            } catch (e:Exception){
                println("Error $e")
            }

        }
    }
}
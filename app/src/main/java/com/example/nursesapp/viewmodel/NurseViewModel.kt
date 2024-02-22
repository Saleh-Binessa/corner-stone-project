package com.example.nursesapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nursesapp.data.booking_data.BookingDetails
import com.example.nursesapp.data.profile.ProfileDetails
import com.example.nursesapp.data.response.TokenResponse
import com.example.nursesapp.data.models.Nurse
import com.example.nursesapp.data.models.User
import com.example.nursesapp.network.NurseApiService
import com.example.nursesapp.network.RetrofitHelper
import com.example.nursesapp.utils.enum.WorkingPeriodEnum
import kotlinx.coroutines.launch
import java.time.LocalDate

class NurseViewModel : ViewModel(){

    private val apiService = RetrofitHelper.getInstance().create(NurseApiService::class.java)
    var token: TokenResponse? by mutableStateOf(null)
    var user: User? by mutableStateOf(null)
    var nurses: List<Nurse>? by mutableStateOf(null)
    var bookings: List<BookingDetails>? by mutableStateOf(null)
    var profile: List<ProfileDetails>? by mutableStateOf(null)


    fun signup(username: String, password: String, name: String, civilId: String, age: String, gender: String, address: String, medicalRecord: String, navigation: () -> Unit) {
        viewModelScope.launch {
            try {
                val response = apiService.signup(User(username, password, name, civilId, age, gender, address,medicalRecord,null))
                token = response.body()
            } catch (e: Exception) {
                println("Error $e")
            } finally {
                if (token != null) {
                    showNurses()
                    navigation()
                }
            }
        }
    }

    fun signin(username: String,password: String, navToNurses: () -> Unit){
        viewModelScope.launch {
            try {
                val response = apiService.signin(User(username, password, "","","", "" , "","",null))
                token = response.body()
                println("TOKEN SIGNIN ${token?.token}")
                navToNurses()
      //          showNurses()
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

    fun bookNurse(){
        viewModelScope.launch {
            try {
                val response = apiService.Bookings(token = token?.getBearerToken())
                bookings = response.body()
            } catch (e:Exception){
                println("Error $e")
            }

        }
    }

    fun showNurses(){
        viewModelScope.launch {
            try {
                val response = apiService.getAllNurses(token = token?.getBearerToken())
                nurses = response.body()
            } catch (e:Exception){
                println("Error $e")
            }

        }
    }
}
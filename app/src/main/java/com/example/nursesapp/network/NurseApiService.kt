package com.example.nursesapp.network

import com.example.nursesapp.data.booking_data.BookingDetails
import com.example.nursesapp.data.booking_data.DateChange
import com.example.nursesapp.data.models.Nurse
import com.example.nursesapp.data.models.User
import com.example.nursesapp.data.response.TokenResponse
import com.example.nursesapp.utils.Constants
import com.example.nursesapp.utils.enum.SpecialityEnum
import com.example.nursesapp.utils.enum.WorkingPeriodEnum
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import java.time.Period
import kotlin.enums.EnumEntries

interface NurseApiService {

    @POST(Constants.signupEndpoint)
    suspend fun signup(@Body user: User): Response<TokenResponse>

    @POST(Constants.signinEndpoint)
    suspend fun signin(@Body user: User): Response<TokenResponse>

    @PUT(Constants.dateEndpoint)
    suspend fun selectDate(
        @Header(Constants.authorization) token: String?,
        @Body dateChange: DateChange
    ): Response<Unit>

    @PUT(Constants.specialityEndpoint)
    suspend fun selectSpeciality(
        @Header(Constants.authorization) token: String?,
        @Body specialityEnum: EnumEntries<SpecialityEnum>
    ): Response<Unit>

    @GET(Constants.showbookingEndpoint)
    suspend fun Bookings(@Header(Constants.authorization) token: String?): Response<List<BookingDetails>>

    @PUT(Constants.updateProfileEndpoints)
    suspend fun updateProfile(@Header(Constants.authorization) token: String?,
                              @Body user: User
    ): Response<Unit>

    @GET(Constants.nursesEndpoint)
    suspend fun getAllNurses(@Header(Constants.authorization) token: String?): Response<List<Nurse>>

    @POST("${Constants.periodEndpoint}/{period}")
    suspend fun period(@Path("period") period: Period,
                       @Header(Constants.authorization) token: String?,
                       @Body workingPeriodEnum: EnumEntries<WorkingPeriodEnum>
    ): Response<Unit>

    @GET(Constants.showProfileEndpoint)
    suspend fun showProfile(@Header(Constants.authorization) token: String?): Response<User>

    fun period(token: String?, workingPeriodEnum: EnumEntries<WorkingPeriodEnum>): Response<Unit>

}
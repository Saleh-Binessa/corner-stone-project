package com.example.nursesapp.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nursesapp.composables.booking.BookingPage
import com.example.nursesapp.composables.booking.NursesListScreen
import com.example.nursesapp.composables.profile.ProfilePage
import com.example.nursesapp.composables.profile.updateProfileScreen
import com.example.nursesapp.composables.signUp.SignUpScreen
import com.example.nursesapp.composables.signin.SignInScreen
import com.example.nursesapp.data.profile.ProfileDetails
import com.example.nursesapp.repository.NurseRepo
import com.example.nursesapp.utils.Routes
import com.example.nursesapp.viewmodel.NurseViewModel
@Composable
fun AppNav() {
    val navController: NavHostController = rememberNavController()
    val nurseViewModel: NurseViewModel = viewModel()
    NavHost(navController = navController, startDestination = Routes.nursesRoute) {

        composable(Routes.signupRoute) {
            SignUpScreen(
                nurseViewModel = nurseViewModel,
                navToNurses = { navController.navigate(Routes.nursesRoute) },

                )
        }
        composable(Routes.nursesRoute) {
            NursesListScreen(
                NurseRepo.dummyNursesList,
                nurseViewModel,
                navigatToBokings = { navController.navigate(Routes.bookingsRoute) })
        }
        composable(Routes.signinRoute) {
            SignInScreen(
                nurseViewModel = nurseViewModel,
                onSignUpClick = {
                    navController.navigate(Routes.signupRoute)
                },
                navigateToHome = {
                    navController.navigate(Routes.homeRoute)
                }
            )
        }

        composable(Routes.nursesRoute) {
            AppNavBar(nurseViewModel = nurseViewModel)
        }

        composable(Routes.homeRoute) {
            AppNavBar(nurseViewModel = nurseViewModel)
        }

    }
}
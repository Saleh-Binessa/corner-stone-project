package com.example.nursesapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nursesapp.composables.booking.NursesListScreen
import com.example.nursesapp.composables.profile.ProfilePage
import com.example.nursesapp.composables.profile.updateProfileScreen
import com.example.nursesapp.composables.signUp.SignUpScreen
import com.example.nursesapp.composables.signin.SignInScreen
import com.example.nursesapp.data.profile.ProfileDetails
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
                onSignInClick = { navController.navigate(Routes.signinRoute) },

                )
        }
        composable(Routes.nursesRoute) {
            NursesListScreen(
                nurseViewModel,
                onNursesClick = { navController.navigate(Routes.signinRoute) })
            navController.navigate(Routes.bookingsRoute)
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


        composable(Routes.updateProfileRoute) {
            updateProfileScreen(
                nurseViewModel = nurseViewModel,
                ProfileDetails("","",0,0.0,0.0,null),
                onUpdateProfileClick = {
                    navController.navigate(Routes.updateProfileRoute)
                })
        }

        composable(Routes.bookingsRoute) {
            AppFrontPage(nurseViewModel = nurseViewModel)
        }

        composable(Routes.homeRoute) {
            AppFrontPage(nurseViewModel = nurseViewModel)
        }

    }
}
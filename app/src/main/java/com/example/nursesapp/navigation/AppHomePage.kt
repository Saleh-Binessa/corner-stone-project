package com.example.nursesapp.navigation

import android.provider.ContactsContract.Profile
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nursesapp.composables.booking.BookingPage
import com.example.nursesapp.composables.booking.NursesListScreen
import com.example.nursesapp.composables.profile.ProfilePage
import com.example.nursesapp.composables.profile.updateProfileScreen
import com.example.nursesapp.data.profile.ProfileDetails
import com.example.nursesapp.utils.Routes
import com.example.nursesapp.viewmodel.NurseViewModel

@Composable
fun AppFrontPage(nurseViewModel: NurseViewModel = viewModel(),) {
    val navController = rememberNavController()

    Scaffold(bottomBar = {
        NavigationBar(modifier = Modifier, Color.DarkGray) {
            NavigationBarItem(selected = true, onClick = {
                navController.navigate(Routes.bookingsRoute)
            }, icon = {
                Text(text = "Bookings")
            })
            NavigationBarItem(selected = true, onClick = {
                navController.navigate(Routes.nursesRoute)
            }, icon = {
                Text(text = "Nurses")
                //Icon(Icons.Filled.AccountBox, contentDescription = "Nurses")
            })
            NavigationBarItem(selected = true, onClick = {
                navController.navigate(Routes.profileRoute)
            }, icon = {
                Text(text = "Profile")
                //Icon(Icons.Filled.AccountBox, contentDescription = "Profile")
            })
        }
    }) {
        NavHost(
            modifier = Modifier.padding(it),
            navController = navController,
            startDestination = Routes.nursesRoute
        ) {

            composable(Routes.nursesRoute) {
                    NursesListScreen(nurseViewModel, onNursesClick = {
                        navController.navigate(Routes.nursesRoute)
                    })
            }

            composable(Routes.bookingsRoute) {
                BookingPage(nurseViewModel, onBookClick = {
                    navController.navigate(Routes.bookingsRoute)
                })
            }

            composable(Routes.profileRoute) {
                ProfilePage(nurseViewModel,onUpdateProfileClick = {navController.navigate(Routes.updateProfileRoute)})
            }
            composable(Routes.updateProfileRoute) {
                updateProfileScreen(nurseViewModel, ProfileDetails("","",0,0.0,0.0,null),onUpdateProfileClick = {
                    navController.navigate(Routes.updateProfileRoute)
                })
            }
        }
    }
}


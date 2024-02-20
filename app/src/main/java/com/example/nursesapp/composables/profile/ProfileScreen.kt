package com.example.nursesapp.composables.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.nursesapp.data.profile.ProfileDetails
import com.example.nursesapp.utils.Routes
import com.example.nursesapp.utils.enum.SpecialityEnum
import com.example.nursesapp.utils.enum.WorkingPeriodEnum
import com.example.nursesapp.viewmodel.NurseViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun ProfilePage(nurseViewModel: NurseViewModel, onUpdateProfileClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Header with Wallet icon and balance
        ProfileHeader(nurseViewModel, onUpdateProfileClick)

        // Divider
        Divider(
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.1f),
            thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        // Profile
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            items(nurseViewModel.profile?: emptyList()) { profileDetails ->
                ProfileItem(nurseViewModel, profileDetails)
                UpdateProfile(nurseViewModel, profileDetails )
            }
        }
    }
}


@Composable
fun ProfileHeader(nurseViewModel: NurseViewModel, onUpdateProfileClick: () -> Unit) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Icon(
                imageVector = Icons.Outlined.Person,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.height(40.dp)
            )

            Text(
                text = "Username: ${nurseViewModel.user?.username ?: null}",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(60.dp))

            Text(
                text = "Age: ${nurseViewModel.user?.age ?: null} ",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            Text(
                text = "Gender: ${nurseViewModel.user?.gender ?: null} ",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            Text(
                text = "Height: ${nurseViewModel.user?.height ?: null} ",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            Text(
                text = "Weight: ${nurseViewModel.user?.weight ?: null} ",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = { onUpdateProfileClick },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(ListItemDefaults.contentColor)
            ) {
                Text(text = "Edit Profile")
            }
        }

    }
}

@Composable
fun ProfileItem(nurseviewModel: NurseViewModel, profile: ProfileDetails) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

//            Icon(
//                imageVector = if (nur.speciality.equals(SpecialityEnum.Adults)) Icons.Default.KeyboardArrowUp else Icons.Default.ArrowDropDown,
//                contentDescription = null,
//                tint = if (profile.workingPeriod.equals(WorkingPeriodEnum.AM)) Color.Green else Color.Red,
//                modifier = Modifier.height(24.dp)
//            )

            Text(
                text = "${profile.token} $",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(8.dp))


        Text(
            text = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(Date()),
            color = Color.Gray,
            fontSize = 14.sp
        )
    }
}
@Composable
fun UpdateProfile(nurseViewModel: NurseViewModel, profile: ProfileDetails) {
    val navController = rememberNavController()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            NavigationBarItem(selected = true, onClick = {
                navController.navigate(Routes.updateProfileRoute)
            }, icon = {
                Icon(Icons.Filled.AccountCircle, contentDescription = "Profile")
            })
        }
    }
    Button(
        onClick = {
            navController.navigate(Routes.updateProfileRoute)
            //nurseViewModel.updateProfile("", "")
        },
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(ListItemDefaults.contentColor)
    ) {
        Text(text = "Edit Profile")
    }
}
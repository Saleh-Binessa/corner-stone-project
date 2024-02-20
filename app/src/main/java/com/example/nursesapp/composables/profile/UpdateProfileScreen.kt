package com.example.nursesapp.composables.profile

import android.annotation.SuppressLint
import android.provider.ContactsContract.Profile
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nursesapp.composables.InputField
import com.example.nursesapp.data.profile.ProfileDetails
import com.example.nursesapp.viewmodel.NurseViewModel


@Composable
fun updateProfileScreen(nurseViewModel: NurseViewModel, profile: ProfileDetails, onUpdateProfileClick: () -> Unit) {


    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
    ) {
        Text(
            text = "Update profile",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        InputField(
            value = username,
            onValueChange = { username = it },
            label = "UserName"
        )
        InputField(
            value = password,
            onValueChange = { password = it },
            label = "Password"
        )

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                onUpdateProfileClick.equals(nurseViewModel.updateProfile(username, password))
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(ListItemDefaults.contentColor)
        ) {
            Text(text = "Update")
        }
    }
}

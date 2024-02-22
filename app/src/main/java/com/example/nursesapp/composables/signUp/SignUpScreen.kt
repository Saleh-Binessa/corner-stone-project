package com.example.nursesapp.composables.signUp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.nursesapp.utils.Routes
import com.example.nursesapp.viewmodel.NurseViewModel

@Composable
fun SignUpScreen(
    nurseViewModel: NurseViewModel, navToNurses: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Text(text = "Bank App", style = MaterialTheme.typography.headlineMedium,color =  Color(0xFF9AD14D))

        Spacer(modifier = Modifier.height(16.dp))

        // double check
        SignUpForm(nurseViewModel, navToNurses)

        Spacer(modifier = Modifier.height(16.dp))
        TextButton(onClick = navToNurses) {
            Text(text = "Already have an account? Sign In")
        }
    }
}
@Composable
fun SignUpForm( nurseViewModel: NurseViewModel, navigation: () -> Unit) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var civilId by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var medicalRecord by remember { mutableStateOf("") }
    var image by remember { mutableStateOf("") }

    Column {
        OutlinedTextField(
            colors = OutlinedTextFieldDefaults.colors(Color.White),
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        OutlinedTextField(
            colors = OutlinedTextFieldDefaults.colors(Color.White),
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        OutlinedTextField(
            colors = OutlinedTextFieldDefaults.colors(Color.White),
            value = civilId,
            onValueChange = { civilId = it },
            label = { Text("Civil ID") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        OutlinedTextField(
            colors = OutlinedTextFieldDefaults.colors(Color.White),
            value = name,
            onValueChange = { name = it },
            label = { Text("Full Name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        OutlinedTextField(
            colors = OutlinedTextFieldDefaults.colors(Color.White),
            value = age,
            onValueChange = { age = it },
            label = { Text("Age") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        OutlinedTextField(
            colors = OutlinedTextFieldDefaults.colors(Color.White),
            value = address,
            onValueChange = { address = it },
            label = { Text("Address") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        OutlinedTextField(
            colors = OutlinedTextFieldDefaults.colors(Color.White),
            value = medicalRecord,
            onValueChange = { medicalRecord = it },
            label = { Text("Medical Record") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { nurseViewModel.signup(username, password, name, civilId, age, gender, address, medicalRecord,
                { navigation() }) },
            modifier = Modifier.fillMaxWidth(),colors = ButtonDefaults.buttonColors(ListItemDefaults.contentColor)
        ) {
            Text(text = "Sign Up")
        }
    }
}
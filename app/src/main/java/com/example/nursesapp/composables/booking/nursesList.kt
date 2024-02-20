package com.example.nursesapp.composables.booking


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.nursesapp.data.models.Nurse
import com.example.nursesapp.viewmodel.NurseViewModel
@Composable
fun NursesListScreen(nurseViewModel: NurseViewModel, onNursesClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        NurseHeader(nurseViewModel)

        // Divider
        Divider(
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.1f),
            thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        // Transactions
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            items(nurseViewModel.bookings ?: emptyList()) { BookingDetails ->
                BookingItem(nurseViewModel, BookingDetails)
            }
        }
    }
}
@Composable
fun NurseHeader(nurseViewModel: NurseViewModel) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Icon(
                imageVector = Icons.Outlined.AccountBox,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.height(40.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

val nurses = nurseViewModel.nurse
            Text(
                text = "Nurses List: ${nurseViewModel.nurse}",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        }
    }
}

@Composable
fun NurseItem(nurseviewModel: NurseViewModel, nurse: Nurse) {

    Card(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = com.example.nursesapp.ui.theme.Yellow),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp,
        ),

        ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .height(150.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically

        ) {
//            AsyncImage(modifier = Modifier.size(100.dp),
//                model = nurse.image,
//                contentDescription = "nurse image")
//               Spacer(modifier = Modifier.width(10.dp))

            Column(
                Modifier
                    .padding(10.dp)
            ) {
                Text(
                    text = "ID: \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + nurse.id.toString(),
                    fontSize = 16.sp
                )
                Text(text = "\nName:\t\t\t\t\t\t\t\t\t\t\t\t" + nurse.name, fontSize = 16.sp)
                Text(
                    text = "Age: \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + nurse.age.toString(),
                    fontSize = 16.sp
                )
                Text(
                    text = "Speciality:\t\t\t\t\t" + nurse.specialized.toString(),
                    fontSize = 16.sp
                )
                Text(text = "Gender:\t\t\t\t\t\t\t\t\t\t\t\t  " + nurse.gender, fontSize = 16.sp)
                Text(
                    text = "Working Time:\t\t\t\t\t\t\t\t\t\t\t\t  " + nurse.workingTime,
                    fontSize = 16.sp
                )

            }
        }
    }
}

package com.example.nursesapp.composables.booking

import android.widget.CalendarView
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.nursesapp.data.models.Nurse
import com.example.nursesapp.ui.theme.Yellow
import com.example.nursesapp.viewmodel.NurseViewModel

//@Composable
//fun DateOfBooking(nurseviewModel: NurseViewModel, onSpiciality: () -> Unit) {
//    LazyColumn(modifier = Modifier) {
//        val nurse = nurseviewModel.nurse
//        items(nurse) {
//            DateItem(nurseviewModel, onSpiciality)
//            Spacer(modifier = Modifier.height(20.dp))
//        }
//    }
//}

@Composable
fun DateItem(nurseviewModel: NurseViewModel = viewModel(), onDateClick: () -> Unit) {

    Card(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Yellow ),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp,
        ),

        ) {
        Row (
            modifier = Modifier
                .padding(10.dp)
                .height(150.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically

        ) {

            Spacer(modifier = Modifier.width(10.dp))

            Column (
                Modifier
                .padding(10.dp)){
                Button(onClick = onDateClick) {
                    Text(text = "submit")
                }
                CalendarView()
            }
        }
    }
}

fun CalendarView() {
    TODO("Not yet implemented")
}

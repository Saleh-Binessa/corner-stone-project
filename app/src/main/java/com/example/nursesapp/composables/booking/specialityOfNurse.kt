package com.example.nursesapp.composables.booking

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.nursesapp.ui.theme.Yellow
import com.example.nursesapp.viewmodel.NurseViewModel

@Composable
fun SpecialityOfNurse(nurseviewModel: NurseViewModel, onWorkingPeriodClick: () -> Unit) {
    LazyColumn(modifier = Modifier) {
        val nurse = nurseviewModel.nurse
        items(nurse) {
           SpecialityItem(nurseviewModel, onWorkingPeriodClick)
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun SpecialityItem(nurseviewModel: NurseViewModel = viewModel(), onWorkingPeriodClick: () -> Unit) {

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
                Button(onClick = onWorkingPeriodClick) {
                    Text(text = "submit")
                }
            }
        }
    }
}
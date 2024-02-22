package com.example.nursesapp.composables.booking


import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nursesapp.data.models.Nurse
import com.example.nursesapp.repository.NurseRepo
import com.example.nursesapp.utils.Routes
import com.example.nursesapp.viewmodel.NurseViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun NursesListScreen(nursesList: List<Nurse>, nurseViewModel: NurseViewModel, navigatToBokings: () -> Unit) {
    var selectedPeriod by remember {
        mutableStateOf("AM")}

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 2.dp),
            horizontalArrangement = Arrangement.spacedBy(1.dp)
        )
        {
            items(listOf("AM", "PM", "Full Time"))
            { period ->
                Button(
                    onClick = { /*Handle button click*/ },
//                    { selectedPeriod = period }
                    modifier = Modifier
                        .padding(end = 6.dp)
                        .height(35.dp)
                        .width(121.dp)

                ) {
                    Text(period)
                }
            }
        }

        LazyRow(modifier = Modifier.padding(horizontal = 16.dp, vertical = 1.dp))
        {
            items(listOf("Female", "Male"))
            { speciality ->
                Button(
                    onClick = { /*Handle button click*/ },
                    modifier = Modifier
                        .padding(end = 6.dp)
                        .height(35.dp)
                        .width(185.dp)
                ) {
                    Text(speciality)


                }
            }
        }

        LazyRow(modifier = Modifier.padding(horizontal = 16.dp, vertical = 2.dp))
        {
            items(listOf("Cardio", "ER", "ICU", "Surgery", "Oncology"))
            { speciality ->
                Button(
                    onClick = { /*Handle button click*/ },
                    Modifier.padding(end = 6.dp)
                ) {
                    Text(speciality)

                }
            }
        }



        // Divider
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.1f)
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            items(nursesList) {
                NurseHeader(
                    nurseId = it.id.toInt(),
                    nurseName = it.name,
                    nurseSpeciality = it.specialized.typeName,
                    nurseGender =  it.gender.typeName,
                    workingTime = it.workingTime.typeName
                )
            }
        }
    }
}
@Composable
fun NurseHeader(nurseId: Int, nurseName: String, nurseSpeciality: String, nurseGender: String, workingTime: String) {
    val nursesData = NurseRepo.dummyNursesList

    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .fillMaxWidth()
            .height(190.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Name: ${nurseName}",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            Text(
                text = "Speciality: ${nurseSpeciality}",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            Text(
                text = "Gender: ${nurseGender} ",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            Text(
                text = "Working Time: ${workingTime} ",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            Button(
                onClick = {
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(ListItemDefaults.contentColor)
            ) {
                Text(text = "Book")
            }
        }

    }
}


//@Composable
//fun BookNurse(nurseViewModel: NurseViewModel, nurse: Nurse) {
//    val navController = rememberNavController()
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp)
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//
//    Button(
//        onClick = {
//            navController.navigate(Routes.signinRoute)
//        },
//        modifier = Modifier.fillMaxWidth(),
//        colors = ButtonDefaults.buttonColors(ListItemDefaults.contentColor)
//    ) {
//        Text(text = "Book")
//    }
//        }
//    }
//}

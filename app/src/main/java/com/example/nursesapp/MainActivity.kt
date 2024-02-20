package com.example.nursesapp

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.nursesapp.navigation.AppNav
import com.example.nursesapp.ui.theme.NurseAPITheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NurseAPITheme() {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNav()
                }
            }
        }
    }
}


//        @RequiresApi(Build.VERSION_CODES.N)
//        fun clickDataPicker(view: View) {
//            val c = Calendar.getInstance()
//            val year = c.get(Calendar.YEAR)
//            val month = c.get(Calendar.MONTH)
//            val day = c.get(Calendar.DAY_OF_MONTH)
//
//            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener
//            { view, year, monthOfYear, dayOfMonth ->
//                Toast.makeText(
//                    this, """$dayOfMonth - ${monthOfYear + 1} -
//                            $year""", Toast.LENGTH_LONG
//                ).show()
//
//            }, year, month, day
//            )
//            dpd.show()
//        }

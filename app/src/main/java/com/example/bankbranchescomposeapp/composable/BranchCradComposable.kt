package com.example.bankbranchescomposeapp.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.lang.reflect.Type


@Composable
fun BranchCard(id: Int,
               name: String,
               address: String,
               phone: String,
               hours: String,
               location: String,
               imageUri: Int,
               branchType: Type,
               modifier: Modifier = Modifier
) {
    Card(colors = CardDefaults.cardColors(containerColor = Color.DarkGray, contentColor = Color.White),
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column {
            Row (modifier = Modifier
                .fillMaxWidth().padding(8.dp)
                , horizontalArrangement = Arrangement.SpaceBetween){
                Text(text = "Name: $name ")
                Text(text = "Address: $address")
            }
            Row (modifier = Modifier
                .fillMaxWidth().padding(8.dp), horizontalArrangement = Arrangement.SpaceBetween){
                Text(text = "Phone:   $phone ")
                Text(text = "Hours: $hours ")
            }
            Row (modifier = Modifier
                .fillMaxWidth().padding(8.dp), horizontalArrangement = Arrangement.SpaceBetween){
                Text(text = "location: $ $location")
                Text(text = "imageUri: $ $imageUri ")
            }
        }
    }
}
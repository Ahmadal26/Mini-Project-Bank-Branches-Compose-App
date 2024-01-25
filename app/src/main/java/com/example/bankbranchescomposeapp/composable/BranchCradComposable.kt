package com.example.bankbranchescomposeapp.composable

import android.graphics.drawable.Drawable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bankbranchescomposeapp.Data.BranchType
import com.example.bankbranchescomposeapp.ui.theme.BankBranchesComposeAppTheme
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
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(5.dp),
        colors = CardDefaults.cardColors(containerColor =
        MaterialTheme.colorScheme.primaryContainer
        )
    )
    {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Column {
                Text(text = "$imageUri")
            }
            Column {
            Text(text = "KFH - $name Branch", fontWeight = FontWeight.Bold)
            Text(text = hours, textAlign = TextAlign.Center )
            }

            Column {
                Text(text = "+965 $phone")
//                Text(text = address)
            }
        }
    }
}




//    Card(colors = CardDefaults.cardColors(containerColor = Color.DarkGray, contentColor = Color.White),
//        modifier = modifier
//            .fillMaxWidth()
//            .padding(8.dp)
//    ) {
//        Column {
//            Row (modifier = Modifier
//                .fillMaxWidth().padding(8.dp)
//                , horizontalArrangement = Arrangement.SpaceBetween){
//                Text(text = "Name: $name ")
//                Text(text = "Address: $address")
//            }
//            Row (modifier = Modifier
//                .fillMaxWidth().padding(8.dp), horizontalArrangement = Arrangement.SpaceBetween){
//                Text(text = "Phone:   $phone ")
//                Text(text = "Hours: $hours ")
//            }
//            Row (modifier = Modifier
//                .fillMaxWidth().padding(8.dp), horizontalArrangement = Arrangement.SpaceBetween){
//                Text(text = "location: $ $location")
//                Text(text = "imageUri: $ $imageUri ")
//            }
//        }
//    }
//}

@Preview(showBackground = true)
@Composable
fun StatementCardPreview() {
    BankBranchesComposeAppTheme {
        BranchCard(
            1,"Sharq",
            "Sharq","678944",
            "7 AM - 3 PM",
            "gggh", imageUri = 8,
            BranchType.ONLINEBANCH
        )
    }}




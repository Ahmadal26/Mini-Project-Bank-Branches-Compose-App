package com.example.bankbranchescomposeapp.composable

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bankbranchescomposeapp.Data.BranchData
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
               navController: NavController,
               modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(5.dp).clickable {

                navController.navigate("branchDetails/${id}")


            },
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

            }
        }
    }
}





//@Preview(showBackground = true)
//@Composable
//fun StatementCardPreview() {
//    BankBranchesComposeAppTheme {
//        BranchCard(
//            1,"Sharq",
//            "Sharq","678944",
//            "7 AM - 3 PM",
//            "gggh", imageUri = 8,
//            BranchType.ONLINEBANCH
//        )
//    }}




package com.example.bankbranchescomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bankbranchescomposeapp.Data.BranchData
import com.example.bankbranchescomposeapp.Repo.BranchesRepo
import com.example.bankbranchescomposeapp.composable.BranchCard
import com.example.bankbranchescomposeapp.ui.theme.BankBranchesComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val branchesData = BranchesRepo.dummyBranchesList
        setContent {
            BankBranchesComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BranchesList(branchesData)
                }
            }
        }
    }
}

@Composable
fun BranchesList(branchData: List<BranchData>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = Modifier) {
        items(branchData){
            BranchCard(
                id = 0,
                name = it.name,
                address = it.address,
                phone = it.phone,
                hours = it.hours,
                location = it.location,
                imageUri = it.imageUri,
                branchType = it.branchType
        )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BankBranchesComposeAppTheme {
        BranchesList(branchData = BranchesRepo.dummyBranchesList)
    }
}
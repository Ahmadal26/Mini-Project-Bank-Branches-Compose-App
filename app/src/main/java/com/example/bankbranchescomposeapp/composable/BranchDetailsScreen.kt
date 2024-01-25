package com.example.bankbranchescomposeapp.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.bankbranchescomposeapp.Data.BranchData

@Composable
fun BranchDetailsScreen(branchData: BranchData) {

    Column {
        Text(text = "Branch Name: ${branchData.name}")
        Text(text = "Address: ${branchData.address}")

    }
}
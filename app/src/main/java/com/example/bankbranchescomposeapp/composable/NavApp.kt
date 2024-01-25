package com.example.bankbranchescomposeapp.composable



import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bankbranchescomposeapp.BranchesList
import com.example.bankbranchescomposeapp.Data.BranchData


@Composable
fun NavApp(branchList: List<BranchData>,navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "branchList"
    ) {
        composable("branchList") {
            BranchesList(navController = navController, branchData = branchList)
        }

        composable("branchDetails/{branchId}") { // Update route to include branchId
            val branchId = it.arguments?.getString("branchId")?.toInt()
            val selectedBranch = branchList.find { it.id == branchId }
            if (selectedBranch != null) {
                BranchDetailsScreen(branchData = selectedBranch)
            } else {
                // Handle error or show a placeholder screen
            }
        }
    }
}
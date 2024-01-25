package com.example.bankbranchescomposeapp.composable



import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bankbranchescomposeapp.BranchesList
import com.example.bankbranchescomposeapp.Data.BranchData
import com.example.bankbranchescomposeapp.Data.BranchType
import com.example.bankbranchescomposeapp.R


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

                val newBranch = BranchData(
                    1, "Auto",
                    "Shuwaikh", "678944",
                    "9 AM - 7 PM",
                    "https://maps.app.goo.gl/oim8b69GzSodp2SQ9?g_st=ic", imageUri = R.drawable.kfhauto,
                    BranchType.ONLINEBANCH
                )

                BranchDetailsScreen(selectedBranch)
            } else {
                // Handle error or show a placeholder screen
            }
        }
    }
}
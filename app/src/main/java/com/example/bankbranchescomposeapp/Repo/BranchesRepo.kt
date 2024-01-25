package com.example.bankbranchescomposeapp.Repo

import com.example.bankbranchescomposeapp.Data.BranchData
import com.example.bankbranchescomposeapp.Data.BranchType
import com.example.bankbranchescomposeapp.R

class BranchesRepo {
    companion object {
        var dummyBranchesList = listOf(
            BranchData(
                1, "KFH Auto",
                "Shuwaikh", "678944",
                "9 AM - 7 PM",
                "https://maps.app.goo.gl/oim8b69GzSodp2SQ9?g_st=ic", imageUri = R.drawable.kfhauto,
                BranchType.ONLINEBANCH
            ),

            BranchData(
                3, "AlKhaldiya Branch",
                "Khaldiya", "253889",
                "7 AM - 3 PM",
                "https://maps.app.goo.gl/oim8b69GzSodp2SQ9?g_st=ic", imageUri = R.drawable.kfh,
                BranchType.ONSITEBRANCH
            ),

            BranchData(
                2, "Kaifan Branch",
                "Kaifan", "365432",
                "7 AM - 3 PM",
                "https://maps.app.goo.gl/oim8b69GzSodp2SQ9?g_st=ic", imageUri = 6,
                BranchType.ONSITEBRANCH
            ),

            BranchData(
                9, "AlShamiya Branch",
                "Shamiya", "678944",
                "7 AM - 3 PM",
                "https://maps.app.goo.gl/oim8b69GzSodp2SQ9?g_st=ic", imageUri = 10,
                BranchType.ONSITEBRANCH
            )

        )

    }
}
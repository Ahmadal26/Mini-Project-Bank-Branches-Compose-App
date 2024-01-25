package com.example.bankbranchescomposeapp.Repo

import com.example.bankbranchescomposeapp.Data.BranchData
import com.example.bankbranchescomposeapp.Data.BranchType

class BranchesRepo {
    companion object {
        var dummyBranchesList = listOf(
            BranchData(
                1, "Sharq",
                "Sharq", "678944",
                "7 AM - 3 PM",
                "gggh", imageUri = 8,
                BranchType.ONSITEBRANCH
            ),

            BranchData(
                3, "Khaldiya",
                "Khaldiya", "253889",
                "7 AM - 3 PM",
                "gggh", imageUri = 9,
                BranchType.ONLINEBANCH
            ),

            BranchData(
                2, "Kaifan",
                "Kaifan", "365432",
                "7 AM - 3 PM",
                "gggh", imageUri = 6,
                BranchType.ONLINEBANCH
            ),

            BranchData(
                9, "Shamiya",
                "Shamiya", "678944",
                "7 AM - 3 PM",
                "gggh", imageUri = 10,
                BranchType.ONSITEBRANCH
            )

        )

    }
}
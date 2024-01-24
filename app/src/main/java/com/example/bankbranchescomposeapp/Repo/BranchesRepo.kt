package com.example.bankbranchescomposeapp.Repo

import com.example.bankbranchescomposeapp.Data.BranchData
import com.example.bankbranchescomposeapp.Data.BranchType

class BranchesRepo {
    companion object {
        var dummyBranchesList = listOf(
            BranchData(1,"sal","yugd","678944","1-5","gggh",9,BranchType.ONLINEBANCH)
        )
    }
}
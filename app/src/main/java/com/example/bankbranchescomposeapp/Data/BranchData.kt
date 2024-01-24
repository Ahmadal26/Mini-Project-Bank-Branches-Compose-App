package com.example.bankbranchescomposeapp.Data

import java.lang.reflect.Type

data class BranchData(

val id : Int,
val name : String,
val address : String,
val phone: String,
val hours: String,
val location: String,
val imageUri: Int,
val branchType: Type
)


enum class BranchType: Type{
    ONLINEBANCH,
    ONSITEBRANCH

}
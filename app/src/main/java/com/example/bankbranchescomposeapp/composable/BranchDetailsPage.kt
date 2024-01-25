//package com.example.bankbranchescomposeapp.composable
//
//import android.annotation.SuppressLint
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.*
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.unit.dp
//import com.example.bankbranchescomposeapp.Data.BranchData
//import com.example.bankbranchescomposeapp.R
//
//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun BranchDetailsPage(branch: BranchData, onBackClick: () -> Unit) {
//    Scaffold(
//        topBar = {
//            Column(
//                modifier = Modifier.fillMaxWidth(),
//                verticalArrangement = Arrangement.Top
//            ) {
//                Box(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(100.dp)
//                        .clip(shape = MaterialTheme.shapes.small),
//                    contentAlignment = Alignment.TopEnd
//                ) {
//                    Image(
//                        painter = painterResource(id = R.drawable.kfh),
//                        contentDescription = null,
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(100.dp)
//                            .clip(shape = MaterialTheme.shapes.small),
//                        contentScale = ContentScale.Crop)
//
//                }
//
//                TopAppBar(
//                    title = { Text(text = branch.name) },
//                    navigationIcon = {
//                        IconButton(onClick = { onBackClick.invoke() }) {
//                            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
//                        }
//                    },
//                    actions = {
//                        IconButton(onClick = { /* Handle menu click */ }) {
//                        }
//                    }
//                )
//            }
//        },
//        content = {
//            // Your content goes here
//        }
//    )
//}
//
//

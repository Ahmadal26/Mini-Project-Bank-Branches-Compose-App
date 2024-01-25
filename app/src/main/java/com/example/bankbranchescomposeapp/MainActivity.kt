package com.example.bankbranchescomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
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
        Image(
            painter = rememberAsyncImagePainter("https://www.example.com/image.jpg"),
            contentDescription = null,
            modifier = Modifier.size(128.dp)
        )
}
@Composable
fun FavoriteButton(
    modifier: Modifier = Modifier,
    color: Color = Color.White
) {

    var isFavorite by remember { mutableStateOf(false) }

    IconToggleButton(
        checked = isFavorite,
        onCheckedChange = {
            isFavorite = !isFavorite
        }
    ) {
        Icon(
            tint = color,

            imageVector = if (isFavorite) {
                Icons.Filled.Favorite
            } else {
                Icons.Default.FavoriteBorder
            },
            contentDescription = null
        )
    }
}
@Composable
fun MyComponent(
    imageUrl:String,
    modifier: Modifier = Modifier,
) {
    Box(contentAlignment = Alignment.TopEnd) {

        Image(
            contentScale = ContentScale.None,
            modifier = modifier,
            painter = rememberAsyncImagePainter(imageUrl),
            contentDescription = null
        )

        FavoriteButton(modifier = Modifier.padding(12.dp))

    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BankBranchesComposeAppTheme {
        BranchesList(branchData = BranchesRepo.dummyBranchesList)
    }
}








//
//package com.example.newcanaryproject
//
//import android.annotation.SuppressLint
//import android.content.Context
//import android.os.Bundle
//
//import android.widget.Toast
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.ExperimentalFoundationApi
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.*
////import androidx.compose.foundation.lazy.GridCells
////import androidx.compose.foundation.lazy.LazyVerticalGrid
//import androidx.compose.material.*
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.material3.TopAppBar
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.unit.dp
//import coil.compose.rememberAsyncImagePainter
//import com.example.bankbranchescomposeapp.ui.theme.BankBranchesComposeAppTheme
//import java.lang.reflect.Type
//
//
//class MainActivity : ComponentActivity() {
//
//    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//    @OptIn(ExperimentalMaterial3Api::class)
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            BankBranchesComposeAppTheme {
//                // on below line we are specifying
//                // background color for our application
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    //color = MaterialTheme.colors.background
//                ) {
//                    // on below line we are specifying theme as scaffold.
//                    Scaffold(
//                        // in scaffold we are specifying top bar.
//                        topBar = {
//                            // inside top bar we are specifying background color.
//                            TopAppBar(
//                                // along with that we are specifying title for our top bar.
//                                title = {
//                                    // in the top bar we are specifying tile as a text
//                                    Text(
//                                        // on below line we are specifying
//                                        // text to display in top app bar.
//                                        text = "Image From URL",
//
//                                        // on below line we are specifying
//                                        // modifier to fill max width.
//                                        modifier = Modifier.fillMaxWidth(),
//
//                                        // on below line we are
//                                        // specifying text alignment.
//                                        textAlign = TextAlign.Center,
//
//                                        // on below line we are
//                                        // specifying color for our text.
//                                        color = Color.White
//                                    )
//                                }
//                            )
//                        }
//                    ) {
//                        imageFromURL()
//                    }
//                }
//            }
//        }
//    }
//}
//
//// on below line we are creating an
//// image url function for our image view.
//@Composable
//fun imageFromURL() {
//    // on below line we are creating a column,
//    Column(
//        // in this column we are adding modifier
//        // to fill max size, mz height and max width
//        modifier = Modifier
//            .fillMaxSize()
//            .fillMaxHeight()
//            .fillMaxWidth()
//            // on below line we are adding
//            // padding from all sides.
//            .padding(10.dp),
//        // on below line we are adding vertical
//        // and horizontal arrangement.
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        // on below line we are adding image for our image view.
//        Image(
//            // on below line we are adding the image url
//            // from which we will be loading our image.
//            painter = rememberAsyncImagePainter("https://media.geeksforgeeks.org/wp-content/uploads/20210101144014/gfglogo.png"),
//
//            // on below line we are adding content
//            // description for our image.
//            contentDescription = "gfg image",
//
//            // on below line we are adding modifier for our
//            // image as wrap content for height and width.
//            modifier = Modifier
//                .wrapContentSize()
//                .wrapContentHeight()
//                .wrapContentWidth()
//        )
//    }
//}

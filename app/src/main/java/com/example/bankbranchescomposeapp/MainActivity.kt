package com.example.bankbranchescomposeapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.BoxScopeInstance.align
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.ColumnScopeInstance.align
//import androidx.compose.foundation.layout.FlowRowScopeInstance.align
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Place
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
import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.tooling.data.EmptyGroup.location
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.bankbranchescomposeapp.Data.BranchData
import com.example.bankbranchescomposeapp.Repo.BranchesRepo
import com.example.bankbranchescomposeapp.composable.BranchCard
import com.example.bankbranchescomposeapp.composable.BranchDetailsPage
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

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    // Upper part with top bar and KFH image
                    TopBarWithImage()
                    Spacer(modifier = Modifier.height(8.dp))

                    BranchesList(branchesData)
                }
//                    BranchData(
//                        BranchDataState = remember { mutableStateOf(branchesData) },
//                        onBranchClick = { branchId ->
//                            currentBranch = branchesData.find { it.id == branchId }
//                        },
//                        onSortClick = {
//                            branchesData = branchesData.sortedBy { it.name }
//                        }
//                    )
//
//                    if (currentBranch != null) {
//                        BranchDetailsPage(branch = currentBranch!!, onBackClick = {
//                            currentBranch = null
//                        })
//                    }
                }

            }
        }
    }
}
    //@OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TopBarWithImage() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.kfh),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()

                    .height(80.dp),
                contentScale = ContentScale.None
            )
        }
    }

@Composable
fun BranchesList(branchData: List<BranchData>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = Modifier) {
        items(branchData) {
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
@Composable

fun BranchCard(branch: BranchData) {
    // Your existing BranchCard composable logic here
    // Display a clickable icon to open Google Maps with the location
    Icon(
        imageVector = Icons.Filled.Place,
        contentDescription = null,
        modifier = Modifier
            .clickable {
                openGoogleMaps(branch.location, activity = ComponentActivity())
            }
            .padding(8.dp)
    )
}
fun openGoogleMaps(location: String, activity: ComponentActivity) {
    // Create a URI for the Google Maps location
    val gmmIntentUri = Uri.parse("geo:0,0?q=$location")
    // Create an Intent with the ACTION_VIEW action
    val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
    // Set the package for the intent to Google Maps
    mapIntent.setPackage("com.google.android.apps.maps")
    // Start the intent using the activity's launcher
    activity.startActivity(mapIntent)
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
    imageUrl: String,
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

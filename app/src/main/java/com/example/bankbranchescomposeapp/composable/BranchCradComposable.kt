package com.example.bankbranchescomposeapp.composable

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.bankbranchescomposeapp.Data.BranchData
import com.example.bankbranchescomposeapp.Data.BranchType
import com.example.bankbranchescomposeapp.FavoriteButton
import com.example.bankbranchescomposeapp.R
import com.example.bankbranchescomposeapp.ui.theme.BankBranchesComposeAppTheme
import java.lang.reflect.Type


@Composable
fun BranchCard(
    id: Int,
    name: String,
    address: String,
    phone: String,
    hours: String,
    location: String,
    imageUri: Int,
    branchType: Type,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(5.dp),
        colors = CardDefaults.cardColors(
            containerColor =
            MaterialTheme.colorScheme.primaryContainer
        )
    )
    {
        FavoriteButton(modifier = Modifier
            .padding(8.dp)
            .align(Alignment.End))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
//
//            Column {
//            }

            Column (modifier = Modifier.padding(3.dp)){
                Text(text = "KFH - $name", fontWeight = FontWeight.Bold)
                Text(text = hours, textAlign = TextAlign.Center)
            }

            Column {
                //Text(text = "+965 $phone")
                //Text(text = location)
            }
            Image(
                painter = painterResource(id = R.drawable.kfhauto),
                contentDescription = null,
                modifier = Modifier.size(150.dp)
            )
        }
    }
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
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@OptIn(ExperimentalMaterial3Api::class)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BranchDetailsPage(branch: BranchData, onBackClick: () -> Unit) {
    Scaffold(
        topBar = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Top
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .clip(shape = MaterialTheme.shapes.small),
                    contentAlignment = Alignment.TopEnd
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.kfh),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .clip(shape = MaterialTheme.shapes.small),
                        contentScale = ContentScale.Crop)

                }

                TopAppBar(
                    title = { Text(text = branch.name) },
                    navigationIcon = {
                        IconButton(onClick = { onBackClick.invoke() }) {
                            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                        }
                    },
                    actions = {
                        IconButton(onClick = { /* Handle menu click */ }) {
                        }
                    }
                )
            }
        },
        content = {
            // Your content goes here
        }
    )
}


@Preview(showBackground = true)
@Composable
fun StatementCardPreview() {
    BankBranchesComposeAppTheme {
        BranchCard(
            1, "Sharq",
            "Sharq", "678944",
            "7 AM - 3 PM",
            "gggh", imageUri = 8,
            BranchType.ONLINEBANCH
        )
    }
}


package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.PuppiesProvider
import com.example.androiddevchallenge.ui.model.Gender

@ExperimentalFoundationApi
@Composable
fun PuppyDetailScreen(
    navController: NavHostController,
    puppyId: Int
) {
    val puppy = PuppiesProvider.getPuppy(puppyId)
    Box(contentAlignment = Alignment.Center) {
        Column(modifier = Modifier.fillMaxSize()) {
            Box {
                puppy.image?.let {
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.5f),
                        painter = painterResource(id = it),
                        contentDescription = "Puppy",
                        contentScale = ContentScale.Crop
                    )
                }
                IconButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.padding(top = 20.dp, start = 20.dp)
                ) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
                }
            }
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(65.dp))
                Row(modifier = Modifier.padding(top = 24.dp, start = 16.dp, end = 16.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.dummy_pic),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .width(60.dp)
                            .height(60.dp)
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(
                                text = "Peter Parker",
                                fontSize = 22.sp,
                                color = Color.Black
                            )
                            Text(
                                modifier = Modifier.padding(top = 4.dp),
                                text = "Owner",
                                fontSize = 20.sp,
                                color = Color.Gray
                            )
                        }
                        Text(
                            text = "01.01.2021",
                            fontSize = 14.sp,
                            color = Color.Gray,
                            textAlign = TextAlign.Center
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                val lipsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus eu elit sed mi posuere convallis. Aenean sed arcu vel turpis posuere viverra. Sed velit purus, iaculis eu euismod et, malesuada sed arcu. Donec semper gravida leo id egestas. Donec sed tortor tempor mi consequat viverra in semper orci."
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = lipsum,
                    textAlign = TextAlign.Justify
                )
                Button(
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .width(150.dp),
                    onClick = {},
                    shape = MaterialTheme.shapes.small.copy(CornerSize(24.dp)),
                    contentPadding = PaddingValues(16.dp)
                ) {
                    Text(text = "Adopt")
                }
            }
        }
        Card(
            shape = MaterialTheme.shapes.medium.copy(CornerSize(24.dp)),
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp)
                .fillMaxWidth()
                .height(130.dp)
        ) {
            Column(modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 24.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = puppy.name, fontSize = 22.sp, color = Color.Black, fontWeight = FontWeight.Bold)
                    Icon(
                        imageVector = if (puppy.gender == Gender.MALE) {
                            Icons.Filled.Male
                        } else {
                            Icons.Filled.Female
                        },
                        contentDescription = "", tint = Color.Black
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = puppy.breed.name, fontSize = 16.sp, color = Color.Black)
                    Row {
                        Icon(imageVector = Icons.Filled.QueryBuilder, contentDescription = "", tint = Color.White)
                        Text(
                            text = "${puppy.age} years old",
                            fontSize = 16.sp,
                            color = Color.Black
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.LocationOn,
                        contentDescription = "", tint = Color.Black
                    )
                    Text(
                        text = "3rd St, Lekki, Lagos, Mars",
                        fontSize = 16.sp,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}

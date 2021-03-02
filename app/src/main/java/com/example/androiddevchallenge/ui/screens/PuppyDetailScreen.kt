/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Female
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Male
import androidx.compose.material.icons.filled.QueryBuilder
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

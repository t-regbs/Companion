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
package com.example.androiddevchallenge.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Female
import androidx.compose.material.icons.filled.Male
import androidx.compose.material.icons.filled.QueryBuilder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.data.PuppiesProvider
import com.example.androiddevchallenge.ui.model.Gender
import com.example.androiddevchallenge.ui.model.Puppy
import com.example.androiddevchallenge.ui.theme.CompanionTheme

@Composable
fun PuppyCard(
    modifier: Modifier = Modifier,
    puppy: Puppy,
    onClick: () -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.medium.copy(CornerSize(24.dp)),
        modifier = modifier
            .width(180.dp)
            .height(220.dp)
            .clickable(onClick = onClick),
        elevation = 8.dp
    ) {
        Box {
            puppy.image?.let {
                Image(
                    painter = painterResource(id = it),
                    contentDescription = "Puppy",
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .alpha(0.9f),
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier
                    .padding(top = 145.dp)
                    .background(Color.Black.copy(alpha = 0.1f))
                    .padding(start = 16.dp, bottom = 2.dp)
            ) {
                Text(text = puppy.name, fontSize = 22.sp, color = Color.White, fontWeight = Bold)
                Text(text = puppy.breed.name, fontSize = 16.sp, color = Color.White)
                Row {
                    Row(modifier = Modifier.padding(end = 8.dp)) {
                        Icon(imageVector = Icons.Filled.QueryBuilder, contentDescription = "", tint = Color.White)
                        Text(
                            text = "${puppy.age} yrs",
                            fontSize = 16.sp,
                            color = Color.White
                        )
                    }
                    Row {
                        Icon(
                            imageVector = if (puppy.gender == Gender.MALE) {
                                Icons.Filled.Male
                            } else {
                                Icons.Filled.Female
                            },
                            contentDescription = "", tint = Color.White
                        )
                        Text(
                            text = if (puppy.gender == Gender.MALE) "boy" else "girl",
                            fontSize = 16.sp,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previewPuppy() {
    CompanionTheme {
        val puppy = PuppiesProvider.randomPuppy()
        PuppyCard(puppy = puppy) { }
    }
}

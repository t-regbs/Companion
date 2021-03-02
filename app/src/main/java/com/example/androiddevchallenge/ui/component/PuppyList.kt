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

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.BackdropScaffoldDefaults.frontLayerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.Navigation
import com.example.androiddevchallenge.data.PuppiesProvider
import com.example.androiddevchallenge.ui.model.Puppy
import com.example.androiddevchallenge.ui.theme.CompanionTheme

@ExperimentalFoundationApi
@Composable
fun PuppyList(
    puppies: List<Puppy>,
    navController: NavHostController
) {
    Surface(
        Modifier
            .fillMaxSize()
            .padding(bottom = 16.dp),
        shape = frontLayerShape,
    ) {
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(all = 12.dp),
            content = {
                itemsIndexed(puppies) { index, puppy ->
                    val modifier = if (index % 2 != 0) {
                        Modifier.padding(top = 40.dp, start = 8.dp, end = 8.dp, bottom = 8.dp)
                    } else {
                        Modifier.padding(8.dp)
                    }
                    PuppyCard(
                        modifier = modifier,
                        puppy = puppy,
                        onClick = {
                            navController.navigate(Navigation.buildPuppyDetailPath(puppyId = puppy.id))
                        }
                    )
                }
            }
        )
    }
}

@ExperimentalFoundationApi
@Preview(showBackground = false)
@Composable
fun PetsListPreview() {
    CompanionTheme {
        PuppyList(
            PuppiesProvider.getAllPuppies(),
            rememberNavController()
        )
    }
}

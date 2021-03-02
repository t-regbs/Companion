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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.extension.getPuppyIdArgument
import com.example.androiddevchallenge.ui.screens.PuppyDetailScreen
import com.example.androiddevchallenge.ui.screens.PuppyListScreen
import com.example.androiddevchallenge.ui.theme.CompanionTheme

class MainActivity : AppCompatActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompanionTheme {
                BuildNavGraph()
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
private fun BuildNavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Navigation.NAV_PUPPY_LIST
    ) {
        composable(route = Navigation.NAV_PUPPY_LIST) {
            PuppyListScreen(navController = navController)
        }
        composable(
            route = Navigation.NAV_PUPPY_DETAIL,
            arguments = listOf(
                navArgument(Navigation.NAV_PUPPY_DETAIL_ARGUMENT) {
                    type = NavType.IntType
                }
            )
        ) {
            PuppyDetailScreen(
                navController = navController,
                puppyId = it.getPuppyIdArgument(Navigation.NAV_PUPPY_DETAIL_ARGUMENT)
            )
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    CompanionTheme {
//        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    CompanionTheme(darkTheme = true) {
//        MyApp()
    }
}

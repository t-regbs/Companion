package com.example.androiddevchallenge.extension

import androidx.navigation.NavBackStackEntry
import com.example.androiddevchallenge.Navigation

fun NavBackStackEntry.getPuppyIdArgument(key: String) =
    arguments?.getInt(Navigation.NAV_PUPPY_DETAIL_ARGUMENT)?.let {
        it
    } ?: error("$key not provided")

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
import com.example.androiddevchallenge.data.PuppiesProvider
import com.example.androiddevchallenge.ui.model.Puppy
import com.example.androiddevchallenge.ui.theme.CompanionTheme

@ExperimentalFoundationApi
@Composable
fun PuppyList(
    puppies: List<Puppy>
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
                    PuppyCard(modifier = modifier, puppy = puppy, onClick = { })
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
            PuppiesProvider.getAllPuppies()
        )
    }
}

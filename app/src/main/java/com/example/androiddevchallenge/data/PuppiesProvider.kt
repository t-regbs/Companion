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
package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.model.*

object PuppiesProvider {
    val breeds = mutableListOf(
        Breed(
            breedId = 1,
            name = "Terrier",
        ),
        Breed(
            breedId = 2,
            name = "Lhasa",
        ),
        Breed(
            breedId = 3,
            name = "Chihuahua",
        ),
        Breed(
            breedId = 4,
            name = "Affenpinscher",
        ),
        Breed(
            breedId = 5,
            name = "Shiba",
        ),
    )

    private val puppies = listOf(
        Puppy(
            id = 1,
            name = "Titi",
            image = R.drawable.titi,
            gender = Gender.FEMALE,
            breed = breeds[0],
            age = 9,
            icon = R.drawable.ic_dog,
        ),
        Puppy(
            id = 2,
            name = "Oba",
            image = R.drawable.oba,
            gender = Gender.MALE,
            breed = breeds[2],
            age = 2,
            icon = R.drawable.ic_dog,
        ),
        Puppy(
            id = 3,
            name = "Tunji",
            image = R.drawable.tunji,
            gender = Gender.MALE,
            breed = breeds[3],
            age = 4,
            icon = R.drawable.ic_dog,
        ),
        Puppy(
            id = 4,
            name = "Motun",
            image = R.drawable.motun,
            gender = Gender.FEMALE,
            breed = breeds[4],
            age = 1,
            icon = R.drawable.ic_dog,
        ),
        Puppy(
            id = 5,
            name = "Ayo",
            image = R.drawable.ayo,
            gender = Gender.FEMALE,
            breed = breeds[1],
            age = 1,
            icon = R.drawable.ic_dog,
        ),
        Puppy(
            id = 6,
            name = "Femi",
            image = R.drawable.femi,
            gender = Gender.MALE,
            breed = breeds[2],
            age = 3,
            icon = R.drawable.ic_dog,
        ),
        Puppy(
            id = 7,
            name = "Bolaji",
            image = R.drawable.bolaji,
            gender = Gender.MALE,
            breed = breeds[0],
            age = 4,
            icon = R.drawable.ic_dog,
        ),
        Puppy(
            id = 8,
            name = "Olamide",
            image = R.drawable.olamide,
            gender = Gender.MALE,
            breed = breeds[4],
            age = 2,
            icon = R.drawable.ic_dog,
        ),
    )

    private val petTypes = listOf(
        Pet(
            id = PetId("all"),
            name = "All",
            icon = R.drawable.ic_pawn
        ),
        Pet(
            id = PetId("dog"),
            name = "Dog",
            icon = R.drawable.ic_dog
        ),
        Pet(
            id = PetId("cat"),
            name = "Cat",
            icon = R.drawable.ic_cat
        ),
        Pet(
            id = PetId("bird"),
            name = "Bird",
            icon = R.drawable.ic_bird
        ),
    )

    fun getAllPuppies(): List<Puppy> = puppies

    fun randomPuppy(): Puppy = puppies.random()

    fun getAllPets(): List<Pet> = petTypes

    fun getPuppy(id: Int): Puppy =
        puppies.first { it.id == id }
}

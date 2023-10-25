package com.example.travel.db

import androidx.lifecycle.LiveData

class PlaceRepository(private val placeDao: PlaceDao) {
    val allPlaces: LiveData<List<Place>> = placeDao.allPlaces()

    suspend fun addPlace(place: Place){
        placeDao.insert(place)
    }
}